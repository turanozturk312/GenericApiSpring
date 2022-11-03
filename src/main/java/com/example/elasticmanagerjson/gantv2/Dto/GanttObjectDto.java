package com.example.elasticmanagerjson.gantv2.Dto;

import com.example.elasticmanagerjson.gantv2.Entity.Field;
import com.example.elasticmanagerjson.gantv2.Entity.File;
import lombok.Data;
import org.json.JSONObject;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import java.util.Map;

@Data
public class GanttObjectDto {

    private Long id;
    private Long moduleId;
    private String value;
    private List<File> files;
    private Boolean active;


}

