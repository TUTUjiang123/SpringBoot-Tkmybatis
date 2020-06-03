package com.tutu.hellospringboot;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tutu.hellospringboot.domain.User;
import com.tutu.hellospringboot.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest

//@Transactional 这两个注解是加事务和回滚的意思，保证了测试的数据不能直接写到数据库中
//@Rollback
class HelloSpringBootApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void contextLoads() {
        System.out.println("Hello tutu");
    }

    @Test
    public void testInsert(){
        User user = new User();
        user.setId(2);
        user.setName("ww");
        user.setPhone("15223311124");
        userMapper.insert(user);

    }

    @Test
    public void testSelectAll() {
        User user = userMapper.selectByPrimaryKey(1);
        user.setName("douhua");
        userMapper.updateByPrimaryKey(user);
    }

    @Test
    public void testDelete() {
        userMapper.deleteByPrimaryKey(2);
    }

    @Test
    public void testPageHerpler() {
        PageHelper.startPage(1,10);
        PageInfo<User> pageInfo = new PageInfo<>(userMapper.selectAll());
        System.out.println(pageInfo);
    }



}
