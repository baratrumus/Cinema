package cinema.data;

import cinema.models.Order;

import java.util.List;

public interface Db {
    Order addOrder(Order order);
    List<Order> getOrders();
}
