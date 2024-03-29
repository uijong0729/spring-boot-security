package com.example.its.domain.auth;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserRepository {
    
    @Select("select * from users where username = #{username}")
    Optional<User> findByUserName(String username);

    @Select("select * from users")
    List<User> findAll();

    @Insert("insert into users (username, password, authority) values (#{username}, #{password}, 'USER')")
    void insert(String username, String password);

}
