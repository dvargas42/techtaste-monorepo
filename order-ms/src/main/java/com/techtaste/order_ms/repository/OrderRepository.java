package com.techtaste.order_ms.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techtaste.order_ms.model.Order;

public interface OrderRepository extends JpaRepository<Order, UUID> {
    
}
