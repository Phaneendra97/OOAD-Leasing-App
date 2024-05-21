package com.goldinn.leasing.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private static final Logger logger = LoggerFactory.getLogger(LoginService.class);
    private static final String ADMIN_ACCESS_CODE = "openseseme";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createUser(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new IllegalArgumentException("Email already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setAdmin(false);
        return userRepository.save(user);
    }

    public User createAdminUser(AdminSignUpRequest adminSignUpRequest) {
        if (!ADMIN_ACCESS_CODE.equals(adminSignUpRequest.getAccessCode())) {
            throw new IllegalArgumentException("Invalid access code");
        }
        if (userRepository.findByEmail(adminSignUpRequest.getEmail()) != null) {
            throw new IllegalArgumentException("Email already exists");
        }
        User user = new User();
        user.setFirstName(adminSignUpRequest.getFirstName());
        user.setLastName(adminSignUpRequest.getLastName());
        user.setPhone(adminSignUpRequest.getPhone());
        user.setEmail(adminSignUpRequest.getEmail());
        user.setPassword(passwordEncoder.encode(adminSignUpRequest.getPassword()));
        user.setAdmin(true);
        return userRepository.save(user);
    }

    public User authenticateUser(LoginRequest loginRequest) {
        logger.info("Authenticating user: {}", loginRequest.getEmail());
        User user = userRepository.findByEmail(loginRequest.getEmail());
        if (user != null && passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            logger.info("User authenticated: {}", user.getEmail());
            return user;
        }
        logger.warn("Authentication failed for user: {}", loginRequest.getEmail());
        return null;
    }
}
