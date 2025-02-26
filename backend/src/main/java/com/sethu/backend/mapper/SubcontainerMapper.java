package com.sethu.backend.mapper;

import com.sethu.backend.dto.ContainerDTO;
import com.sethu.backend.dto.SubcontainerDTO;
import com.sethu.backend.model.Container;
import com.sethu.backend.model.Subcontainer;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubcontainerMapper {
    void subContainerTosubContainerDTO(Subcontainer container, @MappingTarget SubcontainerDTO containerDTO);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void subContainerDTOtosubContainer(SubcontainerDTO containerDTO,@MappingTarget Subcontainer container);
    List<SubcontainerDTO> subContainerListTosubContainerDTOList(List<Subcontainer> subcontainers);

}