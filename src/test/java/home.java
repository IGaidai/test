import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.TestCase.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

@RunWith(SerenityRunner.class)
public class home{

    @Managed
    WebDriver driver;

    @Test
    public void test() {
        driver.get("http://www.google.com");

        driver.findElement(By.name("q")).sendKeys("firefly", Keys.ENTER);

//        new WebDriverWait(driver,15).until(titleContains("Google Search"));

//        assertEquals(driver.getTitle(),"firefly - Google Search");
    }
}