import extension.AndroidExtension;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.LoginPage;
import users.UsersLogin;

@ExtendWith(AndroidExtension.class)
public class CreateAndEditMyGiftTest {

  @Inject
  private LoginPage loginPage;

  @Test
  public void createMyGiftTest() {
    loginPage
        .login(UsersLogin.DOSHICK.getUsername(), UsersLogin.DOSHICK.getPassword())
        .clickWishListItem(1)
        //.assertNumberOfGifts(0)
        .clickAddButton()
        .assertEditGiftTitle("Новый подарок")
        .fieldGiftInformation(
            "Пони",
            "1500",
            "тир белых коня"
        )
        .assertNumberOfGifts(1);
  }
}
