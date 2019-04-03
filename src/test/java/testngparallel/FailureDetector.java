package testngparallel;

import org.testng.*;

public class FailureDetector implements IConfigurationListener, IDataProviderListener {
	public static final String FAILURE = "failure";

	@Override
	public void onConfigurationFailure(ITestResult itr) {
		itr.getTestContext().setAttribute(FAILURE, Boolean.TRUE.toString());
	}

	@Override
	public void beforeDataProviderExecution(IDataProviderMethod dataProviderMethod, ITestNGMethod method, ITestContext iTestContext) {
		if (iTestContext.getAttribute(FailureDetector.FAILURE) != null) {
			throw new SkipException("Failure");
		}
	}
}

