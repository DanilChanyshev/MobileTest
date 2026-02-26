package factory;

import emulator.Emulator;
import emulator.EmulatorProvider;
import io.appium.java_client.android.AndroidDriver;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import java.net.URL;
import java.time.Duration;

@Singleton
@AllArgsConstructor(onConstructor_ = @Inject)
public class AndroidDriverFactory {

  private EmulatorProvider emulatorProvider;
  private Capabilities capabilities;

  @SneakyThrows
  public WebDriver create() {
    Emulator emulator = emulatorProvider.takeAndGet();
    AndroidDriver driver = new AndroidDriver(
        new URL(System.getProperty("base.url").formatted(emulator.getPort())),
        capabilities
    );
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    return driver;
  }

  public void quit(WebDriver driver) {
    emulatorProvider.putBack();
    driver.quit();
  }
}
