package com.skillsanalysis.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillsanalysis.domains.SoftSkills;

@Repository
public interface SoftSkillsRepo extends JpaRepository<SoftSkills, Long> {

}
