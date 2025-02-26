package com.sethu.backend.utils;

import com.sethu.backend.model.Container;
import com.sethu.backend.repo.ContainerRepo;
import com.sethu.backend.repo.OrganisationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContainerUtils {


    @Autowired
    OrganisationRepo organisationRepo;
    @Autowired
    ContainerRepo containerRepo;

    public boolean checkContainerName(String containerName,String orgId){
        Container container = containerRepo.findByContainerNameAndOrganisationOrganisationId(containerName,orgId);
        return container!=null;
    }


    public Container getContainer(String containerId,String orgId){
        Container container = containerRepo.findByContainerIdAndOrganisationOrganisationId(containerId,orgId);
        return container;
    }


}
