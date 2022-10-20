package com.example.elasticmanagerjson.gantt.repository;

import com.example.elasticmanagerjson.gantt.entity.Dependeny;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DependencyRepository extends JpaRepository<Dependeny,Long> {
}
