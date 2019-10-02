package testngparallel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testngparallel.listeners.RetriesCount;
import testngparallel.listeners.RetryAnalyzer;

import java.lang.invoke.MethodHandles;
import java.util.concurrent.atomic.AtomicInteger;

public class RetryLoop {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	private AtomicInteger atomicInt = new AtomicInteger(0);

	@RetriesCount(3)
	@Test(retryAnalyzer = RetryAnalyzer.class, dataProvider = "dp3")
	public void test1(Object object) {
		logger.info("Run: " + atomicInt.incrementAndGet());
		Assert.fail("Kaboom!");
	}

	@DataProvider
	public Object[][] dp3() {
		return new Object[][]{new Object[] {new Object()}};
	}
}
