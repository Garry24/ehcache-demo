package com.garry.ehcache.demo.exception;

import com.garry.ehcache.demo.commons.SysCode;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 全局异常处理类
 * Author : GarryLuo
 * Date  : 2019/1/9 10:20
 */
@Component
public class GlobalExceptionHandler implements HandlerExceptionResolver {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @Nullable
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, @Nullable Object o, Exception e) {
        String msg = "";
        if (e instanceof Exception) {
            msg = SysCode.EXCEPTION.getMessage();
        }
        exceptionResponse(response, msg);
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }

    protected void exceptionResponse(HttpServletResponse response, String msg) {
        PrintWriter writer = null;
        try {
            response.setContentType("application/json");
            writer = response.getWriter();
            writer.write(msg);
        } catch (Exception e) {
            logger.error("exceptionResponse error", e);
        } finally {
            IOUtils.closeQuietly(writer);
        }
    }
}
