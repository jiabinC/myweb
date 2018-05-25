package com.sale.myweb.services;

import com.sale.myweb.DAO.DetailRepository;
import com.sale.myweb.entity.Detail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailSercice {
    private final DetailRepository detailRepository;

    @Autowired
    public DetailSercice(DetailRepository detailRepository) {
        this.detailRepository = detailRepository;
    }


    public Detail addDetail(Detail detail) {
       return detailRepository.save(detail);

    }
}
