package com.sale.myweb.controller;
import com.sale.myweb.entity.Detail;
import com.sale.myweb.entity.Orders;
import com.sale.myweb.entity.Users;
import com.sale.myweb.services.ClothService;
import com.sale.myweb.services.DetailSercice;
import com.sale.myweb.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
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
    @Autowired
    ClothService clothService;

    @PostMapping("/generateOrder")
    public String generateOrder(ModelMap model, HttpSession session,@RequestParam String value) {

        String[] split= value.split("/");
        Users users = (Users)session.getAttribute("user");
        if(split.length==0) {
            model.addAttribute("result","请至少选择一种商品");
            model.addAttribute("users",session.getAttribute("user"));
            return "myCart";
        }
//        String[] split1 = split[0].split(",");
//        Detail detail = new Detail(split1[0],split1[1]);
//        Detail detail1 = detailSercice.addDetail(detail);
//        String detailId =  detail1.getDetailId();

        double totalPrice=0 ;
        for (int i=0;i<split.length;i++) {
          totalPrice = totalPrice + Double.parseDouble(split[i].split(",")[0]) * Double.parseDouble(split[i].split(",")[1])*Double.parseDouble(clothService.findByclothId(split[i].split(",")[0]).getClothDiscount())*0.01;

        }
        Orders orders = new Orders(users.getUserAddress(),"审核中",users.getUserTel(),"待交付",users.getUserId(),String.valueOf(totalPrice));
        Orders orders1 = orderService.produceOrder(orders);
        int k;
        for (k =0;k < split.length; k++ ) {
            Detail detail2 =new Detail(orders1.getOrderId(),split[k].split(",")[0],split[k].split(",")[1]);
            detailSercice.addDetail(detail2);

        }
        List myOrders = orderService.getOrdersByUserId(users.getUserId());
        model.addAttribute("orders",myOrders);
        model.addAttribute("details",detailSercice.getAllDetails());
        model.addAttribute("cloths",clothService.getAllCloth());
        model.addAttribute("users",session.getAttribute("user"));
        return "myOrder";
    }

    @GetMapping("/myOrder")
    public String myOrder(ModelMap model,HttpSession session){
        Users users = (Users)session.getAttribute("user");
        List myOrders = orderService.getOrdersByUserId(users.getUserId());
        model.addAttribute("orders",myOrders);
        model.addAttribute("details",detailSercice.getAllDetails());
        model.addAttribute("cloths",clothService.getAllCloth());
        model.addAttribute("users",session.getAttribute("user"));
        return "myOrder";
    }
}
