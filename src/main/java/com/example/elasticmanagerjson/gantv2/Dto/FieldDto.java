package com.example.elasticmanagerjson.gantv2.Dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class FieldDto {

    private Long id;
    private Long moduleId;
    private String name;
    private String type;
    private String part;

}
