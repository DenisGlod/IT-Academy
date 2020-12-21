package by.itacademy.model;

import java.util.Objects;

public class User extends AbstractModel {
    private String login;
    private String password;
    private String fio;
    private Integer age;
    private Role role;

    public User() {
    }

    public User(Long id, String login, String password, String fio, Integer age, Role role) {
        super(id);
        this.login = login;
        this.password = password;
        this.fio = fio;
        this.age = age;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("login='").append(login).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", fio='").append(fio).append('\'');
        sb.append(", age=").append(age);
        sb.append(", role=").append(role);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) && Objects.equals(password, user.password) && Objects.equals(fio, user.fio) && Objects.equals(age, user.age) && role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, fio, age, role);
    }
}
