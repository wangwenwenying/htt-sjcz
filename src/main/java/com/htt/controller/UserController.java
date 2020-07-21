package com.htt.controller;

import com.htt.dao.UserDao;
import com.htt.exception.UserException;
import com.htt.po.User;
import com.htt.result.Result;
import com.htt.result.ResultEnum;
import com.htt.result.ResultUtil;
import com.htt.view.Userroleview;
import com.htt.viewdao.UserroleviewDao;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

/**
 * @author ：www
 * @date ：Created in 20-7-10 下午4:00
 * @description：
 * @modified By：
 * @version:
 */
@Api(value = "/swagger", tags = "我的接口模块user")
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserroleviewDao userroleviewDao;
    @PostMapping("save")
    public Result save(@RequestBody User user){
        user.setUserCreatetime(new Date());
        User save = userDao.save(user);
        return ResultUtil.success();
    }
    @GetMapping("selectAll")
    public Result selectAll(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size){
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        Page<Userroleview> all = userroleviewDao.findAll(pageRequest);
        return ResultUtil.success(all);
    }
    @PostMapping("login")
    public Result login(String useremail,String usermm){
        if (StringUtils.isEmpty(useremail)){
            throw new UserException(ResultEnum.ZHMMNLL_ERROR);
        }
        if (StringUtils.isEmpty(usermm)){
            throw new UserException(ResultEnum.ZHMMNLL_ERROR);
        }
        User user = userDao.findByUserEmailAndUserMm(useremail, usermm).orElse(new User());
        if (user!=null&&user.getUserEmail()!=null){
            return ResultUtil.success(user);
        }else {
            throw new UserException(ResultEnum.ZHMM_ERROR);
        }
    }
    @PostMapping("regist")
    public Result regist(@RequestBody User user){
        User user1 = userDao.findByUserMc(user.getUserMc()).orElse(new User());
        if (!StringUtils.isEmpty(user1.getUserEmail())){
            throw new UserException(ResultEnum.ZH_REERO);
        }else {
            User save = userDao.save(user);
            return ResultUtil.success();
        }
    }
    @GetMapping("selectById")
    public Result selectById(long id){
        Userroleview userroleview = userroleviewDao.findById(id).orElse(new Userroleview());
        return ResultUtil.success(userroleview);
    }
}
