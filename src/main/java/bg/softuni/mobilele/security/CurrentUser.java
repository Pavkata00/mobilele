package bg.softuni.mobilele.security;

import bg.softuni.mobilele.model.entities.UserRoleEntity;
import bg.softuni.mobilele.model.entities.enums.UserRoleEnum;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Component
@SessionScope
public class CurrentUser {

  private static final String ANONYMOUS = "anonymous";

  private String name = ANONYMOUS;
  private boolean isAnonymous = true;
  private List<UserRoleEnum> roles = new ArrayList<>();

  public String getName() {
    return name;
  }

  public CurrentUser setName(String name) {
    this.name = name;
    return this;
  }

  public boolean isAnonymous() {
    return isAnonymous;
  }

  public CurrentUser setAnonymous(boolean anonymous) {
    if (anonymous) {
      this.name = ANONYMOUS;
      this.roles.clear();
    }
    isAnonymous = anonymous;
    return this;
  }
  public boolean isLoggedIn() {
    return !this.isAnonymous;
  }
  public boolean isAdmin() {
    return this.roles.contains(UserRoleEnum.ADMIN);
  }

  public List<UserRoleEnum> getRoles() {
    return roles;
  }

  public CurrentUser setRoles(List<UserRoleEnum> roles) {
    this.roles.clear();
    this.roles.addAll(roles);
    return this;
  }
}
