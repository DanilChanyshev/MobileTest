import extension.AndroidExtension;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.LoginPage;

@ExtendWith(AndroidExtension.class)
public class CreateAndEditWishListTest {

  @Inject
  LoginPage loginPage;

  String user = "tonyp90";
  String password = "12345678";
  String editTitle = "Ждем следующий год";
  String editDescription = "остлалось 300 днед";

  @Test
  public void createWishListTest() {
    loginPage
        .login(user, password)
        .clickAddButton()
        .fieldNewWish("Автотестер", "Хочу под елочку нового автотестера");
  }

  @Test
  public void editWishListTest() {
    loginPage
        .login(user, password)
        .clickRefactorButton()
        .fieldNewWish(editTitle, editDescription)
        .checkEditableWish(editTitle, editDescription);
  }
}
