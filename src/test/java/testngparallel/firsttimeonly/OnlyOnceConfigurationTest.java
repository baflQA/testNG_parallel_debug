package testngparallel.firsttimeonly;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class OnlyOnceConfigurationTest extends ParentTestClass {

    @BeforeMethod(firstTimeOnly = true)
    public void beforeMethodFirstTimeOnlyTestClass(Method method) {
        System.out.println("First Time Only Test Class " + method);
    }

    @Test
    public void test() {
        System.out.println("Test passed");
    }

    @AfterMethod(lastTimeOnly = true)
    public void afterMethodLastTimeOnly() {
        System.out.println("Last Time Only");
    }
}
