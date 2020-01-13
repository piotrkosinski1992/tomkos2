package com.tomkos2.user.controller;


import com.tomkos2.user.config.UserPrincipalDetailsService;
import com.tomkos2.user.config.jwt.JwtUtils;
import com.tomkos2.user.usecase.SaveUserInfo;
import javax.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthRestController {

  private final AuthenticationManager authManager;
  private final UserPrincipalDetailsService userDetailsService;
  private final SaveUserInfo saveUserInfo;
  private final JwtUtils jwtUtils;

  public AuthRestController(AuthenticationManager authManager,
      UserPrincipalDetailsService userDetailsService,
      SaveUserInfo saveUserInfo, JwtUtils jwtUtils) {
    this.authManager = authManager;
    this.userDetailsService = userDetailsService;
    this.saveUserInfo = saveUserInfo;
    this.jwtUtils = jwtUtils;
  }

  @PostMapping("/auth")
  public ResponseEntity<?> login(@RequestBody AuthenticationRequest request) {
    authenticate(request.getUsername(), request.getPassword());
    UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
    return ResponseEntity.ok(new AuthenticationResponse(jwtUtils.generateToken(userDetails)));
  }

  @PostMapping("/register")
  public void register(@RequestBody AuthenticationRequest request) {
    saveUserInfo.saveUserInfo(request.getUsername(), request.getPassword());
  }

  private void authenticate(String username, String password) {
    try {
      authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    } catch (BadCredentialsException e) {
      throw new EntityNotFoundException("Wrong username or password!");
    }
  }
}
