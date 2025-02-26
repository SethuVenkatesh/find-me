package com.sethu.backend.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.google.zxing.WriterException;
import com.sethu.backend.dto.ApiResponse;
import com.sethu.backend.dto.DesignDTO;
import com.sethu.backend.model.Design;
import com.sethu.backend.service.DesignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@Validated
@RequestMapping(value = "/api/v1/design")
public class DesignController {

    @Autowired
    DesignService designService;

    @PostMapping(value = "/new",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @JsonView(value = DesignDTO.View.Details.class)
    public ResponseEntity<ApiResponse<Object>> createDesign(
     @RequestPart(name = "design") @Validated(value = {DesignDTO.View.Create.class}) @JsonView(value = DesignDTO.View.Create.class)  DesignDTO design,
     @RequestPart(name = "designImage") MultipartFile designImage,
     @RequestParam(name = "subContainerId") String subContainerId,
     @RequestParam(name = "orgId") String orgId

    ) throws IOException, WriterException {
        return designService.createDesign(subContainerId,orgId,design,designImage);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<ApiResponse<Object>> allDesigns(
       @RequestParam(name = "subContainerId") String subContainerId
    )
    {
        return designService.getAllDesign(subContainerId);
    }
}
