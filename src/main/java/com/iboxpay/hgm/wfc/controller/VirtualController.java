package com.iboxpay.hgm.wfc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iboxpay.hgm.wfc.entity.BankVO;
import com.iboxpay.hgm.wfc.utils.JSonUtil;
import com.iboxpay.hgm.wfc.utils.WebUtil;

@Controller
public class VirtualController {

	private final Logger logger = LoggerFactory.getLogger(VirtualController.class);
	
	@RequestMapping(value = "/preCreateJson.htm")
    public String listMessage(HttpServletRequest request, HttpServletResponse response) {
		BankVO bank = new BankVO();
		bank.setBankCode("001");
		bank.setBankName("中国银行深圳分行");
		bank.setMarketActivitySort("333");
		
		String jsonTxt = JSonUtil.toJson(bank);
      
      logger.info("message_list jsonData : " + jsonTxt);
      WebUtil.writeToClient(response, jsonTxt, "UTF-8");
		
        return null;
    }
	
}
    