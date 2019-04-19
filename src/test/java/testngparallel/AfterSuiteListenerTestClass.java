package testngparallel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import testngparallel.listeners.AfterSuiteListenerImp;
import testngparallel.listeners.TestReporter;

import java.lang.invoke.MethodHandles;

@Listeners({AfterSuiteListenerTestClass.class, TestReporter.class})
public class AfterSuiteListenerTestClass implements ITestListener, ISuiteListener {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Override
	public void onStart(ISuite suite) {
		logger.warn("MASTER CLASS On start");
		suite.addListener(new AfterSuiteListenerImp());
	}

	@BeforeClass(alwaysRun = true)
	public void setUp() {
		AfterSuiteListenerTestClass.logger.warn("MASTER CLASS Before class");
	}

	@BeforeMethod
	public void navigate() {
		AfterSuiteListenerTestClass.logger.warn("MASTER CLASS Before method");
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		AfterSuiteListenerTestClass.logger.warn("MASTER CLASS After class");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		AfterSuiteListenerTestClass.logger.warn("MASTER CLASS On Test Failure");
	}


	@Override
	public void onStart(ITestContext context) {
		AfterSuiteListenerTestClass.logger.warn("MASTER CLASS On start");
	}

	@Override
	public void onFinish(ITestContext context) {
		AfterSuiteListenerTestClass.logger.warn("MASTER CLASS On finish");
	}
}
