package _5HashMap;

import lombok.Data;

import java.util.Objects;

@Data
public class User {
    private  String username;
    private  String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return password.equals(user.password) && username.equals(user.username);
        //return Objects.equals(username, user.username) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return username.hashCode()*31 + password.hashCode();
    }

    @Override
    public String toString() {
        return "{" +
                "password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
