package components;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

public class GiftsContent extends AbsComponents<GiftsContent> {

  private final ElementsCollection items = root.$$(AppiumBy.id("ru.otus.wishlist:id/gift_item"));

  public GiftsContent(SelenideElement root) {
    super(root);
  }

  public Giftitem get(int index) {
    return new Giftitem(items.get(index - 1));
  }

  public void asserSizeEqualTo(int expectedSize) {
    items.shouldHave(CollectionCondition.size(expectedSize));
  }
}
