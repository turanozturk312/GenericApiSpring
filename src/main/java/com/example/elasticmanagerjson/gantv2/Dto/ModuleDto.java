package com.example.elasticmanagerjson.gantv2.Dto;

import com.example.elasticmanagerjson.gantv2.Entity.Field;
import com.example.elasticmanagerjson.gantv2.Entity.GanttObject;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class ModuleDto {

    private Long id;
    private String name;
    private List<Field> fields;
    private List<GanttObject> ganttObjects;
    private String orderOfItems;

}

