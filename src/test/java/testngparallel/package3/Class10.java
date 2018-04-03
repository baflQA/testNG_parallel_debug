package test.java.testngparallel.package3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.java.testngparallel.MasterTestClass;

import java.lang.invoke.MethodHandles;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Class10 extends MasterTestClass {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	private final ExecutorService executorService = Executors.newFixedThreadPool(2);
	private final CountDownLatch latch = new CountDownLatch(2);

	@BeforeClass
	public void createData() throws Exception {
		Class10.logger.warn("Before class");

		this.executorService.submit(() -> {
			try {
				Class10.logger.warn("First Thread");

			} finally {
				this.latch.countDown();
			}
		});
		this.executorService.submit(() -> {
			try {
				Class10.logger.warn("Second Thread");

			} finally {
				this.latch.countDown();
			}
		});
		this.latch.await();
	}

	@Test
	public void test1() {
		Class10.logger.warn("test 1");
	}

	@Test
	public void test2() {
		Class10.logger.warn("test 2");
	}

	@Test
	public void test3() {
		Class10.logger.warn("test 3");
	}

	@Test
	public void test4() {
		Class10.logger.warn("test 4");
	}

	@Test
	public void test5() {
		Class10.logger.warn("test 5");
	}

	@Test
	public void test6() {
		Class10.logger.warn("test 6");
	}
}
