package app.service;

import app.model.Order;
import app.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public void addOrder(Order order) {
        orderRepository.addOrder(order);
    }

    @Override
    public void updateOrder(Order order) {

    }

    @Override
    public Order findOrderById(long id) {
        return null;
    }

    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAllOrders();
    }
}
