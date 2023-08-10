package screens;

import Actions.MobileActions;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeScreen {
    private final By Accessibility = AppiumBy.accessibilityId("Access'ibility");
    private final By app = AppiumBy.accessibilityId("App");
    private final By graphics = AppiumBy.accessibilityId("Graphics");
    private final By views = AppiumBy.accessibilityId("Views");

    WebDriver driver;
    MobileActions mobileActions;

    public HomeScreen(WebDriver driver, MobileActions mobileActions) {
        this.driver = driver;
        this.mobileActions = mobileActions;
    }

    public AccessibilityMenuScreen clickOnAccessibility() {
        driver.findElement(Accessibility).click();
        return new AccessibilityMenuScreen(driver);
    }

    public AppMenuScreen clickOnApp() {
        driver.findElement(app).click();
        return new AppMenuScreen(driver);
    }

    public GraphicsScreen clickOnGraphics() {
        driver.findElement(graphics).click();
        return new GraphicsScreen(driver, mobileActions);
    }

    public ViewsScreen clickOnViews() {
        driver.findElement(views).click();
        return new ViewsScreen(driver, mobileActions);
    }

}
