package com.example.elasticmanagerjson;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.util.ObjectUtils;
import org.springframework.web.context.request.WebRequest;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class LogUtil {

    private static final Logger logger = LoggerFactory.getLogger(LogUtil.class);

    private LogUtil(){

    }

    public static void log(LogDTO logDTO,String token, String elasticApiProviderUrl)
    {
        if(ObjectUtils.isEmpty(logDTO.logType))
            logDTO.logType=LogTypeEnum.INFO;

        if(ObjectUtils.isEmpty(logDTO.application))
            logDTO.application= ApplicationTypeEnum.EAFADAPI;

        infoLog(logDTO);
        elkService(logDTO,token,elasticApiProviderUrl);
    }

    public static void exceptionLog(RuntimeException exception, List<String> messageList, MessageCodeEnum messageCode, WebRequest request, String elasticApiProviderUrl)
    {
        LogDTO logDTO = new LogDTO();

        String message = "";
        for(int i=0 ; i<messageList.size() ; i++){
            message += messageList.get(i);
            message += " - ";
        }
        logDTO.message = message;
        //logDTO.messageDate = new Date();

        if(ObjectUtils.isEmpty(logDTO.application))
            logDTO.application=ApplicationTypeEnum.EAFADAPI;

        if(messageCode == MessageCodeEnum.ERROR)
        {
            logDTO.logType = LogTypeEnum.ERROR;
            errorLog(logDTO, exception);
        }
        else if(messageCode == MessageCodeEnum.WARNING)
        {
            logDTO.logType = LogTypeEnum.WARNING;
            warnLog(logDTO, exception);
        }
        else
        {
            logDTO.logType = LogTypeEnum.INFO;
            infoLog(logDTO);
        }

        String tokenValue = request.getHeader("Authorization");
        elkService(logDTO,tokenValue,elasticApiProviderUrl);
    }

    private static void infoLog(LogDTO logDTO)
    {
        JSONObject jsonObject = new JSONObject(logDTO);
        logger.info(String.valueOf(jsonObject));
    }

    private static void warnLog(LogDTO logDTO, @Nullable Exception ex)
    {
        JSONObject jsonObject = new JSONObject(logDTO);
        logger.warn(String.valueOf(jsonObject), ex);
    }

    private static void errorLog(LogDTO logDTO, @Nullable Exception ex)
    {
        JSONObject jsonObject = new JSONObject(logDTO);
        logger.error(String.valueOf(jsonObject), ex);
    }

    private static void elkService(LogDTO logDTO, String token, String elasticApiProviderUrl)
    {
        JSONObject jsonDto = new JSONObject(logDTO);
        if(ObjectUtils.isEmpty(logDTO.messageDate)) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString = format.format(new Date());
            ;
            jsonDto.remove("messageDate");
            jsonDto.put("messageDate",dateString);
        }

        String serviceName = ElasticCacheServiceEnum.ELASTIC_LOG_SERVICE.getName();

        MultivaluedMap<String, Object> headers = new MultivaluedHashMap<>();
        headers.add("Content-Type","application/json");
        headers.add("Authorization",token);

        WebTarget target = RestUtil.getWebTarget(elasticApiProviderUrl + serviceName);
        target.request(MediaType.APPLICATION_JSON).headers(headers)
                .async().post(Entity.entity(jsonDto.toString(),MediaType.APPLICATION_JSON));

//        if(response.getStatus() == 200 || response.getStatus() == 201) {
//            return;
//        }

    }
}