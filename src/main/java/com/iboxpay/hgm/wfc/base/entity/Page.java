/*
 * (C) Copyright. United-Imaging All rights reserved.
 *
 */
package com.iboxpay.hgm.wfc.base.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The class for page.
 *
 * @author: yanhui.wang
 * @since: 2014-03-16	
 * @version: $Revision: 1.0 $ $Date: 2014-03-16 $ $LastChangedBy$
 *
 */
public class Page<T> implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8733790208566933261L;
	public static final String PAGED_STR = "paged";
    public static final int PAGE_SIZE = 10;
    private List<T> _data;
    private int _curPage;
    private int _totalRecord;
    private String _totalItemSql;

    public String getTotalItemSql() {
        return _totalItemSql;
    }

    public void setTotalItemSql(String totalItemSql) {
        this._totalItemSql = totalItemSql;
    }

    public List<T> getData() {
        return _data;
    }

    public void setData(List<T> data) {
        this._data = data;
    }

    /**
     * e.g. 1 2 3 4 5 6 7 8 9 e.g. 1 2 ... 5 6 7 ... 11 12 4 Split to three
     * Sections first section: 1 2 second section: ... 5 6 7 third section: ...
     * 11 12 4
     *
     * @return
     */
    public List<String> getPageNo() {
        List<String> pageNo = new ArrayList<String>();
        //first section
        if (getTotalPage() >= 0) {
            getFirstSectionPageNo(pageNo);
        }
        //second section
        if (getTotalPage() >= 3) {
            getMiddleSectionPageNo(pageNo);
        }
        //third section
        if (getTotalPage() > 9 && getTotalPage() - getCurPage() >= 5) {
            getLastSectionPageNo(pageNo);
        }
        return pageNo;
    }

    private void getFirstSectionPageNo(List<String> pageNo) {
        int totalPage = getTotalPage();
        if (totalPage >= 2) {
            pageNo.add("1");
            pageNo.add("2");
        } else if (totalPage >= 1) {
            pageNo.add("1");
        }

    }

    private void getMiddleSectionPageNo(List<String> pageNo) {
        int prev = getCurPage() - 1;
        int curr = getCurPage();
        int next = getCurPage() + 1;
        if (getTotalPage() <= 9) {
            for (int i = 3; i <= getTotalPage(); i++) {
                pageNo.add(String.valueOf(i));
            }
        } else {
            if (curr <= 5) {
                if (curr == 5) {
                    pageNo.add("...");
                    pageNo.add(String.valueOf(4));
                    pageNo.add(String.valueOf(5));
                    pageNo.add(String.valueOf(6));
                } else {
                    pageNo.add(String.valueOf(3));
                    pageNo.add(String.valueOf(4));
                    pageNo.add(String.valueOf(5));
                    pageNo.add(String.valueOf(6));
                }
            } else if (getTotalPage() - curr < 5) {
                pageNo.add("...");
                pageNo.add(String.valueOf(getTotalPage() - 5));
                pageNo.add(String.valueOf(getTotalPage() - 4));
                pageNo.add(String.valueOf(getTotalPage() - 3));
                pageNo.add(String.valueOf(getTotalPage() - 2));
                pageNo.add(String.valueOf(getTotalPage() - 1));
                pageNo.add(String.valueOf(getTotalPage() - 0));
            } else {
                pageNo.add("...");
                pageNo.add(String.valueOf(prev));
                pageNo.add(String.valueOf(curr));
                pageNo.add(String.valueOf(next));
            }
        }
    }

    private void getLastSectionPageNo(List<String> pageNo) {
        int totalPage = getTotalPage();
        if (totalPage > 9) {
            pageNo.add("...");
            pageNo.add(String.valueOf(totalPage - 1));
            pageNo.add(String.valueOf(totalPage));
        } else if (totalPage >= 8) {
            pageNo.add(String.valueOf(totalPage - 1));
            pageNo.add(String.valueOf(totalPage));
        } else if (totalPage == 7) {
            pageNo.add("7");
        }
    }

    public int getCurPage() {
    	if (_curPage <= 0 || _curPage > getTotalPage()) {
    		return 1;
    	} else {
    		return _curPage;
    	}
    }

    public void setCurPage(int curPage) {
        this._curPage = curPage;
    }

    public int getTotalPage() {
        int temp = getTotalRecord() / PAGE_SIZE;
        return (getTotalRecord() % PAGE_SIZE == 0) ? temp : (temp + 1);
    }
/*
    public void setTotalPage(int totalPage) {
        this._totalPage = totalPage;
    }*/

    public int getTotalRecord() {
        return _totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this._totalRecord = totalRecord;
    }

    public int getStartIndex() {
        return (getCurPage() - 1) * PAGE_SIZE;
    }
}