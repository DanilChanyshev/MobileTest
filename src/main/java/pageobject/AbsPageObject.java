package pageobject;

import com.codeborne.selenide.SelenideElement;

public abstract class AbsPageObject {

  protected boolean isToggleEnabled(SelenideElement switchElement) {
    return "true".equals(switchElement.getAttribute("checked"));
  }

  protected boolean isToggleDisable(SelenideElement switchElement) {
    return !isToggleEnabled(switchElement);
  }
}
