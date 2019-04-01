package testngparallel.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.*;

import java.lang.invoke.MethodHandles;

public class FailFastListener implements IInvokedMethodListener, IConfigurationListener, IDataProviderListener {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	private static boolean hasFailures = false;

	@Override
	public synchronized void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		logger.info("AFTER INVOCATION");
		if (method.isTestMethod() && !hasFailures && !testResult.isSuccess()) {
			hasFailures = true;
		}
	}

	@Override
	public void beforeConfiguration(ITestResult testResult) {
		logger.info("BEFORE CONFIGURATION");
	}

	@Override
	public void beforeDataProviderExecution(IDataProviderMethod dataProviderMethod, ITestNGMethod method, ITestContext iTestContext) {
		logger.info("BEFORE DATA PROVIDER");
	}
}
