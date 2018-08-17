package ru.tandser.fines.dto;

import com.google.common.base.MoreObjects;
import org.springframework.util.Assert;
import ru.tandser.fines.models.Car;
import ru.tandser.fines.models.Duty;
import ru.tandser.fines.models.Fine;
import ru.tandser.fines.models.User;

import java.util.Objects;

public class FlatFine {

    private String  userName;
    private String  userPatronymic;
    private String  userSurname;
    private String  userLicenseNumber;
    private String  carBrand;
    private String  carModel;
    private String  carGovNumber;
    private String  dutyName;
    private Integer dutyPrice;
    private Boolean fineStatus;

    public static FlatFine valueOf(Fine fine) {
        Assert.notNull(fine, "fine is required");

        FlatFine result = new FlatFine();

        Car car = fine.getCar();

        if (car != null) {
            result.carBrand     = car.getBrand();
            result.carModel     = car.getModel();
            result.carGovNumber = car.getGovNumber();

            User user = car.getUser();

            if (user != null) {
                result.userName          = user.getName();
                result.userPatronymic    = user.getPatronymic();
                result.userSurname       = user.getSurname();
                result.userLicenseNumber = user.getLicenseNumber();
            }
        }

        Duty duty = fine.getDuty();

        if (duty != null) {
            result.dutyName  = duty.getName();
            result.dutyPrice = duty.getPrice();
        }

        result.fineStatus = fine.getStatus();

        return result;
    }

    /* equals, hashCode, toString */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        FlatFine that = (FlatFine) obj;

        return Objects.equals(this.userName,          that.userName)          &&
               Objects.equals(this.userPatronymic,    that.userPatronymic)    &&
               Objects.equals(this.userSurname,       that.userSurname)       &&
               Objects.equals(this.userLicenseNumber, that.userLicenseNumber) &&
               Objects.equals(this.carBrand,          that.carBrand)          &&
               Objects.equals(this.carModel,          that.carModel)          &&
               Objects.equals(this.carGovNumber,      that.carGovNumber)      &&
               Objects.equals(this.dutyName,          that.dutyName)          &&
               Objects.equals(this.dutyPrice,         that.dutyPrice)         &&
               Objects.equals(this.fineStatus,        that.fineStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName,
                            userPatronymic,
                            userSurname,
                            userLicenseNumber,
                            carBrand,
                            carModel,
                            carGovNumber,
                            dutyName,
                            dutyPrice,
                            fineStatus);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("userName",          userName)
                .add("userPatronymic",    userPatronymic)
                .add("userSurname",       userSurname)
                .add("userLicenseNumber", userLicenseNumber)
                .add("carBrand",          carBrand)
                .add("carModel",          carModel)
                .add("carGovNumber",      carGovNumber)
                .add("dutyName",          dutyName)
                .add("dutyPrice",         dutyPrice)
                .add("fineStatus",        fineStatus)
                .toString();
    }

    /* Setters and Getters */

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPatronymic() {
        return userPatronymic;
    }

    public void setUserPatronymic(String userPatronymic) {
        this.userPatronymic = userPatronymic;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getUserLicenseNumber() {
        return userLicenseNumber;
    }

    public void setUserLicenseNumber(String userLicenseNumber) {
        this.userLicenseNumber = userLicenseNumber;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarGovNumber() {
        return carGovNumber;
    }

    public void setCarGovNumber(String carGovNumber) {
        this.carGovNumber = carGovNumber;
    }

    public String getDutyName() {
        return dutyName;
    }

    public void setDutyName(String dutyName) {
        this.dutyName = dutyName;
    }

    public Integer getDutyPrice() {
        return dutyPrice;
    }

    public void setDutyPrice(Integer dutyPrice) {
        this.dutyPrice = dutyPrice;
    }

    public Boolean getFineStatus() {
        return fineStatus;
    }

    public void setFineStatus(Boolean fineStatus) {
        this.fineStatus = fineStatus;
    }
}