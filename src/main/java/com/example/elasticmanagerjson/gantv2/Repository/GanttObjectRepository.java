package com.example.elasticmanagerjson.gantv2.Repository;

import com.example.elasticmanagerjson.gantv2.Entity.GanttObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface GanttObjectRepository extends JpaRepository<GanttObject,Long> {

    List<GanttObject> findAllByModuleIdOrderByIdAsc(Long moduleId);

}
