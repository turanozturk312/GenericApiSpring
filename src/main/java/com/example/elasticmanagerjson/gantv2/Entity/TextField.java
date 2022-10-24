package com.example.elasticmanagerjson.gantv2.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "gantt_text_fields")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TextField implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "module_id")
    private Long moduleId;

}
