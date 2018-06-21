package testngparallel.providers;

import org.testng.annotations.DataProvider;

public class Provider2 extends MasterProvider {

	@DataProvider(name = "dp1")
	public Object[][] getObjects() {
		return new Object[][]{new Object[]
				{Object.class, new Object(), new Object()},
				{Object.class, new Object(), new Object()},
				{Object.class, new Object(), new Object()},
				{Object.class, new Object(), new Object()},
				{Object.class, new Object(), new Object()}
		};
	}

	@DataProvider(name = "dp2")
	public Object[][] dp1() {
		return new Object[][]{new Object[]
				{Object.class, new Object(), new Object(),
						new Object(), new Object()},
				{Object.class, new Object(), new Object(),
						new Object(), new Object()},
				{Object.class, new Object(), new Object(),
						new Object(), new Object()},
				{Object.class, new Object(), new Object(),
						new Object(), new Object()},
		};
	}
}
