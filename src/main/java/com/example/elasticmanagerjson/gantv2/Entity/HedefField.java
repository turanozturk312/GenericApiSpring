package com.example.elasticmanagerjson.gantv2.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "s")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HedefField {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "hedef_id")
    private Long hedefId;
    private String name;
    private String type;

}
