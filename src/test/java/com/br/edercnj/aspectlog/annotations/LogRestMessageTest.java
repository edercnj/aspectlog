package com.br.edercnj.aspectlog.annotations;

import com.br.edercnj.aspectlog.annotation.LogRestMessage;
import com.br.edercnj.aspectlog.enumeration.HttpMethod;
import com.br.edercnj.aspectlog.enumeration.LogType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
public class LogRestMessageTest {

    @Test
    public void logTypeInLogRestMessageShouldBeLogTypeHttpMessage() throws NoSuchMethodException {
        LogRestMessage annotation = LogRestMessageTest.class.getDeclaredMethod("logRestMessage").getAnnotation(LogRestMessage.class);
        Assert.assertEquals(LogType.HTTP_MESSAGE, annotation.logType());
    }

    @Test
    public void logRestMessageShouldBeReturnPreExecuteMessageEmpty() throws NoSuchMethodException {
        LogRestMessage annotation = LogRestMessageTest.class.getDeclaredMethod("logRestMessage").getAnnotation(LogRestMessage.class);
        Assert.assertEquals("", annotation.preExecuteMessage());
    }

    @LogRestMessage
    private void logRestMessage() {
        System.out.println("test Log Rest Message annotation");
    }

    @Test
    public void logRestMessageShouldBeReturnPreExecuteMessageNoEmptyMessage() throws NoSuchMethodException {
        LogRestMessage annotation = LogRestMessageTest.class.getDeclaredMethod("logRestMessageWithPreExecuteMessage").getAnnotation(LogRestMessage.class);
        Assert.assertEquals("test pre execute message", annotation.preExecuteMessage());
    }

    @LogRestMessage(preExecuteMessage = "test pre execute message")
    private void logRestMessageWithPreExecuteMessage() {
        System.out.println("test Log Rest Message annotation");
    }

    @Test
    public void ogRestMessageShouldBeReturnAllHttpMethods() throws NoSuchMethodException {
        LogRestMessage annotation = LogRestMessageTest.class.getDeclaredMethod("logRestMessage").getAnnotation(LogRestMessage.class);
        Assert.assertArrayEquals(new HttpMethod[]{HttpMethod.GET, HttpMethod.DELETE, HttpMethod.PUT, HttpMethod.POST, HttpMethod.PATCH}, annotation.httpMethods());
    }

    @Test
    public void ogRestMessageShouldBeReturnHttpMethodGet() throws NoSuchMethodException {
        LogRestMessage annotation = LogRestMessageTest.class.getDeclaredMethod("logRestMessageWithHttpMethodGet").getAnnotation(LogRestMessage.class);
        Assert.assertArrayEquals(new HttpMethod[]{HttpMethod.GET}, annotation.httpMethods());
    }

    @LogRestMessage(httpMethods = HttpMethod.GET)
    private void logRestMessageWithHttpMethodGet() {
        System.out.println("test Log Rest Message annotation");
    }

    @Test
    public void ogRestMessageShouldBeReturnHttpMethodPost() throws NoSuchMethodException {
        LogRestMessage annotation = LogRestMessageTest.class.getDeclaredMethod("logRestMessageWithHttpMethodPost").getAnnotation(LogRestMessage.class);
        Assert.assertArrayEquals(new HttpMethod[]{HttpMethod.POST}, annotation.httpMethods());
    }

    @LogRestMessage(httpMethods = HttpMethod.POST)
    private void logRestMessageWithHttpMethodPost() {
        System.out.println("test Log Rest Message annotation");
    }

    @Test
    public void ogRestMessageShouldBeReturnHttpMethodDelete() throws NoSuchMethodException {
        LogRestMessage annotation = LogRestMessageTest.class.getDeclaredMethod("logRestMessageWithHttpMethodDelete").getAnnotation(LogRestMessage.class);
        Assert.assertArrayEquals(new HttpMethod[]{HttpMethod.DELETE}, annotation.httpMethods());
    }

    @LogRestMessage(httpMethods = HttpMethod.DELETE)
    private void logRestMessageWithHttpMethodDelete() {
        System.out.println("test Log Rest Message annotation");
    }


    @Test
    public void ogRestMessageShouldBeReturnHttpMethodPut() throws NoSuchMethodException {
        LogRestMessage annotation = LogRestMessageTest.class.getDeclaredMethod("logRestMessageWithHttpMethodPut").getAnnotation(LogRestMessage.class);
        Assert.assertArrayEquals(new HttpMethod[]{HttpMethod.PUT}, annotation.httpMethods());
    }

    @LogRestMessage(httpMethods = HttpMethod.PUT)
    private void logRestMessageWithHttpMethodPut() {
        System.out.println("test Log Rest Message annotation");
    }

    @Test
    public void ogRestMessageShouldBeReturnHttpMethodPath() throws NoSuchMethodException {
        LogRestMessage annotation = LogRestMessageTest.class.getDeclaredMethod("logRestMessageWithHttpMethodPath").getAnnotation(LogRestMessage.class);
        Assert.assertArrayEquals(new HttpMethod[]{HttpMethod.PATCH}, annotation.httpMethods());
    }

    @LogRestMessage(httpMethods = HttpMethod.PATCH)
    private void logRestMessageWithHttpMethodPath() {
        System.out.println("test Log Rest Message annotation");
    }
}
