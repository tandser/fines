package ru.tandser.fines.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.base.MoreObjects;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "fines")
@NamedEntityGraph(name = Fine.WITH_CAR_AND_DUTY, attributeNodes = {@NamedAttributeNode("car"), @NamedAttributeNode("duty")})
public class Fine extends AbstractEntity {

    public static final String WITH_CAR_AND_DUTY = "Fine.withCarAndDuty";

    private Car     car;
    private Duty    duty;
    private Boolean status;

    /* Setters and Getters */

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "duty_id")
    public Duty getDuty() {
        return duty;
    }

    public void setDuty(Duty duty) {
        this.duty = duty;
    }

    @NotNull
    @Column(name = "status")
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    /* equals, hashCode, toString */

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("status", getStatus())
                .toString();
    }
}