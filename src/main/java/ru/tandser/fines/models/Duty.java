package ru.tandser.fines.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.base.MoreObjects;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "duty")
@NamedEntityGraph(name = Duty.WITH_FINES, attributeNodes = @NamedAttributeNode("fines"))
public class Duty extends AbstractEntity {

    public static final String WITH_FINES = "Duty.withFines";

    private String     name;
    private Integer    price;
    private List<Fine> fines;

    /* Setters and Getters */

    @NotBlank
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull @Min(0)
    @Column(name = "price")
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonBackReference
    @OneToMany(mappedBy = "duty")
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
                .add("id",   getId())
                .add("name", getName())
                .add("duty", getPrice())
                .toString();
    }
}