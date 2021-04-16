package testngparallel;

import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testngparallel.providers.MasterProvider;

import java.lang.invoke.MethodHandles;

public class Class1 extends MasterTestClass {
    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @BeforeClass
    public void beforeClass() {
        logger.info("BEFORE CLASS");
    }

    @BeforeMethod
    public void refresh() {
        logger.info("BEFORE METHOD");
    }

    @Step
    @Test(dataProviderClass = MasterProvider.class, dataProvider = "dp1master")
    public <T extends Object> void test1(Object object) {
        logger.info(object.toString());
    }

    @Test(dataProviderClass = MasterProvider.class, dataProvider = "dp1master")
    public <T extends Object> void test2(Object object) {
        logger.info(object.toString());
    }
}