package com.htt.controller;

import com.alibaba.fastjson.JSONObject;
import com.htt.configFabric.EnvConfigFabric;
import com.htt.dao.ProofDao;
import com.htt.exception.UserException;
import com.htt.po.Proof;
import com.htt.result.Result;
import com.htt.result.ResultEnum;
import com.htt.result.ResultUtil;
import com.htt.utils.Base64Zip;
import com.htt.utils.MD5Util;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author ：www
 * @date ：Created in 20-7-14 下午7:04
 * @description：
 * @modified By：
 * @version:
 */
@Api(value = "/swagger", tags = "我的接口模块proof")
@RestController
@RequestMapping("proof")
public class ProofController {
    @Autowired
    private EnvConfigFabric envConfigFabric;
    @Autowired
    private ProofDao proofDao;
    @PostMapping("save")
    public Result save(@RequestBody Proof proof){
        proof.setProofTime(new Date());
        String uuid = String.valueOf(UUID.randomUUID());
        proof.setProofUuid(uuid);
        String fcn = "initMember" ;
        StringBuilder stringBuilder = new StringBuilder().append("{\"key\":\"").append(uuid).append("\",\"value\":\"")
                .append(proof.getProofFilehash()).append("\"}");
        String data = stringBuilder.toString();
        String[] args = new String[]{data};
        JSONObject jsonObjects;
        jsonObjects = envConfigFabric.fm.invoke(envConfigFabric.getChaincodeName(),fcn,args);
        if ("200".equals(jsonObjects.getString("code"))){
            String txid = jsonObjects.getString("txid");
            proof.setProofTxid(txid);
            Proof save = proofDao.save(proof);
            return ResultUtil.success();
        }else {
            return ResultUtil.error(ResultEnum.UNKNOW_ERROR);
        }

    }
    @GetMapping("selectAllPage")
    public Result selectAllPage(long userid,@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size){
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        Page<Proof> all = proofDao.findByUserId(userid,pageRequest);
        return ResultUtil.success(all);
    }
    /** 
    * @Description: 核验证据
    * @Param: [proofUuid, proofFilehash] 
    * @return: com.htt.result.Result 
    * @Author: www
    * @Date: 20-7-20 
    */ 
    @GetMapping("hyzj")
    public Result hyzj(String proofUuid,String proofFilehash){
        String fcn = "queryMember" ;
        String[] args = new String[]{proofUuid};
        JSONObject jsonObjects ;
        jsonObjects =envConfigFabric.fm.invoke(envConfigFabric.getChaincodeName(),fcn,args);
        if ("200".equals(jsonObjects.getString("code"))){
            JSONObject data = jsonObjects.getJSONObject("data");
            String filehash = data.getString("value");
            if (proofFilehash.equals(filehash)){
                return ResultUtil.success();
            }else {
                return ResultUtil.error(ResultEnum.PROOF_ERROR);
            }
        }else {
            return ResultUtil.error(ResultEnum.PROOF_ERROR);
        }
    }

    @PostMapping("zjhy")
    public Result zjhy(@RequestParam(value = "files") List<MultipartFile> files){
        JSONObject jsonObject = new JSONObject();
        for (MultipartFile file:files){
            String filehash = MD5Util.getMultipartFileMd5(file);
            List<Proof> byProofFilehash = proofDao.findByProofFilehash(filehash);
            if (byProofFilehash.size()==0){
                jsonObject.put(file.getOriginalFilename(),false);
            }else {
                jsonObject.put(file.getOriginalFilename(),true);
            }
        }
        return ResultUtil.success(jsonObject);
    }
}
