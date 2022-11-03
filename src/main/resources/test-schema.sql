DROP TABLE IF EXISTS employee CASCADE;
DROP TABLE IF EXISTS soft_skills CASCADE;
CREATE TABLE employee 
(
	id BIGINT PRIMARY KEY AUTO_INCREMENT, 
	address VARCHAR(255), company_name VARCHAR(255), 
	dob DATE, email VARCHAR(255), first_name VARCHAR(255), 
	last_name VARCHAR(255), role VARCHAR(255)
);
CREATE TABLE soft_skills 
(
	id BIGINT PRIMARY KEY AUTO_INCREMENT, 
	communication INTEGER NOT NULL, 
	date DATE, leadership INTEGER NOT NULL, 
	problem_solving INTEGER NOT NULL, 
	punctuality INTEGER NOT NULL, 
	team_player INTEGER NOT NULL, 
	employee_id BIGINT, 
	FOREIGN KEY (employee_id) REFERENCES employee(id)
);