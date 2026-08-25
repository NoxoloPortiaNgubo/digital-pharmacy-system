package za.ac.cput.digitalpharmacysystem.service;
/*
 * Sibulele Pama
 * 221447498
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.digitalpharmacysystem.domain.Order;
import za.ac.cput.digitalpharmacysystem.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService implements IOrderService {
    private final OrderRepository repository;

    @Autowired
    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Order create(Order order) {
        return this.repository.save(order);
    }

    @Override
    public Order read(String id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Order update(Order order) {
        if (this.repository.existsById(order.getId())) {
            return this.repository.save(order);
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Order> getAll() {
        return this.repository.findAll();
    }
}
