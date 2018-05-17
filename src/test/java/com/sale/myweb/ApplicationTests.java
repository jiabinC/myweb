package com.sale.myweb;

import com.sale.myweb.entity.Users;
import com.sale.myweb.DAO.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() throws Exception {

        // 创建10条记录
//        userRepository.save(new Users("AAA", 10));
//        userRepository.save(new Users("BBB", 20));
//        userRepository.save(new Users("CCC", 30));
//        userRepository.save(new Users("DDD", 40));



    }


//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//    @Test
//    public void test() throws Exception {
//        jdbcTemplate.update("INSERT INTO dbo.abina VALUES (?,?)",1,2);
//
//    }
}
