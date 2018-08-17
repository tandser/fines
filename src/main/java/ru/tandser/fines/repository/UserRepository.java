package ru.tandser.fines.repository;

import ru.tandser.fines.models.User;

public interface UserRepository {

    User getByLicenseNumber(String licenseNumber);
}