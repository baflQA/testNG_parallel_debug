package test.java.testngparallel.providers;

import org.testng.annotations.DataProvider;

public class Provider2 extends MasterProvider {

	@DataProvider(name = "dp1")
	public Object[][] getEmmeObjects() {
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
