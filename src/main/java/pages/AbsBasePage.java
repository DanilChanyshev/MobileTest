package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import jakarta.inject.Inject;
import pageobject.AbsPageObject;

public abstract class AbsBasePage extends AbsPageObject {

  @Inject
  private UsersMenuPage usersMenuPage;

  private final SelenideElement usersMenu = $(AppiumBy.id("ru.otus.wishlist:id/users_menu"));

  public UsersMenuPage clickButtonUserMenu() {
    usersMenu
        .shouldBe(visible)
        .click();
    return usersMenuPage;
  }
}
