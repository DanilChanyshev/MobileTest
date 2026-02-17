package components;

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
}
