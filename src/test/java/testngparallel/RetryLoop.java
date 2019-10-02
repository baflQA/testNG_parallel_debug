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
	Object existingObject = new Object();

	@RetriesCount(3)
	@Test(retryAnalyzer = RetryAnalyzer.class, dataProvider = "dpNewObject")
	public void willNotStopAfter3Failures(Object newObject) {
		logger.info("Run: " + atomicInt.incrementAndGet());
		Assert.fail("Kaboom!");
	}

	@RetriesCount(3)
	@Test(retryAnalyzer = RetryAnalyzer.class, dataProvider = "dpNewSameObject")
	public void willStopAfter3Failures(Object existingObject) {
		logger.info("Run: " + atomicInt.incrementAndGet());
		Assert.fail("Kaboom!");
	}

	@DataProvider
	public Object[][] dpNewObject() {
		return new Object[][]{new Object[] {new Object()}};
	}

	@DataProvider
	public Object[][] dpNewSameObject() {
		return new Object[][]{new Object[] {existingObject}};
	}
}
