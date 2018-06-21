package testngparallel.providers;

import org.testng.annotations.DataProvider;

public class MasterProvider {


	@DataProvider
	public Object[][] dp1master() {
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
