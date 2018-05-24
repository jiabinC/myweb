package com.sale.myweb.DAO;

import com.sale.myweb.entity.Carts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartsRepository extends JpaRepository<Carts,String>{

    @Modifying
    @Query(value = "update Carts  set Carts.cloth_num = Carts.cloth_num + ?3 where Carts.user_id=?1 and Carts.cloth_id=?2" ,nativeQuery = true)
    void addClothNum(String cartId, String clothId, Integer num);

    Carts findByUserIdAndClothId(String cartId,String clothId);

    List<Carts> findAllByUserId(String id);

    void deleteAllByUserId(String userId);
    void deleteByClothId(String clothId);

}
