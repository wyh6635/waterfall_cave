/*
 * Copyright (C) 2011 ShenZhen iBOXPAY Information Technology Co.,Ltd.
 *
 * All right reserved.
 *
 * This software is the confidential and proprietary
 * information of iBoxPay Company of China.
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement
 * you entered into with iBoxpay inc.
 *
 * BankVO.java 1439 2013-12-19 下午03:10:17 Z sunwei 
 *
 * Description:  .
 *
 */
package com.iboxpay.hgm.wfc.entity;

/**
 * @author sunwei
 * 
 */
public class BankVO {
	private String bankCode;
	private String bankName;
	private String marketActivitySort;

	public String getMarketActivitySort() {
		return marketActivitySort;
	}

	public void setMarketActivitySort(String marketActivitySort) {
		this.marketActivitySort = marketActivitySort;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

}
