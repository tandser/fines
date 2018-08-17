package ru.tandser.fines.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.base.MoreObjects;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cars")
@NamedEntityGraph(name = Car.WITH_FINES, attributeNodes = @NamedAttributeNode("fines"))
public class Car extends AbstractEntity {

    public static final String WITH_FINES = "Car.withFines";

    private String     brand;
    private String     model;
    private String     govNumber;
    private User       user;
    private List<Fine> fines;

    /* Setters and Getters */

    @NotBlank
    @Column(name = "brand")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @NotBlank
    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @NotBlank
    @Column(name = "gov_number")
    public String getGovNumber() {
        return govNumber;
    }

    public void setGovNumber(String govNumber) {
        this.govNumber = govNumber;
    }

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonBackReference
    @OneToMany(mappedBy = "car")
    public List<Fine> getFines() {
        return fines;
    }

    public void setFines(List<Fine> fines) {
        this.fines = fines;
    }

    /* equals, hashCode, toString */

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id",        getId())
                .add("brand",     getBrand())
                .add("model",     getModel())
                .add("govNumber", getGovNumber())
                .toString();
    }
}