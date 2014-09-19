package com.iboxpay.hgm.wfc.utils;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSonUtil {
	/**
	 * Map object convert to json string
	 * 
	 * @param map
	 * @return
	 */
	public static String toJson(Object obj) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_EMPTY);
		mapper.setSerializationInclusion(Include.NON_NULL);
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

		try {
			return mapper.writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException("Map object convert to json string error.", e);
		}
	}

	/**
	 * convert json string to Map.
	 * 
	 * @param jsonText
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> fromJson(String jsonText) {
		if ( jsonText == null || jsonText.trim().length() == 0) {
			return null;
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		ObjectMapper mapper = new ObjectMapper();
		//设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		
		try {
			map = mapper.readValue(jsonText, HashMap.class);
		} catch (Exception e) {
			throw new RuntimeException("Object convert to json string error.", e);
		}
		
		return map;
	}

}
