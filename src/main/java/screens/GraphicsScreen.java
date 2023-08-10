package screens;

import Actions.MobileActions;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GraphicsScreen {
    private final By scaleToFit = AppiumBy.accessibilityId("ScaleToFit");
    private final By vertices = AppiumBy.accessibilityId("Vertices");
    WebDriver driver;
    MobileActions mobileActions;

    public GraphicsScreen(WebDriver driver, MobileActions mobileActions) {
        this.driver = driver;
        this.mobileActions = mobileActions;
    }

    public GraphicsOnScaleToFitScreen clickOnScaleToFit() {
        mobileActions.scrollDownToSpecificTextContained("ScaleToFit");
        driver.findElement(scaleToFit).click();
        return new GraphicsOnScaleToFitScreen(driver);
    }

    public GraphicsVerticesScreen scrollDownToVerticsAndClickOnVertices() {
        mobileActions.scrollDownToSpecificText("Vertices");
        driver.findElement(vertices).click();
        return new GraphicsVerticesScreen(driver, mobileActions);
    }
}
