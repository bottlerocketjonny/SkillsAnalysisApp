package com.skillsanalysis;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

@SpringBootTest(classes = SkillsAnalysisApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@Sql(scripts = { "classpath:test-schema.sql",
		"classpath:test-data.sql" },
   executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles(profiles = "test")
@AutoConfigureMockMvc
class SoftSkillsIntegrationTests {

	// to write
	
}
