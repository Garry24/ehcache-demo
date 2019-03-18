package com.garry.ehcache.demo.commons;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 服务器响应信息类
 *
 * @author gaomp
 */
@Data
public class SysResult {
    private String code;

    private boolean success;

    private String message;

    private Object data;

    /**
     * 服务器响应成功，并传回对象数据给前端
     *
     * @return
     */
    public static SysResult ok(Object data) {
        SysResult sysResult = new SysResult();
        sysResult.setCode(SysCode.SUCCESS.getCode());
        sysResult.setMessage(SysCode.SUCCESS.getMessage());
        sysResult.setSuccess(true);
        sysResult.setData((null == data) ? new HashMap<>() : data);
        return sysResult;
    }

    /**
     * 服务器响应成功，并传回List数据给前端
     *
     * @return
     */
    public static SysResult okList(List list) {
        SysResult sysResult = new SysResult();
        sysResult.setCode(SysCode.SUCCESS.getCode());
        sysResult.setMessage(SysCode.SUCCESS.getMessage());
        sysResult.setSuccess(true);
        Map<String, List> map = new HashMap<>();
        list = (null == list) ? new ArrayList() : list;
        map.put("list", list);
        sysResult.setData(map);
        return sysResult;
    }

    /**
     * 返回失败信息
     *
     * @param sysCode
     * @return
     */
    public static SysResult fail(SysCode sysCode) {
        SysResult sysResult = new SysResult();
        sysResult.setCode(sysCode.getCode());
        sysResult.setMessage(sysCode.getMessage());
        sysResult.setSuccess(false);
        sysResult.setData(new HashMap<>());
        return sysResult;
    }

    public static SysResult fail(String msg, SysCode sysCode) {
        SysResult sysResult = new SysResult();
        sysResult.setCode(sysCode.getCode());
        sysResult.setMessage(msg + sysCode.getMessage());
        sysResult.setSuccess(false);
        sysResult.setData(new HashMap<>());
        return sysResult;
    }

}
