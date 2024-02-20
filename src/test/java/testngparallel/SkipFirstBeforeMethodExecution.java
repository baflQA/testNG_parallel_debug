package testngparallel;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SkipFirstBeforeMethodExecution {

    @BeforeClass
    public void createWebdriverAndNavigate() {
        //webdriver = new WebDriver
        //webdriver.logIn()
    }


    @BeforeMethod(
            //skipFirstExecution = true
    )
    public void refreshPageBefore() {
        //webdriver.refresh()
    }

    @Test
    public void test() {
        assertTrue(true);
    }

    @AfterMethod(
            //skipLastExecution = true
    )
    public void refreshPageAfterMethod() {
        //webdriver.refresh()
    }
}
