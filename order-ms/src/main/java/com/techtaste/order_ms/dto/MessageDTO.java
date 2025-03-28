package com.techtaste.order_ms.dto;

public record MessageDTO(
        String cpf,
        String orderId,
        String status
) {
    
}
