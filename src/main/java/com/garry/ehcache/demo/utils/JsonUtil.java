package com.garry.ehcache.demo.utils;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Json工具类
 * Author : GarryLuo
 * Date  : 2019/1/21 13:44
 */
public class JsonUtil {

    private static Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    public static final ObjectMapper mapper = new ObjectMapper();

    /**
     * 对象转Json
     *
     * @param object
     * @return
     */
    public static String object2Json(Object object) {
        String result = "";
        try {
            ObjectMapper mapper = new ObjectMapper();
            result = mapper.writeValueAsString(object);
        } catch (Exception e) {
            logger.error("getJsonStr error: " + e.getMessage(), e);
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 使用泛型方法，把json字符串转换为相应的JavaBean对象。
     * (1)转换为普通JavaBean：readValue(json,Student.class)
     * (2)转换为List,如List<Student>,将第二个参数传递为Student
     * [].class.然后使用Arrays.asList();方法把得到的数组转换为特定类型的List
     *
     * @param jsonStr
     * @param valueType
     * @return
     */
    public static <T> T json2Object(String jsonStr, Class<T> valueType) throws Exception {

        try {
            return mapper.readValue(jsonStr, valueType);
        } catch (Exception e) {
            logger.error("readValue error: " + e.getMessage(), e);
            throw e;
        }
    }

    /**
     * Json转List
     *
     * @param jsonString
     * @return
     */
    public static List<Map<String, JsonNode>> getJsonListStr(String jsonString) {
        List<Map<String, JsonNode>> mapList = new ArrayList<Map<String, JsonNode>>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode root = objectMapper.readTree(jsonString);
            Iterator<Map.Entry<String, JsonNode>> elements = root.getFields();
            while (elements.hasNext()) {
                Map<String, JsonNode> jsonNodeMap = new HashMap<String, JsonNode>();
                Map.Entry<String, JsonNode> node = elements.next();
                String key = node.getKey();
                JsonNode jsonNode = node.getValue();
                jsonNodeMap.put(key, jsonNode);
                mapList.add(jsonNodeMap);
            }
            return mapList;
        } catch (IOException e) {
            logger.error("getJsonListStr error: " + e.getMessage(), e);
            e.printStackTrace();
        }
        return null;

    }

    public static void sendResponse(HttpServletResponse response, String jsonContent) {
        if (null == response) {
            return;
        }

        PrintWriter pWriter = null;
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");

            pWriter = response.getWriter();
            pWriter.print(jsonContent);
            pWriter.flush();
        } catch (IOException e) {
            logger.debug("[JsonUtil][sendResponse]:Catch exception {}", e);
            e.printStackTrace();
        } finally {
            if (null != pWriter) {
                pWriter.close();
            }
        }

    }

    public static void sendResponse(HttpServletResponse response, Object beanObject) {

        try {
            String jsonContent = mapper.writeValueAsString(beanObject);
            sendResponse(response, jsonContent);
        } catch (Exception e) {
            logger.debug("[JsonUtil][sendResponse]:Catch exception {}", e);
            e.printStackTrace();
        }
    }

    /**
     * 获取JsonNode，JsonNode可以对Json串各节点进行操作
     *
     * @param jsonString
     * @return
     */
    public static JsonNode readTree(String jsonString) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(jsonString);
            return jsonNode;
        } catch (IOException e) {
            logger.error("readTree error: " + e.getMessage(), e);
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws Exception {

    }

}
