package com.sethu.backend.service;

import com.sethu.backend.dto.ApiResponse;
import com.sethu.backend.dto.OrganisationDTO;
import com.sethu.backend.mapper.OrganisationMapper;
import com.sethu.backend.model.Organisation;
import com.sethu.backend.repo.OrganisationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class OrganisationService {


    @Autowired
    OrganisationMapper orgMapper;

    @Autowired
    OrganisationRepo orgRepo;

    public ResponseEntity<ApiResponse<Object>> createNewOrg(OrganisationDTO requestBody){
        Organisation isExsistOrg = orgRepo.findByOrganisationName(requestBody.getOrganisationName());
        if(isExsistOrg!=null){
            ApiResponse response = new ApiResponse(false,"organisation name already found",null);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        Organisation org = new Organisation();
        orgMapper.organisationDTOToOrganisation(requestBody,org);
        Organisation newOrg = orgRepo.save(org);
        OrganisationDTO newOrgDTO = new OrganisationDTO();
        orgMapper.organisationToOrganisationDTO(newOrg,newOrgDTO);
        ApiResponse<Object> response = new ApiResponse<>(true,"organisation created successfully",newOrgDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }
    public ResponseEntity<ApiResponse<Object>> updateOrg(OrganisationDTO requestBody,String orgId){
        Organisation org = orgRepo.findByOrganisationId(orgId);
        if(org==null){
            ApiResponse response = new ApiResponse(false,"organisation not found",null);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        org = orgRepo.findByOrganisationName(requestBody.getOrganisationName());
        if(org!=null){
            ApiResponse response = new ApiResponse(false,"organisation name already found",null);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        orgMapper.organisationDTOToOrganisation(requestBody,org);
        Organisation newOrg = orgRepo.save(org);
        OrganisationDTO newOrgDTO = new OrganisationDTO();
        orgMapper.organisationToOrganisationDTO(newOrg,newOrgDTO);
        ApiResponse<Object> response = new ApiResponse<>(true,"organisation updated successfully",null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

