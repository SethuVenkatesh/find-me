package com.sethu.backend.repo;

import com.sethu.backend.model.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganisationRepo extends JpaRepository<Organisation,String> {

    Organisation findByOrganisationId(String orgId);
    Organisation findByOrganisationName(String organisationName);
}
