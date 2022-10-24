package com.example.elasticmanagerjson.gantv2.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "gantt_module_fields")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ModuleField {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "module_id")
    private Long moduleId;
    private String name;
    private String type;

}
