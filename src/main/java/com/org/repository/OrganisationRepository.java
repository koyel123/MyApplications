package com.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.model.Organisation;

@Repository
public interface OrganisationRepository extends JpaRepository<Organisation, Long>{

}
