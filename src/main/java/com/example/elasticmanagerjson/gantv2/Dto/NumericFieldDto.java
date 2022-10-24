package com.example.elasticmanagerjson.gantv2.Dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class NumericFieldDto {

    private Long id;
    private int value;
    private Long ganttItemId;

}
