package bg.softuni.mobilele.model.service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserLoginServiceModel {

  private String username;
  private String password;

  @NotNull
  @Size(min = 2)
  public String getUsername() {
    return username;
  }

  public UserLoginServiceModel setUsername(String username) {
    this.username = username;
    return this;
  }

  @NotNull
  @Size(min = 3)
  public String getPassword() {
    return password;
  }

  public UserLoginServiceModel setPassword(String password) {
    this.password = password;
    return this;
  }
}
