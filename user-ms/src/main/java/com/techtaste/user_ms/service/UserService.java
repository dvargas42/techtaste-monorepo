package com.techtaste.user_ms.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.techtaste.user_ms.dto.EmailDTO;
import com.techtaste.user_ms.dto.UserDTO;
import com.techtaste.user_ms.model.User;
import com.techtaste.user_ms.repository.UserRepository;

@Service
public class UserService {

    public final UserRepository userRepository;
    public final EmailService emailService;

    public UserService(UserRepository userRepository, EmailService emailService) {
        this.userRepository = userRepository;
        this.emailService = emailService;
    }
    
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> new UserDTO(user.getId(), user.getCpf(), user.getName(), user.getEmail()))
                .collect(Collectors.toList());
    }

    public UserDTO createUser(UserDTO userDTO) {
        User user = new User();
        user.setCpf(userDTO.cpf());
        user.setName(userDTO.name());
        user.setEmail(userDTO.email());
        userRepository.save(user);
        return new UserDTO(user.getId(), user.getCpf(), user.getName(), user.getEmail());
    }

    public void sendMessage(EmailDTO message) {
        Optional<User> user = userRepository.findByCpf(message.cpf());

        if (user.isPresent()) {
            emailService.sendEmail(
                user.get().getEmail(), 
                "Order status " + message.status(),
                "Order is: " + message.orderId()
            );
        }
    }
}
