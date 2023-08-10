package screens;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CustomTitleScreen {
    private final By leftTextEdit = AppiumBy.id("io.appium.android.apis:id/left_text_edit");
    private final By changeLeftButton = AppiumBy.accessibilityId("Change Left");
    private final By leftText = AppiumBy.id("io.appium.android.apis:id/left_text");

    WebDriver driver;

    public CustomTitleScreen(WebDriver driver) {
        this.driver = driver;
    }

    public CustomTitleScreen typeOnLeftTextfield(String query) {
        driver.findElement(leftTextEdit).clear();
        driver.findElement(leftTextEdit).sendKeys(query);
        return this;
    }

    public CustomTitleScreen clickOnChangeLeftButton() {
        driver.findElement(changeLeftButton).click();
        return this;
    }

    public CustomTitleScreen assertOnLeftText(String expected) {
        Assert.assertEquals(driver.findElement(leftText).getText(), expected);
        return this;
    }


}
