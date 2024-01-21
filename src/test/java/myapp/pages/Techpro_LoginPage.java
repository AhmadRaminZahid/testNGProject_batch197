package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Techpro_LoginPage {
    public Techpro_LoginPage (){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath =" //a//i") public WebElement logoutButton;
    @FindBy(xpath = "//div[@role='alert']") public WebElement loginVerification ;
}
