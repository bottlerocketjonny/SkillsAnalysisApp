package com.skillsanalysis.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillsanalysis.domains.SoftSkills;
import com.skillsanalysis.services.SoftSkillsService;

@RestController
@RequestMapping("/softskills")
public class SoftSkillsController {
	
	@Autowired
	SoftSkillsService service;
	
	// create
	@PostMapping("/create")
	public SoftSkills createSoftSkills(@RequestBody SoftSkills softSkills) {
		return service.createSoftSkills(softSkills);
	}
	
	// get all
	@GetMapping("/getAll")
	public List<SoftSkills> getAllSoftSkills() {
		return service.getAllSoftSkills();
	}
	
	// get one by id
	@GetMapping("/getOne/{id}")
	public SoftSkills getSoftSkillsById(@PathVariable("id") Long id) {			
		return service.getSoftSkillsById(id);
	}
	
//	// update
//	@PutMapping("/update/{id}")
//	public SoftSkills updateSoftSkills(@RequestBody SoftSkills softSkills, @PathVariable("id") Long id) {
//		return service.updateSoftSkills(id, softSkills);
//	}
	
	// delete
	@DeleteMapping("/delete/{id}")
	public Boolean deleteSoftSkills(@PathVariable("id") Long id) {
		return service.deleteSoftSkills(id);
	}


	
}
