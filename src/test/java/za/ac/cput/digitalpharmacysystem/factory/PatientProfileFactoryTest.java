package za.ac.cput.digitalpharmacysystem.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.digitalpharmacysystem.domain.PatientProfile;
import za.ac.cput.digitalpharmacysystem.domain.User;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class PatientProfileFactoryTest {

    @Test
    void testBuildPatientProfileSuccess() {
        User user = UserFactory.buildUser(
                "Noxolo Ngubo",
                "noxolo@example.com",
                "hashedPass123",
                "0821234567",
                User.UserRole.CUSTOMER
        );

        PatientProfile profile = PatientProfileFactory.buildPatientProfile(
                user,
                LocalDate.of(1998, 5, 15),
                "Penicillin",
                "Asthma",
                "0829876543"
        );

        assertNotNull(profile);
        assertEquals(user, profile.getUser());
        assertEquals("Penicillin", profile.getAllergies());
        System.out.println("PatientProfile built successfully: " + profile);
    }

    @Test
    void testBuildPatientProfileWithNullUserFails() {
        PatientProfile profile = PatientProfileFactory.buildPatientProfile(
                null,
                LocalDate.of(1998, 5, 15),
                "None",
                "None",
                "0829876543"
        );

        assertNull(profile, "Factory should return null if User is null");
    }

}
