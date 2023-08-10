package screens;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ActivityMenuScreen {
    private final By customTitle = AppiumBy.accessibilityId("Custom Title");

    WebDriver driver;

    public ActivityMenuScreen(WebDriver driver) {
        this.driver = driver;
    }

    public CustomTitleScreen clickOnCustomTitle() {
        driver.findElement(customTitle).click();
        return new CustomTitleScreen(driver);
    }

}
