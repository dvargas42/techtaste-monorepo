package com.techtaste.order_ms.dto;

public record AuthorizationDTO(
        String orderId,
        String status
) {}
