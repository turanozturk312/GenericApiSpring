package com.example.elasticmanagerjson.gantv2.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "gantt_modules")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Module implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "module_id")
    private List<Field> fields;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "module_id")
    private List<GanttObject> ganttObjects;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "module_id")
    private List<Dependeny> dependenies;

    private String orderOfItems;


}
