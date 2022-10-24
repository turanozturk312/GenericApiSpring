package com.example.elasticmanagerjson.gantv2.Dto;

import com.example.elasticmanagerjson.gantv2.Entity.ListFieldItem;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class ListFieldDto {

    private Long id;
    private String name;
    private List<ListFieldItem> listFieldItems;
    private Long ganttItemId;

}
