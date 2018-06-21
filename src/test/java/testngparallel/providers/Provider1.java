package testngparallel.providers;

import org.testng.annotations.DataProvider;

public class Provider1 extends MasterProvider {

	@DataProvider(name = "dp1")
	public Object[][] dp1() {
		return new Object[][]{new Object[]{new Object()}};
	}

	@DataProvider(name = "dp2")
	public Object[][] dp2() {
		return new Object[][]{new Object[]
				{new Object()}, {new Object()}, {new Object()}, {new Object()}
		};
	}

	@DataProvider(name = "dp3")
	public Object[][] dp3() {
		return new Object[][]{new Object[]
				{Object.class, new Object()},
				{Object.class, new Object()},
				{Object.class, new Object()},
				{Object.class, new Object()}
		};
	}

	@DataProvider(name = "dp4")
	public Object[][] getTwoEmmeObjects() {
		return new Object[][]{new Object[]
				{Object.class, new Object()},
				{Object.class, new Object()},
				{Object.class, new Object()},
				{Object.class, new Object()}
		};
	}

}
