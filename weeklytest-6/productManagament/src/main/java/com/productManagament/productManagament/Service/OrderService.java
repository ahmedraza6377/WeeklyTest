package com.productManagament.productManagament.Service;

import com.productManagament.productManagament.Model.Address;
import com.productManagament.productManagament.Model.Orders;
import com.productManagament.productManagament.Model.Product;
import com.productManagament.productManagament.Model.User;
import com.productManagament.productManagament.Repository.IAddRepo;
import com.productManagament.productManagament.Repository.IOrderRepo;
import com.productManagament.productManagament.Repository.IProdRepo;
import com.productManagament.productManagament.Repository.IUserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    IOrderRepo orderRepo;

    @Autowired
    private IUserRepo userRepo;

    @Autowired
    private IProdRepo prodRepo;

    @Autowired
    private IAddRepo addRepo;
    public Orders createOrder(Integer userId, Integer productId, Integer addressId, Integer productQuantity) throws ChangeSetPersister.NotFoundException {
        User user = userRepo.findById(userId).orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        Product product = prodRepo.findById(productId).orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        Address address = addRepo.findById(addressId).orElseThrow(() -> new ChangeSetPersister.NotFoundException());

        Orders order = new Orders();
        order.setUser(user);
        order.setProduct(product);
        order.setAddress(address);
        order.setProdQuantity(productQuantity);

        return orderRepo.save(order);
    }

    public Orders getOrderById(Integer orderId) throws ChangeSetPersister.NotFoundException {
        return orderRepo.findById(orderId).orElseThrow(() -> new ChangeSetPersister.NotFoundException());
    }

}
