package com.example.elasticmanagerjson;

import org.springframework.util.CollectionUtils;

import java.util.List;

public class ExceptionUtil {

    protected ExceptionUtil(){
        throw new UnsupportedOperationException();
    }

    public static void addToMessageList(List<String> messageList, String message){
        if(!messageList.contains(message)){
            messageList.add(message);
        }
    }

    public static void throwIfAny(List<String> messageList, MessageCodeEnum messageCodeEnum){
        if(!CollectionUtils.isEmpty(messageList)){
            throw new EafadException.EafadExceptionBuilder(messageCodeEnum).messageList(messageList).build();
        }
    }

}
