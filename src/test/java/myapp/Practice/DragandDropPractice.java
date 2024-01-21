package myapp.Practice;

import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragandDropPractice {

    @Test
    public void dragAndDrop() throws InterruptedException {


        Driver.getDriver().get("https://demoqa.com/droppable");
        Thread.sleep(50000);

        WebElement source= Driver.getDriver().findElement(By.id("draggable"));
        Thread.sleep(2000);
        WebElement target= Driver.getDriver().findElement(By.id("droppable"));
        Thread.sleep(2000);
        Actions actions= new Actions(Driver.getDriver());
        actions.dragAndDrop(source,target).perform();
        Driver.closeDriver();

    }
}
