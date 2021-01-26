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

    public LogRestMessage givenAnnotationClass(String methodName) {
        try {
            return LogRestMessageTest.class.getDeclaredMethod(methodName).getAnnotation(LogRestMessage.class);
        } catch (Exception e) {
            Assert.fail();
            return null;
        }
    }

    @Test
    public void logTypeInLogRestMessageShouldBeLogTypeHttpMessage() {
        LogRestMessage annotation = givenAnnotationClass("logRestMessage");
        Assert.assertEquals(LogType.HTTP_MESSAGE, annotation.logType());
    }

    @Test
    public void logRestMessageShouldBeReturnPreExecuteMessageEmpty() {
        LogRestMessage annotation = givenAnnotationClass("logRestMessage");
        Assert.assertEquals("", annotation.preExecuteMessage());
    }

    @LogRestMessage
    private void logRestMessage() {
        System.out.println("test Log Rest Message annotation");
    }

    @Test
    public void logRestMessageShouldBeReturnPreExecuteMessageNoEmptyMessage() {
        LogRestMessage annotation = givenAnnotationClass("logRestMessageWithPreExecuteMessage");
        Assert.assertEquals("test pre execute message", annotation.preExecuteMessage());
    }

    @LogRestMessage(preExecuteMessage = "test pre execute message")
    private void logRestMessageWithPreExecuteMessage() {
        System.out.println("test Log Rest Message annotation");
    }

    @Test
    public void logRestMessageShouldBeReturnAllHttpMethods() {
        LogRestMessage annotation = givenAnnotationClass("logRestMessage");
        Assert.assertArrayEquals(new HttpMethod[]{HttpMethod.GET, HttpMethod.DELETE, HttpMethod.PUT, HttpMethod.POST, HttpMethod.PATCH}, annotation.httpMethods());
    }

    @Test
    public void logRestMessageShouldBeReturnHttpMethodGet() {
        LogRestMessage annotation = givenAnnotationClass("logRestMessageWithHttpMethodGet");
        Assert.assertArrayEquals(new HttpMethod[]{HttpMethod.GET}, annotation.httpMethods());
    }

    @LogRestMessage(httpMethods = HttpMethod.GET)
    private void logRestMessageWithHttpMethodGet() {
        System.out.println("test Log Rest Message annotation");
    }

    @Test
    public void logRestMessageShouldBeReturnHttpMethodPost() {
        LogRestMessage annotation = givenAnnotationClass("logRestMessageWithHttpMethodPost");
        Assert.assertArrayEquals(new HttpMethod[]{HttpMethod.POST}, annotation.httpMethods());
    }

    @LogRestMessage(httpMethods = HttpMethod.POST)
    private void logRestMessageWithHttpMethodPost() {
        System.out.println("test Log Rest Message annotation");
    }

    @Test
    public void logRestMessageShouldBeReturnHttpMethodDelete() {
        LogRestMessage annotation = givenAnnotationClass("logRestMessageWithHttpMethodDelete");
        Assert.assertArrayEquals(new HttpMethod[]{HttpMethod.DELETE}, annotation.httpMethods());
    }

    @LogRestMessage(httpMethods = HttpMethod.DELETE)
    private void logRestMessageWithHttpMethodDelete() {
        System.out.println("test Log Rest Message annotation");
    }


    @Test
    public void logRestMessageShouldBeReturnHttpMethodPut() {
        LogRestMessage annotation = givenAnnotationClass("logRestMessageWithHttpMethodPut");
        Assert.assertArrayEquals(new HttpMethod[]{HttpMethod.PUT}, annotation.httpMethods());
    }

    @LogRestMessage(httpMethods = HttpMethod.PUT)
    private void logRestMessageWithHttpMethodPut() {
        System.out.println("test Log Rest Message annotation");
    }

    @Test
    public void ogRestMessageShouldBeReturnHttpMethodPath() {
        LogRestMessage annotation = givenAnnotationClass("logRestMessageWithHttpMethodPath");
        Assert.assertArrayEquals(new HttpMethod[]{HttpMethod.PATCH}, annotation.httpMethods());
    }

    @LogRestMessage(httpMethods = HttpMethod.PATCH)
    private void logRestMessageWithHttpMethodPath() {
        System.out.println("test Log Rest Message annotation");
    }
}
