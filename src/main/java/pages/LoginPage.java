package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static io.appium.java_client.AppiumBy.id;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import com.codeborne.selenide.SelenideElement;

@Singleton
public class LoginPage extends AbsBasePage {

  @Inject
  private MyWishListPage myWishListPage;

  private final SelenideElement userNameInputField = $(id("ru.otus.wishlist:id/username_text_input"));
  private final SelenideElement passwordInputField = $(id("ru.otus.wishlist:id/password_text_input"));
  private final SelenideElement buttonLogin = $(id("ru.otus.wishlist:id/log_in_button"));

  public MyWishListPage login(String userName, String password) {
    userNameInputField
        .shouldBe(visible)
        .sendKeys(userName);
    passwordInputField
        .shouldBe(visible)
        .sendKeys(password);
    buttonLogin
        .shouldBe(visible)
        .click();
    myWishListPage.checkOpenPage();
    return myWishListPage;
  }
}
