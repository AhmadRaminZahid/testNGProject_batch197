package myapp.tests.topics;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Day15_dependsOnGroups {

    @Test (groups = "Smoke Test") // groups keyword is used to declare that
    // this test belongs to a particular group
    public void homePageTest(){
        System.out.println("home page test...");
        Assert.assertTrue(false); //test fails at this step
    }

    @Test (groups = "Smoke Test")
    public void searchTest(){
        System.out.println("searching something...");
      Assert.assertTrue(false); //test fails at this step
    }

    @Test (groups = "Regression Test")
    public void checkoutTest(){
        System.out.println("checking out...");
    }

    @Test (dependsOnGroups = "Smoke Test")
    public void logOutTest(){
        System.out.println("user logging out");
    }
    //   logOutTest is dependent on the group called "Smoke Test". If all tests belonging to this group pass, logOutTest will pass too
//    otherwise it will be skipped

}
