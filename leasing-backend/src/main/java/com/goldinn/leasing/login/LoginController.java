package com.goldinn.leasing.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;

    @PostMapping("/register")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        try {
            logger.info("Creating user: {}", user.getEmail());
            user.setIsResident(false);
            loginService.createUser(user);
            return new ResponseEntity<>("Account created successfully", HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            logger.error("Error creating user: {}", e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/register-admin")
    public ResponseEntity<String> createAdminUser(@RequestBody AdminSignUpRequest adminSignUpRequest) {
        try {
            logger.info("Creating admin user: {}", adminSignUpRequest.getEmail());
            adminSignUpRequest.setIsResident(null);
            loginService.createAdminUser(adminSignUpRequest);
            return new ResponseEntity<>("Admin account created successfully", HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            logger.error("Error creating admin user: {}", e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

 @PostMapping("/signin")
public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
    logger.info("Authenticating user: {}", loginRequest.getEmail());
    User authenticatedUser = loginService.authenticateUser(loginRequest);
    if (authenticatedUser != null) {
        logger.info("User authenticated: {}", authenticatedUser.getEmail());
        return ResponseEntity.ok(Map.of(
            "firstName", authenticatedUser.getFirstName() != null ? authenticatedUser.getFirstName() : "",
            "userId", authenticatedUser.getId() != null ? authenticatedUser.getId() : "",
            "isAdmin", authenticatedUser.isAdmin() != null ? authenticatedUser.isAdmin() : false,
            "isResident", authenticatedUser.getIsResident() != null ? authenticatedUser.getIsResident() : false 
        ));
    } else {
        logger.warn("Authentication failed for user: {}", loginRequest.getEmail());
        return new ResponseEntity<>("Invalid email or password", HttpStatus.UNAUTHORIZED);
    }
}



    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        logger.info("Logging out user");
        session.invalidate();
        return new ResponseEntity<>("User logged out successfully", HttpStatus.OK);
    }
}
