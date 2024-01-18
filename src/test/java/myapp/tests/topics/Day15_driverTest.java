package myapp.tests.topics;

import myapp.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day15_driverTest {

    @Test
    public void driverTest() throws InterruptedException {

        //driver.get("https://www.amazon.com/"), we were calling driver from TestBase

        Driver.getDriver().get("https://www.amazon.com/");
        Thread.sleep(15000); // to type the captcha manually
        String title= Driver.getDriver().getTitle();
        Assert.assertTrue(title.contains("Spend less"));
        Driver.closeDriver();
    }
}
