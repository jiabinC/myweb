package com.sale.myweb.DAO;


import com.sale.myweb.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders,String>{

    List getOrdersByUserId(String userId);





}
