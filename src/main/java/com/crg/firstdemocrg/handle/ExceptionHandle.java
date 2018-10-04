package com.crg.firstdemocrg.handle;


import com.crg.firstdemocrg.domin.Result;
import com.crg.firstdemocrg.exception.GirlException;
import com.crg.firstdemocrg.until.ResultUntil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger("ExceptionHandle.class");
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if (e instanceof GirlException){
            return ResultUntil.error(((GirlException) e).getCode(),e.getMessage());
        }else {
            logger.info(e.toString());
            return ResultUntil.error(-1,"未知错误");
        }

    }
}
