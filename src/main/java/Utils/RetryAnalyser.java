package Utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {

    public int retryCount=0;
    public static final int MAX_RETRY_COUNT=2;

    @Override
    public boolean retry(ITestResult result)
    {
        if(retryCount<MAX_RETRY_COUNT)
        {
            retryCount++;
            System.out.println("Retrying "+result.getMethod().getMethodName()
            + " |Attempt "+(retryCount+1)
            + " |Reason "+result.getThrowable());
            return true;
        }

        return false;
    }

}
