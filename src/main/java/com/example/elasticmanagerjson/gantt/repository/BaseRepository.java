package com.example.elasticmanagerjson.gantt.repository;

import com.example.elasticmanagerjson.gantt.entity.BaseEntity;
import com.example.elasticmanagerjson.gantt.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;


public interface BaseRepository <T extends BaseEntity> extends JpaRepository<T,Long> {



}
