import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;

@RunWith(SerenityRunner.class)


public class internetExplorerTest {

    @Test
    public void test() throws InterruptedException {
        System.setProperty("webdriver.ie.driver", "C:\\dev\\drivers\\IEDriverServer.exe");
        DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
        caps.setCapability("ignoreZoomSetting", true);
        WebDriver driver = new InternetExplorerDriver(caps);
        driver.get("https://www.google.com.ua");
        Thread.sleep(2000);
        try {
            Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}