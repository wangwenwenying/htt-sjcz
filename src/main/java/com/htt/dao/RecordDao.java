package com.htt.dao;

import com.htt.po.Record;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


/**
 * @author ：www
 * @date ：Created in 20-7-14 下午4:19
 * @description：
 * @modified By：
 * @version:
 */
public interface RecordDao extends JpaRepository<Record, Long>, JpaSpecificationExecutor<Record> {
    Page<Record> findByUserId(long userid, Pageable pageable);
}
