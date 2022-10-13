package Task3;

import java.util.Objects;

public class User {
    @Save
    private String login;
    @Save
    private int age;
    @Save
    private String email;
    private String gender;


    public User(String login, int age, String email, String gender) {
        this.login = login;
        this.age = age;
        this.email = email;
        this.gender = gender;
    }

    public User() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(login, user.login) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, age, email);
    }
}
