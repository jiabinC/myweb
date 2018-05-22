package com.sale.myweb.services;


import com.sale.myweb.DAO.CartsRepository;
import com.sale.myweb.entity.Carts;
import com.sale.myweb.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartsService {
    private final CartsRepository cartsRepository;

    @Autowired
    public CartsService(CartsRepository cartsRepository) {
        this.cartsRepository = cartsRepository;
    }

    public String addClothsToCarts(Carts carts) {
        if(cartsRepository.findByUserIdAndClothId(carts.getUserId(),carts.getClothId())==null) {
            cartsRepository.save(carts);
            return "success";

        }
        else {
            cartsRepository.addClothNum(carts.getUserId(),carts.getClothId(),carts.getClothNum());
            return "success";
        }
    }

    public List<Carts> getMyCarts(Users users) {

        return cartsRepository.findAllByUserId(users.getUserId());
    }

    public void deleteAllMyCarts(Users users) {
        cartsRepository.deleteAllByUserId(users.getUserId());

    }

    public void deleteByClothId(String clothId) {
        cartsRepository.deleteByClothId(clothId);
    }


}
