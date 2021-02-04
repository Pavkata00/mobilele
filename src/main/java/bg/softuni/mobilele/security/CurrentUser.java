package bg.softuni.mobilele.security;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CurrentUser {

  private static final String ANONYMOUS = "anonymous";

  private String name = ANONYMOUS;
  private boolean isAnonymous = true;

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
    }
    isAnonymous = anonymous;
    return this;
  }
  public boolean isLoggedIn() {
    return !this.isAnonymous;
  }

}
