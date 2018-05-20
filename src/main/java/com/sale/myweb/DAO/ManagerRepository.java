package com.sale.myweb.DAO;

import com.sale.myweb.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager,String> {

}
