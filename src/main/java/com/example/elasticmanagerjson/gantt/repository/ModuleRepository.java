package com.example.elasticmanagerjson.gantt.repository;

import com.example.elasticmanagerjson.gantt.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepository extends JpaRepository<Module,Long> {
}
