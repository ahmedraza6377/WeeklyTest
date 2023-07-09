package com.productManagament.productManagament.Controller;

import com.productManagament.productManagament.Model.Orders;
import com.productManagament.productManagament.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
   @Autowired
    OrderService orderService;

    @PostMapping("order")
    public Orders createOrder(@RequestParam Integer userId, @RequestParam Integer productId, @RequestParam Integer addressId, @RequestParam Integer productQuantity) throws ChangeSetPersister.NotFoundException {
        return orderService.createOrder(userId, productId, addressId, productQuantity);
    }

    @GetMapping("order/{orderId}")
    public Orders getOrderById(@PathVariable Integer orderId) throws ChangeSetPersister.NotFoundException {
        return orderService.getOrderById(orderId);
    }
}
