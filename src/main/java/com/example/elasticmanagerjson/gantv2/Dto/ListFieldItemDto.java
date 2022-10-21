package com.example.elasticmanagerjson.gantv2.Dto;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class ListFieldItemDto {
    
    private Long id;
    private String item;

}
