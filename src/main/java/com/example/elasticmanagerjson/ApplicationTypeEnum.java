package com.example.elasticmanagerjson;

public enum ApplicationTypeEnum {

    EAFADAPI(1L, "EAFADAPI"),
    ELASTICAPI(2L, "ELASTICAPI"),
    INTEGRATIONAPI(3L, "INTEGRATIONAPI"),
    EAFADCLIENT(4L, "EAFADCLIENT"),
    AUTHORIZATIONAPI(5L, "AUTHORIZATIONAPI"),
    SCHEDULEDQUARTZ(6L, "SCHEDULEDQUARTZ"),
    EAFADDISSERVIS(7L, "EAFADDISSERVIS"),
    EXPORTEDAPI(8L, "EXPORTEDAPI"),
    MOBILEANDROID(9L, "MOBILEANDROID"),
    MOBILEIPHONE(10L, "MOBILEIPHONE"),
    IMPROVEMENTAPI(11L, "IMPROVEMENTAPI");

    private Long id;
    private String value;

    ApplicationTypeEnum(Long id, String value) {
        this.id = id;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}