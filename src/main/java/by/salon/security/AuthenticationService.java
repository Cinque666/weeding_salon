package by.salon.security;

import by.salon.entity.AppUser;
import by.salon.repository.AppUserRepository;
import by.salon.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service("authService")
public class AuthenticationService implements UserDetailsService {

    private AppUserRepository appUserRepository;
    private RoleRepository roleRepository;

    @Autowired
    public void setAppUserRepository(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) {
        AppUser user = appUserRepository.findUserByLogin(username);

        if (user == null) {
            throw new UsernameNotFoundException("Username " + username + " not found");
        }

        String role = "ROLE_" + roleRepository.getRoleById(user.getRoleId()).getName();
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role));

        return new User(user.getLogin(), user.getPassword(), authorities);
    }
}
