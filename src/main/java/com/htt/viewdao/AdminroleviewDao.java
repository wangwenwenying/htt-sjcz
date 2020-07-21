package com.htt.viewdao;

import com.htt.view.Adminroleview;
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
public interface AdminroleviewDao extends JpaRepository<Adminroleview, Long>, JpaSpecificationExecutor<Adminroleview> {
    Optional<Adminroleview> findByAdminMcAndAdminMm(String adminmc, String adminmm);
}
