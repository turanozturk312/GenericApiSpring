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

    @OneToMany
    @JoinColumn(name = "module_item_id")
    List<TextField> textFields;

    @OneToMany
    @JoinColumn(name = "module_item_id")
    List<DateField> dateFields;

    @OneToMany
    @JoinColumn(name = "module_item_id")
    List<NumericField> numericFields;

    @OneToMany
    @JoinColumn(name = "module_item_id")
    List<ListField> listFields;

}
