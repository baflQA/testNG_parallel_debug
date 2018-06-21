package testngparallel.package4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.testngparallel.MasterTestClass;
import test.java.testngparallel.providers.MasterProvider;
import test.java.testngparallel.providers.Provider2;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;

public class Class11 extends MasterTestClass {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@BeforeMethod
	public void refresh() {
		logger.warn("Before Method");
	}

	@Test(dataProviderClass = Provider2.class, dataProvider = "dp2")
	public <T extends Object> void test1(Class<T> clazz, Object object, Object object2, Object object3, Object object4, Method method) {
		logger.warn(clazz.getSimpleName() + "test 1");
	}

	@Test(dataProviderClass = MasterProvider.class, dataProvider = "dp2master")
	public <T extends Object> void test2(Class<T> clazz, Method method) {
		logger.warn(clazz.getSimpleName() + "test 2");
	}
}