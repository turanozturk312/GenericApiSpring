package com.example.elasticmanagerjson.gantv2.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "gantt_modules")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Hedef {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    @JoinColumn(name = "hedef_id")
    private List<HedefField> fields;

    @Column(name = "module_id")
    private Long moduleId;

}
