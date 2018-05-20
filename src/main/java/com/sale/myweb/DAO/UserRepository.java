package com.sale.myweb.DAO;


  import com.sale.myweb.entity.Users;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.data.repository.query.Param;
        import org.springframework.stereotype.Repository;

        import java.util.List;

/**
 * @author abin
 * @version 1.0
 * @date 2018/5/17 9:35
 */

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

        Users findByUserName(String name);
        List<Users> findAllByUserSex(String sex);



}