package com.skillsanalysis;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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

@SpringBootTest(classes = SkillsAnalysisApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@Sql(scripts = { "classpath:test-schema.sql",
		"classpath:test-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles(profiles = "test")
@AutoConfigureMockMvc
class EmployeeIntegrationTests {

	@Autowired
	private EmployeeRepo empRepo;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper mapper;

	private List<Employee> testEmployees;
	private List<EmployeeDTO> testEmployeesResponse;
	private List<SoftSkills> softSkills = new ArrayList<>();

	@BeforeEach
	void setup() {

		softSkills.add(new SoftSkills(1L, null, null, 8, 5, 7, 9, 6));

		LocalDate dob = LocalDate.of(1993, 03, 28);

		testEmployees = new ArrayList<>();
		testEmployees.add(new Employee(1L, softSkills, "Jennie", "Parnham", "j.parnham@gmail.com", dob,
				"124 Fake st, London, SE4 5DH", "Java Developer", "Peach Ltd"));

		testEmployeesResponse = testEmployees.stream().map(EmployeeDTO::new).toList();
	}

	// test create
	@Test
	public void testCreate() throws Exception {
		Employee test = testEmployees.get(0);
		test.setId(null);

		String testResult = mockMvc
				.perform(post("/employee/create").contentType(MediaType.APPLICATION_JSON)
						.content(mapper.writeValueAsString(test)))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

		test.setId(2L);
		assertThat(testResult).isEqualTo(mapper.writeValueAsString(test));
	}

	// test getAll
	@Test
	public void testGetAll() throws Exception {
		String testResult = mockMvc.perform(get("/employee/getAll")).andExpect(status().isOk()).andReturn()
				.getResponse().getContentAsString();

		assertThat(testResult).isEqualTo(mapper.writeValueAsString(testEmployeesResponse));
	}
	
	// test getOne
	@Test
	void testGetOne() throws Exception {

		String testResult = mockMvc.perform(get("/employee/getOne/1")).andExpect(status().isOk()).andReturn()
				.getResponse().getContentAsString();

		assertThat(testResult).isEqualTo(mapper.writeValueAsString(testEmployeesResponse));

	}

	// test update
	@Test
	public void testUpdate() throws JsonProcessingException, UnsupportedEncodingException, Exception {
		
		LocalDate dob2 = LocalDate.of(1993, 01, 22);
		Employee test = new Employee(1L, softSkills, "Jonny", "Coddington", "j.coddington@gmail.com", dob2,
				"69 The Road, London, SE23 5RT", "Python Developer", "Peach Ltd");
		
		String testResult = mockMvc
				.perform(put("/employee/update/").contentType(MediaType.APPLICATION_JSON)
						.content(mapper.writeValueAsString(test)))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

		assertThat(testResult).isEqualTo(mapper.writeValueAsString(test));
	}
	
	// test delete
	@Test
	public void testDelete() throws Exception {
		
		this.mockMvc.perform(delete("/employee/delete/{id}", "1").contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		
	//	assertThat(testResult).isEqualTo(mapper.writeValueAsString(null));
		
	}

}
