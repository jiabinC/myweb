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
import java.util.List;

@Controller
public class OrdersController {

    @Autowired
    OrderService orderService;
    @Autowired
    DetailSercice detailSercice;

    @PostMapping("/generateOrder")
    public String generateOrder(ModelMap model, HttpSession session,@RequestParam String value) {

        String[] split= value.split("/");
        Users users = (Users)session.getAttribute("user");
        if(split.length==0) {
            model.addAttribute("result","请至少选择一种商品");
            model.addAttribute("users",session.getAttribute("user"));
            return "myCart";
        }
        String[] split1 = split[0].split(",");
        Detail detail = new Detail(split1[0],split1[1]);
        Detail detail1 = detailSercice.addDetail(detail);
        String detailId =  detail1.getDetailId();

        Orders orders = new Orders(users.getUserAddress(),"审核中",users.getUserTel(),"待交付",detailId,users.getUserId());
        orderService.produceOrder(orders);
        int k;
        for (k =1;k < split.length; k++ ) {
            detailSercice.addDetail(new Detail(split[k].split(",")[0],split[k].split(",")[1]));

        }
        List myOrders = orderService.getOrdersByUserId(users.getUserId());
        model.addAttribute("orders",myOrders);
        model.addAttribute("details",detailSercice.getAllDetails());
        return "myOrder";
    }
}
