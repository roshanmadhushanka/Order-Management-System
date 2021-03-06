package app.service;

import app.model.Order;
import java.util.List;

public interface OrderService {

    void addOrder(Order order);

    void updateOrder(Order order);

    Order findOrderById(long id);

    List<Order> findAllOrders();
}
