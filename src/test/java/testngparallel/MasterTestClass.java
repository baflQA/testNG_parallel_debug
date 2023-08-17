package testngparallel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import testngparallel.listeners.DPListener;
import testngparallel.listeners.FailureDetector;
import testngparallel.listeners.TestListenerImpl;
import testngparallel.listeners.TestReporter;

import java.lang.invoke.MethodHandles;
@Listeners({MasterTestClass.class, TestReporter.class, FailureDetector.class, DPListener.class})
public class MasterTestClass implements ITestListener, ISuiteListener {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Override
	public void onStart(ISuite suite) {
		logger.warn("MASTER CLASS On start");
		suite.addListener(new TestListenerImpl());
	}

	@BeforeClass(alwaysRun = true)
	public void setUp() {
		logger.warn("MASTER CLASS Before class");
	}

	@BeforeMethod
	public void navigate() {
		logger.warn("MASTER CLASS Before method");
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		logger.warn("MASTER CLASS After class");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.warn("MASTER CLASS On Test Failure");
	}

	@Override
	public void onStart(ITestContext context) {
		logger.warn("MASTER CLASS On start");
	}

	@Override
	public void onFinish(ITestContext context) {
		logger.warn("MASTER CLASS On finish");
	}
}
