package com.sethu.backend.dto;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DesignDTO {
    public interface View{
        interface Details extends ResponseDTO.View.Public,DesignDTO.View.Create, DesignDTO.View.Update
        {}
        interface Create {}
        interface Update  {}
    }
    @JsonView(value = DesignDTO.View.Details.class)
    private String designId;
    @NotNull(groups = {DesignDTO.View.Create.class},message = "Design Name cannot be blank")
    @Size(groups ={DesignDTO.View.Update.class,DesignDTO.View.Create.class},min = 10,max = 50,message = "design name must be between 10 to 50 characters")
    @JsonView(value = {DesignDTO.View.Details.class,DesignDTO.View.Create.class,DesignDTO.View.Update.class})
    private String name;
    @JsonView(value = DesignDTO.View.Details.class)
    private String imageId;
}
