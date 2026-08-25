package za.ac.cput.digitalpharmacysystem.factory;

import za.ac.cput.digitalpharmacysystem.domain.User;
import za.ac.cput.digitalpharmacysystem.util.Helper;

public class UserFactory {

    public static User buildUser(String fullName, String email, String passwordHash, String phone, User.UserRole role) {
        if (Helper.isNullOrEmpty(fullName) || Helper.isNullOrEmpty(passwordHash) || !Helper.isValidEmail(email)) {
            return null;
        }

        return new User.Builder()
                .setFullName(fullName)
                .setEmail(email)
                .setPasswordHash(passwordHash)
                .setPhone(phone)
                .setRole(role != null ? role : User.UserRole.CUSTOMER)
                .build();
    }
}
