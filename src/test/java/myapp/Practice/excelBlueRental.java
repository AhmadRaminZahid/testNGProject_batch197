package myapp.Practice;

import myapp.pages.BlueRental_HomePage;
import myapp.pages.BlueRental_LoginPage;
import myapp.utilities.Driver;
import myapp.utilities.ExcelUtils;
import myapp.utilities.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class excelBlueRental {
//    HW: vTest the log in functionality of the application with different user
//    profiles (admin, manager, customer services, end user)

//    vTest Data URL : https://www.bluerentalcars.com/
//    vUser Credentials : Excel Sheet
List< Map <String,String>> list;
    ExcelUtils excelUtils;
    @Test
    public void test(){

        String path= "./resources/data_sheet.xlsx";
       excelUtils = new ExcelUtils(path,"admin_credentials");
       list= excelUtils.getDataList();
        System.out.println(list);
        Map<String ,String > row1= list.get(0);
        System.out.println(row1);
        BlueRental_LoginPage blueRentalLoginPage= new BlueRental_LoginPage();
        BlueRental_HomePage blueRental_homePage= new BlueRental_HomePage();
        // go to the website
         WaitUtils.waitFor(2);
            Driver.getDriver().get("https://www.bluerentalcars.com/");
            blueRental_homePage.userIcon.click();
            WaitUtils.waitFor(2);
            blueRentalLoginPage.email.sendKeys(row1.get("username"));
            WaitUtils.waitFor(2);
            blueRentalLoginPage.password.sendKeys(row1.get("password"));
            WaitUtils.waitFor(2);
            blueRentalLoginPage.loginButton.click();
            WaitUtils.waitFor(2);
            //Assert.assertTrue(blueRentalLoginPage.dropDown.isDisplayed());



Driver.closeDriver();


    }

}
