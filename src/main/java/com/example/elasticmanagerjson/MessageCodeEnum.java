package com.example.elasticmanagerjson;

public enum MessageCodeEnum {

    INFO(1L, "INFO"),
    WARNING(2L, "WARNING"),
    ERROR(3L, "ERROR");

    private Long id;
    private String value;

    MessageCodeEnum(Long id, String value) {
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
