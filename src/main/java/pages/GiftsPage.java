package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

import com.codeborne.selenide.SelenideElement;
import components.Giftitem;
import components.GiftsContent;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class GiftsPage extends AbsBasePage {

  @Inject
  private EditGiftPage editGiftPage;

  private final GiftsContent giftsContent = new GiftsContent($(AppiumBy.id("ru.otus.wishlist:id/gifts")));

  private final SelenideElement addButton = $(AppiumBy.id("ru.otus.wishlist:id/add_button"));

  @Step("Нажать на кнопку 'добавить подарок'")
  public EditGiftPage clickAddButton() {
    addButton
        .shouldBe(visible)
        .click();
    return editGiftPage;
  }

  @Step("Проверить количество подарок")
  public GiftsPage assertNumberOfGifts(int value){
    giftsContent
        .shouldBe(visible)
        .asserSizeEqualTo(value);
    return this;
  }

  @Step("Проверить название подарка")
  public GiftsPage assertGiftTitle(int index, String expectedTitle) {
    getGiftItem(index).assertTitleEqualsTo(expectedTitle);
    return this;
  }

  @Step("Проверить описание подарка")
  public GiftsPage assertGiftSubtitle(int index, String expectedSubtitle) {
    getGiftItem(index).assertSubtitleEqualsTo(expectedSubtitle);
    return this;
  }

  @Step("Проверить цену подарка")
  public GiftsPage assertGiftPrice(int index, String expectedPrice) {
    getGiftItem(index).assertPriceEqualsTo(expectedPrice);
    return this;
  }

  @Step("Нажать на кнопку 'редактировать'")
  public EditGiftPage clickEditButton(int index) {
    getGiftItem(index).clickEdit();
    return editGiftPage;
  }

  @Step("Переключить статус подарка")
  public GiftsPage switchStatusGift(int index) {
    getGiftItem(index).switchStatusItemEnable();
    return this;
  }

  private Giftitem getGiftItem(int index) {
    return giftsContent.get(index).shouldBe(visible);
  }

}
