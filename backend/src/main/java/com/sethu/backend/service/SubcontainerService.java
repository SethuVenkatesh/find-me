package com.sethu.backend.service;


import com.sethu.backend.dto.ApiResponse;
import com.sethu.backend.dto.SubcontainerDTO;
import com.sethu.backend.mapper.SubcontainerMapper;
import com.sethu.backend.model.Container;
import com.sethu.backend.model.Organisation;
import com.sethu.backend.model.Subcontainer;
import com.sethu.backend.repo.OrganisationRepo;
import com.sethu.backend.repo.SubcontainerRepo;
import com.sethu.backend.utils.ContainerUtils;
import com.sethu.backend.utils.IdGenerator;
import com.sethu.backend.utils.SubcontainerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubcontainerService {


    @Autowired
    OrganisationRepo orgRepo;
    @Autowired
    SubcontainerUtils subcontainerUtils;
    @Autowired
    SubcontainerMapper subcontainerMapper;
    @Autowired
    ContainerUtils containerUtils;
    @Autowired
    SubcontainerRepo subcontainerRepo;

    public ResponseEntity<ApiResponse<Object>> createSubcontainer(String containerId,String orgId,SubcontainerDTO subcontainerDTO){
        Organisation org = orgRepo.findByOrganisationId(orgId);
        if(org == null){
            ApiResponse<Object> response = new ApiResponse<>(false,"organisation not found",orgId);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }

        Container container = containerUtils.getContainer(containerId, org.getOrganisationId());
        if(container == null){
            ApiResponse<Object> response = new ApiResponse<>(false,"container doesn't exsist",null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if(subcontainerUtils.checkSubContainerName(subcontainerDTO.getSubContainerName(), container.getContainerId())){
            ApiResponse<Object> response = new ApiResponse<>(false,"sub container name already exsist",null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Subcontainer subcontainer = new Subcontainer();
        subcontainerMapper.subContainerDTOtosubContainer(subcontainerDTO,subcontainer);
        subcontainer.setContainer(container);
        Subcontainer savedSubContainer = subcontainerRepo.save(subcontainer);
        SubcontainerDTO savedSubContainerDTO = new SubcontainerDTO();
        subcontainerMapper.subContainerTosubContainerDTO(savedSubContainer,savedSubContainerDTO);
        ApiResponse<Object> response = new ApiResponse<>(true,"subcontainer created successfully",savedSubContainerDTO);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    public ResponseEntity<ApiResponse<Object>> getAllSubcontainer(String orgId,String containerId) {
        Organisation org = orgRepo.findByOrganisationId(orgId);
        if(org == null){
            ApiResponse<Object> response = new ApiResponse<>(false,"organisation not found",orgId);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }

        Container container = containerUtils.getContainer(containerId, org.getOrganisationId());
        if(container == null){
            ApiResponse<Object> response = new ApiResponse<>(false,"container doesn't exsist",null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        List<Subcontainer> allSubContainers = subcontainerRepo.findAllByContainerContainerId(container.getContainerId());
        List<SubcontainerDTO> subContainerDTOList= subcontainerMapper.subContainerListTosubContainerDTOList(allSubContainers);
        ApiResponse<Object> response = new ApiResponse<>(true,"subcontainer fetched successfully",subContainerDTOList);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    public ResponseEntity<ApiResponse<Object>> updateSubcontainer(String orgId,String containerId,String subContainerId,SubcontainerDTO requestBody) {
        Organisation org = orgRepo.findByOrganisationId(orgId);
        if(org == null){
            ApiResponse<Object> response = new ApiResponse<>(false,"organisation not found",orgId);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }

        Container container = containerUtils.getContainer(containerId, org.getOrganisationId());
        if(container == null){
            ApiResponse<Object> response = new ApiResponse<>(false,"container doesn't exsist",null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Subcontainer subcontainer = subcontainerUtils.getSubContainer(container.getContainerId(), subContainerId);
        if(subcontainer == null){
            ApiResponse<Object> response = new ApiResponse<>(false,"subcontainer doesn't exsist",null);
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
        if(subcontainerUtils.checkSubContainerName(requestBody.getSubContainerName(), org.getOrganisationId())){
            ApiResponse<Object> response = new ApiResponse<>(false,"subcontainer name already exsist",null);
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }

        subcontainerMapper.subContainerDTOtosubContainer(requestBody,subcontainer);
        Subcontainer savedSubContainer = subcontainerRepo.save(subcontainer);
        SubcontainerDTO savedSubContainerDTO = new SubcontainerDTO();
        subcontainerMapper.subContainerTosubContainerDTO(savedSubContainer,savedSubContainerDTO);
        ApiResponse<Object> response = new ApiResponse<>(true,"subcontainer updated successfully",savedSubContainerDTO);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
}
