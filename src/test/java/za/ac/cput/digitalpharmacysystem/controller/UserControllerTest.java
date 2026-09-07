
package za.ac.cput.digitalpharmacysystem.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.digitalpharmacysystem.domain.User;
import za.ac.cput.digitalpharmacysystem.factory.UserFactory;

import static org.junit.jupiter.api.Assertions.*;

//Author: 221066746 (Noxolo Portia Ngubo)

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private static User user;

    @BeforeAll
    static void setUp() {
        // Updated to match your UserFactory method signature (fullName, email, passwordHash, phone, role)
        user = UserFactory.buildUser("Noxolo", "noxolo.controller@example.com", "pass123", "0812345678", User.UserRole.CUSTOMER);
    }

    @Test
    @Order(1)
    void create() {
        String url = "/user/create";
        ResponseEntity<User> response = restTemplate.postForEntity(url, user, User.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        user = response.getBody(); // Store saved user with generated ID
    }

    @Test
    @Order(2)
    void read() {
        assertNotNull(user, "User should not be null before testing read");
        String url = "/user/read/" + user.getId();
        ResponseEntity<User> response = restTemplate.getForEntity(url, User.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    @Order(3)
    void getAll() {
        String url = "/user/getall";
        ResponseEntity<User[]> response = restTemplate.getForEntity(url, User[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().length > 0);
    }
}