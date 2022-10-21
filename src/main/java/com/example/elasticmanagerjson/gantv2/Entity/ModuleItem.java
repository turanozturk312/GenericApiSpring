package com.example.elasticmanagerjson.gantv2.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "gantt_module_items")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ModuleItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "parent_id")
    private Long parentId;

    private String title;

    @Column(name = "start_date")
    private Date start;

    @Column(name = "end_date")
    private Date end;

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

    private int progress;
    private String color;

}
