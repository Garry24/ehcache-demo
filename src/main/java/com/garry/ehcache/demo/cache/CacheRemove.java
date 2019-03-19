package com.garry.ehcache.demo.cache;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义缓存清除注解
 * 区别于CacheEvict，支持正则清除key
 */
@Target({java.lang.annotation.ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheRemove {
    String value();

    String[] key();
}