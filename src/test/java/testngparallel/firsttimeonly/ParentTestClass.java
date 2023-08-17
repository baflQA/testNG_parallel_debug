package testngparallel.firsttimeonly;

import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import testngparallel.listeners.DPListener;
import testngparallel.listeners.FailureDetector;
import testngparallel.listeners.TestReporter;

import java.lang.reflect.Method;

@Listeners({ParentTestClass.class, TestReporter.class, FailureDetector.class, DPListener.class})
public class ParentTestClass implements ITestListener, ISuiteListener {

	@BeforeMethod(firstTimeOnly = true)
	public void beforeMethodFirstTimeOnlyParent(Method method) {
		System.out.println("First Time Only Parent " + method);
	}
}
