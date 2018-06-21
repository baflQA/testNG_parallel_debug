package testngparallel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.lang.invoke.MethodHandles;

@Listeners({MasterTestClass.class})
public class MasterTestClass implements ITestListener {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@BeforeClass(alwaysRun = true)
	public void setUp() {
		MasterTestClass.logger.warn("Before class");
	}

	@BeforeMethod
	public void navigate() {
		MasterTestClass.logger.warn("Before method");
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		MasterTestClass.logger.warn("After class");
	}

	@Override
	public void onTestStart(ITestResult result) {
		//no need to implement!
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//no need to implement!
	}

	@Override
	public void onTestFailure(ITestResult result) {
		MasterTestClass.logger.warn("On Test Failure");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		//no need to implement!
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		//no need to implement!
	}

	@Override
	public void onStart(ITestContext context) {
		MasterTestClass.logger.warn("On start");
	}

	@Override
	public void onFinish(ITestContext context) {
		MasterTestClass.logger.warn("On finish");
	}
}
