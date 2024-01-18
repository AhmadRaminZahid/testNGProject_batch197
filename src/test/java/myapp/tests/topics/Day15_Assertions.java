package myapp.tests.topics;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Day15_Assertions {

    /*
    in Junit we only had HARD ASSERTION
    in TestNG we have two types of assertions (Hard assertion(Assertion) and Soft assertion(Verification))
HARD assertion in TestNG is the same with assertion in JUnit, it stops the
execution of the rest of the test if the test fails at any point
SOFT assertion is different in sense that it does not stop execution of the rest of the test
if the test fails at any point
It will give the report of parts that failed , at the end
     */

    @Test
    public void hardAssertion(){
        System.out.println("checking how hard assertion works... ");
        Assert.assertTrue(true); //passes
        System.out.println("line 12...");
        Assert.assertTrue(false); //fails at this point, so the rest of the test
        //will not be executed
        System.out.println("line 14...");
    }

    @Test
    public void JavaAssertion(){
        /*
        this comes from Java library, it works the same way as Hard Asserion
        but we (Testers) prefer TestNG assertions, especially Hard Assertions
         */
        System.out.println("line 40");
        assert 3<5; //pass
        System.out.println("line 42");
        assert"Apple".contains("a"); //fail
        System.out.println("line 44");

    }

    @Test
    public void SoftAssertion(){
    /*
    if Soft assertion fails at any step, it continues to execute the test steps
    1. create the Soft assertion object
    2. use the soft assertion method like, assertTrue, assertEqual ...
    3. use the AssertAll method as a last step, otherwise you cannot find out if the test step failed or not
     */

        System.out.println("line 51");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(5,5);
        System.out.println("line 55");
        softAssert.assertTrue("Apple".toLowerCase().contains("a"));
        System.out.println("line 57");
        softAssert.assertEquals("apple","orange");
        System.out.println("line 59");
        softAssert.assertEquals("pineapple", "grapes");
        System.out.println("line 61");
        softAssert.assertAll();
    }
}
