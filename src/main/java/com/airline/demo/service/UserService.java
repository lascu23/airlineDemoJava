package com.airline.demo.service;

import com.airline.demo.entity.User;
import com.airline.demo.exception.UserRegistrationException;
import com.airline.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void registerUser(String email, String password, String nume) throws UserRegistrationException{
        User existingUser = userRepository.findByEmail(email);
        if(existingUser != null){
            throw new UserRegistrationException("Adresa de mail este deja inregistrata!");
        }

        User newUser = new User();
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setName(nume);
        userRepository.save(newUser);
    }

    public User login(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }
}
