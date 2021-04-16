package testngparallel.jarexitcode;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Fail {

    @Test
    public void failedTest() {
        Assert.fail();
    }
}