# SkillsAnalysisAPI
RESTful API built using Java and Spring Boot.

Deployed API: https://skillsanalysisapp-production.up.railway.app/

Deployed Frontend: https://skillsanalysisfrontend-production.up.railway.app/

**Why are we doing this?**

For this software development project we were required to build an API for the backend of an application that communicates and stores data within a relational database. The API must have CRUD functionality (create, read, update, delete) and be fully tested using automated integration and unit tests. 

In order to implement this it was necessary to use a variety of technologies learnt during our time on the QA DfE Software Specialism course, including Java, Spring Boot, Maven, H2/SQL, Lombok, Junit and Mockito, as well as demonstrating version control and project management using industry standard software such as Git/GitHub and Jira. 

After some research and planning, I decided to work on an API that would become part of a full stack application that employers/HR can use to track their employees’ soft skills and tech skills. This information would be displayed to the user in the form of a radar chart, giving the employer visual feedback of their employees’ strengths and weaknesses. 

Users of the app can create employees with attributes such as name, email, address, DOB, role and company name. They can also assign a rating (between 1-10) to each employee for soft skills such as communication, problem solving, leadership, team player and punctuality. 

The main functionality of the backend of the project has been achieved during the allocated time, however in the future I would like to work towards building a frontend and improve some of the logic. 

**How did it go?**

I went into this project feeling confident about the majority of technologies we have learnt on the course, however the main challenge was combining all these technologies to create a functioning application that could be showcased on a portfolio.

Despite feeling mostly confident, there were still some aspects of the project that seemed daunting. Testing was the main topic that I didn’t grasp wholly during our study time, however after having gone through it with our tutor during the week of the project, I’m happy to have ironed out any major issues that I had with the topic.

**What went well? What didn't go as planned?**

Overall, I am really happy with how this project has turned out and I’m excited to demonstrate its functionality to potential employers. The highlights for me were that I managed to get two tables working together without too many issues and learned a lot about how databases are built during the process. I’m also pleased that I managed to successfully implement the feature-branch model in my Git usage.

**Possible improvements for future revisions of the project?**

I would like to add a feature where you can view the employee data as a radar chart. This would add a visual element to the project that could help it stand out to employers. It would also be nice to have the option to superimpose the soft skills data on top of one another so employers can compare their employees’ development. 

Another idea that I had was to make an evaluation form with questions and a formula that would help determine the average score for each soft skill as opposed to employers assigning arbitrary values. This would add another layer of complexity to the project. 

**ERD diagram**

![ERD](https://i.postimg.cc/sDpRT6py/ERD-diagram.png)

**Postman request screenshots**

![createEmployee](https://i.postimg.cc/x1rrgFyP/create-employee.png)

![createSoftSkills](https://i.postimg.cc/cHk23DLw/create-soft-Skills.png)

![deleteEmployee](https://i.postimg.cc/d1VgLMwJ/delete-employee.png)

![deleteSoftSkills](https://i.postimg.cc/2yqJ741J/delete-soft-Skills.png)

![getAllEmployees](https://i.postimg.cc/02wF60RK/get-All-employees.png)

![getOneEmployeeByName](https://i.postimg.cc/pV73X17t/get-One-By-Name-employee.png)

![getOneEmployee](https://i.postimg.cc/wMSrf7JB/get-One-employee.png)

![updateEmployee](https://i.postimg.cc/9QHSywC8/update-Employee-employee.png)

![updateSoftSkills](https://i.postimg.cc/SxLPdQKy/update-Soft-Skills-soft-Skills.png)

**H2 database screenshots**

![h2persistance](https://i.postimg.cc/ZqZGzBQB/h2-proof.png)

**Integration and unit test results**

![testresults](https://i.postimg.cc/Z56GQFwz/tests-proof.png)

**Jira Board**

https://jonnycoddington.atlassian.net/jira/software/projects/QFP/boards/1
