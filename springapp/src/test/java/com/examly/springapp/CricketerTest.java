package com.examly.springapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import org.junit.After;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
public class CricketerTest {

@Test
    public void W1_Day1testFieldExistence() {
        Class<Cricketer> personClass = Cricketer.class;
        
        assertFieldExists(personClass, "name");
        assertFieldExists(personClass, "age");
        assertFieldExists(personClass, "country");
    }
    
    private void assertFieldExists(Class<?> clazz, String fieldName) {
        try {
            Field field = clazz.getDeclaredField(fieldName);
            assertNotNull(field);
        } catch (NoSuchFieldException e) {
            fail("Field '" + fieldName + "' does not exist in the " + clazz.getSimpleName() + " class.");
        }
    }


@Test
void W1_Day1testCricketerNameGetterAndSetter() {

        Cricketer cricketer = new Cricketer();

        cricketer.setName("Virat Kohli");

        assertEquals("Virat Kohli", cricketer.getName());

    }

 @Test

    void W1_Day1testCricketerAgeGetterAndSetter() {

        Cricketer cricketer = new Cricketer();

        cricketer.setAge(25);

        assertEquals(25, cricketer.getAge());

    }

   
@Test
void W1_Day1testCricketerCountryGetterAndSetter() {

        Cricketer cricketer = new Cricketer();

        cricketer.setCountry("India");

        assertEquals("India", cricketer.getCountry());

    }
@Test
public void W1_day2Clientinterface() {

        String filePath = "src/main/java/com/examly/springapp/Client.java";

        File file = new File(filePath);

        assertTrue(file.exists() && file.isFile());

    }

	@Test

    public void W1_day2serviceinterface() {

        String filePath = "src/main/java/com/examly/springapp/Service.java";

        File file = new File(filePath);

        assertTrue(file.exists() && file.isFile());

    }





 @Test
    public void W1_Day3testAddCricketers() {
        ArrayList<Cricketer> cricketersList = new ArrayList<>();

        cricketersList.add(new Cricketer("Virat Kohli", 32, "India"));
        cricketersList.add(new Cricketer("Steve Smith", 31, "Australia"));

        assertEquals(2, cricketersList.size(), "Number of cricketers added should be 2");
    }

    @Test
    public void W1_Day4testSortCricketersByName() {
        ArrayList<Cricketer> cricketersList = new ArrayList<>();
        cricketersList.add(new Cricketer("Virat Kohli", 32, "India"));
        cricketersList.add(new Cricketer("Steve Smith", 31, "Australia"));
        cricketersList.add(new Cricketer("Kane Williamson", 30, "New Zealand"));

        Collections.sort(cricketersList);

        assertEquals("Kane Williamson", cricketersList.get(0).getName(), "First cricketer should be Kane Williamson");
        assertEquals("Steve Smith", cricketersList.get(1).getName(), "Second cricketer should be Steve Smith");
        assertEquals("Virat Kohli", cricketersList.get(2).getName(), "Third cricketer should be Virat Kohli");
    }

    @Test
    public void W1_Day4testSortCricketersByAge() {
        ArrayList<Cricketer> cricketersList = new ArrayList<>();
        cricketersList.add(new Cricketer("Virat Kohli", 32, "India"));
        cricketersList.add(new Cricketer("Steve Smith", 31, "Australia"));
        cricketersList.add(new Cricketer("Kane Williamson", 30, "New Zealand"));

        Collections.sort(cricketersList, new CricketerAgeComparator());

        assertEquals("Kane Williamson", cricketersList.get(0).getName(), "Youngest cricketer should be Kane Williamson");
        assertEquals("Steve Smith", cricketersList.get(1).getName(), "Second youngest cricketer should be Steve Smith");
        assertEquals("Virat Kohli", cricketersList.get(2).getName(), "Oldest cricketer should be Virat Kohli");
    }
        
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/project";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "Sound@0301";

    private Connection connection;
 @Test
    public void W1_Day5testConnection() throws Exception{
        connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
        assertNotNull(connection);
        connection.close();
    }




    @After
    public void tearDown() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

   


    
    @Test
    public void W1_Day5testRetrieveData() throws SQLException {
        connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
        String query = "SELECT * FROM cricketer";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            
            // Assuming that the ResultSet contains multiple rows, loop through them
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String country = resultSet.getString("country");

                assertNotNull(name);
                assertNotNull(age); // Update the age threshold as needed
                assertNotNull(country);
                //System.out.println("Display the cricketername"+name);
            }
        }
    }

@Autowired
private MockMvc mockMvc;
   


@Test
    public void W2_Day2testWelcome() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/admin/Welcome"))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.content().string("Welcome to SpringProject"));
    }


@Test
void W2_day3getAllTeamsList() throws Exception {
        mockMvc.perform(get("/api/admin/teams")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andReturn();
    }




@Test
void W2_day4testaddTeamsusingjpa() throws Exception {
String st = "{\"id\": 123,\"name\": \"browndemo\", \"maximumBudget\": 457}";
mockMvc.perform(MockMvcRequestBuilders.post("/api/admin/teams")
.contentType(MediaType.APPLICATION_JSON)
.content(st))
.andExpect(MockMvcResultMatchers.status().isOk())
                // .andExpect(jsonPath("$").value(true))
.andReturn();
}


@Test
void W2_day5testgetAllusingJpa() throws Exception{  

        mockMvc.perform(get("/api/admin/JpaTeams")
        .accept(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$").isArray())
        .andReturn();
}

@Test
void W2_day6testupdateDetailsJpa() throws Exception {  

String st ="{\"id\": 123,\"name\": \"browndemo\", \"maximumBudget\": 45750}";
mockMvc.perform(MockMvcRequestBuilders.put("/api/admin/teams/123")
.contentType(MediaType.APPLICATION_JSON)
.content(st)
.accept(MediaType.APPLICATION_JSON))
.andExpect(MockMvcResultMatchers.status().isOk())
.andExpect(jsonPath("$.maximumBudget").value(45750))
.andReturn();
}
    
    @Test
    public void W2_day6testDeleteJpa() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/admin/teams/123")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                // .andExpect(jsonPath("$").value(true))

                .andReturn();
    }


    


    @Test
    void w3_day2playeraddJpa() throws Exception {
        String st = "{\"id\": 1000,\"name\": \"Demo\", \"age\": 24,\"category\": \"Seniorteam\",\"biddingPrice\":15000,\"sold\":true,\"email\": \"Viratdemo@gmail.com\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/player/add")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(st)
                    .accept(MediaType.APPLICATION_JSON))
               .andExpect(MockMvcResultMatchers.status().isOk())
              // .andExpect(MockMvcResultMatchers.content().string("true"))  // Correct way to validate boolean response
               .andReturn();
    }
    
    
        @Test
        void w3_day2playerupdateJpa() throws Exception {
            String st = "{\"id\": 1000,\"name\": \"Demo\", \"age\": 24,\"category\": \"Juniorteam\",\"biddingPrice\":15000,\"sold\":true,\"email\": \"Viratdemo@gmail.com\"}";
            mockMvc.perform(MockMvcRequestBuilders.put("/player/update/1000")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(st)
                        .accept(MediaType.APPLICATION_JSON))
                   .andExpect(MockMvcResultMatchers.status().isOk())
                   .andExpect(jsonPath("$.category").value("Juniorteam"))
                   .andReturn();
        }
    
        @Test
        void W3_day2getallPlayer() throws Exception {
            mockMvc.perform(MockMvcRequestBuilders.get("/player/getall")
                        .accept(MediaType.APPLICATION_JSON))
                   .andDo(print())
                   .andExpect(status().isOk())
                   .andExpect(jsonPath("$").isArray())
                   .andReturn();
        }
    
        @Test
        void W3_day2deletePlayer() throws Exception {
            mockMvc.perform(MockMvcRequestBuilders.delete("/player/delete/1000")
                        .accept(MediaType.APPLICATION_JSON))
                   .andDo(print())
                   .andExpect(status().isOk())
                   .andExpect(jsonPath("$").value(true))
                   .andReturn();
        }





    @Test

    public void configfolder() {

        String directoryPath = "src/main/java/com/examly/springapp/configurations"; // Replace with the path to your directory

        File directory = new File(directoryPath);

        assertTrue(directory.exists() && directory.isDirectory());

    }

    @Test

    public void  ApplSecurityfile() {

        String filePath = "src/main/java/com/examly/springapp/configurations/ApplSecurityConfig.java";

        File file = new File(filePath);

        assertTrue(file.exists() && file.isFile());

    }

    @Test

    public void Authfile() {

        String filePath = "src/main/java/com/examly/springapp/configurations/AuthenticationBean.java";

        File file = new File(filePath);

        assertTrue(file.exists() && file.isFile());

    }

    @Test

    public void corsCongiffile() {

        String filePath = "src/main/java/com/examly/springapp/configurations/CorsConfig.java";

        File file = new File(filePath);

        assertTrue(file.exists() && file.isFile());

    }

@Test
public void  usersConfig() {

        String filePath = "src/main/java/com/examly/springapp/configurations/MyUserDetailsService.java";

        File file = new File(filePath);

        assertTrue(file.exists() && file.isFile());

    }

//@Test
//public void swagger() {
//
//        String filePath = "src/main/java/com/examly/springapp/configurations/SwaggerConfig.java";
//
//        File file = new File(filePath);
//
//        assertTrue(file.exists() && file.isFile());
//
//    }

    @Test

    public void UserPrin() {

        String filePath = "src/main/java/com/examly/springapp/configurations/UserPrinciple.java";

        File file = new File(filePath);

        assertTrue(file.exists() && file.isFile());

    }

    // @Test
    // public void testHelloSpring() throws Exception {
    //     mockMvc.perform(MockMvcRequestBuilders.get("myapp/Welcome"))
    //         .andExpect(MockMvcResultMatchers.status().isOk())
    //         .andExpect(MockMvcResultMatchers.content().string("Welcome to Spring"));
    // }



    
}
    


