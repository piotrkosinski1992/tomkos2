package com.tomkos2.monolith.app.user.config.jwt;


import static com.tomkos2.monolith.app.user.config.jwt.JwtProperties.EXPIRATION_TIME;
import static com.tomkos2.monolith.app.user.config.jwt.JwtProperties.JWT_SECRET;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import java.util.Date;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtUtils {

  public String extractUsername(String token) {
    return extractClaims(token).getSubject();
  }

  public Date extractExpiration(String token) {
    return extractClaims(token).getExpiration();
  }

  private Claims extractClaims(String token) {
    return Jwts.parser()
        .setSigningKey(JWT_SECRET)
        .parseClaimsJws(token)
        .getBody();
  }

  public String generateToken(UserDetails userDetails) {
    return Jwts.builder()
        .signWith(SignatureAlgorithm.HS256, TextCodec.BASE64.decode(JWT_SECRET))
        .setSubject(userDetails.getUsername())
        .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
        .claim("role",
            userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).findFirst()
                .get())
        .compact();
  }


  public Boolean validateToken(String token, UserDetails userDetails) {
    final String username = extractUsername(token);
    return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
  }

  private Boolean isTokenExpired(String token) {
    return extractExpiration(token).before(new Date());
  }
}
