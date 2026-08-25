package za.ac.cput.digitalpharmacysystem.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.digitalpharmacysystem.domain.User;

import static org.junit.jupiter.api.Assertions.*;

public class UserFactoryTest {

    @Test
    void testBuildUserSuccess() {
        User user = UserFactory.buildUser(
                "Noxolo Ngubo",
                "noxolo@example.com",
                "hashedPass123",
                "0821234567",
                User.UserRole.CUSTOMER
        );

        assertNotNull(user);
        assertEquals("Noxolo Ngubo", user.getFullName());
        assertEquals("noxolo@example.com", user.getEmail());
        assertEquals(User.UserRole.CUSTOMER, user.getRole());
        System.out.println("User built successfully: " + user);
    }
    @Test
    void testBuildUserWithInvalidEmailFails() {
        User user = UserFactory.buildUser(
                "Noxolo Ngubo",
                "invalid-email-format",
                "hashedPass123",
                "0821234567",
                User.UserRole.CUSTOMER
        );

        assertNull(user, "Factory should return null for invalid email formats");
    }
    @Test
    void testBuildUserWithMissingNameFails() {
        User user = UserFactory.buildUser(
                "",
                "noxolo@example.com",
                "hashedPass123",
                "0821234567",
                User.UserRole.CUSTOMER
        );

        assertNull(user, "Factory should return null if full name is empty");
    }
}
