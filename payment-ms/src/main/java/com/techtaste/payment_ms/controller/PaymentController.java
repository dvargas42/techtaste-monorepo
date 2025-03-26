package com.techtaste.payment_ms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techtaste.payment_ms.dto.AuthorizationDTO;
import com.techtaste.payment_ms.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    
    @Autowired
    private PaymentService service;

    @GetMapping("/authorization/{id}")
    public ResponseEntity<AuthorizationDTO> getPaymentAuthorization(@PathVariable String id) {
        return ResponseEntity.ok().body(service.autorizePayment(id));
    }

    @GetMapping
    public ResponseEntity<List<AuthorizationDTO>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }
}
