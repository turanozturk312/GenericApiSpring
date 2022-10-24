package com.example.elasticmanagerjson.gantv2.Dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
@Data
public class ModuleFieldDto {

    private Long id;
    private Long moduleId;
    private String name;
    private String type;

}
