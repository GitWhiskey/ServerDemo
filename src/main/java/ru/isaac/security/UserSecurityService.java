package ru.isaac.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.isaac.model.User;
import ru.isaac.model.UserRepository;

/**
 * Created by Maxon on 25.02.2017.
 */
@Service("userDetailsService")
public class UserSecurityService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).stream().findFirst().get();
        return new UserSecurityDetails(user);
    }
}
