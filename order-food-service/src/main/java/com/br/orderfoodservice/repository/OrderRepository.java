package com.br.orderfoodservice.repository;

import com.br.orderfoodservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
