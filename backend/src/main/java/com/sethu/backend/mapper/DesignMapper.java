package com.sethu.backend.mapper;

import com.sethu.backend.dto.DesignDTO;
import com.sethu.backend.model.Design;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DesignMapper {
    void DesignDTOtoDesign(DesignDTO designDTO,@MappingTarget Design design);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)

    void DesigntoDesignDTO(Design design,@MappingTarget DesignDTO designDTO);

    List<DesignDTO> designListtoDesignDTOList(List<Design> designs);
}
