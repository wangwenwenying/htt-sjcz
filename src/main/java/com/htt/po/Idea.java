package com.htt.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @author ：www
 * @date ：Created in 20-7-14 上午8:51
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
@Table(name = "idea")
public class Idea {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long ideaId;
    private Long userId;
    private String userName;
    private String ideaLx;
    private String ideaNr;
    private String ideaSfcl;
    private String ideaSfyd;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date ideaTime;
}
