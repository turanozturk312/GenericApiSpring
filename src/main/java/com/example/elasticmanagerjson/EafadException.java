package com.example.elasticmanagerjson;

import java.util.List;

public class EafadException extends RuntimeException {

    private MessageCodeEnum messageCodeEnum;
    private List<String> messageList;

    public EafadException(EafadExceptionBuilder eafadExceptionBuilder){
        super();
        this.messageCodeEnum = eafadExceptionBuilder.messageCodeEnum;
        this.messageList = eafadExceptionBuilder.messageList;
    }

    public static class EafadExceptionBuilder {

        private MessageCodeEnum messageCodeEnum;
        private List<String> messageList;

        public EafadExceptionBuilder(MessageCodeEnum messageCodeEnum){
            this.messageCodeEnum = messageCodeEnum;
        }

        public EafadExceptionBuilder messageCodeEnum(MessageCodeEnum messageCodeEnum){
            this.messageCodeEnum = messageCodeEnum;
            return this;
        }

        public EafadExceptionBuilder messageList(List<String> messageList){
            this.messageList = messageList;
            return this;
        }

        public EafadException build(){
            EafadException eafadException = new EafadException(this);
            return eafadException;
        }

    }

    public MessageCodeEnum getMessageCodeEnum() {
        return messageCodeEnum;
    }

    public List<String> getMessageList() {
        return messageList;
    }
}