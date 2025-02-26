package com.sethu.backend.controller;


import com.fasterxml.jackson.annotation.JsonView;
import com.sethu.backend.dto.ApiResponse;
import com.sethu.backend.dto.OrganisationDTO;
import com.sethu.backend.service.OrganisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Validated
@RestController
@RequestMapping(value = "api/v1/organisation")
public class OrganisationController {
    @Autowired
    OrganisationService organisationService;

    @JsonView(value = {OrganisationDTO.View.Details.class})
    @PostMapping(value = "/new")
    public ResponseEntity<ApiResponse<Object>> createOrg(@RequestBody @Validated(value = {OrganisationDTO.View.Create.class}) @JsonView(value = {OrganisationDTO.View.Create.class}) OrganisationDTO requestBody){
       return organisationService.createNewOrg(requestBody);
    }

    @JsonView(value = {OrganisationDTO.View.Details.class})
    @PatchMapping(value = "/update")
    public ResponseEntity<ApiResponse<Object>> updateOrg(@RequestParam(required = true,name = "orgId") String orgId,@RequestBody @Validated(value = {OrganisationDTO.View.Update.class}) @JsonView(value = {OrganisationDTO.View.Update.class}) OrganisationDTO requestBody){
        return organisationService.updateOrg(requestBody,orgId);
    }

}
