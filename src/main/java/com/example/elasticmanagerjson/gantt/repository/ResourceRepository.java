package com.example.elasticmanagerjson.gantt.repository;

import com.example.elasticmanagerjson.gantt.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends JpaRepository<Resource,Long> {
}
