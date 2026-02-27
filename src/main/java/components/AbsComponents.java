package components;

import static com.codeborne.selenide.Condition.visible;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebElementCondition;
import lombok.AllArgsConstructor;
import pageobject.AbsPageObject;

@AllArgsConstructor
public abstract class AbsComponents<T extends AbsComponents<T>> extends AbsPageObject {

  protected final SelenideElement root;

  public T shouldBe(WebElementCondition... condition) {
    root.shouldBe(condition);
    return (T) this;
  }

  public void clickItem() {
    root.shouldBe(visible).click();
  }
}
