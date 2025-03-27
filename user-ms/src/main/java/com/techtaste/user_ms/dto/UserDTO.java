package com.techtaste.user_ms.dto;

public record UserDTO(
        Long id,
        String cpf,
        String name,
        String email
) {
    
}
