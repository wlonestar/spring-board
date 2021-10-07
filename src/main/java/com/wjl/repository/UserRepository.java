package com.wjl.repository;

import com.wjl.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: wjl
 * @date: 2021/10/7 15:10
 * @version: v1.0
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserByUsername(String username);

    User findUserByUsernameAndPassword(String username, String password);

    User findUserByToken(String token);

}
