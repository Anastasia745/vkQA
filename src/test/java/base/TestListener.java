package base;

import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Отчёты о прохождении тестов
 * */
public class TestListener implements ITestListener {

    /**
     * Тест пройден
     * */
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed: " + result.getName());
    }

    /**
     * Тест не пройден
     * */
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed: " + result.getName());
    }

    /**
     * Тест пропущен
     * */
    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped: " + result.getName());
    }
}