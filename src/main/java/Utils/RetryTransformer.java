package Utils;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class RetryTransformer implements IAnnotationTransformer {
@Override
    public void transform(ITestAnnotation annotation, Class testCLass, Constructor testConstructor, Method testMethod)
{
    annotation.setRetryAnalyzer(RetryAnalyser.class);
}

}
