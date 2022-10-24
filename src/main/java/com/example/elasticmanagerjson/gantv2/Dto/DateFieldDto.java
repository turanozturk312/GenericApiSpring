package com.example.elasticmanagerjson.gantv2.Dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
public class DateFieldDto {

    private Long id;
    private Date value;
    private Long ganttItemId;

}
