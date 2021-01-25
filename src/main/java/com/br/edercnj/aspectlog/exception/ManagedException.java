package com.br.edercnj.aspectlog.exception;

public class ManagedException extends Exception {

    private String debugMessage;
    private String userMessage;
    private int errorCod;
    private String moreInfo;

    public void setDebugMessage(String debugMessage) { this.debugMessage = debugMessage; }

    public void setUserMessage(String userMessage) { this.userMessage = userMessage; }

    public void setErrorCod(int errorCod) { this.errorCod = errorCod; }

    public void setMoreInfo(String moreInfo) { this.moreInfo = moreInfo; }

    protected ManagedException(String message) { super(message); }

    public String getDebugMessage() { return debugMessage; }

    public String getUserMessage() { return userMessage; }

    public int getErrorCod() { return errorCod; }

    public String getMoreInfo() { return moreInfo; }

    @Override
    public String toString() {
        return "DomainException{" +
                "debugMessage='" + getDebugMessage() + '\'' +
                ", userMessage='" + getUserMessage() + '\'' +
                ", errorCod=" + getErrorCod() +
                ", moreInfo='" + getMoreInfo() + '\'' +
                '}';
    }
}