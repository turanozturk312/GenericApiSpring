package com.example.elasticmanagerjson.gantv2.Dto;

import com.example.elasticmanagerjson.gantv2.Entity.DateField;
import com.example.elasticmanagerjson.gantv2.Entity.ListField;
import com.example.elasticmanagerjson.gantv2.Entity.NumericField;
import com.example.elasticmanagerjson.gantv2.Entity.TextField;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
public class ModuleItem {

    private Long id;
    private Long parentId;
    private String title;
    private Date start;
    private Date end;
    List<TextField> textFields;
    List<DateField> dateFields;
    List<NumericField> numericFields;
    List<ListField> listFields;
    private int progress;
    private String color;

}
