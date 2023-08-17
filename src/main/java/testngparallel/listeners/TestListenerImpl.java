package testngparallel.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.lang.invoke.MethodHandles;

public class TestListenerImpl implements ITestListener {

	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	private static final String ON_TEST_MSG = "TEST LISTENER - ON TEST";

	@Override
	public void onTestStart(ITestResult result) {
		logger.warn("{} START", ON_TEST_MSG);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.warn("{} SUCCESS", ON_TEST_MSG);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.warn("{} FAILURE", ON_TEST_MSG);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.warn("{} SKIPPED", ON_TEST_MSG);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		logger.warn("{} FAILED BUT WITHIN SUCCESS PERCENTAGE", ON_TEST_MSG);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		logger.warn("{} FAILED WITH TIMEOUT", ON_TEST_MSG);
	}
}

