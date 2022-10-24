package com.example.elasticmanagerjson.gantv2.Dto;

import com.example.elasticmanagerjson.gantv2.Entity.GanttItem;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class ModuleDto {

    private Long id;
    private Long moduleId;
    private String name;
    private String type;

}
