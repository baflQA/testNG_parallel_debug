package testngparallel.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IRetryAnalyzer;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import java.lang.invoke.MethodHandles;

public class RetryAnalyzer implements IRetryAnalyzer {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	private static final int DEFAULT_MAX_RETRY_COUNT = 3;
	private int retryCount = 1;

	@Override
	public boolean retry(ITestResult result) {
		ITestNGMethod method = result.getMethod();
		RetriesCount annotation = method.getConstructorOrMethod().getMethod()
				.getAnnotation(RetriesCount.class);
		logger.warn("Run {} of {} failed with:", retryCount, method.getMethodName(), result.getThrowable());
		logger.error(String.valueOf(retryCount));
		if (retryCount < (annotation != null ? annotation.value() : DEFAULT_MAX_RETRY_COUNT)) {
			retryCount++;
			return true;
		}
		return false;
	}
}
