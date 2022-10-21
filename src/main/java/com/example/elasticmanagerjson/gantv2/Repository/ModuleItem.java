package com.example.elasticmanagerjson.gantv2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleItem extends JpaRepository<ModuleItem,Long> {
}
