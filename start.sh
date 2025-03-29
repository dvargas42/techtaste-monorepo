#!/bin/bash
echo "Starting Config Server..."
(cd config-server && mvn spring-boot:run) &

sleep 10

echo "Starting Service Registry..."
(cd service-registry && mvn spring-boot:run) &

sleep 10

echo "Starting API Gateway..."
(cd api-gateway && mvn spring-boot:run) &

sleep 5

echo "Starting Order Service..."
(cd order-ms && mvn spring-boot:run) &

sleep 5

echo "Starting Payment Service..."
(cd payment-ms && mvn spring-boot:run) &

sleep 5

echo "Starting User Service..."
(cd user-ms && mvn spring-boot:run)