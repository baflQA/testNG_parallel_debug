package testngparallel.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import java.lang.invoke.MethodHandles;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class TestReporter implements IReporter {

	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	private static TestReporter INSTANCE;
	private final Map<Keys, Set<ITestResult>> data = new ConcurrentHashMap<>();

	public TestReporter() {
		setInstance(this);
	}

	public static TestReporter getInstance() {
		return INSTANCE;
	}

	private static void setInstance(TestReporter instance) {
		INSTANCE = instance;
	}

	public Map<Keys, Set<ITestResult>> getData() {
		return data;
	}

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		logger.info("PRINTING TEST RESULTS");
		suites.forEach(this::generateReport);
	}

	private void generateReport(ISuite suite) {
		suite.getResults().values().forEach(this::generateReport);
	}

	private void generateReport(ISuiteResult suiteResult) {
		String msg = "List of passed tests.";
		generateReport(suiteResult.getTestContext().getPassedTests().getAllResults(), msg, Keys.PASSED_TESTS);
		msg = "List of failed tests.";
		generateReport(suiteResult.getTestContext().getFailedTests().getAllResults(), msg, Keys.FAILED_TESTS);
		msg = "List of skipped tests.";
		generateReport(suiteResult.getTestContext().getSkippedTests().getAllResults(), msg, Keys.SKIPPED_TESTS);
		msg = "List of passed configurations.";
		generateReport(suiteResult.getTestContext().getPassedConfigurations().getAllResults(), msg,
				Keys.PASSED_CONFIGS);
		msg = "List of failed configurations.";
		generateReport(suiteResult.getTestContext().getFailedConfigurations().getAllResults(), msg,
				Keys.FAILED_CONFIGS);
		msg = "List of skipped configurations.";
		generateReport(suiteResult.getTestContext().getSkippedConfigurations().getAllResults(), msg,
				Keys.SKIPPED_CONFIGS);
	}

	private void generateReport(Set<ITestResult> results, String title, Keys key) {
		if (results.isEmpty()) {
			logger.info("Skipping print of [{}] because nothing is present.", title);
			data.put(key, new HashSet<>());
			return;
		}
		logger.info("{} [{}]", title, results.size());
		results.forEach(result -> logger.info("{}.{}()", result.getMethod().getTestClass().getName(),
				result.getMethod().getMethodName()));
		data.put(key, results);
	}

	public enum Keys {
		PASSED_TESTS,
		FAILED_TESTS,
		SKIPPED_TESTS,
		PASSED_CONFIGS,
		FAILED_CONFIGS,
		SKIPPED_CONFIGS
	}
}
