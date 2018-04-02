package test.java.testngparallel.package1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.testngparallel.MasterTestClass;
import test.java.testngparallel.providers.Provider1;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;

public class Class4 extends MasterTestClass {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@BeforeMethod
	public void refresh() {
	}

	@Test(dataProviderClass = Provider1.class, dataProvider = "dp3")
	public <T extends Object> void test1(Class<T> clazz, Object remarks, Method method) {
		Class4.logger.warn(method.getName());

	}

	@Test(dataProviderClass = Provider1.class, dataProvider = "dp2", enabled = false)
	public void test2(Object remarks, Method method) {
		Class4.logger.warn(method.getName());

	}

	@Test(dataProviderClass = Provider1.class, dataProvider = "dp3")
	public <T extends Object> void test3(Class<T> clazz, Object remarks, Method method) {
		Class4.logger.warn(method.getName());

	}

	@Test(dataProviderClass = Provider1.class, dataProvider = "dp2")
	public void test4(Object remarks, Method method) {
		Class4.logger.warn(method.getName());

	}

	@Test(dataProviderClass = Provider1.class, dataProvider = "dp4")
	public <T extends Object> void test5(Class<T> clazz, Object remarks, Method method) {
		Class4.logger.warn(method.getName());

	}

	@Test(dataProviderClass = Provider1.class, dataProvider = "dp1")
	public void test6(Object remarks, Method method) {
		Class4.logger.warn(method.getName());

	}
}