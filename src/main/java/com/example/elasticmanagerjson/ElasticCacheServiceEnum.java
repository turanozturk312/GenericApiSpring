package com.example.elasticmanagerjson;

public enum ElasticCacheServiceEnum {

    ELASTIC_CACHE_SEARCH_LOAD_NEW_ENTITY("/elasticCacheSearch/loadNewEntityElasticCache"),
    ELASTIC_LOG_SERVICE("/api/log/log");

    private String name;

    ElasticCacheServiceEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
