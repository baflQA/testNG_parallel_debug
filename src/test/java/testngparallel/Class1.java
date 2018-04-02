package test.java.testngparallel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.testngparallel.providers.MasterProvider;

import java.lang.invoke.MethodHandles;

public class Class1 extends MasterTestClass {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@BeforeMethod
	public void refresh() {
		Class1.logger.warn("Before method");
	}

	@Test(dataProviderClass = MasterProvider.class, dataProvider = "dp1master")
	public <T extends Object> void test1(Class<T> clazz) {
		Class1.logger.warn("Running test for class {}.", clazz.getSimpleName());
	}

	@Test(dataProviderClass = MasterProvider.class, dataProvider = "dp1master")
	public <T extends Object> void test2(Class<T> clazz) {
		Class1.logger.warn("Running test for class {}.", clazz.getSimpleName());
	}
}