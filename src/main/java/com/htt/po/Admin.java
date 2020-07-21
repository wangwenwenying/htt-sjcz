package com.htt.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @author ：www
 * @date ：Created in 20-7-20 上午10:27
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
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long adminId;
    private String adminMc;
    private String adminSfzhm;
    private String adminDhhm;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date adminTime;
    private String adminDw;
    private String adminBm;
    private String adminZt;
    private String adminLx;
    private Long roleId;
    private String adminMm;
}
