package core;

import io.cucumber.testng.Pickle;
import io.cucumber.testng.PickleWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryHandler implements IRetryAnalyzer {

    private int retryCount = 0;
    private int maxRetryCount = Integer.valueOf(System.getProperty("retry", "1"));
    private static Logger log = LoggerFactory.getLogger(RetryHandler.class);


    /**
     * Returns true if the test method has to be retried, false otherwise.
     *
     * @param result The result of the test method that just ran.
     * @return true if the test method has to be retried, false otherwise.
     */
    @Override
    public boolean retry(ITestResult result) {
        if (!result.isSuccess()) { // Check the Test is Success or not
            if (retryCount < maxRetryCount) { // Check max retry reached
                log.info("Retrying the Test: {} with Status: {} for the RetryCount: {}", getCucumberTestName(result), getResultStatus(result.getStatus()), retryCount + 1);
                retryCount++; // Increment the retry count
                result.setStatus(ITestResult.FAILURE); // Mark the test as fail
                return true; // Tell the testNg to rerun the test
            } else {
                result.setStatus(ITestResult.FAILURE); // Max Retry reached, so the test marked as fail
            }
        } else {
            result.setStatus(ITestResult.SUCCESS); // Mark the test as passed
        }
        return false;
    }

    public String getCucumberTestName(ITestResult result) {
        if (result == null) {
            return "- unknown";
        } else {
            return getPickle(result).getName();
        }
    }

    private Pickle getPickle(ITestResult result) {
        Object[] parameter = result.getParameters();
        if (parameter == null) {
            log.warn("Not Found any Parameters");
            return null;
        }
        PickleWrapper pickle = (PickleWrapper) result.getParameters()[0];
        return pickle.getPickle();
    }

    private String getResultStatus(int status) {
        String resultStatus = null;
        switch (status) {
            case 1:
                resultStatus = "SUCCESS";
                break;
            case 2:
                resultStatus = "FAILURE";
                break;
            case 3:
                resultStatus = "SKIP";
                break;
        }
        return resultStatus;
    }
}
