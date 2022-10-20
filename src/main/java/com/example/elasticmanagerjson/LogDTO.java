package com.example.elasticmanagerjson;

import com.fasterxml.jackson.annotation.JsonFormat;

public class LogDTO {

    public String message;
    public String path;
    public String className;
    public String methodName;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public String messageDate;
    public Long responseTime;
    public String userId;
    public String userName;
    public String clientIp;
    public String clientName;
    public String clientType;
    public String clientDetail;
    public String hostIp;
    public ApplicationTypeEnum application;
    public LogTypeEnum logType;
    public String lokasyon;


    public LogTypeEnum getLogType() {
        return logType;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    public String getClassName() {
        return className;
    }

    public String getMethodName() {
        return methodName;
    }

    public String getMessageDate() {
        return messageDate;
    }

    public Long getResponseTime() {
        return responseTime;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getClientIp() {
        return clientIp;
    }

    public String getHostIp() {
        return hostIp;
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientDetail() {
        return clientDetail;
    }

    public String getLokasyon() {
        return lokasyon;
    }

    public String getClientType() {
        return clientType;
    }

    public ApplicationTypeEnum getApplication() {
        return application;
    }
}
