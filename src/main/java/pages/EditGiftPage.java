package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class EditGiftPage extends AbsBasePage {

  @Inject
  private GiftsPage giftsPage;

  private final SelenideElement title = $(AppiumBy.id("ru.otus.wishlist:id/gift_edit_title"));
  private final SelenideElement inputNameField = $(AppiumBy.id("ru.otus.wishlist:id/name_input"));
  private final SelenideElement inputPriceField = $(AppiumBy.id("ru.otus.wishlist:id/price_input"));
  private final SelenideElement inputDescriptionField = $(AppiumBy.id("ru.otus.wishlist:id/description_input"));
  private final SelenideElement saveButton = $(AppiumBy.id("ru.otus.wishlist:id/save_button"));

  public EditGiftPage assertEditGiftTitle(String expectedTitle) {
    title
        .shouldBe(visible)
        .shouldHave(Condition.text(expectedTitle));
    return this;
  }

  public GiftsPage fieldGiftInformation(String nameGift, String price, String description) {
    inputNameField
        .shouldBe(visible)
        .sendKeys(nameGift);
    inputPriceField
        .shouldBe(visible)
        .sendKeys(price);
    inputDescriptionField
        .shouldBe(visible)
        .sendKeys(description);
    saveButton
        .shouldBe(visible)
        .click();
    return giftsPage;
  }
}
