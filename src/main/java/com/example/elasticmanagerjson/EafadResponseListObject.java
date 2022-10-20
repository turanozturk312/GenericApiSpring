package com.example.elasticmanagerjson;

import org.springframework.http.HttpStatus;

import java.util.List;

public class EafadResponseListObject {

    private HttpStatus status;
    private MessageCodeEnum messageCode;
    private List<String> messageList;
    private List<Object> data;

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public MessageCodeEnum getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(MessageCodeEnum messageCode) {
        this.messageCode = messageCode;
    }

    public List<String> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<String> messageList) {
        this.messageList = messageList;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }
}
