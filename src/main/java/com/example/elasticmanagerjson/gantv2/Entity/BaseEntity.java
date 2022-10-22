package com.example.elasticmanagerjson.gantv2.Entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue
    Long id = null;

    @Column(name = "module_id")
    private Long moduleId;

    private Long module_item_id;

}
