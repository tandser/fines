package ru.tandser.fines.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.tandser.fines.models.User;

@Transactional(readOnly = true)
public interface JpaUserRepository extends JpaRepository<User, Integer> {

    User findOneByLicenseNumber(String licenseNumber);
}