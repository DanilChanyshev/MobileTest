import db.DbUtils;
import extension.AndroidExtension;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.LoginPage;
import users.UsersLogin;

@ExtendWith(AndroidExtension.class)
public class EditStatusGiftUserTest {

  @Inject
  private LoginPage loginPage;
  @Inject
  private DbUtils dbUtils;

  @Test
  public void editStatusGiftTest() {
    dbUtils.resetGiftStatusForUser(UsersLogin.SIMPLE.getUsername(), false, "testingData");
    loginPage
        .login(UsersLogin.USER_EDITOR.getUsername(), UsersLogin.USER_EDITOR.getPassword())
        .clickButtonUserMenu()
        .clickFilterButton()
        .assertTitle()
        .sendUserByName(UsersLogin.SIMPLE.getUsername())
        .assertUserName(1, UsersLogin.SIMPLE.getUsername())
        .clickByUser(1)
        .clickWishListItem(1)
        .switchStatusGift(1);
  }
}
