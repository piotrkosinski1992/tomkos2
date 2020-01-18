package com.tomkos2.monolith.app.user.domain;

import java.util.Objects;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class UserInfo {

  @EmbeddedId
  private EntityId id;

  @Embedded
  private Credentials credentials;

  @Enumerated(EnumType.STRING)
  private Role role = Role.USER;

  public UserInfo() {
  }

  public UserInfo(String username, String password) {
    this.credentials = Credentials.create(username, password);
    this.id = EntityId.create();
  }

  public UserInfo(String username, String password, Role role) {
    this.credentials = Credentials.create(username, password);
    this.role = role;
    this.id = EntityId.create();
  }

  public EntityId getId() {
    return id;
  }

  public Credentials getCredentials() {
    return credentials;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role){
    this.role = role;
  }

  public String getUsername() {
    return credentials.getUsername();
  }

  public String getPassword() {
    return credentials.getPassword();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserInfo that = (UserInfo) o;
    return id.equals(that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
