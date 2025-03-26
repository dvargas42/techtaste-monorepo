package com.techtaste.order_ms.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.techtaste.order_ms.dto.OrderRequestDTO;
import com.techtaste.order_ms.dto.OrderResponseDTO;
import com.techtaste.order_ms.service.OrderService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/orders")
public class OrderController {
    
    @Autowired
    private OrderService service;

    @PostMapping
    @CircuitBreaker(name="verifyAuthorization", fallbackMethod = "orderRegisterError")
    public ResponseEntity<OrderResponseDTO> createOrder(
            @RequestBody @Valid OrderRequestDTO orderDTO, UriComponentsBuilder uriBuilder) {
        OrderResponseDTO order = service.createOrder(orderDTO, false);
        URI uri = uriBuilder.path("/orders/{id}").buildAndExpand(order.id()).toUri();
        return ResponseEntity.created(uri).body(order);
    }

    @GetMapping
    public ResponseEntity<List<OrderResponseDTO>> listAllOrders() {
        return ResponseEntity.ok().body(service.listAllOrders());
    }

    @GetMapping("/port")
    public ResponseEntity<String> getPort(@Value("${local.server.port}") String port) {
        return ResponseEntity.ok().body(String.format("Response from Order Service running on port %s", port));
    }

    public ResponseEntity<OrderResponseDTO> orderRegisterError(
            @RequestBody @Valid OrderRequestDTO orderDTO, UriComponentsBuilder uriBuilder, Exception e) {
        OrderResponseDTO order = service.createOrder(orderDTO, true);
        URI uri = uriBuilder.path("/orders/{id}").buildAndExpand(order.id()).toUri();
        return ResponseEntity.created(uri).body(order);
    }
}
