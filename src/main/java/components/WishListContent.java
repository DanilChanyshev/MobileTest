package components;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

public class WishListContent extends AbsComponents<WishListContent> {

  private final ElementsCollection items = root.$$(AppiumBy.id("ru.otus.wishlist:id/wishlist_item"));

  public WishListContent(SelenideElement root) {
    super(root);
  }

  public WishListItem get(int index) {
    return new WishListItem(items.get(index - 1));
  }

  public void asserSizeEqualTo(int expectedSize) {
    items.shouldHave(CollectionCondition.size(expectedSize));
  }
}
