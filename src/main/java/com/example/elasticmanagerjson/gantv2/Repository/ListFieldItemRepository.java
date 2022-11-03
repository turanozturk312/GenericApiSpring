package com.example.elasticmanagerjson.gantv2.Repository;

import com.example.elasticmanagerjson.gantv2.Entity.Field;
import com.example.elasticmanagerjson.gantv2.Entity.ListFieldItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ListFieldItemRepository extends JpaRepository<ListFieldItem,Long> {
    List<ListFieldItem> findAllByFieldId(Long fieldId);
    <S extends ListFieldItem> List<S> saveAll(Iterable<S> entities);
}
