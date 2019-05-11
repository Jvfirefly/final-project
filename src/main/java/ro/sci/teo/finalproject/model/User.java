package ro.sci.teo.finalproject.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * @author Teo
 */
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @Size(min = 2, max = 30, message = "At least 2 characters!")
    private String name;

    @Size(min = 2, max = 30, message = "At least 2 characters!")
    private String surname;

    @Size(min = 2, max = 30, message = "At least 2 characters!")
    private String username;

    //@Size(min = 10, max = 30, message = "At least 10 characters!")
    @NotEmpty(message = "*Please provide your password.")
    private String password;

    @Transient
    private String passwordConfirm;

    @Size(min = 2, max = 30, message = "At least 2 characters!")
    private String city;

    @Size(min = 2, max = 255, message = "At least 2 characters!")
    private String address;

    @Size(min = 10, max = 10, message = "10 characters!")
    private String phone;

    @ManyToMany
    private Set<Role> roles;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
