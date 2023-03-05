package models;

public class User {

    private String firstName = "Marian";
    private String lastName = "Best";
    private String postalCode = "14-100";
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


}
