package com.htt.dao;

import com.htt.po.Arbitrate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


/**
 * @author ：www
 * @date ：Created in 20-7-14 下午3:16
 * @description：
 * @modified By：
 * @version:
 */
public interface ArbitrateDao extends JpaRepository<Arbitrate, Long>, JpaSpecificationExecutor<Arbitrate> {
    Page<Arbitrate> findByArbitrateSqryx(String sqryx, Pageable pageable);
    Page<Arbitrate> findByArbitrateBsqryx(String bsqryx, Pageable pageable);
}
