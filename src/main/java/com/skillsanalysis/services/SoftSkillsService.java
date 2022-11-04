package com.skillsanalysis.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillsanalysis.domains.SoftSkills;
import com.skillsanalysis.domains.SoftSkillsDTO;
import com.skillsanalysis.repos.SoftSkillsRepo;

@Service
public class SoftSkillsService {

	@Autowired
	private SoftSkillsRepo repo;
	
	public SoftSkills createSoftSkills(SoftSkills softSkills) {
		return this.repo.save(softSkills);
	}

	public List<SoftSkillsDTO> updateSoftSkills(Long id, SoftSkills softSkills) {
		SoftSkills exists = repo.findById(id).orElse(new SoftSkills());

		exists.setCommunication(softSkills.getCommunication());
		exists.setProblemSolving(softSkills.getProblemSolving());
		exists.setLeadership(softSkills.getLeadership());
		exists.setPunctuality(softSkills.getPunctuality());
		exists.setTeamPlayer(softSkills.getTeamPlayer());
		exists.setDate(softSkills.getDate());
		
		repo.save(exists);
		return repo.findById(id).stream().map(SoftSkillsDTO::new).collect(Collectors.toList());
	}
	
	public boolean deleteSoftSkills(Long id) {				
		
		repo.deleteById(id);
		return (!repo.existsById(id));
	}
}
