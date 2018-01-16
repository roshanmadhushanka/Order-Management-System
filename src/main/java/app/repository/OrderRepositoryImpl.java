package app.repository;

import app.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    @Autowired
    private MongoTemplate mongoTemplate;
    private static AtomicLong counter = new AtomicLong();
    private static final String COLLECTION_NAME = "orders ";

    @Override
    public void addOrder(Order order) {
        if(!mongoTemplate.collectionExists(Order.class)) {
            System.out.println("Creating collection: " + COLLECTION_NAME);
            mongoTemplate.createCollection(Order.class);
        }

        System.out.println("Already has a collection");
        order.setOrderId(counter.incrementAndGet());
        mongoTemplate.insert(order, COLLECTION_NAME);
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
        return mongoTemplate.findAll(Order.class, COLLECTION_NAME);
    }
}
