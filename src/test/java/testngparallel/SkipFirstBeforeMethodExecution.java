package testngparallel;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.testng.Assert.assertEquals;

public class SkipFirstBeforeMethodExecution {

    AtomicInteger atomicInteger = new AtomicInteger();

    @BeforeClass
    public void createWebdriverAndNavigate() {
        //e.g.
        //webdriver = new WebDriver
        //webdriver.logIn()

        System.out.println("Before class");
    }


    @BeforeMethod(
            //skipFirstExecution = true
    )
    public void refreshPageBefore() {
        //e.g.
        //webdriver.refresh()
        System.out.println("Before method");
        atomicInteger.incrementAndGet();
    }

    @Test(priority = 1)
    public void test1() {
        assertEquals(atomicInteger.get(), 0); //before method skipped for the first test
    }

    @Test(priority = 2)
    public void test2() {
        assertEquals(atomicInteger.get(), 1); //before method executed for the second test
    }

    @AfterMethod(
            //skipLastExecution = true
    )
    public void refreshPageAfterMethod() {
        //e.g.
        //webdriver.refresh()
    }
}
