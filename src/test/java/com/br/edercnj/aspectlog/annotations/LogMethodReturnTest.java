package com.br.edercnj.aspectlog.annotations;

import com.br.edercnj.aspectlog.annotation.LogMethodCall;
import com.br.edercnj.aspectlog.annotation.LogMethodReturn;
import com.br.edercnj.aspectlog.enumeration.LogType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
public class LogMethodReturnTest {

    @Test
    public void logTypeInLogMethodReturnShouldBeLogTypeException() throws NoSuchMethodException {
        LogMethodReturn annotation = LogMethodReturnTest.class.getDeclaredMethod("logMethodReturn").getAnnotation(LogMethodReturn.class);
        Assert.assertEquals(LogType.METHOD_RETURN, annotation.logType());
    }

    @Test
    public void logMethodReturnShouldBeReturnPreExecuteMessageEmpty() throws NoSuchMethodException {
        LogMethodReturn annotation = LogMethodReturnTest.class.getDeclaredMethod("logMethodReturn").getAnnotation(LogMethodReturn.class);
        Assert.assertEquals("", annotation.preExecuteMessage());
    }

    @LogMethodReturn
    private void logMethodReturn() {
        System.out.println("test log exception annotation");
    }

    @Test
    public void logMethodReturnShouldBeReturnPreExecuteMessageNoEmptyMessage() throws NoSuchMethodException {
        LogMethodReturn annotation = LogMethodReturnTest.class.getDeclaredMethod("logMethodReturnWithPreExecuteMessage").getAnnotation(LogMethodReturn.class);
        Assert.assertEquals("test pre execute message", annotation.preExecuteMessage());
    }

    @LogMethodReturn(preExecuteMessage = "test pre execute message")
    private void logMethodReturnWithPreExecuteMessage() {
        System.out.println("test log exception annotation");
    }
}
