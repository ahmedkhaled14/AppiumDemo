package screens;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RadioGroupScreen {
    private final By dinner = AppiumBy.accessibilityId("Dinner");
    WebDriver driver;

    public RadioGroupScreen(WebDriver driver) {
        this.driver = driver;
    }

    public RadioGroupScreen clickOnDinner() {
        driver.findElement(dinner).click();
        return this;
    }

    public RadioGroupScreen assertOnRadioButtonSelected() {
        Assert.assertTrue(Boolean.parseBoolean(driver.findElement(dinner).getAttribute("checked")));
        return this;
    }
}
