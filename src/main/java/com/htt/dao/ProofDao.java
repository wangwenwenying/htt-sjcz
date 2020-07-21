package com.htt.dao;

import com.htt.po.Proof;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;


/**
 * @author ：www
 * @date ：Created in 20-7-14 下午7:48
 * @description：
 * @modified By：
 * @version:
 */
public interface ProofDao extends JpaRepository<Proof, Long>, JpaSpecificationExecutor<Proof> {
    Page<Proof> findByUserId(long userid, Pageable pageable);

    List<Proof> findByProofFilehash(String filehash);
}
