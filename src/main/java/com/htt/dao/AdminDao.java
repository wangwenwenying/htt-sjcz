package com.htt.dao;

import com.htt.po.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author ：www
 * @date ：Created in 20-7-14 下午3:16
 * @description：
 * @modified By：
 * @version:
 */
public interface AdminDao extends JpaRepository<Admin, Long>, JpaSpecificationExecutor<Admin> {
}
