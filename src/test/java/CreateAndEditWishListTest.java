import db.DbUtils;
import extension.AndroidExtension;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.LoginPage;
import users.UsersLogin;

@ExtendWith(AndroidExtension.class)
public class CreateAndEditWishListTest {

  @Inject
  private LoginPage loginPage;
  @Inject
  private DbUtils dbUtils;

  @Test
  public void createWishListTest() {
    dbUtils.resetWishListForUser(UsersLogin.DOSHICK.getUsername(), "testingData");
    loginPage
        .login(UsersLogin.DOSHICK.getUsername(), UsersLogin.DOSHICK.getPassword())
        .assertNumberOfWishLists(1)
        .clickAddButton()
        .assertEditWishListTitle("Новый список желаний")
        .fieldNewWish("Автотестер", "Хочу под елочку нового автотестера")
        .assertNumberOfWishLists(2);
  }

  @Test
  public void editWishListTest() {
    final String editTitle = "Ждем следующий год";
    final String editDescription = "остлалось 300 дней";

    dbUtils.resetWishListForUser(UsersLogin.TONIP.getUsername(), "testingData");
    loginPage
        .login(UsersLogin.TONIP.getUsername(), UsersLogin.TONIP.getPassword())
        .assertWishListTitle(1, "testingData")
        .assertWishListSubtitle(1, "testingData")
        .clickEditButton(1)
        .assertEditWishListTitle("Изменить список желаний")
        .fieldNewWish(editTitle, editDescription)
        .assertWishListTitle(1, editTitle)
        .assertWishListSubtitle(1, editDescription);
  }
}
