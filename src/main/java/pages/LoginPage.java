package pages;

import com.codeborne.selenide.SelenideElement;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

@Singleton
public class LoginPage extends AbsBasePage {

  @Inject
  MyWidhListPage myWidhListPage;

  private final SelenideElement userNameInputField = $(By.id("ru.otus.wishlist:id/username_text_input"));
  private final SelenideElement passwordInputField = $(By.id("ru.otus.wishlist:id/password_text_input"));
  private final SelenideElement buttonLogin = $(By.id("ru.otus.wishlist:id/log_in_button"));

  public MyWidhListPage login(String userName, String password) {
    userNameInputField
        .shouldBe(visible)
        .sendKeys(userName);
    passwordInputField
        .shouldBe(visible)
        .sendKeys(password);
    buttonLogin
        .shouldBe(visible)
        .click();
    myWidhListPage.checkOpenPage();
    return myWidhListPage;
  }
}
