package com.example.elasticmanagerjson.gantv2.Repository;

import com.example.elasticmanagerjson.gantv2.Entity.DateField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DateFieldRepository extends JpaRepository<DateField,Long> {
    Optional<DateField> findAllByModule_item_id(Long moduleItemId);
}