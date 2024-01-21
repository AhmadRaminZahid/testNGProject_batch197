package myapp.Practice;

import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.util.Arrays;

public class AmazonTeapotHW {

    @Test
    public void teapotHW() throws InterruptedException {
//       go to the amazon website
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
        Thread.sleep(6000);
        Driver.getDriver().navigate().refresh();
        Driver.getDriver().manage().window().maximize();

//       type porcelain teapot in the searchbox
        Thread.sleep(3000);
        Driver.getDriver().findElement(By.id("twotabsearchtextbox")).sendKeys("porcelain teapot", Keys.ENTER);
        Thread.sleep(3000);
        String result = Driver.getDriver().findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small']//span)[1]")).getText();
        String[] list = result.split(" ");
        System.out.println(Arrays.toString(list));
        String firstPart= list[0];
        String[] minilist= firstPart.split("-");
        String number= minilist[1];
        System.out.println(number);


        WebElement clickPart = Driver.getDriver().findElement(By.xpath("//select[@id='s-result-sort-select']"));
        Thread.sleep(3000);
        Select select = new Select(clickPart);
        Thread.sleep(3000);
        select.selectByVisibleText("Price: Low to High");

        String lowestPrice=Driver.getDriver().findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
        Thread.sleep(3000);
        String lowestFraction=Driver.getDriver().findElement(By.xpath("(//span[@class='a-price-fraction'])[1]")).getText();
        System.out.println("lowestPrice and fraction = " + lowestPrice+","+lowestFraction);

        WebElement clickPart1 = Driver.getDriver().findElement(By.xpath("//select[@id='s-result-sort-select']"));
        Select select1 = new Select(clickPart1);
        select1.selectByVisibleText("Price: High to Low");
        Thread.sleep(3000);
        String hightPrice=Driver.getDriver().findElement(By.xpath("(//span[@class='a-color-base'])[1]")).getText();
        Thread.sleep(3000);
        System.out.println("hightPrice = " + hightPrice);

        String hightpriceLast=hightPrice.replaceAll("[$,]","");
        System.out.println("hightpriceLast = " + hightpriceLast);
        String lastLowestPrice= lowestPrice+"."+lowestFraction;
        System.out.println("lastLowestPrice = " + lastLowestPrice);

        double hight=Double.parseDouble(hightpriceLast);
        System.out.println("hightpriceLast = " + hightpriceLast);

        double low=Double.parseDouble(lastLowestPrice);
        double averagePriceOfTeaPots=(hight+low)/2;
        System.out.println("averagePriceOfTeaPots = " + averagePriceOfTeaPots);


        Driver.closeDriver();
    }
}
