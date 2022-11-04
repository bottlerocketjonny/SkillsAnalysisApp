package com.skillsanalysis.domains;

import java.time.LocalDate;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class SoftSkillsDTO {

	private Long id;
	
	private LocalDate date;

	private int communication;

	private int problemSolving;

	private int leadership;

	private int punctuality;

	private int teamPlayer;

	public SoftSkillsDTO(SoftSkills softSkills) {
		this.id = softSkills.getId();
		this.date = softSkills.getDate();
		this.communication = softSkills.getCommunication();
		this.problemSolving = softSkills.getProblemSolving();
		this.leadership = softSkills.getLeadership();
		this.punctuality = softSkills.getPunctuality();
		this.teamPlayer = softSkills.getTeamPlayer();
	}
}
