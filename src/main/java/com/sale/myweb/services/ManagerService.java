package com.sale.myweb.services;

import com.sale.myweb.DAO.ManagerRepository;
import com.sale.myweb.entity.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {
    private final ManagerRepository managerRepository;

    @Autowired
    public ManagerService (ManagerRepository managerRepository) {
    this.managerRepository = managerRepository;

    }
    public Manager getManager() {
        return managerRepository.findAll().get(0);

    }
}
