package com.htt.exception;

/**
 * @description:
 * @Author: www
 * @Date: 2020-03-26 15:14
 */

import com.htt.result.Result;
import com.htt.result.ResultEnum;
import com.htt.result.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理
 */
@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof UserException) {
            UserException userException = (UserException) e;
            return ResultUtil.error(userException);
        } else {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.UNKNOW_ERROR);
        }
    }
}
