package com.skillsanalysis;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
import com.skillsanalysis.repos.EmployeeRepo;

@SpringBootTest(classes = SkillsAnalysisApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@Sql(scripts = { "classpath:testdata.sql" },
   executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles(profiles = "test")
@AutoConfigureMockMvc
class SkillsAnalysisApplicationTests {

	@Autowired
	private EmployeeRepo repo;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	private final List<Employee> DB_DATA = new ArrayList<Employee>(Arrays.asList
			(new Employee(1L, "Jonny", "Coddington", "j.coddington@gmail.com", "28/07/1993", "123 Fake St, London, SE3 4DY", "Java Developer", "Peach Ltd"), 
			new Employee(2L, "Jonny", "Coddington", "j.coddington@gmail.com", "28/07/1993", "123 Fake St, London, SE3 4DY", "Java Developer", "Peach Ltd")));
	
	private final List<EmployeeDTO> RESPONSE_DATA = new ArrayList<EmployeeDTO>(Arrays.asList
			(new EmployeeDTO(DB_DATA.get(0)), new EmployeeDTO(DB_DATA.get(1))));
	
	// test getAll
	
	@Test
	public void testGetAll() throws IllegalStateException, UnsupportedEncodingException, Exception {
		String testResult = mockMvc.perform(get("/employee/getAll")).andExpect
				(status().isOk()).andReturn().getResponse().getContentAsString();					// perform getAll and receive 200 response
		assertThat(testResult).isEqualTo(mapper.writeValueAsString(RESPONSE_DATA));					// DTO returned as JSON is the same as SQL test data
	}
	
	// test create
	
	@Test
	public void testCreate() throws JsonProcessingException, UnsupportedEncodingException, Exception {
		Employee test = DB_DATA.get(0);
		test.setId(null);																			// expecting id = null
		
		String testResult = mockMvc
				.perform(post("/employee/create").contentType(MediaType.APPLICATION_JSON)			// perform create and pass data in JSON
				.content(mapper.writeValueAsString(test)))								
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();			// status 200 check and get response content as string
		
		test.setId(3L);																				// id = 3L as we have passed in 2 employees
		
		assertThat(testResult).isEqualTo(mapper.writeValueAsString(test));
	}
}
