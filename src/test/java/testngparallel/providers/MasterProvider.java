package testngparallel.providers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;

import java.lang.invoke.MethodHandles;

public class MasterProvider {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@DataProvider
	public Object[][] dp1master() {
		logger.info("dp1 master");
		return new Object[][]{new Object[]
				{Object.class},
				{Object.class},
				{Object.class},
				{Object.class}
		};
	}

	@DataProvider
	public Object[][] dp2master() {
		return new Object[][]{new Object[]
				{Object.class},
				{Object.class},
				{Object.class},
				{Object.class},
				{Object.class}
		};
	}
}
