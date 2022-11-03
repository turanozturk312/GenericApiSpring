package com.example.elasticmanagerjson.gantv2.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "gantt_fields")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Field implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "module_id")
    private Long moduleId;
    private String name;
    private String type;
    private String part;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "field_id")
    private List<ListFieldItem> listFieldItems;

    public Field(Long moduleId, String name, String part, String type) {
        this.moduleId = moduleId;
        this.name = name;
        this.type = type;
        this.part = part;
    }
}
