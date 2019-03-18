package com.garry.ehcache.demo.cache;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by GarryLuo
 * 2018/8/21
 */
@Aspect
@Component
public class CacheRemoveAspect {
    @Pointcut(value = "(@annotation(com.garry.ehcache.demo.cache.CacheRemove))")
    private void pointcut() {
    }

    @AfterReturning(value = "pointcut()")
    private void process(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        CacheRemove cacheRemove = method.getAnnotation(CacheRemove.class);
        if (cacheRemove != null) {
            String value = cacheRemove.value();
            String[] keys = cacheRemove.key();
            List cacheKeys = CacheUtils.cacheKeys(value);
            for (String key : keys) {
                Pattern pattern = Pattern.compile(key);
                for (Object cacheKey : cacheKeys) {
                    String cacheKeyStr = String.valueOf(cacheKey);
                    if (pattern.matcher(cacheKeyStr).find()) {
                        CacheUtils.remove(value, cacheKeyStr);
                    }
                }
            }
        }
    }
}
