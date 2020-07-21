package com.htt.controller;

import com.htt.dao.ArbitrateDao;
import com.htt.po.Arbitrate;
import com.htt.result.Result;
import com.htt.result.ResultUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * @author ：www
 * @date ：Created in 20-7-20 上午11:27
 * @description：
 * @modified By：
 * @version:
 */
@Api(value = "/swagger", tags = "我的接口模块arbitrate")
@RestController
@RequestMapping("arbitrate")
public class ArbitrateController {
    @Autowired
    private ArbitrateDao arbitrateDao;
    @PostMapping("save")
    public Result save(@RequestBody Arbitrate arbitrate){
        Arbitrate save = arbitrateDao.save(arbitrate);
        return ResultUtil.success();
    }
    @GetMapping("selectBySqryx")
    public Result selectBySqryx(String sqryx,@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size){
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        Page<Arbitrate> byArbitrateSqryx = arbitrateDao.findByArbitrateSqryx(sqryx, pageRequest);
        return ResultUtil.success(byArbitrateSqryx);
    }
    @GetMapping("selectByBsqryx")
    public Result selectByBsqryx(String bsqryx,@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size){
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        Page<Arbitrate> byArbitrateBsqryx = arbitrateDao.findByArbitrateBsqryx(bsqryx, pageRequest);
        return ResultUtil.success(byArbitrateBsqryx);
    }
}
