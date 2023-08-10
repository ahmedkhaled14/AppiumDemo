package Actions;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;

import java.time.Duration;


public class MobileActions {
    private static WebDriver driver;

    public MobileActions(WebDriver driver) {
        MobileActions.driver = driver;
    }

    /**
     * This method is to scroll down to specific text/Element by passing only the text appeared on the screen
     *
     * @param text the text or element you want to scroll to
     */
    public void scrollDownToSpecificText(String text) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)" + ".instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + text + "\").instance(0))"));
    }

    /**
     * This method is to scroll down to a text or Element that containing a text that happened by passing only the text appeared on the screen
     *
     * @param text the text or element you want to scroll to
     */
    public void scrollDownToSpecificTextContained(String text) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)" + ".instance(0)).scrollIntoView(new UiSelector().textContains(\"" + text + "\").instance(0))"));
    }

    /**
     * This a private method the purpose of that is to swipe right
     *
     * @param element the webElement that you want to get its location
     * @param driver  an instance of your driver
     */
    @SuppressWarnings({"rawtypes", "unused"})
    private void swipeRightOnElement(WebElement element, WebDriver driver) {
        Point point = element.getLocation();
        Dimension eleSize = element.getSize();
        int centerX = driver.manage().window().getSize().width / 2;
        int centerY = point.getY() + (eleSize.getHeight() / 2);
        int moveToX = driver.manage().window().getSize().width / 2;
        int moveToY = point.getY() + (eleSize.getHeight() / 2);

        System.out.println("centerX :" + centerX);
        System.out.println("moveToX :" + centerX * 8 / 5);
        System.out.println("moveToY :" + moveToY);

        new TouchAction((PerformsTouchActions) driver).press(PointOption.point(centerX, centerY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(centerX * 8 / 5, moveToY)).release().perform();
    }

    /**
     * This method is to swipe right
     *
     * @param element the by Element that you want to get its location and swipe right out of it
     * @param driver  an instance of your driver
     */
    public void swipeRightOnElement(By element, WebDriver driver) {
        swipeRightOnElement(driver.findElement(element), driver);
    }

    /**
     * This a private method the purpose of that is to swipe left
     *
     * @param element the webElement that you want to get its location
     * @param driver  an instance of your driver
     */
    @SuppressWarnings({"rawtypes", "unused"})
    private void swipeLeftOnElement(WebElement element, WebDriver driver) {
        Point point = element.getLocation();
        Dimension eleSize = element.getSize();
        int centerX = driver.manage().window().getSize().width / 2;
        int centerY = point.getY() + (eleSize.getHeight() / 2);
        int moveToX = driver.manage().window().getSize().width / 2;
        int moveToY = point.getY() + (eleSize.getHeight() / 2);

        System.out.println("centerX :" + centerX);
        System.out.println("moveToX :" + centerX / 5);
        System.out.println("moveToY :" + moveToY);

        new TouchAction((PerformsTouchActions) driver).press(PointOption.point(centerX, centerY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(centerX / 5, moveToY)).release().perform();
    }

    /**
     * This method is to swipe left
     *
     * @param element the by Element that you want to get its location and swipe left out of it
     */
    public void swipeLeftOnElement(By element) {
        swipeLeftOnElement(driver.findElement(element), driver);
    }

    /**
     * This method is to tap on element
     *
     * @param element the webElement that you want to get its location and tap on it
     */
    public void tap(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("mobile: clickGesture", ImmutableMap.of("elementId", ((RemoteWebElement) element).getId()));
    }

    /**
     * This method performs long click action on the given element/coordinates.
     *
     * @param element the webElement that you want to get its location and long click on it
     */
    public void longClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId", ((RemoteWebElement) element).getId()));
    }

    /**
     * This method performs double click action on the given element/coordinates.
     *
     * @param element the webElement that you want to get its location and double-click on it
     */
    public void doubleClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("mobile: doubleClickGesture", ImmutableMap.of("elementId", ((RemoteWebElement) element).getId()));
    }

    /**
     * This method is a drag action from the given element/coordinates to the given point.
     *
     * @param element the webElement that you want to get its location and double-click on it
     * @param x       the x-axis of the target location like x =100
     * @param y       the y-axis of the target location like y =100
     */
    public void drag(WebElement element, int x, int y) {
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "endX", x, "endY", y));
    }

    /**
     * This method performs fling gesture on the given element/area.
     *
     * @param element   the webElement that you want to get its location and double-click on it
     * @param direction the direction that you want to fling the element like (up, down, left and right (case insensitive))
     * @param speed     The speed at which to perform this gesture in pixels per second. The value must be greater than the minimum fling velocity for the given view (50 by default). The default value is 7500 * displayDensity (500)
     */
    public void fling(WebElement element, String direction, int speed) {
        boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: flingGesture", ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "direction", direction, "speed", speed));
    }

    /**
     * This method performs pinch-open gesture on the given element/area.
     *
     * @param element the webElement that you want to pinchOpen on it
     * @param percent The size of the pinch as a percentage of the pinch area size. Valid values must be float numbers in range 0..1, where 1.0 is 100%. like (0.75)
     */
    public void pinchOpen(WebElement element, int percent) {
        ((JavascriptExecutor) driver).executeScript("mobile: pinchOpenGesture", ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "percent", percent));
    }

    /**
     * This method performs pinch-close gesture on the given element/area.
     *
     * @param element the webElement that you want to pinchClose on it
     * @param percent The size of the pinch as a percentage of the pinch area size. Valid values must be float numbers in range 0..1, where 1.0 is 100%. like (0.75)
     */
    public void pinchClose(WebElement element, int percent) {
        ((JavascriptExecutor) driver).executeScript("mobile: pinchOpenGesture", ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "percent", percent));
    }

    /**
     * This method performs swipe gesture on the given element/area.
     *
     * @param width     The width of the swipe bounding area like (200)
     * @param height    The height of the swipe bounding area like (200)
     * @param direction Swipe direction. Mandatory value. Acceptable values are: up, down, left and right (case insensitive)
     * @param percent   The size of the pinch as a percentage of the pinch area size. Valid values must be float numbers in range 0..1, where 1.0 is 100%. like (0.75)
     */

    public void swipe(double percent, int width, int height, String direction) {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("left", 100, "top", 100, "width", width, "height", height, "direction", direction, "percent", percent));

    }

    /**
     * This method performs scroll gesture on the given element/area.
     *
     * @param width:     The width of the swipe bounding area like (200)
     * @param height:    The height of the swipe bounding area like (200)
     * @param direction: Swipe direction. Mandatory value. Acceptable values are: up, down, left and right (case insensitive)
     * @param percent    The size of the pinch as a percentage of the pinch area size. Valid values must be float numbers in range 0..1, where 1.0 is 100%. like (0.75)
     */
    public void scroll(int percent, int width, int height, String direction) {
        boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left", 100, "top", 100, "width", width, "height", height, "direction", direction, "percent", percent));
    }
}
