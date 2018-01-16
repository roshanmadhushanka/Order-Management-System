package app.controller;

import app.model.Order;
import app.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderRestController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<String> index() {
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/addOrder", method = RequestMethod.POST)
    public ResponseEntity<String> addOrder(@RequestBody Order order) {
        System.out.println("Add Order: Request received\n");
        System.out.println(order.toString());
        orderService.addOrder(order);
        System.out.println("Order Added");
        return new ResponseEntity<String>("Order Added", HttpStatus.OK);
    }

    @RequestMapping(value = "/getOrders", method = RequestMethod.GET)
    public ResponseEntity<List<Order>> getOrders() {
        return new ResponseEntity<List<Order>>(orderService.findAllOrders(), HttpStatus.OK);
    }
}
