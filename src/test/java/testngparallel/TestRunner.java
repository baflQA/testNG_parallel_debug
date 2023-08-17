package testngparallel;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.TestNG;
import org.testng.annotations.Test;
import testngparallel.listeners.TestReporter;
import testngparallel.listeners.TestReporter.Keys;
import testngparallel.package1.KMClassTest;

import java.util.Map;
import java.util.Set;

public class TestRunner {

  @Test
  public void runTest() {
    TestNG testng = new TestNG();
    testng.setTestClasses(new Class[]{KMClassTest.class});
    testng.setVerbose(2);
    testng.run();
    Map<Keys, Set<ITestResult>> data = TestReporter.getInstance().getData();

    Assert.assertEquals(data.get(Keys.PASSED_TESTS).size(), 0);
    Assert.assertEquals(data.get(Keys.FAILED_TESTS).size(), 1);
    Assert.assertEquals(data.get(Keys.SKIPPED_TESTS).size(), 1);
    Assert.assertEquals(data.get(Keys.PASSED_CONFIGS).size(), 3);
    Assert.assertEquals(data.get(Keys.FAILED_CONFIGS).size(), 0);
    Assert.assertEquals(data.get(Keys.SKIPPED_CONFIGS).size(), 5);
  }
}
