package com.techtaste.order_ms.dto;

import java.util.List;

import com.techtaste.order_ms.model.OrderItem;

public record OrderRequestDTO(
        String cpf,
        List<OrderItem> items
) {}
