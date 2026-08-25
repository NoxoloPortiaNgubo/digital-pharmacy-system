package za.ac.cput.digitalpharmacysystem.repository;
/*
 * Sibulele Pama
 * 221447498
 */

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.digitalpharmacysystem.domain.Order;

import java.util.List;

public interface IOrderRepository extends JpaRepository<Order, String> {
    List<Order> findByOrderNumber(String orderNumber);
}
