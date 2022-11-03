package com.example.elasticmanagerjson.gantv2.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "gantt_dependencies")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Dependeny {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "module_id")
    private Long moduleId;

    private Long predecessorId;
    private Long successorId;
    private int type;

}
