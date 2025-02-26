package com.sethu.backend.mapper;

import com.sethu.backend.dto.OrganisationDTO;
import com.sethu.backend.model.Organisation;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrganisationMapper {
    void organisationToOrganisationDTO(Organisation container, @MappingTarget OrganisationDTO containerDTO);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void organisationDTOToOrganisation(OrganisationDTO containerDTO,@MappingTarget Organisation container);

}


