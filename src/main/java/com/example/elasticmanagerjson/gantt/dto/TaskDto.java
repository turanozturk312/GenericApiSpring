package com.example.elasticmanagerjson.gantt.dto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskDto {

    private Long id;
    private Long parentId;
    private String title;
    private Date start;
    private Date end;
    private int progress;
    private String color;
    private Long moduleId;

}
