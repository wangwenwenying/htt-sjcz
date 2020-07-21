package com.htt.controller;

import com.htt.dao.RecordDao;
import com.htt.po.Record;
import com.htt.result.Result;
import com.htt.result.ResultUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * @author ：www
 * @date ：Created in 20-7-14 下午4:16
 * @description：
 * @modified By：
 * @version:
 */
@Api(value = "/swagger", tags = "我的接口模块record")
@RestController
@RequestMapping("record")
public class RecordController {
    @Autowired
    private RecordDao recordDao;
    @PostMapping("save")
    public Result save(@RequestBody Record record){
        Record save = recordDao.save(record);
        return ResultUtil.success();
    }
    @GetMapping("selectByUserId")
    public Result selectByUserId(long userid,@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size){
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        Page<Record> byUserId = recordDao.findByUserId(userid,pageRequest);
        return ResultUtil.success(byUserId);
    }
}
