package testngparallel.package3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testngparallel.MasterTestClass;

import java.lang.invoke.MethodHandles;

public class Class10 extends MasterTestClass {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@BeforeClass
	public void createData() {
		logger.warn("Before class");
	}

	@Test
	public void test1() {
		logger.warn("test 1");
	}

	@Test
	public void test2() {
		logger.warn("test 2");
	}

	@Test
	public void test3() {
		logger.warn("test 3");
	}

	@Test
	public void test4() {
		logger.warn("test 4");
	}

	@Test
	public void test5() {
		logger.warn("test 5");
	}

	@Test
	public void test6() {
		logger.warn("test 6");
	}
}
