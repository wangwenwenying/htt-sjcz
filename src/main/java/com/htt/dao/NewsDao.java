package com.htt.dao;

import com.htt.po.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author ：www
 * @date ：Created in 20-7-14 下午3:22
 * @description：
 * @modified By：
 * @version:
 */
public interface NewsDao extends JpaRepository<News, Long>, JpaSpecificationExecutor<News> {
}
