package com.htt.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @author ：www
 * @date ：Created in 20-7-14 上午11:44
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
@Table(name = "record")
public class Record {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long recordId;
    private Long userId;
    private String userName;
    private Long adminId;
    private String adminName;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date recordTime;
    private String recordJg;
    private String recordSqzs;
    private String recordJdjg;
}
