package com.example.elasticmanagerjson.gantt.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "gantt_tasks")
@Getter
@Setter
public class Task {

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

    private int progress;

    private String color;

    @Column(name = "module_id")
    private Long moduleId;

}
