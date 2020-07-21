package com.htt.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;

/**
 * @author ：www
 * @date ：Created in 20-7-14 上午8:57
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
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long newsId;
    private String newsNr;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date newsTime;
    private Long userSendid;
    private Long userReceiveid;
    private String userSendname;
    private String userReceivename;
    private String newsFilename;
    private String newsFileurl;
    private String newsZt;
}
