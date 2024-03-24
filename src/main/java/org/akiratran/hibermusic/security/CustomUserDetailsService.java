package org.akiratran.hibermusic.security;
import org.akiratran.hibermusic.model.User;
import org.akiratran.hibermusic.repositories.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;


/**
 * This class implements the spring security interface to provide user-specific data during
 * authentication
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    /**
     * Constructs a new instance of CustomerUserDetailService with the provided userRepository
     * @param userRepository {Object} - UserRepository used to retrieve user information
     */
    public CustomUserDetailsService(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    /**
     * Retrieves user details by the provided email address.
     * @param email {String} - the email of the user to load
     * @return {Object} - returns userDetails object containing user details if found
     * @throws UsernameNotFoundException - throws UsernameNotFoundException if no
     * user is found with the provided email
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if(user != null) {
            return new org.springframework.security.core.userdetails.User(user.getEmail(),
                    user.getPassword(),
                    user.getUserRole().stream()
                            .map((role) -> new SimpleGrantedAuthority(role.getRoleName()))
                            .collect(Collectors.toList()));
        } else {
            throw new UsernameNotFoundException("Invalid email or password");
        }
    }
}

