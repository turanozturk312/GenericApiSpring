package com.example.elasticmanagerjson.gantv2.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "gantt_list_fields")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ListField {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany
    @JoinColumn(name = "list_field_id")
    private List<ListFieldItem> listFieldItems;

    private Long module_item_id;

}