package testngparallel.listeners;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.SkipException;

public class FailFastListener implements IInvokedMethodListener {
	private static final String FAIL_FAST = System.getProperty("failFast");
	private static final Boolean IS_FAIL_FAST = true;
	private static boolean hasFailures = false;

	@Override
	public synchronized void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		if (!IS_FAIL_FAST || !method.isTestMethod()) {
			return;
		}
		if (hasFailures) {
			throw new SkipException(
					String.format("Skipping \"%s\" test method.", method.getTestMethod().getMethodName()));
		}
	}

	@Override
	public synchronized void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		if (!IS_FAIL_FAST && !method.isTestMethod()) {
			return;
		}
		if ((!hasFailures) && !testResult.isSuccess()) {
			hasFailures = true;
		}
	}
}
