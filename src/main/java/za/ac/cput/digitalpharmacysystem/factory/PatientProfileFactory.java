package za.ac.cput.digitalpharmacysystem.factory;

import za.ac.cput.digitalpharmacysystem.domain.PatientProfile;
import za.ac.cput.digitalpharmacysystem.domain.User;
import za.ac.cput.digitalpharmacysystem.util.Helper;

import java.time.LocalDate;

public class PatientProfileFactory {

    public static PatientProfile buildPatientProfile(User user, LocalDate dateOfBirth, String allergies, String chronicConditions, String emergencyContactPhone) {
        if (user == null || dateOfBirth == null || Helper.isNullOrEmpty(emergencyContactPhone)) {
            return null;
        }

        return new PatientProfile.Builder()
                .setUser(user)
                .setDateOfBirth(dateOfBirth)
                .setAllergies(allergies)
                .setChronicConditions(chronicConditions)
                .setEmergencyContactPhone(emergencyContactPhone)
                .build();
    }

}
