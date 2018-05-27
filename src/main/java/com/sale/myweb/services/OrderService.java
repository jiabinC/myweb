package com.sale.myweb.services;


import com.sale.myweb.DAO.OrdersRepository;
import com.sale.myweb.entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrdersRepository ordersRepository;
    @Autowired
    public OrderService( OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }
    public Orders produceOrder(Orders orders) {

        return ordersRepository.save(orders);


    }


    public List getOrdersByUserId(String userId) {
        return ordersRepository.getOrdersByUserId(userId);
    }

}
