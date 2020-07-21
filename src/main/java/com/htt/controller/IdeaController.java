package com.htt.controller;

import com.htt.dao.IdeaDao;
import com.htt.po.Idea;
import com.htt.result.Result;
import com.htt.result.ResultUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * @author ：www
 * @date ：Created in 20-7-14 下午3:16
 * @description：
 * @modified By：
 * @version:
 */
@Api(value = "/swagger", tags = "我的接口模块idea")
@RestController
@RequestMapping("idea")
public class IdeaController {
    @Autowired
    private IdeaDao ideaDao;
    @PostMapping("save")
    public Result save(@RequestBody Idea idea){
        Idea save = ideaDao.save(idea);
        return ResultUtil.success();
    }
    @GetMapping("selectAll")
    public Result selectAll(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size){
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        Page<Idea> all = ideaDao.findAll(pageRequest);
        return ResultUtil.success(all);
    }
}
