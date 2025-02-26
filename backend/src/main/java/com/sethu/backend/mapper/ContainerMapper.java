package com.sethu.backend.mapper;

import com.sethu.backend.dto.ContainerDTO;
import com.sethu.backend.model.Container;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContainerMapper {
    void containerToContainerDTO(Container container, @MappingTarget ContainerDTO containerDTO);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void containerDTOtoContainer(ContainerDTO containerDTO,@MappingTarget Container container);
    List<ContainerDTO> containerListToContainerDTOList(List<Container> containers);

}
