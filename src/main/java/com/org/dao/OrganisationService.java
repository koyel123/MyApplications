package com.org.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.model.Organisation;
import com.org.repository.OrganisationRepository;

@Service
public class OrganisationService {

	@Autowired
	OrganisationRepository organisationRepository;

	public Organisation save(Organisation organisation) {
		return organisationRepository.save(organisation);
	}

	public List<Organisation> findAll() {
		return organisationRepository.findAll();
	}

	public Organisation findById(Long id) {
		return organisationRepository.findOne(id);

	}

	public void delete(Organisation organisation) {
		organisationRepository.delete(organisation);

	}
	
	

}
