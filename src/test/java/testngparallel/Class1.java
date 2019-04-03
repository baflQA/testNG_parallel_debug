package testngparallel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testngparallel.providers.MasterProvider;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;

import static org.testng.Assert.fail;

public class Class1 extends MasterTestClass {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@BeforeClass
	public void beforeClass() {
		logger.info("BEFORE CLASS");
		fail();
	}

	@BeforeMethod
	public void refresh() {
		logger.info("BEFORE METHOD");
	}

	@Test(dataProviderClass = MasterProvider.class, dataProvider = "dp1master")
	public <T extends Object> void test1(Class<T> clazz, Method method) {
		Class1.logger.warn("Running test {} for class {}.",method.getName(), clazz.getSimpleName());
	}

	@Test(dataProviderClass = MasterProvider.class, dataProvider = "dp1master")
	public <T extends Object> void test2(Class<T> clazz) {
		Class1.logger.warn("Running test for class {}.", clazz.getSimpleName());
	}
}