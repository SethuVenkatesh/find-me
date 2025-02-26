package com.sethu.backend.dto;


import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ContainerDTO {
    public interface View{

        interface Details extends ResponseDTO.View.Public ,ContainerDTO.View.Create, ContainerDTO.View.Update {}
        interface Create{}
        interface Update{}

    }
    @JsonView(value = {ContainerDTO.View.Details.class})
    private String containerId;
    @JsonView(value = {ContainerDTO.View.Create.class,ContainerDTO.View.Update.class,ContainerDTO.View.Details.class})
    @NotNull(groups = {ContainerDTO.View.Create.class},message = "Container Name cannot be blank")
    @Size(groups ={ContainerDTO.View.Update.class,ContainerDTO.View.Create.class},min = 10,max = 50,message = "container name must be between 10 to 50 characters")
    private String containerName;
    @JsonView(value = {ContainerDTO.View.Details.class})
    private LocalDateTime createdAt;
    @JsonView(value = {ContainerDTO.View.Details.class})
    private LocalDateTime updatedAt;
}
