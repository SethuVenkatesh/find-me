package com.sethu.backend.repo;

import com.sethu.backend.model.Container;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContainerRepo extends JpaRepository<Container,String> {

    Container findByContainerNameAndOrganisationOrganisationId(String containerName,String orgId);
    List<Container> findAllByOrganisationOrganisationId(String orgId);

    Container findByContainerIdAndOrganisationOrganisationId(String containerId,String orgId);


}
