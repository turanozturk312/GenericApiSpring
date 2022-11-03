package com.example.elasticmanagerjson.gantv2.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "gantt_gantt_object")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GanttObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "module_id")
    private Long moduleId;

    @Column(columnDefinition="TEXT")
    private String value;

    @OneToOne
    @JoinColumn(name = "gantt_object_id")
    private File file;

    private Boolean active = false;


}
