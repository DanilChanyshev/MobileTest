package components;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class Giftitem extends AbsComponents<Giftitem> {

  public Giftitem(SelenideElement root) {
    super(root);
  }

  private final SelenideElement title = $(AppiumBy.id("ru.otus.wishlist:id/title"));
  private final SelenideElement subTitle = $(AppiumBy.id("ru.otus.wishlist:id/subtitle"));
  private final SelenideElement price = $(AppiumBy.id("ru.otus.wishlist:id/price"));
  private final SelenideElement editButton = $(AppiumBy.id("ru.otus.wishlist:id/edit_button"));

  public void assertTitleEqualsTo(String value) {
    title.shouldHave(text(value));
  }

  public void assertPriceEqualsTo(String value) {
    price.shouldHave(text(value));
  }

  public void assertSubtitleEqualsTo(String value) {
    subTitle.shouldHave(text(value));
  }

  public void clickEdit() {
    editButton
        .shouldBe(visible)
        .click();
  }
}
