package com.skillsanalysis.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillsanalysis.domains.SoftSkills;
import com.skillsanalysis.repos.SoftSkillsRepo;

@Service
public class SoftSkillsService {

	@Autowired
	private SoftSkillsRepo repo;
	
	public SoftSkills createSoftSkills(SoftSkills softSkills) {
		return this.repo.save(softSkills);
	}
	
	public SoftSkills getSoftSkillsById(Long id) {
		return this.repo.findById(id).orElse(null);	
	}
	
	public List<SoftSkills> getAllSoftSkills() {
		return this.repo.findAll().stream().collect(Collectors.toList());
	}
	
//	public SoftSkills updateSoftSkills(Long id, SoftSkills softSkills) {
//		SoftSkills exists = repo.findById(id).orElse(null);
//
//		exists.setFirstName(employee.getFirstName());
//		exists.setLastName(employee.getLastName());
//		exists.setEmail(employee.getEmail());
//		exists.setAddress(employee.getAddress());
//		exists.setRole(employee.getRole());
//		exists.setCompanyName(employee.getCompanyName());
//
//		return repo.save(exists);
//	}
	
	public boolean deleteSoftSkills(Long id) {				
		
		repo.deleteById(id);
		return (!repo.existsById(id));
	}
}
