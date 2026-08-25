package za.ac.cput.digitalpharmacysystem.util;
import java.util.regex.Pattern;

public class Helper {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean isValidEmail(String email) {
        if (isNullOrEmpty(email)) {
            return false;
}
        return Pattern.compile(EMAIL_REGEX).matcher(email).matches();
    }
}
