package com.example.elasticmanagerjson.gantv2.Repository;

import com.example.elasticmanagerjson.gantv2.Entity.DateField;
import com.example.elasticmanagerjson.gantv2.Entity.NumericField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NumericFieldRepository extends JpaRepository<NumericField,Long> {
    Optional<NumericField> findAllByModule_item_id(Long moduleItemId);
}
