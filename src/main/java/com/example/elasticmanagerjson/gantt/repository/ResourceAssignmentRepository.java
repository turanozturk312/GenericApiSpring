package com.example.elasticmanagerjson.gantt.repository;

import com.example.elasticmanagerjson.gantt.entity.ResourceAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceAssignmentRepository extends JpaRepository<ResourceAssignment,Long> {
}
