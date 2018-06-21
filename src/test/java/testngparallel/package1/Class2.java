package testngparallel.package1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testngparallel.MasterTestClass;
import testngparallel.providers.Provider1;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;

public class Class2 extends MasterTestClass {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@BeforeMethod
	public void refresh() {
		logger.warn("{} Before method", this.getClass().getSimpleName());
	}

	@Test(dataProviderClass = Provider1.class, dataProvider = "dp3")
	public <T extends Object> void test1(Class<T> clazz, Object remarks, Method method) {
		logger.warn("{} {}", this.getClass().getSimpleName(), method.getName());
	}

	@Test(dataProviderClass = Provider1.class, dataProvider = "dp2")
	public void test2(Object remarks, Method method) {
		logger.warn("{} {}", this.getClass().getSimpleName(), method.getName());
	}

	@Test(dataProviderClass = Provider1.class, dataProvider = "dp3")
	public <T extends Object> void test3(Class<T> clazz, Object remarks, Method method) {
		logger.warn("{} {}", this.getClass().getSimpleName(), method.getName());

	}

	@AfterMethod
	public void afterMethods() {
		logger.warn("{} ConfiAfter method", this.getClass().getSimpleName() );
	}
}