package com.br.edercnj.aspectlog.annotations;

import com.br.edercnj.aspectlog.annotation.LogException;
import com.br.edercnj.aspectlog.enumeration.LogType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
public class LogExceptionTest {

    @Test
    public void logTypeInLogExceptionShouldBeLogTypeEXCEPTION() throws NoSuchMethodException {
        LogException annotation = LogExceptionTest.class.getDeclaredMethod("testLogException").getAnnotation(LogException.class);
        Assert.assertEquals(LogType.EXCEPTION, annotation.logType());
    }

    @LogException
    private void testLogException() {
        System.out.println("test log exception annotation");
    }
}
