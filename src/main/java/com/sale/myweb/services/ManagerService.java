package com.sale.myweb.services;

import com.sale.myweb.DAO.ClothRepository;
import com.sale.myweb.DAO.ManagerRepository;
import com.sale.myweb.DAO.UserRepository;
import com.sale.myweb.entity.Cloth;
import com.sale.myweb.entity.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {
    private final ManagerRepository managerRepository;
    private final ClothRepository   clothRepository;
    private final UserRepository userRepository;

    @Autowired
    public ManagerService (ManagerRepository managerRepository,ClothRepository clothRepository,UserRepository userRepository) {
        this.managerRepository = managerRepository;
        this.clothRepository = clothRepository;
        this.userRepository = userRepository;
    }
    public Manager getManager() {
        return managerRepository.findAll().get(0);

    }

    public List getAllClothOfManager() {
        return clothRepository.findAll();
    }
    public void addCloth(Cloth cloth) {
        clothRepository.save(cloth);
    }
    public List getAllUsers() {return userRepository.findAll();}
    public List gerUsersBySex(String sex) {return userRepository.findAllByUserSex(sex);}
}
