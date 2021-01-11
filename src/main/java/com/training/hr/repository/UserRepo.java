package com.training.hr.repository;

import com.training.hr.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends JpaRepository<User,Integer> {

    public User findByUserName(@Param("username") String userName);
}
