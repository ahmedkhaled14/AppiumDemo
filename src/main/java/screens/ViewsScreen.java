package screens;

import Actions.MobileActions;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewsScreen {
    private final By radioGroup = AppiumBy.accessibilityId("Radio Group");

    WebDriver driver;
    MobileActions mobileActions;

    public ViewsScreen(WebDriver driver, MobileActions mobileActions) {
        this.driver = driver;
        this.mobileActions = mobileActions;
    }

    public RadioGroupScreen scrollDownToRadioGroupAndClickOnRadioGroup() {
        mobileActions.scrollDownToSpecificText("Radio Group");
        driver.findElement(radioGroup).click();
        return new RadioGroupScreen(driver);
    }
}
