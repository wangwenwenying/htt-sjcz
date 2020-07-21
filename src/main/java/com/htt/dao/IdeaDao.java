package com.htt.dao;

import com.htt.po.Idea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author ：www
 * @date ：Created in 20-7-14 下午3:16
 * @description：
 * @modified By：
 * @version:
 */
public interface IdeaDao extends JpaRepository<Idea, Long>, JpaSpecificationExecutor<Idea> {
}
