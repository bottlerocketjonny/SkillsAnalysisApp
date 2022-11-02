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

	private LocalDate date;

	private String communication;

	private String problemSolving;

	private String leadership;

	private String punctuality;

	private String teamPlayer;

	public SoftSkillsDTO(SoftSkills softSkills) {
		this.date = softSkills.getDate();
		this.communication = softSkills.getCommunication();
		this.problemSolving = softSkills.getProblemSolving();
		this.leadership = softSkills.getLeadership();
		this.punctuality = softSkills.getPunctuality();
		this.teamPlayer = softSkills.getTeamPlayer();
	}
}
