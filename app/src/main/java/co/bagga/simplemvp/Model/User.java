package co.bagga.simplemvp.Model;

/**
 * Created by Lalit Bagga on 2017-06-11.
 *
 * Represents user object
 */

public class User {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private int id;
    private String firstName;
    private String lastName;
}
