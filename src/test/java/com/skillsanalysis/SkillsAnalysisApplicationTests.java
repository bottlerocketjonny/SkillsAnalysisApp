package com.skillsanalysis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillsanalysis.domains.Employee;
import com.skillsanalysis.domains.EmployeeDTO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:testdata.sql", "classpath:testdata.sql" },
    executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles(profiles = "dev")
class SkillsAnalysisApplicationTests {

	   @Autowired
	    private MockMvc mock;

	    @Autowired
	    private ModelMapper mapper;

	    private EmployeeDTO mapToDTO(Employee employee) {
	        return this.modelMapper.map(employee, EmployeeDTO.class);
	    }

	    @Autowired
	    private ObjectMapper jsonifier;

}
