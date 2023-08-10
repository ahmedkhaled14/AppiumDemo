import Actions.MobileActions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.HomeScreen;
import screens.Setup;
import utils.JsonFileManager;

import java.net.MalformedURLException;

public class Test_MobileActions {
    WebDriver driver;
    MobileActions mobileActions;
    JsonFileManager accessibilityNodeProviderTextTestData;
    JsonFileManager leftTextFieldTestData;
    JsonFileManager graphicsScaleToFitTestData;

    @BeforeClass(description = "initialize Json File Manager")
    public void beforeClass() {
        accessibilityNodeProviderTextTestData = new JsonFileManager("src\\test\\resources\\TestDataFiles\\AccessibilityNodeProviderText.json");
        leftTextFieldTestData = new JsonFileManager("src\\test\\resources\\TestDataFiles\\LeftTextfieldTestData.json");
        graphicsScaleToFitTestData = new JsonFileManager("src\\test\\resources\\TestDataFiles\\graphicsScaleToFitTestData.json");
    }

    @BeforeMethod(description = "setup")
    public void setupDevice() throws MalformedURLException {
        driver = new Setup(driver).setupDevice();
        mobileActions = new MobileActions(driver);
    }


    @Test(description = "test Click Action")
    public void testClickAction() {
        new HomeScreen(driver, mobileActions)
                .clickOnAccessibility()
                .assertOnAccessibilityNodeProviderText(accessibilityNodeProviderTextTestData.getTestData("AccessibilityNodeProviderTextExpectedResult"));
    }

    @Test(description = "test Typing")
    public void testTyping() {
        // Navigate to APP ,activity , custom title , type "Appium" and check If the text written or not
        new HomeScreen(driver, mobileActions)
                .clickOnApp()
                .clickOnActivity()
                .clickOnCustomTitle()
                .typeOnLeftTextfield(leftTextFieldTestData.getTestData("query"))
                .clickOnChangeLeftButton()
                .assertOnLeftText(leftTextFieldTestData.getTestData("query"));
    }


    @Test(description = "test CheckBox")
    public void testCheckBox() {
        // Navigate to Access'ibility , Accessibility Node Querying , click on any checkbox and validate that the checkbox is checked
        new HomeScreen(driver, mobileActions)
                .clickOnAccessibility()
                .clickOnAccessibilityNodeQuering()
                .clickOnTaskConquerWorldCheckBox()
                .assertOnTaskConquerWorldCheckBox();
    }

    @Test(description = "test Scrolling")
    public void testScrolling() {
        // Navigate to Graphics , scaleToFit and click on it and check If it's scrolled and clicked or not
        new HomeScreen(driver, mobileActions)
                .clickOnGraphics()
                .clickOnScaleToFit()
                .assertOnGraphicsScaleToFit(graphicsScaleToFitTestData.getTestData("graphicsScaleToFitTestDataExpectedResult"));
    }

    @Test(description = "test Swiping")
    public void testSwiping() {
        // Navigate to Graphics , Vertices , Swipe right on the photo and then swipe left
        new HomeScreen(driver, mobileActions)
                .clickOnGraphics()
                .scrollDownToVerticsAndClickOnVertices()
                .swipePhoto();
    }

    @Test(description = "test Radio Button")
    public void testRadioButton() {
        // Navigate to Views , Radio Group , click on any radio button and check If it's selected or not
        new HomeScreen(driver, mobileActions)
                .clickOnViews()
                .scrollDownToRadioGroupAndClickOnRadioGroup()
                .clickOnDinner()
                .assertOnRadioButtonSelected();
    }

    @AfterMethod(description = "tear down")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
