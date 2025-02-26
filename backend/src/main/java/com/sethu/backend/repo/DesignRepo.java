package com.sethu.backend.repo;

import com.sethu.backend.model.Design;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DesignRepo extends JpaRepository<Design,String> {
    List<Design> findBySubcontainerSubContainerId(String subContainerId);
}
