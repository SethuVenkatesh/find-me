package com.sethu.backend.utils;

import com.sethu.backend.model.Container;
import com.sethu.backend.model.Subcontainer;
import com.sethu.backend.repo.SubcontainerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SubcontainerUtils {

    @Autowired
    SubcontainerRepo subcontainerRepo;
    public boolean checkSubContainerName(String subContainerName,String containerId){
        Subcontainer container = subcontainerRepo.findBySubContainerNameAndContainerContainerId(subContainerName,containerId);
        return container!=null;
    }

    public Subcontainer getSubContainer(String containerId,String subContainerId){
        Subcontainer container = subcontainerRepo.findBySubContainerIdAndContainerContainerId(subContainerId,containerId);
        return container;
    }

    public Subcontainer getSubContainer(String subContainerId){
        Subcontainer container = subcontainerRepo.findBySubContainerId(subContainerId);
        return container;
    }
}
