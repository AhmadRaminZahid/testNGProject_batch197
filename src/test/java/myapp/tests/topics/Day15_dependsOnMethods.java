package myapp.tests.topics;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Day15_dependsOnMethods {
    //  DependsOnMethods parameter is used to make tests dependent on each other
//    If the test (on which other tests are dependent) fails, the other tests will be skipped

    @Test
    public void homePageTest(){
        System.out.println("home page test...");
        //Assert.assertTrue(false);
    }

    @Test (dependsOnMethods = "homePageTest")
    public void searchTest(){
        System.out.println("searching something...");
        Assert.assertTrue(false);
    }

    @Test (dependsOnMethods = "searchTest")
    public void checkoutTest(){
        System.out.println("checking out...");
    }

}
