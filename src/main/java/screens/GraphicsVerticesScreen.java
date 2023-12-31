package screens;

import Actions.MobileActions;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GraphicsVerticesScreen {
    private final By photo = AppiumBy.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']");
    WebDriver driver;
    MobileActions mobileActions;

    public GraphicsVerticesScreen(WebDriver driver, MobileActions mobileActions) {
        this.driver = driver;
        this.mobileActions = mobileActions;
    }

    public GraphicsVerticesScreen swipePhoto() {
        mobileActions.swipeRightOnElement(photo, driver);
        mobileActions.swipeLeftOnElement(photo);
        return this;
    }
}
