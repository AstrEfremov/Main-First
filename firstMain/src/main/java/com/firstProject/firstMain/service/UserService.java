package com.firstProject.firstMain.service;

import com.firstProject.firstMain.dtos.RegistrationUserDto;
import com.firstProject.firstMain.entities.User;
import com.firstProject.firstMain.repositories.RoleRepository;
import com.firstProject.firstMain.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService  implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username).orElseThrow(()->new UsernameNotFoundException(
                String.format("User '%s' not found", username)
        ));

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())
                ).collect(Collectors.toList())
                );
    }

    public List<String> showAllUsers(){
        List<String> users = new ArrayList<>();
        userRepository.findAll().forEach(user -> users.add(user.getUsername()));
        return users;
    }


    public User createNewUser (RegistrationUserDto registrationUserDto){
        User user = new User();
        user.setUsername(registrationUserDto.getUsername());
        user.setEmail(registrationUserDto.getEmail());
        user.setPassword(passwordEncoder.encode(registrationUserDto.getPassword()));
        user.setRoles(List.of(roleRepository.findByName("ROLE_USER").get()));
        return userRepository.save(user);
    }
}
