package ru.tandser.fines.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.tandser.fines.models.User;
import ru.tandser.fines.repository.UserRepository;

@Repository
public class DataJpaUserRepositoryImpl implements UserRepository {

    JpaUserRepository jpaUserRepository;

    @Override
    public User getByLicenseNumber(String licenseNumber) {
        return jpaUserRepository.findOneByLicenseNumber(licenseNumber);
    }

    /* Setters and Getters */

    @Autowired
    public void setJpaUserRepository(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }
}