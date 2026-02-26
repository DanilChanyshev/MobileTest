package users;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UsersLogin {

  TONIP("tonyp90", "12345678"),
  SLOWBROO("slowbroo", "password"),
  DOSHICK("doshick", "password2");

  private final String username;
  private final String password;
}
