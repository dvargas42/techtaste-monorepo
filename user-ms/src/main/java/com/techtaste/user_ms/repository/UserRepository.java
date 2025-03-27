package com.techtaste.user_ms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techtaste.user_ms.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByCpf(String cpf);
}
