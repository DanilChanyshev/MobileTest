package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class EditWidhListPage extends AbsBasePage {

  @Inject
  private MyWishListPage myWishListPage;

  private final SelenideElement title = $(AppiumBy.id("ru.otus.wishlist:id/wishlist_edit_title"));
  private final SelenideElement titleInputField = $(AppiumBy.id("ru.otus.wishlist:id/title_input"));
  private final SelenideElement descriptionInputField = $(AppiumBy.id("ru.otus.wishlist:id/description_input"));
  private final SelenideElement saveButton = $(AppiumBy.id("ru.otus.wishlist:id/save_button"));

  public EditWidhListPage assertEditWishListTitle(String expected) {
    title
        .shouldBe(visible)
        .shouldHave(Condition.text(expected));
    return this;
  }

  public MyWishListPage fieldNewWish(String title, String description) {
    titleInputField
        .shouldBe(visible)
        .sendKeys(title);
    descriptionInputField
        .shouldBe(visible)
        .sendKeys(description);
    saveButton
        .shouldBe(visible)
        .click();
    return myWishListPage;
  }

}
