package com.techtaste.order_ms.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.techtaste.order_ms.dto.AuthorizationDTO;
import com.techtaste.order_ms.dto.OrderRequestDTO;
import com.techtaste.order_ms.dto.OrderResponseDTO;
import com.techtaste.order_ms.enums.Status;
import com.techtaste.order_ms.http.AuthorizePaymentClient;
import com.techtaste.order_ms.model.Order;
import com.techtaste.order_ms.repository.OrderRepository;

@Service
public class OrderService {
    
    private final OrderRepository repository;
    private final AuthorizePaymentClient client;

    public OrderService(OrderRepository repository, AuthorizePaymentClient client) {
        this.repository = repository;
        this.client = client;
    }

    public OrderResponseDTO createOrder(OrderRequestDTO orderDTO, Boolean haveError) {
        Order order = new Order();
        BeanUtils.copyProperties(orderDTO, order);
        Status status = Status.WAITING_PAYMENT;
        order.setStatus(status);
        order.setDate(LocalDate.now());
        order.calculateTotalValue();
        repository.save(order);
        if (haveError) {
            status = Status.ERROR_CONSULTATION_PAYMENT;
        } else {
            status = getPaymentStatus(order.getId().toString());
        }
        order.setStatus(status);
        repository.save(order);
        return new OrderResponseDTO(
                order.getId(), 
                order.getStatus(), 
                order.getCpf(), 
                order.getItems(), 
                order.getTotalValue(),
                order.getDate());
    }

    public  List<OrderResponseDTO> listAllOrders() {
        return repository.findAll().stream()
                .map(order -> new OrderResponseDTO(order.getId(), order.getStatus(),
                        order.getCpf(), order.getItems(), order.getTotalValue(), order.getDate()))
                .collect(Collectors.toList());            
    }

    private Status getPaymentStatus(String id) {
        AuthorizationDTO authorization = client.getAuthorization(id);
        if (authorization.status().equalsIgnoreCase("APPROVED")) {
            return Status.PREPARING;
        }
        return Status.REFUSED;
    }
}
