package testngparallel.listeners;

import org.testng.*;

import java.time.Duration;

public class RetryConfigurationMethodsListener implements IConfigurable, IHookable {

    @Override
    public void run(IConfigureCallBack callBack, ITestResult testResult) {
        callBack.runConfigurationMethod(testResult);
        if (testResult.getThrowable() != null) {
            String className = testResult.getMethod().getTestClass().getName();
            String methodName = testResult.getMethod().getMethodName();
            System.out.printf("Configuration method '%s#%s' failed. Retrying...%n", className, methodName);
            for (int i = 0; i < 3; i++) {
                sleep5s();
                callBack.runConfigurationMethod(testResult);
                if (testResult.getThrowable() == null) {
                    break;
                } else {
                    System.out.printf("Retry %d/%d of '%s#%s' method failed.%n", i + 1, 3, className, methodName);
                }
            }
        }
    }

    private static void sleep5s() {
        try {
            Thread.sleep(Duration.ofSeconds(5).toMillis());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void run(IHookCallBack callBack, ITestResult testResult) {
        System.out.println(callBack);
    }
}
