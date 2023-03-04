package models;

public class User {

    private static String firstName = "Marian";
    private static String lastName = "Best";
    private static String postalCode = "14-100";
    private static String username = "standard_user";
    private static String password = "secret_sauce";

    public static void setUsername(String username) {
        User.username = username;
    }

    public static void setPassword(String password) {
        User.password = password;
    }

    public static String getFirstName() {
        return firstName;
    }

    public static String getLastName() {
        return lastName;
    }

    public static String getPostalCode() {
        return postalCode;
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }


}
