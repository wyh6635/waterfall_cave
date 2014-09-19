/*
 * (C) Copyright. United-Imaging All rights reserved.
 *
 */
package com.iboxpay.hgm.wfc.base.entity;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * The class ParamList.
 *
 * @author: yanhui.wang
 * @since: 2014/03/15
 * @version: $Revision: 1.0 $ $Date: 2014/03/15 20:46 $ $LastChangedBy:yanhui.wang$
 *
 */
public class ParamList<T> extends ArrayList<T> implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -9059511289084937958L;
	private String head;
    private String foot;

	public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getFoot() {
        return foot;
    }

    public void setFoot(String foot) {
        this.foot = foot;
    }
}
