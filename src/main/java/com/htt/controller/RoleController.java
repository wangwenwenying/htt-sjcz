package com.htt.controller;

import com.htt.dao.RoleDao;
import com.htt.po.Role;
import com.htt.result.Result;
import com.htt.result.ResultUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author ：www
 * @date ：Created in 20-7-14 下午2:12
 * @description：
 * @modified By：
 * @version:
 */
@Api(value = "/swagger", tags = "我的接口模块role")
@RestController
@RequestMapping("role")
public class RoleController {
    @Autowired
    private RoleDao roleDao;
    @PostMapping("save")
    public Result save(@RequestBody Role role){
        Role save = roleDao.save(role);
        return ResultUtil.success();
    }
    @GetMapping("selectAllPage")
    public Result selectAllPage(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size){
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        Page<Role> all = roleDao.findAll(pageRequest);
        return ResultUtil.success(all);
    }
    @GetMapping("selectAll")
    public Result selectAll(){
        List<Role> all = roleDao.findAll();
        return ResultUtil.success(all);
    }

}
