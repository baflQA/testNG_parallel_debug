package testngparallel.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ISuite;
import org.testng.ISuiteListener;

import java.lang.invoke.MethodHandles;

public class AfterSuiteListenerImp implements ISuiteListener {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Override
	public void onStart(ISuite suite) {
		logger.warn("MASTER CLASS On start");
		suite.addListener(new TestListenerImpl());
	}
}
