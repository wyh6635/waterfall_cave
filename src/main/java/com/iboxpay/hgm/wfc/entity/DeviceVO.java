/*
 * Copyright (C) 2011-2013 ShenZhen iBOXPAY Information Technology Co.,Ltd.
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
 * $Id: DeviceVO.java 4688 2013-07-17 07:39:39Z deli $
 * 
 * Create on 2012-6-28
 * 
 * Description: 
 *
 */

package com.iboxpay.hgm.wfc.entity;

/**
 * @author <a href="falchion123@gmail.com">liuzhonghui</a>
 */
public class DeviceVO {

	// 会员ID
	// private Long memberId;

	// 设备ID
	private String deviceId;

	// 认证随机数
	private String randomNum;

	// 3des密文
	private String des3Msg;

	// 密钥
	private String des3Key;

	// 便民密钥
	private String des3KeyByIboxpay;

	// des3key密钥的mac计算
	private String mac;

	// 是否强制认证
	private String isAuth = "N";

	private String wkMD5;

	private String boxId;

	private String authRandom;

	private String desMessage;

	private String workkey;

	private String hardwareVersion;

	private String tmkIndex;

	private String wkmk;

	private String wklmk;

	private String lastTmkIndex;

	public String getLastTmkIndex() {
		return lastTmkIndex;
	}

	public void setLastTmkIndex(String lastTmkIndex) {
		this.lastTmkIndex = lastTmkIndex;
	}

	public String getWklmk() {
		return wklmk;
	}

	public void setWklmk(String wklmk) {
		this.wklmk = wklmk;
	}

	public String getWkmk() {
		return wkmk;
	}

	public void setWkmk(String wkmk) {
		this.wkmk = wkmk;
	}

	public String getTmkIndex() {
		return tmkIndex;
	}

	public void setTmkIndex(String tmkIndex) {
		this.tmkIndex = tmkIndex;
	}

	public String getHardwareVersion() {
		return hardwareVersion;
	}

	public void setHardwareVersion(String hardwareVersion) {
		this.hardwareVersion = hardwareVersion;
	}

	public String getAuthRandom() {
		return authRandom;
	}

	public String getDes3KeyByIboxpay() {
		return des3KeyByIboxpay;
	}

	public void setDes3KeyByIboxpay(String des3KeyByIboxpay) {
		this.des3KeyByIboxpay = des3KeyByIboxpay;
	}

	public void setAuthRandom(String authRandom) {
		this.authRandom = authRandom;
	}

	public String getDesMessage() {
		return desMessage;
	}

	public void setDesMessage(String desMessage) {
		this.desMessage = desMessage;
	}

	public String getWorkkey() {
		return workkey;
	}

	public void setWorkkey(String workkey) {
		this.workkey = workkey;
	}

	public String getBoxId() {
		return boxId;
	}

	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}

	public String getWkMD5() {
		return wkMD5;
	}

	public void setWkMD5(String wkMD5) {
		this.wkMD5 = wkMD5;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getDes3Msg() {
		return des3Msg;
	}

	public void setDes3Msg(String des3Msg) {
		this.des3Msg = des3Msg;
	}

	public String getRandomNum() {
		return randomNum;
	}

	public void setRandomNum(String randomNum) {
		this.randomNum = randomNum;
	}

	/**
	 * @return the des3Key
	 */
	public String getDes3Key() {
		return des3Key;
	}

	/**
	 * @param des3Key
	 *            the des3Key to set
	 */
	public void setDes3Key(String des3Key) {
		this.des3Key = des3Key;
	}

	/**
	 * @return the mac
	 */
	public String getMac() {
		return mac;
	}

	/**
	 * @param mac
	 *            the mac to set
	 */
	public void setMac(String mac) {
		this.mac = mac;
	}

	/**
	 * @return the isAuth
	 */
	public String getIsAuth() {
		return isAuth;
	}

	/**
	 * @param isAuth
	 *            the isAuth to set
	 */
	public void setIsAuth(String isAuth) {
		this.isAuth = isAuth;
	}

}
