package screens;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckBoxScreen {
    private final By taskConquerWorldCheckBox = AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Task Conquer World\"]//parent::android.widget.LinearLayout/android.widget.CheckBox");
    WebDriver driver;

    public CheckBoxScreen(WebDriver driver) {
        this.driver = driver;
    }

    public CheckBoxScreen clickOnTaskConquerWorldCheckBox() {
        driver.findElement(taskConquerWorldCheckBox).click();
        return this;
    }

    public CheckBoxScreen assertOnTaskConquerWorldCheckBox() {
        Assert.assertTrue(Boolean.parseBoolean(driver.findElement(taskConquerWorldCheckBox).getAttribute("checked")));
        return this;
    }


}
