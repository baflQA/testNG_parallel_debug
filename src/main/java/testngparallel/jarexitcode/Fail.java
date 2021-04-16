package testngparallel.jarexitcode;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Fail {

    @BeforeMethod
    public void failedConf() {
        Assert.fail();
    }

    @Test
    public void failedTest() {
        Assert.fail();
    }
}