package com.example.elasticmanagerjson.gantt.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "gantt_dependencies")
@Getter
@Setter
public class Dependeny {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "predecessor_id")
    private Long predecessorId;

    @Column(name = "successor_id")
    private Long successorId;

    private int type;

}
