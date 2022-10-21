package com.example.elasticmanagerjson.gantv2.Dto;

import com.example.elasticmanagerjson.gantv2.Entity.ModuleItem;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class ModuleDto {

    private Long id;
    private String name;
    List<ModuleItem> moduleItems;

}
