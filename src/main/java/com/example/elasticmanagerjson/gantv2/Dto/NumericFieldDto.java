package com.example.elasticmanagerjson.gantv2.Dto;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
public class NumericFieldDto {

    private Long id;
    private int value;

}
