package com.example.elasticmanagerjson.gantv2.Repository;

import com.example.elasticmanagerjson.gantv2.Entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface FileRepository extends JpaRepository<File,Long> {

    @Override
    Optional<File> findById(Long aLong);
    Optional<File> findByFileName(String fileName);
}
