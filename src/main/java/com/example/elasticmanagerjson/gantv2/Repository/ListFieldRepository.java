package com.example.elasticmanagerjson.gantv2.Repository;

import com.example.elasticmanagerjson.gantv2.Entity.DateField;
import com.example.elasticmanagerjson.gantv2.Entity.ListField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ListFieldRepository extends JpaRepository<ListField,Long> {

}
