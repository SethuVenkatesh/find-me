package com.sethu.backend.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.sethu.backend.dto.ApiResponse;
import com.sethu.backend.dto.ContainerDTO;
import com.sethu.backend.dto.SubcontainerDTO;
import com.sethu.backend.service.SubcontainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/sub_container")
public class SubContainerController {


    @Autowired
    SubcontainerService subcontainerService;

    @PostMapping(value = "/new")
    @JsonView(value = {SubcontainerDTO.View.Details.class})
    public ResponseEntity<ApiResponse<Object>> createSubContainer(
            @RequestParam(required = true,name = "orgId") String orgId,
            @RequestParam(name = "containerId") String containerId,
            @RequestBody @Validated(SubcontainerDTO.View.Create.class) @JsonView(value = {SubcontainerDTO.View.Create.class}) SubcontainerDTO requestBody)
    {
        return subcontainerService.createSubcontainer(containerId,orgId,requestBody);
    }

    @GetMapping(value = "/all")
    @JsonView(value = {SubcontainerDTO.View.Details.class})
    public ResponseEntity<ApiResponse<Object>> getAllSubContainer(
            @RequestParam(required = true,name = "orgId") String orgId,
            @RequestParam(required = true,name = "containerId") String containerId
    ){
        return subcontainerService.getAllSubcontainer(orgId,containerId);
    }

    @PatchMapping("/update")
    @JsonView(value = {SubcontainerDTO.View.Details.class})
    public ResponseEntity<ApiResponse<Object>> updateSubContainer(
            @RequestParam(required = true,name = "orgId") String orgId,
            @RequestParam(required = true,name = "containerId") String containerId,
            @RequestParam(required = true,name = "subContainerId") String subContainerId,
            @RequestBody @Validated(value = {SubcontainerDTO.View.Update.class}) @JsonView(value = {SubcontainerDTO.View.Update.class}) SubcontainerDTO requestBody){
        return subcontainerService.updateSubcontainer(orgId,containerId,subContainerId,requestBody);
    }

}
