package com.techtaste.order_ms.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.techtaste.order_ms.dto.OrderRequestDTO;
import com.techtaste.order_ms.dto.OrderResponseDTO;
import com.techtaste.order_ms.enums.Status;
import com.techtaste.order_ms.model.Order;
import com.techtaste.order_ms.repository.OrderRepository;

@Service
public class OrderService {
    
    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public OrderResponseDTO createOrder(OrderRequestDTO orderDTO) {
        Order order = new Order();
        BeanUtils.copyProperties(orderDTO, order);
        order.setStatus(Status.WAITING_PAYMENT);
        order.setDate(LocalDate.now());
        order.calculateTotalValue();
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
}
