package components;

import static com.codeborne.selenide.Condition.*;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

public class Giftitem extends AbsComponents<Giftitem> {

  public Giftitem(SelenideElement root) {
    super(root);
  }

  private final SelenideElement title = root.$(AppiumBy.id("ru.otus.wishlist:id/title"));
  private final SelenideElement subTitle = root.$(AppiumBy.id("ru.otus.wishlist:id/subtitle"));
  private final SelenideElement price = root.$(AppiumBy.id("ru.otus.wishlist:id/price"));
  private final SelenideElement editButton = root.$(AppiumBy.id("ru.otus.wishlist:id/edit_button"));
  private final SelenideElement statusBut = root.$(AppiumBy.id("ru.otus.wishlist:id/reserved"));

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

  public void switchStatusItemEnable() {
    if (isToggleDisable(statusBut)){
      statusBut.click();
    }
  }

  public void switchStatusItemDisable() {
    if (isToggleEnabled(statusBut)){
      statusBut.click();
    }
  }
}
