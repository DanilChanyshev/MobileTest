package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.openqa.selenium.By;

@Singleton
public class EditWidhListPage extends AbsBasePage {

  @Inject
  private MyWishListPage myWishListPage;

  private final SelenideElement title = $(By.id("ru.otus.wishlist:id/wishlist_edit_title"));
  private final SelenideElement titleInputField = $(By.id("ru.otus.wishlist:id/title_input"));
  private final SelenideElement descriptionInputField = $(By.id("ru.otus.wishlist:id/description_input"));
  private final SelenideElement saveButton = $(By.id("ru.otus.wishlist:id/save_button"));

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
