package com.bing;

import com.bing.dao.UsersDaoPageAndSortRepository;
import com.bing.dao.UsersRepository;
import com.bing.pojo.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class SpringbootSpringdatajpaApplicationTests {

    @Autowired
    private UsersRepository dao;
    @Autowired
    private UsersDaoPageAndSortRepository page;

    /**
     * 单次增加
     */
    @Test
    void contextLoads() {
        Users users = new Users();
        users.setUserName("王大");
        users.setUserOld(22);
        users.setUserBook("葵花宝典");
        dao.save(users);
    }

    /**
     * 批量增加
     */
    @Test
    void contextLoads1() {
        List<Users> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Users users = new Users();
            users.setUserName("王大" + i);
            users.setUserOld(22 + i);
            users.setUserBook("葵花宝典" + i);
            list.add(users);
        }
        dao.saveAll(list);
    }

    /**
     * 查询单条数据
     */
    @Test
    void contextLoads2() {
        Optional<Users> users = dao.findById(3);
        System.out.println(users);
    }

    /**
     * 查询所有数据
     */
    @Test
    void contextLoads3() {
        List<Users> list = dao.findAll();
        Iterator<Users> iterator = list.iterator();
        while (iterator.hasNext()) {
            Users nser = iterator.next();
            System.out.println(nser);
        }
    }

    /**
     * 删除数据
     */
    @Test
    void contextLoads4() {
        dao.deleteById(3);
    }

    /**
     * 更新数据
     */
    @Test
    void contextLoads5() {
//        根据save方法来实现   如果users对象的userId属性不为空则update
        Users users = new Users();
        users.setUserId(15);
        users.setUserName("艾弗森");
        users.setUserOld(22);
        users.setUserBook("葵花宝典");
        dao.save(users);
    }

    /**
     * 分页查询
     */
    @Test
    void contextLoads6() {
        int page = 0;
        int size = 5;
        PageRequest pageable = new PageRequest(page,size);
        Page<Users> all = dao.findAll(pageable);
        System.out.println("总的条数:" + all.getTotalElements());
        System.out.println("总的页数:" + all.getTotalPages());
        List<Users> content = all.getContent();
        for (Users users : content) {
            System.out.println(users);+
        }
    }

}
