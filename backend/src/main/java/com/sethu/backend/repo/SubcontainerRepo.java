package com.sethu.backend.repo;

import com.sethu.backend.model.Container;
import com.sethu.backend.model.Subcontainer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubcontainerRepo extends JpaRepository<Subcontainer,String> {
    Subcontainer findBySubContainerNameAndContainerContainerId(String subContainerName,String containerId);

    Subcontainer findBySubContainerIdAndContainerContainerId(String subContainerId,String containerId);

    Subcontainer findBySubContainerId(String subContainerId);

    List<Subcontainer> findAllByContainerContainerId(String containerId);
}
