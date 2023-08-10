package screens;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccessibilityMenuScreen {
    private final By accessibilityNodeProvider = AppiumBy.accessibilityId("Accessibility Node Provider");
    private final By accessibilityNodeQuerying = AppiumBy.accessibilityId("Accessibility Node Querying");
    WebDriver driver;
    //MobileActions mobileActions;

    public AccessibilityMenuScreen(WebDriver driver) {
        this.driver = driver;
    }

    public CheckBoxScreen clickOnAccessibilityNodeQuering() {
        driver.findElement(accessibilityNodeQuerying).click();
        return new CheckBoxScreen(driver);
    }

    public AccessibilityMenuScreen assertOnAccessibilityNodeProviderText(String expected) {
        Assert.assertEquals(driver.findElement(accessibilityNodeProvider).getText(), expected);
        return this;
    }
}


