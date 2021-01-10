package com.br.edercnj.aspectlog.exception;

public class ManagedException extends DomainException {
    public ManagedException(String message, String debugMessage, String userMessage, int errorCod, String moreInfo) {
        super(message, debugMessage, userMessage, errorCod, moreInfo);
    }
}
