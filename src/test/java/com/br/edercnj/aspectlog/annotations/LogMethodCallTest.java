package com.br.edercnj.aspectlog.annotations;

import com.br.edercnj.aspectlog.annotation.LogMethodCall;
import com.br.edercnj.aspectlog.enumeration.LogType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
public class LogMethodCallTest {

    @Test
    public void logTypeInLogExceptionShouldBeLogTypeException() throws NoSuchMethodException {
        LogMethodCall annotation = LogMethodCallTest.class.getDeclaredMethod("logMethodCall").getAnnotation(LogMethodCall.class);
        Assert.assertEquals(LogType.METHOD_CALL, annotation.logType());
    }

    @Test
    public void testLogExceptionShouldBeReturnPreExecuteMessageEmpty() throws NoSuchMethodException {
        LogMethodCall annotation = LogMethodCallTest.class.getDeclaredMethod("logMethodCall").getAnnotation(LogMethodCall.class);
        Assert.assertEquals("", annotation.preExecuteMessage());
    }

    @LogMethodCall
    private void logMethodCall() {
        System.out.println("test log exception annotation");
    }

    @Test
    public void testLogExceptionShouldBeReturnPreExecuteMessageNoEmptyMessage() throws NoSuchMethodException {
        LogMethodCall annotation = LogMethodCallTest.class.getDeclaredMethod("logMethodCallWithPreExecuteMessage").getAnnotation(LogMethodCall.class);
        Assert.assertEquals("test pre execute message", annotation.preExecuteMessage());
    }

    @LogMethodCall(preExecuteMessage = "test pre execute message")
    private void logMethodCallWithPreExecuteMessage() {
        System.out.println("test log exception annotation");
    }
}
