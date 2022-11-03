package com.example.elasticmanagerjson.gantv2.Repository;

import com.example.elasticmanagerjson.gantv2.Entity.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FieldRepository  extends JpaRepository<Field,Long> {

    List<Field> findAllByModuleId(Long moduleId);

    List<Field> findAllByModuleIdAndAndPart(Long moduleId, String Part);

    @Override
    <S extends Field> List<S> saveAll(Iterable<S> entities);
}
