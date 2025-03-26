package com.techtaste.order_ms.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.techtaste.order_ms.enums.Status;
import com.techtaste.order_ms.model.OrderItem;

public record OrderResponseDTO(
    UUID id,
    Status status,
    String cpf,
    List<OrderItem> items,
    BigDecimal totalValue,
    LocalDate date
) {
    
}
