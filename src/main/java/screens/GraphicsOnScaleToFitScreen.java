package screens;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GraphicsOnScaleToFitScreen {

    private final By graphicsScaleToFit = AppiumBy.xpath("//android.widget.TextView[@text='Graphics/ScaleToFit']");
    WebDriver driver;

    public GraphicsOnScaleToFitScreen(WebDriver driver) {
        this.driver = driver;
    }

    public GraphicsOnScaleToFitScreen assertOnGraphicsScaleToFit(String expected) {
        Assert.assertEquals(driver.findElement(graphicsScaleToFit).getText(), expected);
        return this;
    }
}
