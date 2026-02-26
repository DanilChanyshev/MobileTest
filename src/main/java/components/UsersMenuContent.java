package components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

public class UsersMenuContent extends AbsComponents<UsersMenuContent> {

  public UsersMenuContent(SelenideElement root) {
    super(root);
  }

  private final ElementsCollection items = root.$$(AppiumBy.id("ru.otus.wishlist:id/user_item"));

  public UsersMenuItem get(int index) {
    return new UsersMenuItem(items.get(index - 1));
  }

}
