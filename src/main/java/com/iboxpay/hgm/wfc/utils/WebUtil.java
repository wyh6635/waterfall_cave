
package com.iboxpay.hgm.wfc.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebUtil {
    
    private static final Logger logger = LoggerFactory.getLogger(WebUtil.class);
	/**
	 * 使用charset格式 将 数据返回给客户端
	 * @param response
	 * @param json
	 * @param charset
	 */
	public static void writeToClient(HttpServletResponse response, String json, String charset) {
		response.setContentType("text/html;charset=" + charset);
		try {
            logger.info("Return to client text: = " + json);
			response.getWriter().write(json);
		} catch (IOException e) {
			throw new RuntimeException("Error when write to client, errmsg: "
					+ e.getMessage(), e);
		}
	}
}
