package com.techtaste.payment_ms.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.techtaste.payment_ms.dto.AuthorizationDTO;
import com.techtaste.payment_ms.model.GeneratorAuthorization;
import com.techtaste.payment_ms.model.Payment;
import com.techtaste.payment_ms.repository.PaymentRepository;

@Service
public class PaymentService {
    
    private final PaymentRepository repository;

    public PaymentService(PaymentRepository repository) {
        this.repository = repository;
    }

    public AuthorizationDTO autorizePayment(String id) {
        Payment payment = new Payment();
        payment.setOrderId(id);
        String status = GeneratorAuthorization.getRandomBoolean() ? "APPROVED" : "DECLINED";
        payment.setStatus(status);
        repository.save(payment);
        return new AuthorizationDTO(payment.getOrderId(), payment.getStatus());
    }

    public List<AuthorizationDTO> getAll() {
        return repository.findAll().stream()
                .map(payment -> new AuthorizationDTO(payment.getOrderId(), payment.getStatus()))
                .collect(Collectors.toList());
    }
}
