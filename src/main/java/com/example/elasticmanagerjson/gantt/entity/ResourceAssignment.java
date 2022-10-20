package com.example.elasticmanagerjson.gantt.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "gantt_resourceassignments")
@Getter
@Setter
public class ResourceAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "task_id")
    public Long taskId;

    @Column(name = "resource_id")
    public Long resourceId;

}
