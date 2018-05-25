package com.sale.myweb.services;


import com.sale.myweb.DAO.OrdersRepository;
import com.sale.myweb.entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrdersRepository ordersRepository;
    @Autowired
    public OrderService( OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }
    public String produceOrder(Orders orders) {

        ordersRepository.save(orders);

        return "success";
    }

}
