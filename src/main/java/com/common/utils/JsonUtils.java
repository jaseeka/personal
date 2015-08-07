package com.common.utils;


//import com.alibaba.fastjson.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

/**
 * Created by jaseeka on 2015/4/7.
 */
public class JsonUtils {
    private static final Logger logger = Logger.getLogger(JsonUtils.class);

    /**
     * Object转json并去除null
     *
     * @param object
     * @return
     */
    public static String Object2Json(Object object) {

        String json = "";
        try {
            ObjectMapper mapper = new ObjectMapper();
            json = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage());
        }
        return json;
    }

}
