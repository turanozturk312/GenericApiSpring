package com.example.elasticmanagerjson;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Arrays;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class EafadExceptionHandler {


    @Value("${elasticapi.providerBaseUrl}")
    private String elasticApiProviderUrl;

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handleExceptions(RuntimeException exception, WebRequest request) {

        if(exception instanceof EafadException){
            EafadException eafadException = (EafadException) exception;
            //LogUtil.exceptionLog(exception, eafadException.getMessageList(), eafadException.getMessageCodeEnum(), request, elasticApiProviderUrl);

            if(eafadException.getMessageCodeEnum().getValue().equals(MessageCodeEnum.ERROR.getValue())){
                return new ResponseEntity<>(new EafadResponse<>(HttpStatus.INTERNAL_SERVER_ERROR, eafadException.getMessageCodeEnum(), eafadException.getMessageList(), null), HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return new ResponseEntity<>(new EafadResponse<>(HttpStatus.OK, eafadException.getMessageCodeEnum(), eafadException.getMessageList(), null), HttpStatus.OK);
        }
        if(exception instanceof BadSqlGrammarException){
            String sqlExceptionMessage = "Bad sql grammar exception is available";
            LogUtil.exceptionLog(exception, Arrays.asList(sqlExceptionMessage), MessageCodeEnum.ERROR, request, elasticApiProviderUrl);

            return new ResponseEntity<>(new EafadResponse<>(HttpStatus.INTERNAL_SERVER_ERROR, MessageCodeEnum.ERROR, Arrays.asList(sqlExceptionMessage), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //LogUtil.exceptionLog(exception, Arrays.asList(exception.getMessage()), MessageCodeEnum.ERROR, request, elasticApiProviderUrl);
        return new ResponseEntity<>(new EafadResponse<>(HttpStatus.INTERNAL_SERVER_ERROR, MessageCodeEnum.ERROR, Arrays.asList(exception.getMessage()), null), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}


