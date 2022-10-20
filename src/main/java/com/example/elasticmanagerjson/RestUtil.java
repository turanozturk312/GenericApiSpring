package com.example.elasticmanagerjson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.util.StringUtils;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class RestUtil {

    public static EafadResponseListObject getRequestAsEafadResponseListObject(String request, MultivaluedMap<String, Object> headers) {
        try {
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target(request);
            String json = target.request(MediaType.APPLICATION_JSON).headers(headers).get(String.class);
            if(StringUtils.isEmpty(json)){
                return null;
            }
            Object object = new ObjectMapper().readValue(json, new TypeReference<>() {});
            return new ModelMapper().map(object, EafadResponseListObject.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static List<Object> getRequestAsListObject(String request, MultivaluedMap<String, Object> headers) {
        try {
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target(request);
            String json = target.request(MediaType.APPLICATION_JSON).headers(headers).get(String.class);
            if(StringUtils.isEmpty(json)){
                return null;
            }
            return new ObjectMapper().readValue(json, new TypeReference<>() {});
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static Object getRequestAsObject(String request, MultivaluedMap<String, Object> headers, Class clazz) {
        try {
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target(request);
            String json = target.request(MediaType.APPLICATION_JSON).headers(headers).get(String.class);
            if(StringUtils.isEmpty(json)){
                return null;
            }
            return new ObjectMapper().readValue(json, clazz);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static String getRequestAsJson(String request, MultivaluedMap<String, Object> headers) {
        try {
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target(request);
            return target.request(MediaType.APPLICATION_JSON).headers(headers).get(String.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static WebTarget getWebTarget(String request){
        try {
            return ClientBuilder.newClient().target(request);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static String getBasicAuthentication(String userName, String password) {
        String token = userName + ":" + password;
        String basic = null;
        try {
            basic = "Basic " + DatatypeConverter.printBase64Binary(token.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return basic;
    }

}
