package com.sale.myweb.services;


        import com.sale.myweb.entity.Users;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.data.repository.query.Param;
        import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

}