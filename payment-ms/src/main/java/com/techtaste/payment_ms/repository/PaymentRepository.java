package com.techtaste.payment_ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techtaste.payment_ms.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    
}
