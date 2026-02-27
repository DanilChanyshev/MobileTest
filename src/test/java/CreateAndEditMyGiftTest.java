
import db.DbUtils;
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
  @Inject
  private DbUtils dbUtils;

  @Test
  public void createAndEditMyGiftTest() {
    String newGiftTitle = "Пони";
    String newGiftSubtitle = "три белых коня";
    String newGiftPrice = "1500";
    String editGiftTitle = "Покемон";
    String editGiftSubtitle = "Пикасу и слоупок";
    String editGiftPrice = "3000";

    dbUtils.resetWishListForUser(UsersLogin.SLOWBROO.getUsername(), "testingData");

    loginPage
        .login(UsersLogin.SLOWBROO.getUsername(), UsersLogin.SLOWBROO.getPassword())
        .clickWishListItem(1)
        .clickAddButton()
        .assertEditGiftTitle("Новый подарок")
        .fieldGiftInformation(
            newGiftTitle,
            newGiftPrice,
            newGiftSubtitle
        )
        .assertNumberOfGifts(1)
        .assertGiftTitle(1, newGiftTitle)
        .assertGiftSubtitle(1, newGiftSubtitle)
        .assertGiftPrice(1, newGiftPrice)
        .clickEditButton(1)
        .assertEditGiftTitle("Изменить подарок")
        .fieldGiftInformation(
            editGiftTitle,
            editGiftPrice,
            editGiftSubtitle
        )
        .assertGiftTitle(1, editGiftTitle)
        .assertGiftSubtitle(1, editGiftSubtitle)
        .assertGiftPrice(1, editGiftPrice);
  }
}
