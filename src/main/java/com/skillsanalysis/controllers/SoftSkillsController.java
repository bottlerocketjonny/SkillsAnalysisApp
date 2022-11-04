package com.skillsanalysis.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillsanalysis.domains.SoftSkills;
import com.skillsanalysis.domains.SoftSkillsDTO;
import com.skillsanalysis.services.SoftSkillsService;

@RestController
@RequestMapping("/softskills")
public class SoftSkillsController {
	
	@Autowired
	SoftSkillsService service;
	
	@PostMapping("/create")
	public SoftSkills createSoftSkills(@RequestBody SoftSkills softSkills) {
		return service.createSoftSkills(softSkills);
	}
	
	@PutMapping("/update/{id}")
	public List<SoftSkillsDTO> updateSoftSkills(@RequestBody SoftSkills softSkills, @PathVariable("id") Long id) {
		return service.updateSoftSkills(id, softSkills);
	}
	
	@DeleteMapping("/delete/{id}")
	public Boolean deleteSoftSkills(@PathVariable("id") Long id) {
		return service.deleteSoftSkills(id);
	}


	
}
