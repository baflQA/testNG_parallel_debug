package test.java.testngparallel.package4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.testngparallel.MasterTestClass;
import test.java.testngparallel.providers.MasterProvider;
import test.java.testngparallel.providers.Provider2;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;

public class Class12 extends MasterTestClass {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


	@BeforeMethod
	public void refresh() {
		Class12.logger.warn("Before method");
	}

	@Test(dataProviderClass = Provider2.class, dataProvider = "dp1")
	public <T extends Object> void test1(Class<T> clazz, Object object1, Object object2, Method method) {
		Class12.logger.warn(clazz.getSimpleName() + " test 1");
	}

	@Test(dataProviderClass = MasterProvider.class, dataProvider = "dp2master")
	public <T extends Object> void test2(Class<T> clazz, Method method) {
		Class12.logger.warn(clazz.getSimpleName() + " test 2");
	}
}