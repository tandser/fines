package ru.tandser.fines.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.base.MoreObjects;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@NamedEntityGraph(name = User.WITH_CARS, attributeNodes = @NamedAttributeNode("cars"))
public class User extends AbstractEntity {

    public static final String WITH_CARS = "User.withCars";

    private String    name;
    private String    patronymic;
    private String    surname;
    private String    licenseNumber;
    private List<Car> cars;

    /* Setters and Getters */

    @NotBlank
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotBlank
    @Column(name = "patronymic")
    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @NotBlank
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @NotBlank
    @Column(name = "license_number")
    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonBackReference
    @OneToMany(mappedBy = "user")
    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    /* equals, hashCode, toString */

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id",            getId())
                .add("name",          getName())
                .add("patronymic",    getPatronymic())
                .add("surname",       getSurname())
                .add("licenseNumber", getLicenseNumber())
                .add("version",       getVersion())
                .toString();
    }
}