package com.sethu.backend.service;

import com.sethu.backend.dto.ApiResponse;
import com.sethu.backend.dto.DesignDTO;
import com.sethu.backend.mapper.DesignMapper;
import com.sethu.backend.model.Design;
import com.sethu.backend.model.Organisation;
import com.sethu.backend.model.Subcontainer;
import com.sethu.backend.repo.DesignRepo;
import com.sethu.backend.repo.OrganisationRepo;
import com.sethu.backend.utils.SubcontainerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class DesignService {

    @Autowired
    SubcontainerUtils subcontainerUtils;
    @Autowired
    DesignRepo designRepo;

    @Autowired
    CloudinaryService cloudinaryService;
    @Autowired
    OrganisationRepo orgRepo;
    @Autowired
    DesignMapper designMapper;
    public ResponseEntity<ApiResponse<Object>> createDesign(String subContainerId,String orgId, DesignDTO designDTO  , MultipartFile designImage) throws IOException {
        Organisation org = orgRepo.findByOrganisationId(orgId);
        if(org == null){
            ApiResponse<Object> response = new ApiResponse<>(false,"organisation not found",orgId);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        Subcontainer subcontainer = subcontainerUtils.getSubContainer(subContainerId);
        if(subcontainer == null){
            ApiResponse<Object> response = new ApiResponse<>(false,"subcontainer not found",subContainerId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        Design design = new Design();
        designMapper.DesignDTOtoDesign(designDTO,design);
        design.setSubcontainer(subcontainer);
        Design savedDesign = designRepo.save(design);
        String imageId = cloudinaryService.uploadImage(designImage,org.getOrganisationId()+"/"+savedDesign.getDesignId());
        savedDesign.setImageId(imageId);

        Design newSavedDesign = designRepo.save(savedDesign);
        DesignDTO savedDesignDTO = new DesignDTO();
        designMapper.DesigntoDesignDTO(newSavedDesign,savedDesignDTO);
        ApiResponse<Object> response = new ApiResponse<>(true,"design added successfully",savedDesignDTO);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    public ResponseEntity<ApiResponse<Object>> getAllDesign(String subContainerId) {
        Subcontainer subcontainer = subcontainerUtils.getSubContainer(subContainerId);
        if(subcontainer == null){
            ApiResponse<Object> response = new ApiResponse<>(false,"subcontainer not found",subContainerId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        List<Design> designs = designRepo.findBySubcontainerSubContainerId(subContainerId);
        List<DesignDTO> designDTOS = designMapper.designListtoDesignDTOList(designs);
        ApiResponse<Object> response = new ApiResponse<>(true,"designs fetched successfully",designDTOS);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
