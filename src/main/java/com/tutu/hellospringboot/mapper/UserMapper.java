package com.tutu.hellospringboot.mapper;

import com.tutu.hellospringboot.domain.User;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.MyMapper;

public interface UserMapper extends MyMapper<User> {
}