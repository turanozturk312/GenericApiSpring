package com.example.elasticmanagerjson.gantv2.Repository;

import com.example.elasticmanagerjson.gantv2.Entity.ModuleItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleItemRepository extends JpaRepository<ModuleItem,Long> {
}
