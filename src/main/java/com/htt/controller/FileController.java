package com.htt.controller;

import com.alibaba.fastjson.JSONObject;
import com.htt.exception.UserException;
import com.htt.result.Result;
import com.htt.result.ResultEnum;
import com.htt.result.ResultUtil;
import com.htt.utils.MD5Util;
import io.swagger.annotations.Api;
import net.bytebuddy.implementation.bytecode.Throw;
import org.apache.commons.codec.digest.Md5Crypt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author ：www
 * @date ：Created in 20-7-14 下午4:32
 * @description：
 * @modified By：
 * @version:
 */
@Api(value = "/swagger", tags = "我的接口模块file")
@RestController
@RequestMapping("file")
public class FileController {
    @Value("${nghttp.ngdir}")
    private  String ngdir;
    @Value("${nghttp.dir}")
    private  String dir;

    @PostMapping("upload")
    public Result upload(@RequestParam(value = "files") List<MultipartFile> files){
        List filenames = new ArrayList();
        List filetruenames = new ArrayList();
        List fileurls = new ArrayList();
        List filesizes = new ArrayList();
        List filehash = new ArrayList();
        //判断文件目录是否存在，否则自动生成
        File directory = new File(dir);
        if (!directory.exists()){
            directory.mkdirs();
        }
        if (files.size()==0){
            throw new UserException(ResultEnum.FILE_NULLERROR);
        }else {
            for (MultipartFile file : files){
                String remoteFileName = file.getOriginalFilename();
                String newFilename = UUID.randomUUID() + "_" + remoteFileName;
                long size = file.getSize();
                File tmpFile = new File(directory + "/" + newFilename);
                try {
                    filehash.add(MD5Util.getMultipartFileMd5(file));
                    file.transferTo(tmpFile);
                    filenames.add(remoteFileName);
                    filetruenames.add(newFilename);
                    filesizes.add(size);
                    fileurls.add(ngdir+newFilename);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("filename",dataToString(filenames));
            jsonObject.put("filetruename",dataToString(filetruenames));
            jsonObject.put("fileurl",dataToString(fileurls));
            jsonObject.put("filesize",dataToString(filesizes));
            jsonObject.put("filehash",dataToString(filehash));
            return ResultUtil.success(jsonObject);
        }
    }
    private static String dataToString(List dataList) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < dataList.size(); i++) {
            if (sb.length() > 0) {//该步即不会第一位有逗号，也防止最后一位拼接逗号！
                sb.append(",");
            }
            sb.append(dataList.get(i));
        }
        return sb.toString();
    }
}
