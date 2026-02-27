package components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

public class WishListItem extends AbsComponents<WishListItem> {

  private final SelenideElement title = root.$(AppiumBy.id("ru.otus.wishlist:id/title"));
  private final SelenideElement subtitle = root.$(AppiumBy.id("ru.otus.wishlist:id/subtitle"));
  private final SelenideElement editButton = root.$(AppiumBy.id("ru.otus.wishlist:id/edit_button"));


  public WishListItem(SelenideElement root) {
    super(root);
  }

  public void assertTitleEqualsTo(String value) {
    title.shouldHave(text(value));
  }

  public void assertSubtitleEqualsTo(String value) {
    subtitle.shouldHave(text(value));
  }

  public void clickEdit() {
    editButton
        .shouldBe(visible)
        .click();
  }
}
