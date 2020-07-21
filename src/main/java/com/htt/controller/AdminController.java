package com.htt.controller;

import com.htt.dao.AdminDao;
import com.htt.exception.UserException;
import com.htt.po.Admin;
import com.htt.result.Result;
import com.htt.result.ResultEnum;
import com.htt.result.ResultUtil;
import com.htt.view.Adminroleview;
import com.htt.viewdao.AdminroleviewDao;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @author ：www
 * @date ：Created in 20-7-20 上午10:35
 * @description：
 * @modified By：
 * @version:
 */
@Api(value = "/swagger", tags = "我的接口模块admin")
@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminroleviewDao adminroleviewDao;
    @Autowired
    private AdminDao adminDao;
    @GetMapping("selectAll")
    public Result selectAll(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size){
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        Page<Adminroleview> all = adminroleviewDao.findAll(pageRequest);
        return ResultUtil.success(all);
    }
    @PostMapping("login")
    public Result login(String adminmc, String adminmm){
        if (StringUtils.isEmpty(adminmc)){
            throw new UserException(ResultEnum.ZHMMNLL_ERROR);
        }
        if (StringUtils.isEmpty(adminmm)){
            throw new UserException(ResultEnum.ZHMMNLL_ERROR);
        }
        Adminroleview adminroleview = adminroleviewDao.findByAdminMcAndAdminMm(adminmc, adminmm).orElse(new Adminroleview());
        if (adminroleview!=null&&adminroleview.getAdminMc()!=null){
            return ResultUtil.success(adminroleview);
        }else {
            throw new UserException(ResultEnum.ZHMM_ERROR);
        }
    }
    @GetMapping("selectById")
    public Result selectById(long adminid){
        Adminroleview adminroleview = adminroleviewDao.findById(adminid).orElse(new Adminroleview());
        return ResultUtil.success(adminroleview);
    }
    @PostMapping("save")
    public Result save(@RequestBody Admin admin){
        Admin save = adminDao.save(admin);
        return ResultUtil.success();
    }
}
