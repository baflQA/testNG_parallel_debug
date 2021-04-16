package testngparallel.jarexitcode;

import org.testng.TestNG;
import org.testng.xml.Parser;

import java.io.FileInputStream;
import java.io.IOException;

class TestRunner {

    public static void main(String[] args) throws IOException {
        final TestNG testng = new TestNG();
        testng.setXmlSuites(new Parser(new FileInputStream("src/main/resources/testng-fail.xml")).parseToList());
        testng.run();
        System.exit(testng.getStatus());
    }
}
