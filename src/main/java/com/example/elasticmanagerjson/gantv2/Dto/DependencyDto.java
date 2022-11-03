package com.example.elasticmanagerjson.gantv2.Dto;

import lombok.Data;

@Data
public class DependencyDto {
    private Long id;
    private Long predecessorId;
    private Long successorId;
    private int type;
}
