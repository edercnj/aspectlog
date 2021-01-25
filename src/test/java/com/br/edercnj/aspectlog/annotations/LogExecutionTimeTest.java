package com.br.edercnj.aspectlog.annotations;

import com.br.edercnj.aspectlog.annotation.LogExecutionTime;
import com.br.edercnj.aspectlog.enumeration.LogTimeType;
import com.br.edercnj.aspectlog.enumeration.LogType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
public class LogExecutionTimeTest {

    @Test
    public void logTypeInLogExecutionTimeShouldBeLogTypeExecutionTime() throws NoSuchMethodException {
        LogExecutionTime annotation = LogExecutionTimeTest.class.getDeclaredMethod("logExecutionTimeTest").getAnnotation(LogExecutionTime.class);
        Assert.assertEquals(LogType.EXECUTION_TIME, annotation.logType());
    }

    @Test
    public void testLogInExecutionTimeShouldBeReturnPreExecuteMessageEmpty() throws NoSuchMethodException {
        LogExecutionTime annotation = LogExecutionTimeTest.class.getDeclaredMethod("logExecutionTimeTest").getAnnotation(LogExecutionTime.class);
        Assert.assertEquals("", annotation.preExecuteMessage());
    }

    @LogExecutionTime
    private void logExecutionTimeTest() {
        System.out.println("test log Execution Time annotation");
    }

    @Test
    public void testLogInExecutionTimeShouldBeReturnPreExecuteMessageNoEmptyMessage() throws NoSuchMethodException {
        LogExecutionTime annotation = LogExecutionTimeTest.class.getDeclaredMethod("logExecutionTimeWithPreExecuteMessage").getAnnotation(LogExecutionTime.class);
        Assert.assertEquals("test pre execute message for LogExecutionTime", annotation.preExecuteMessage());
    }

    @LogExecutionTime(preExecuteMessage = "test pre execute message for LogExecutionTime")
    private void logExecutionTimeWithPreExecuteMessage() {
        System.out.println("test log Execution Time annotation");
    }

    @Test
    public void testLogInExecutionTimeShouldBeReturnLogTimeTypeDefaultMilliseconds() throws NoSuchMethodException {
        LogExecutionTime annotation = LogExecutionTimeTest.class.getDeclaredMethod("logExecutionTimeTest").getAnnotation(LogExecutionTime.class);
        Assert.assertEquals(LogTimeType.MILLISECONDS, annotation.logTimeType());
    }

    @Test
    public void testLogInExecutionTimeShouldBeReturnLogTimeTypeDefaultSeconds() throws NoSuchMethodException {
        LogExecutionTime annotation = LogExecutionTimeTest.class.getDeclaredMethod("logExecutionTimeTestWithSeconds").getAnnotation(LogExecutionTime.class);
        Assert.assertEquals(LogTimeType.SECONDS, annotation.logTimeType());
    }
    @LogExecutionTime(logTimeType = LogTimeType.SECONDS)
    private void logExecutionTimeTestWithSeconds() {
        System.out.println("test log Execution Time annotation with seconds");
    }

    @Test
    public void testLogInExecutionTimeShouldBeReturnLogTimeTypeDefaultMinutes() throws NoSuchMethodException {
        LogExecutionTime annotation = LogExecutionTimeTest.class.getDeclaredMethod("logExecutionTimeTestWithMinutes").getAnnotation(LogExecutionTime.class);
        Assert.assertEquals(LogTimeType.MINUTES, annotation.logTimeType());
    }
    @LogExecutionTime(logTimeType = LogTimeType.MINUTES)
    private void logExecutionTimeTestWithMinutes() {
        System.out.println("test log Execution Time annotation with minutes");
    }
}
