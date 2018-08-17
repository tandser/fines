package ru.tandser.fines.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.base.MoreObjects;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/* synthetic entity */

@Entity
@Table(name = "fines")
public class CountFine extends AbstractEntity {

    private Car     car;
    private Duty    duty;
    private Boolean status;
    private String  dutyName;
    private Long    count;

    public CountFine() {}

    public CountFine(String dutyName, Long count) {
        this.dutyName = dutyName;
        this.count    = count;
    }

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

    public String getDutyName() {
        return dutyName;
    }

    public void setDutyName(String dutyName) {
        this.dutyName = dutyName;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    /* equals, hashCode, toString */

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("dutyName", dutyName)
                .add("count",    count)
                .toString();
    }
}