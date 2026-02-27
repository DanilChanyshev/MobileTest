package factory;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import jakarta.inject.Singleton;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import java.net.URI;

@SuppressWarnings("unused")
public class AndroidDriverModule extends AbstractModule {

  @Provides
  private WebDriver webDriver(AndroidDriverFactory factory) {
    return factory.create();
  }

  @Provides
  @Singleton
  private Capabilities capabilities() {
    UiAutomator2Options options = new UiAutomator2Options();
    options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
    options.setPlatformName("Android");
    options.setApp(URI.create(System.getProperty("base.apk")).resolve("wishlist.apk").toString());
    options.fullReset();
    return options;
  }
}
