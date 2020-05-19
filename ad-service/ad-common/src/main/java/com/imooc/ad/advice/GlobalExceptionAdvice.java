package com.imooc.ad.advice;

import com.imooc.ad.exception.AdException;
import com.imooc.ad.vo.CommonResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: HongchaoLv
 * @Description:
 * @Date: Created in 17:42 2020/5/19
 * @Modified By:
 */
@RestControllerAdvice
public class GlobalExceptionAdvice {
    @ExceptionHandler(value = AdException.class)
    public CommonResponse<String> handlerAdException(HttpServletRequest request,
                                                     AdException ex) {
        CommonResponse<String> response = new CommonResponse<>(50001, "error");
        response.setData(ex.getMessage());
        return response;
    }
}
