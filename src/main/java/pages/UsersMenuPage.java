package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

import com.codeborne.selenide.SelenideElement;
import components.UsersMenuContent;
import components.UsersMenuItem;
import io.appium.java_client.AppiumBy;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class UsersMenuPage extends AbsBasePage {

  @Inject
  private FilterUserPage filterUserPage;
  @Inject
  private MyWishListPage myWishListPage;

  private final UsersMenuContent usersMenuContent = new UsersMenuContent($(AppiumBy.id("ru.otus.wishlist:id/users")));

  private final SelenideElement filterButton = $(AppiumBy.id("ru.otus.wishlist:id/filter"));


  public UsersMenuPage assertUserName(int index, String expectedName) {
    getUserItem(index).assertUserNameEqualsTo(expectedName);
    return this;
  }

  public MyWishListPage clickByUser(int index) {
    getUserItem(index).clickByUser();
    return myWishListPage;
  }

  public FilterUserPage clickFilterButton() {
    filterButton
        .shouldBe(visible)
        .click();
    return filterUserPage;
  }

  private UsersMenuItem getUserItem(int index) {
    return usersMenuContent.get(index).shouldBe(visible);
  }

}
