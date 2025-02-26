package com.sethu.backend.service;


import com.sethu.backend.dto.ApiResponse;
import com.sethu.backend.dto.ContainerDTO;
import com.sethu.backend.mapper.ContainerMapper;
import com.sethu.backend.model.Container;
import com.sethu.backend.model.Organisation;
import com.sethu.backend.repo.ContainerRepo;
import com.sethu.backend.repo.OrganisationRepo;
import com.sethu.backend.utils.ContainerUtils;
import com.sethu.backend.utils.IdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ContainerService {

    @Autowired
    OrganisationRepo orgRepo;
    @Autowired
    ContainerRepo containerRepo;
    @Autowired
    ContainerMapper containerMapper;
    @Autowired
    ContainerUtils containerUtils;
    @Autowired
    IdGenerator idGenerator;
    public ResponseEntity<ApiResponse<Object>> createContainer(ContainerDTO containerDTO,String orgId){
        Organisation org = orgRepo.findByOrganisationId(orgId);
        if(org == null){
            ApiResponse<Object> response = new ApiResponse<>(false,"organisation not found",orgId);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        Container container = new Container();
        if(containerUtils.checkContainerName(containerDTO.getContainerName(),org.getOrganisationId())){
            ApiResponse<Object> response = new ApiResponse<>(false,"container name already exsist",null);
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        containerMapper.containerDTOtoContainer(containerDTO,container);
        container.setOrganisation(org);
        Container savedContainer = containerRepo.save(container);
        ContainerDTO savedContainerDTO = new ContainerDTO();
        containerMapper.containerToContainerDTO(savedContainer,savedContainerDTO);
        ApiResponse<Object> response = new ApiResponse<>(true,"container created successfully",savedContainerDTO);
          return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    public ResponseEntity<ApiResponse<Object>> getAllContainer(String orgId) {
        Organisation org = orgRepo.findByOrganisationId(orgId);
        if(org == null){
            ApiResponse<Object> response = new ApiResponse<>(false,"organisation not found",orgId);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        List<Container> allContainers = containerRepo.findAllByOrganisationOrganisationId(org.getOrganisationId());
        List<ContainerDTO> containerDTOList= containerMapper.containerListToContainerDTOList(allContainers);
        ApiResponse<Object> response = new ApiResponse<>(true,"container fetched successfully",containerDTOList);
        return new ResponseEntity<>(response,HttpStatus.OK);

    }

    public ResponseEntity<ApiResponse<Object>> updateContainer(String containerId,String orgId, ContainerDTO requestBody) {
        Organisation org = orgRepo.findByOrganisationId(orgId);
        if(org == null){
            ApiResponse<Object> response = new ApiResponse<>(false,"organisation not found",orgId);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        if(containerUtils.checkContainerName(requestBody.getContainerName(),org.getOrganisationId())){
            ApiResponse<Object> response = new ApiResponse<>(false,"container name already exsist",null);
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Container container = containerUtils.getContainer(containerId,org.getOrganisationId());
        if(container == null){
            ApiResponse<Object> response = new ApiResponse<>(false,"container not exsist",null);
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
        containerMapper.containerDTOtoContainer(requestBody,container);
        Container savedContainer = containerRepo.save(container);
        ContainerDTO savedContainerDTO = new ContainerDTO();
        containerMapper.containerToContainerDTO(savedContainer,savedContainerDTO);
        ApiResponse<Object> response = new ApiResponse<>(true,"container updated successfully",savedContainerDTO);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
}
