package in.SunbaseApi.service;



import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import in.SunbaseApi.repository.UserEntityRepo;
import in.SunbaseApi.request.UserEntity;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserEntityRepo userEntRepo;

    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userEntRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }

    public UserEntity save(UserEntity userent) {
    	userent.setPassword(passwordEncoder.encode(userent.getPassword()));
        return userEntRepo.save(userent);
    }
}

