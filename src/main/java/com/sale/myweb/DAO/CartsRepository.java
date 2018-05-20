package com.sale.myweb.DAO;

import com.sale.myweb.entity.Carts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartsRepository extends JpaRepository<Carts,String>{

    @Modifying
    @Query("update Carts c set c.clothNum = c.clothNum+?3 where c.userId=?1 and c.clothId=?2")
    public void addClothNum(String cartId, String clothId, String num);

    Carts findByUserIdAndClothId(String cartId,String clothId);

    List<Carts> findAllByUserId(String id);

    void deleteAllByUserId(String userId);
    void deleteByClothId(String clothId);

}
