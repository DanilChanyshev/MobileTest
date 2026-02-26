package extension;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.google.inject.Guice;
import com.google.inject.Injector;
import factory.AndroidDriverFactory;
import factory.AndroidDriverModule;
import org.jspecify.annotations.NullMarked;
import org.junit.jupiter.api.extension.*;
import org.openqa.selenium.WebDriver;

@NullMarked
public class AndroidExtension implements
    TestInstancePostProcessor,
    BeforeEachCallback,
    AfterTestExecutionCallback,
    AfterEachCallback {

  private final Injector inject = Guice.createInjector(new AndroidDriverModule());


  @Override
  public void afterEach(ExtensionContext extensionContext) throws Exception {
    WebDriver driver = WebDriverRunner.getWebDriver();
    inject.getInstance(AndroidDriverFactory.class).quit(driver);
  }

  @Override
  public void afterTestExecution(ExtensionContext extensionContext) throws Exception {

  }

  @Override
  public void beforeEach(ExtensionContext context) throws Exception {
    WebDriver driver = inject.getInstance(WebDriver.class);
    WebDriverRunner.setWebDriver(driver);
    Selenide.open();
  }

  @Override
  public void postProcessTestInstance(Object testInstance, ExtensionContext context) throws Exception {
    inject.injectMembers(testInstance);
  }
}
