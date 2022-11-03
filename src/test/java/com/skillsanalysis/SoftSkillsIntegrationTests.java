package com.skillsanalysis;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillsanalysis.domains.Employee;
import com.skillsanalysis.domains.EmployeeDTO;
import com.skillsanalysis.domains.SoftSkills;
import com.skillsanalysis.repos.EmployeeRepo;
import com.skillsanalysis.repos.SoftSkillsRepo;

@SpringBootTest(classes = SkillsAnalysisApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@Sql(scripts = { "classpath:test-schema.sql",
		"classpath:test-data.sql" },
   executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles(profiles = "test")
@AutoConfigureMockMvc
class SoftSkillsIntegrationTests {

	@Autowired
	private EmployeeRepo empRepo;
	
	@Autowired
	private SoftSkillsRepo ssRepo;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	private List<Employee> testEmployees;
	
	private List<SoftSkills> DB_DATA_SS;
	
	private List<EmployeeDTO> RESPONSE_DATA;
	
	@BeforeEach
	void setup() {
		
		List<SoftSkills> softSkills = new ArrayList<>();
		softSkills.add(new SoftSkills(1L, null, null, 8, 5, 7, 9, 6));
		
		LocalDate dob = LocalDate.of(1993, 03, 28);
		testEmployees = new ArrayList<>();
		//DB_DATA_SS = new ArrayList<>();
		testEmployees.add(new Employee(1L, softSkills, "Jennie", "Parnham", "j.parnham@gmail.com", dob, "124 Fake st, London, SE4 5DH", "Java Developer", "Peach Ltd"));
		//DB_DATA_SS.add(new SoftSkills(1L, null, null, 8, 5, 7, 9, 6));
		
		RESPONSE_DATA = testEmployees.stream().map(EmployeeDTO::new).toList();
		//RESPONSE_DATA.add();
	
		}

	// test create
	@Test
	public void testCreate() throws JsonProcessingException, UnsupportedEncodingException, Exception {
		Employee testEmp = testEmployees.get(0);
		//SoftSkills testSs = DB_DATA_SS.get(0);
		testEmp.setId(null);
		//testSs.setId(null);
		
		String testResultEmp = mockMvc
				.perform(post("/employee/create").contentType(MediaType.APPLICATION_JSON)			
				.content(mapper.writeValueAsString(testEmp)))								
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		
//		String testResultSs = mockMvc
//				.perform(post("/softskills/create").contentType(MediaType.APPLICATION_JSON)			
//				.content(mapper.writeValueAsString(testSs)))								
//				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		
		testEmp.setId(2L);
//		testSs.setId(2L);
		
		assertThat(testResultEmp).isEqualTo(mapper.writeValueAsString(testEmp));
//		assertThat(testResultSs).isEqualTo(mapper.writeValueAsString(testSs));
		
	}
	
	// test getAll
	@Test
	public void testGetAll() throws IllegalStateException, UnsupportedEncodingException, Exception {
		String testResult = mockMvc.perform(get("/employee/getAll")).andExpect
				(status().isOk()).andReturn().getResponse().getContentAsString();
		
		assertThat(testResult).isEqualTo(mapper.writeValueAsString(RESPONSE_DATA));					
	}
	
}
