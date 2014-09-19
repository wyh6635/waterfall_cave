package com.iboxpay.hgm.wfc.utils;

import java.util.ArrayList;
import java.util.List;

import com.iboxpay.hgm.wfc.entity.SyncMerchant;


public class MerchantUtils {

	public static List<SyncMerchant> parseObject(List<String> parseStrList) {
		List<SyncMerchant> list = new ArrayList<SyncMerchant>();
		
		SyncMerchant merchant = null;
		for (String str: parseStrList) {
			merchant = parseMerchant(str);
			
			list.add(merchant);
		}
		
		return list;
	}
	
	public static SyncMerchant parseMerchant(String parseString) {
		String[] array = parseString.split("\\|\\|");
		
		SyncMerchant merchant = new SyncMerchant();
		merchant.setSettleDate(array[0]);
		merchant.setFileName(array[1]);
		merchant.setPartner(array[2]);
		merchant.setMerchantNo(array[3]);
		merchant.setMerchantName(array[4]);
		merchant.setOrderNo(array[5]);
		merchant.setTradeAmt(array[6]);
		merchant.setCardNo(array[7]);
		
		return merchant;
	}
	
	public static List<String> parseStrList(List<SyncMerchant> list) {
		List<String> parseList = new ArrayList<String>();
		StringBuffer sb = null;
		for ( SyncMerchant merchant : list) {
			sb = new StringBuffer();
			sb.append("update cooperate_merchant ");
			sb.append("set merchant_no='");
			sb.append(merchant.getMerchantNo());
			sb.append("', terminal_no='79003009', ");
			sb.append("thirdpart_id=10555, ");
			sb.append("router_code='3042' ");
			sb.append("where partner='");
			sb.append(merchant.getPartner());
			sb.append("';");
			
			parseList.add(sb.toString());
		}
		
		return parseList;
	}
}

	