package testngparallel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import testngparallel.listeners.RetryAnalyzer;
import testngparallel.listeners.RetryConfigurationMethodsListener;

import java.lang.invoke.MethodHandles;

@Listeners(RetryConfigurationMethodsListener.class)
public class DPRetryTest extends MasterTestClass {
    private static boolean aBoolean = false;
    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @BeforeClass
    public void beforeClass() {
        logger.info("BEFORE CLASS");
    }

    @BeforeMethod
    public void refresh() {
        logger.info("BEFORE METHOD");
    }


    @Test(dataProvider = "dp1master", retryAnalyzer = RetryAnalyzer.class)
    public void test1(Object object) {
        logger.info(object.toString());
    }

    @DataProvider
    public Object[][] dp1master() {
        if (!aBoolean) {
            try {
                logger.info("dp1 master");
                throw new IllegalStateException("asd");
            } catch (IllegalStateException e) {
                aBoolean = true;
                throw e;
            }
        }
        return new Object[][]{new Object[]{Object.class}};
    }
}