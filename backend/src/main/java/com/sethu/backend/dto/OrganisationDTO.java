package com.sethu.backend.dto;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.aspectj.weaver.ast.Or;

import java.time.LocalDateTime;

@Data
public class OrganisationDTO {
    public interface View{
        interface Details extends ResponseDTO.View.Public ,OrganisationDTO.View.Create, OrganisationDTO.View.Update{}
        interface Create {}
        interface Update {}
    }
    @JsonView(value = {OrganisationDTO.View.Details.class})
    private String organisationId;
    @JsonView(value = {OrganisationDTO.View.Create.class,OrganisationDTO.View.Update.class,OrganisationDTO.View.Details.class})
    @NotNull(groups = {OrganisationDTO.View.Create.class},message = "Organisation Name cannot be blank")
    @Size(groups ={OrganisationDTO.View.Update.class,OrganisationDTO.View.Create.class},min = 10,max = 50,message = "organisation name must be between 10 to 50 characters")
    private String organisationName;
    @JsonView(value = {OrganisationDTO.View.Details.class})
    private LocalDateTime createdAt;
    @JsonView(value = {OrganisationDTO.View.Details.class})
    private LocalDateTime updatedAt;
}
