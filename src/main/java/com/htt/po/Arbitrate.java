package com.htt.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @author ：www
 * @date ：Created in 20-7-20 上午11:22
 * @description：
 * @modified By：
 * @version:
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "arbitrate")
public class Arbitrate {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long arbitrateId;
    private String arbitrateSqrxm;
    private String arbitrateSqrxb;
    private String arbitrateSqrmz;
    private long arbitrateSqrnl;
    private String arbitrateSqryx;
    private String arbitrateSqrdh;
    private String arbitrateSqrsfzhm;
    private String arbitrateBsqrxm;
    private String arbitrateBsqrxb;
    private String arbitrateBsqrmz;
    private String arbitrateBsqrnl;
    private String arbitrateBsqryx;
    private String arbitrateBsqrdh;
    private String arbitrateBsqrsfzhm;
    private String arbitrateSqfilename;
    private String arbitrateSqfileurl;
    private String arbitrateSqzjfilename;
    private String arbitrateSqzjfileurl;
    private String arbitrateSqzjfilehash;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date arbitrateSqtime;
    private String arbitrateJd;
    private String arbitrateBsqdbs;
    private String arbitrateBsqdbsurl;
    private String arbitrateBsqfilename;
    private String arbitrateBsqfileurl;
    private String arbitrateBsqfilehash;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date arbitrateBsqtime;
    private String arbitrateZcjgname;
    private String arbitrateZcjgurl;
    private String arbitrateSfsl;
    private String arbitrateSftzbsqr;
    private String txid;
    private String uuid;
}
