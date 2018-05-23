package com.sale.myweb.DAO;


import com.sale.myweb.entity.Cloth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClothRepository extends JpaRepository<Cloth,String> {


    List<Cloth> findAllByClothType(String type);


    List<Cloth> findAllByClothDiscountBetween(String low,String high);
    List<Cloth> findAllByClothPriceBetween(String low,String high);

    @Query(value = "select *  from Cloth c where c.cloth_Name like %:name% ",nativeQuery = true)
    List<Cloth> findByLikeName(@Param("name") String name);

    @Query(value = "select distinct c.clothType from Cloth c" )
    List<String> findAllTypes();

    Cloth findByClothId(String clothId);
}
