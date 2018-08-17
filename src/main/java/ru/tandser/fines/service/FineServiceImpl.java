package ru.tandser.fines.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tandser.fines.models.Car;
import ru.tandser.fines.models.CountFine;
import ru.tandser.fines.models.Fine;
import ru.tandser.fines.models.User;
import ru.tandser.fines.repository.FineRepository;
import ru.tandser.fines.repository.UserRepository;

import java.util.Collections;
import java.util.List;

@Service
public class FineServiceImpl implements FineService {

    private UserRepository userRepository;
    private FineRepository fineRepository;

    @Override
    public List<Fine> getByLicenseNumberAndGovNumber(String licenseNumber, String govNumber) {
        User user = userRepository.getByLicenseNumber(licenseNumber);

        if (user == null) {
            return Collections.emptyList();
        }

        return bindUserWithFines(user, fineRepository.getByGovNumber(govNumber));
    }

    private List<Fine> bindUserWithFines(User user, List<Fine> fines) {
        for (Fine fine : fines) {
            Car car = fine.getCar();

            if (car != null) {
                car.setUser(user);
            }
        }

        return fines;
    }

    @Override
    public List<CountFine> getTops() {
        return fineRepository.getTops();
    }

    @Override
    public List<CountFine> getTopsByLicenseNumberAndGovNumber(String licenseNumber, String govNumber) {
        User user = userRepository.getByLicenseNumber(licenseNumber);

        if (user == null) {
            return Collections.emptyList();
        }

        return fineRepository.getTopsByGovNumber(govNumber);
    }

    /* Setters and Getters */

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setFineRepository(FineRepository fineRepository) {
        this.fineRepository = fineRepository;
    }
}