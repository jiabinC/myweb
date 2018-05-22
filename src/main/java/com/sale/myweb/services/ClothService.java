package com.sale.myweb.services;


import com.sale.myweb.DAO.ClothRepository;
import com.sale.myweb.entity.Cloth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author abin
 * @version 1.0
 * @date 2018/5/19 22:39
 */


@Service
public class ClothService {


    private final ClothRepository clothRepository;
    @Autowired
    public ClothService(ClothRepository clothRepository){
        this.clothRepository = clothRepository;

    }
    public List<Cloth> getAllCloth() {

        return clothRepository.findAll();


    }

    public List<Cloth> getClothByLikeName(String name){
        return clothRepository.findByLikeName(name);

    }

    public List findByDiscount(String low ,String high) {
        return  clothRepository.findAllByClothDiscountBetween(low,high);

    }

    public List findByPrice(String low ,String high) {
        return  clothRepository.findAllByClothPriceBetween(low,high);
    }

    public List findByclothType(String type) {
        return clothRepository.findAllByClothType(type);
    }

    public List findAllTypes() {
        return clothRepository.findAllTypes();
    }

}
