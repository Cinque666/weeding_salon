package by.salon.service;

import by.salon.entity.AppUser;
import by.salon.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class RegistrationService {

    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public boolean signUpUser(AppUser user) {

        if (user == null || user.getLogin().isEmpty() || user.getPassword().isEmpty()) {
            return false;
        }

        Integer userCountByLogin = appUserRepository.findUserCountByLogin(user.getLogin());
        if (userCountByLogin != null && userCountByLogin >= 1) {
            return false;
        }

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        appUserRepository.save(user);

        return true;
    }
}
