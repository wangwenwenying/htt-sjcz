package com.htt.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @author ：www
 * @date ：Created in 20-7-14 上午11:40
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
@Table(name = "proof")
public class Proof {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long proofId;
    private Long userId;
    private String proofName;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date proofTime;
    private String proofFilehash;
    private String proofFilesize;
    private String proofFilename;
    private String proofFileurl;
    private String proofUuid;
    private String proofTxid;
}
