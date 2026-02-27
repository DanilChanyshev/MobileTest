package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

import com.codeborne.selenide.SelenideElement;
import components.Giftitem;
import components.GiftsContent;
import io.appium.java_client.AppiumBy;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class GiftsPage extends AbsBasePage {

  @Inject
  private EditGiftPage editGiftPage;

  private final GiftsContent giftsContent = new GiftsContent($(AppiumBy.id("ru.otus.wishlist:id/gifts")));

  private final SelenideElement addButton = $(AppiumBy.id("ru.otus.wishlist:id/add_button"));

  public EditGiftPage clickAddButton() {
    addButton
        .shouldBe(visible)
        .click();
    return editGiftPage;
  }

  public GiftsPage assertNumberOfGifts(int value){
    giftsContent
        .shouldBe(visible)
        .asserSizeEqualTo(value);
    return this;
  }

  public GiftsPage assertGiftTitle(int index, String expectedTitle) {
    getGiftItem(index).assertTitleEqualsTo(expectedTitle);
    return this;
  }

  public GiftsPage assertGiftSubtitle(int index, String expectedSubtitle) {
    getGiftItem(index).assertSubtitleEqualsTo(expectedSubtitle);
    return this;
  }

  public GiftsPage assertGiftPrice(int index, String expectedPrice) {
    getGiftItem(index).assertPriceEqualsTo(expectedPrice);
    return this;
  }

  public EditGiftPage clickEditButton(int index) {
    getGiftItem(index).clickEdit();
    return editGiftPage;
  }

  public GiftsPage switchStatusGift(int index) {
    getGiftItem(index).switchStatusItemEnable();
    return this;
  }

  private Giftitem getGiftItem(int index) {
    return giftsContent.get(index).shouldBe(visible);
  }

}
