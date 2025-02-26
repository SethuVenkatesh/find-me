package com.sethu.backend.dto;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SubcontainerDTO {
    public interface View{
        interface Details extends ResponseDTO.View.Public,SubcontainerDTO.View.Create,SubcontainerDTO.View.Update
        {}
        interface Create  {}
        interface Update  {}
    }
    @JsonView(value = {SubcontainerDTO.View.Details.class})
    private String subContainerId;
    @JsonView(value = {SubcontainerDTO.View.Update.class,SubcontainerDTO.View.Create.class,SubcontainerDTO.View.Details.class})
    @NotNull(groups = {SubcontainerDTO.View.Create.class},message = "Subcontainer Name cannot be blank")
    @Size(groups ={SubcontainerDTO.View.Update.class,SubcontainerDTO.View.Create.class},min = 10,max = 100,message = "subcontainer name must be between 10 tp 50 characters")
    private String subContainerName;
    @JsonView(value = {SubcontainerDTO.View.Details.class})
    private LocalDateTime createdAt;
    @JsonView(value = {SubcontainerDTO.View.Details.class})
    private LocalDateTime updatedAt;
}
