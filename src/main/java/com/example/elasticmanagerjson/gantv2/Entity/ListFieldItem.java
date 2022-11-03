package com.example.elasticmanagerjson.gantv2.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "gantt_list_field_items")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ListFieldItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String item;

    @Column(name = "field_id")
    private Long fieldId;

    public ListFieldItem(String item, Long fieldId) {
        this.item = item;
        this.fieldId = fieldId;
    }
}
