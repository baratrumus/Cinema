package cinema.servlets;

import cinema.models.Order;

import java.util.List;

public interface Controller {
    boolean addOrder(Order order);
    List<Order> getOrders();
}
