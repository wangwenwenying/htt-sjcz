package com.htt.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author ：www
 * @date ：Created in 20-7-10 下午3:24
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
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long userId;
    private String userMc;
    private String userZsxm;
    private String userSfzhm;
    private String userPhone;
    private String userDw;
    private String userBm;
    private String userEmail;
    private String userAddr;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date userCreatetime;
    private String userType;
    private String userLx;
    private String userSex;
    private String userMz;
    private String userMm;
    private Long roleId;
}
