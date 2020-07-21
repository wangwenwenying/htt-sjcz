package com.htt.dao;

import com.htt.po.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author ：www
 * @date ：Created in 20-7-14 下午2:12
 * @description：
 * @modified By：
 * @version:
 */
public interface RoleDao extends JpaRepository<Role, Long>, JpaSpecificationExecutor<Role> {
}
