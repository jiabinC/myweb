package com.sale.myweb.controller;


import com.sale.myweb.entity.Detail;
import com.sale.myweb.entity.Orders;
import com.sale.myweb.entity.Users;
import com.sale.myweb.services.DetailSercice;
import com.sale.myweb.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class OrdersController {

    @Autowired
    OrderService orderService;
    @Autowired
    DetailSercice detailSercice;


    @PostMapping("/generateOrder")
    public String generateOrder(ModelMap model, HttpSession session,@RequestParam Detail...details) {
        Users users = (Users)session.getAttribute("user");
        if(details.length==0) {
            model.addAttribute("result","请至少选择一种商品");
            model.addAttribute("users",session.getAttribute("user"));
            return "myCart";
        }
        Detail detailTemplate = details[0];
        Detail detail1 = detailSercice.addDetail(detailTemplate);
        String detailId =  detail1.getDetailId();

        Orders orders = new Orders(users.getUserAddress(),"审核中",users.getUserTel(),"待交付",detailId,users.getUserId());
        orderService.produceOrder(orders);
        int k;
        for (k =1;k < details.length; k++ ) {
            detailSercice.addDetail(details[k]);

        }



        return "success";
    }
}
