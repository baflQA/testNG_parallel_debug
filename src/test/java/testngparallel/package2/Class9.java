package test.java.testngparallel.package2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.testngparallel.MasterTestClass;

import java.lang.invoke.MethodHandles;

public class Class9 extends MasterTestClass {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@BeforeMethod
	public void before() {
		Class9.logger.warn("Before Method");
	}

	@Test
	public void create() {
		Class9.logger.warn("Create");
	}

	@Test(dependsOnMethods = "create")
	public void update() {
		Class9.logger.warn("Update");
	}

	@Test(dependsOnMethods = {"create", "update"})
	public void duplicate() {
		Class9.logger.warn("duplicate");
	}

	@Test(dependsOnMethods = {"create", "update", "duplicate"})
	public void delete() {
		Class9.logger.warn("Delete");
	}
}