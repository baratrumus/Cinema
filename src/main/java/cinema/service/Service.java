package cinema.service;

import cinema.models.Order;

import java.util.List;

public interface Service {
    boolean addOrder(Order order);
    List<Order> getOrders();
}
