package pages;

import com.codeborne.selenide.SelenideElement;
import jakarta.inject.Singleton;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.appium.SelenideAppium.$;

@Singleton
public class MyWidhListPage extends AbsBasePage{

  private final SelenideElement main = $(By.id("ru.otus.wishlist:id/wishlists_loading"));
  private final SelenideElement addWishButton = $(By.id("ru.otus.wishlist:id/add_button"));
  private final SelenideElement newWishTitle = $(By.id("ru.otus.wishlist:id/wishlist_edit_title"));
  private final SelenideElement nameWishField = $(By.id("ru.otus.wishlist:id/title_input"));
  private final SelenideElement descriptionWishField = $(By.id("ru.otus.wishlist:id/description_input"));
  private final SelenideElement saveButton = $(By.id("ru.otus.wishlist:id/save_button"));
  private final SelenideElement refactorButton = $(By.id("ru.otus.wishlist:id/edit_button"));
  private final SelenideElement editWishTitle = $(By.id("ru.otus.wishlist:id/wishlist_edit_title"));
  private final SelenideElement actualTitleSecondWish = $(By.id("ru.otus.wishlist:id/title"));
  private final SelenideElement actualDescriptionSecondWish = $(By.id("ru.otus.wishlist:id/subtitle"));

  public MyWidhListPage checkOpenPage() {
    main.shouldBe(visible);
    return this;
  }

  public MyWidhListPage clickAddButton(){
    addWishButton
        .shouldBe(visible)
        .click();
    newWishTitle.shouldBe(visible);
    return this;
  }

  public MyWidhListPage fieldNewWish(String title, String description) {
    nameWishField
        .shouldBe(visible)
        .sendKeys(title);
    descriptionWishField
        .shouldBe(visible)
        .sendKeys(description);
    saveButton
        .shouldBe(visible)
        .click();
    return this;
  }

  public MyWidhListPage clickRefactorButton() {
    refactorButton
        .shouldBe(visible)
        .click();
    editWishTitle
        .shouldBe(visible)
        .shouldBe(text("Изменить список желаний"));
    return this;
  }

  public MyWidhListPage checkEditableWish(String title, String description) {
    actualTitleSecondWish
        .shouldBe(text(title));
    actualDescriptionSecondWish
        .shouldBe(text(description));
    return this;
  }
}
