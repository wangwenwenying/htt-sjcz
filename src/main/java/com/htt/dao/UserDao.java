package com.htt.dao;

import com.htt.po.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

/**
 * @author ：www
 * @date ：Created in 20-7-10 下午3:58
 * @description：
 * @modified By：
 * @version:
 */
public interface UserDao extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    Optional<User> findByUserEmailAndUserMm(String useremail,String usermm);

    Optional<User> findByUserMc(String usermc);
}
