package com.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.org.dao.OrganisationService;
import com.org.model.Organisation;

@RestController
public class OrganisationController {

	@Autowired
	OrganisationService organisationService;

	@RequestMapping(value = "saveOrganisations", method = RequestMethod.POST)
	public Organisation save(@RequestBody Organisation organisation) {
		return organisationService.save(organisation);

	}

	@RequestMapping(value = "findAllOrganisations", method = RequestMethod.GET)
	public List<Organisation> findListOfOrganisations() {
		return organisationService.findAll();

	}

	@RequestMapping(value = "findOrganisation/{orgId}", method = RequestMethod.GET)
	public ResponseEntity<Organisation> findOrganisation(@PathVariable(value = "orgId") long id) {
		Organisation org = organisationService.findById(id);
		if (org == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(org);

	}

	@RequestMapping(value = "updateOrganisation/{orgId}", method = RequestMethod.PUT)
	public ResponseEntity<Organisation> updateOrganisation(@PathVariable(value = "orgId") long id,
			@RequestBody Organisation organisation) {
		Organisation org = organisationService.findById(id);
		if (org == null) {
			return ResponseEntity.notFound().build();
		}
		org.setOrgName(organisation.getOrgName());
		org.setCreatedAt(organisation.getCreatedAt());
		org.setUpdatedAt(organisation.getUpdatedAt());
		organisationService.save(org);
		return ResponseEntity.ok().body(org);

	}

	@RequestMapping(value = "deleteOrganisation/{orgId}", method = RequestMethod.DELETE)
	public ResponseEntity<Organisation> deleteOrganisation(@PathVariable(value = "orgId") long id) {
		Organisation org = organisationService.findById(id);
		if (org == null) {
			return ResponseEntity.notFound().build();
		}
		organisationService.delete(org);
		return ResponseEntity.ok().body(org);
	}
}
