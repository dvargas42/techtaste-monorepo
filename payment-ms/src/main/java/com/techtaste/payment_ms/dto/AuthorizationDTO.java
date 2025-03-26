package com.techtaste.payment_ms.dto;

public record AuthorizationDTO(
        String orderId,
        String status
) {}
