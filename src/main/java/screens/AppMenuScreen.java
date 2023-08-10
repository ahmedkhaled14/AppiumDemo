package screens;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AppMenuScreen {
    private final By activity = AppiumBy.accessibilityId("Activity");
    WebDriver driver;

    public AppMenuScreen(WebDriver driver) {
        this.driver = driver;
    }

    public ActivityMenuScreen clickOnActivity() {
        driver.findElement(activity).click();
        return new ActivityMenuScreen(driver);
    }
}
