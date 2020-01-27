package by.salon.service;

import by.salon.entity.AppUser;
import by.salon.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UsersListService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Transactional
    public List<AppUser> getAllUsers() {
        return appUserRepository.getAllUsers();
    }

    @Transactional
    public AppUser getUserById(Long id) {
        return appUserRepository.findUserById(id);
    }

    @Transactional
    public void upUser(AppUser appUser) {
        appUserRepository.upUser(appUser);
    }

    @Transactional
    public void downUser(AppUser appUser) {
        appUserRepository.downUser(appUser);
    }

    @Transactional
    public void deleteUserById(Long id) {
        appUserRepository.delete(id);
    }
}
