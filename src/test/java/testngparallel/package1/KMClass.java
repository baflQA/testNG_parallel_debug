package testngparallel.package1;

import java.lang.invoke.MethodHandles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testngparallel.MasterTestClass;

public class KMClass extends MasterTestClass {

  private static final Logger logger = LoggerFactory
      .getLogger(MethodHandles.lookup().lookupClass());

  @BeforeMethod
  public void refresh(ITestResult result) {
    logger.warn("{} CONFIG Before method for {}()", this.getClass().getSimpleName(),
        result.getMethod().getMethodName());
  }

  @AfterMethod
  public void afterMethods(ITestResult result) {
    logger.warn("{} CONFIG After method for {}()", this.getClass().getSimpleName(),
        result.getMethod().getMethodName());
  }

  @Test
  public void failMethod() {
    Assert.fail();
  }

  @Test
  public void skipMethod() {
    logger.error("I should never be invoked");
  }

}
