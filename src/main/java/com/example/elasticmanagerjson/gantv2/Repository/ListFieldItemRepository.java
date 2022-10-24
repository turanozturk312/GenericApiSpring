package com.example.elasticmanagerjson.gantv2.Repository;

import com.example.elasticmanagerjson.gantv2.Entity.ListFieldItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ListFieldItemRepository extends JpaRepository<ListFieldItem,Long> {

    Optional<ListFieldItem> findAllByListFieldItemId(Long id);

}

