package com.example.elasticmanagerjson.gantv2.Repository;

import com.example.elasticmanagerjson.gantv2.Entity.BaseEntity;
import com.example.elasticmanagerjson.gantv2.Entity.DateField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.config.Task;

import java.util.List;
import java.util.Optional;

public interface BaseRepository <T extends BaseEntity> extends JpaRepository<T,Long> {
    @Override
    <S extends T> S save(S entity);

    //List<Task> findAllByModuleId(Long id);

}
