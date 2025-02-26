package com.sethu.backend.controller;


import com.cloudinary.Api;
import com.fasterxml.jackson.annotation.JsonView;
import com.sethu.backend.dto.ApiResponse;
import com.sethu.backend.dto.ContainerDTO;
import com.sethu.backend.service.ContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping(value = "/api/v1/container")
public class ContainerController {


    @Autowired
    ContainerService containerService;
    @PostMapping(value = "/new")
    @JsonView(value = {ContainerDTO.View.Details.class})
    public ResponseEntity<ApiResponse<Object>> createContainer(
            @RequestParam(required = true,name = "orgId") String orgId,
            @RequestBody @Validated(ContainerDTO.View.Create.class)
            @JsonView(value = {ContainerDTO.View.Create.class}) ContainerDTO requestBody
    ){
        return containerService.createContainer(requestBody,orgId);
    }

    @GetMapping(value = "/all")
    @JsonView(value = {ContainerDTO.View.Details.class})
    public ResponseEntity<ApiResponse<Object>> getAllContainer(@RequestParam(required = true,name = "orgId") String orgId){
        return containerService.getAllContainer(orgId);
    }

    @PatchMapping("/update")
    @JsonView(value = {ContainerDTO.View.Details.class})
    public ResponseEntity<ApiResponse<Object>> updateContainer(
            @RequestParam(required = true,name = "containerId") String containerId,
            @RequestParam(required = true,name = "orgId") String orgId,
            @RequestBody @Validated(value = {ContainerDTO.View.Create.class}) @JsonView(value = {ContainerDTO.View.Update.class}) ContainerDTO requestBody){
        return containerService.updateContainer(containerId,orgId,requestBody);
    }


}
