package com.example.elasticmanagerjson.gantv2.Repository;

import com.example.elasticmanagerjson.gantv2.Entity.ModuleField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuleFieldRepository extends JpaRepository<ModuleField,Long> {
    List<ModuleField> findAllByModuleId(Long moduleId);
}
