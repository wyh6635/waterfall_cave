/*
 * (C) Copyright. LACHESIS All rights reserved.
 *
 */
package com.iboxpay.hgm.wfc.base.dao;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.iboxpay.hgm.wfc.base.entity.Page;

/**
 * 
 * The class for BaseDao.
 * 
 * @author: yanhui.wang
 * @since: 2014/03/15
 * @param <T>	
 * @version: $Revision: 1.0 $ $Date: 2014/03/15 20:46 $ $LastChangedBy:yanhui.wang$
 * 
 */
public interface BaseDao<T> {

	/**
     * insert entity t to database
     * @param statementName
     * @param t
     * @return
     */
    public T insert(String statementName, T t);
    
    
    /**
     * @param statementName
     * @param paramMap
     */
    public void insertMap(String statementName, Map<String, Object> paramMap);

    /**
     * insert collection to database
     * @param statemetnName
     * @param collection
     * @return
     */
    public Collection<T> insert(String statemetnName, Collection<T> collection);

    /**
     * delete more than one item from database,it's really delete the data from database
     * @param statementName
     * @param collection
     * @return
     */
    public int deleteCollection(String statementName, Collection<T> collection);
	
    /**
     * delete the data from database by statment name
     * @param statementName
     * @return
     */
	public int delete(String statementName);
	
	/**
	 * delete the data from database by statmentName and param 
	 * @param statementName
	 * @param param
	 * @return
	 */
	public int delete(String statementName, Object param) ;
	   
	/**
	 * update data by statement Name
	 * @param statementName
	 * @param t
	 * @return
	 */
    public T update(String statementName, T t);

    /**
     * @param statementName
     * @param paramMap
     * @return
     */
    public int updateMap(String statementName, Map<String, Object> paramMap);
    
    /**
     * update more than ony item(collection) by statementName
     * @param statementName
     * @param collection
     * @return
     */
    public Collection<T> update(String statementName, Collection<T> collection);
	   
	/**
	 * update batch data by statement Name
	 * @param statementName
	 * @param t
	 * @return
	 */
    public int updateBatch(String statementName, T t);

    /**
     * get single entity from database by statementName id.
     * @param statementName
     * @param id
     * @return
     */
    public T getById(String statementName, String id);

    /**
     * get single object result by statmentName and param.
     * @param statementName
     * @param param
     * @return
     */
    public Object getSingleResult(String statementName, Object param);

    /**
     * get single object result by statementName
     * @param statementName
     * @return
     */
    public Object getSingleResult(String statementName);

    /**
     * query for list by statementName
     * @param statementName
     * @return
     */
    public List<T> queryForList(String statementName);

    /**
     * query for list by statementName and param
     * @param statementName
     * @param param
     * @return
     */
    public List<T> queryForList(String statementName, Object param);

    /**
     * query for list object by statementName
     * @param statementName
     * @return
     */
    public List<Object> queryForListObject(String statementName);

    /**
     * query for list object by statementName and param
     * @param statementName
     * @param param
     * @return
     */
    public List<Object> queryForListObject(String statementName, Object param);

    /**
     * query for map by statementName and param and key
     * @param statementName
     * @param param
     * @param key
     * @return
     */
    public Map<String, T> queryForMap(String statementName, Object param, String key);

    /**
     * get total record
     * @param statementName
     * @param page
     * @return
     */
    public int getTotalRecord(String statementName, Page<T> page);
    
    /**
     * query for page by pageStatementName and param and page.
     * @param pageStatementName
     * @param param
     * @param page
     * @return
     */
    public Page<T> queryForPage(String pageStatementName, Object param, Page<T> page);

    /**
     * query for page by pageStatementName and page
     * @param pageStatementName
     * @param page
     * @return
     */
    public Page<T> queryForPage(String pageStatementName, Page<T> page);
    
    /**
     * get the first section of paged sql
     * @return
     */
    public String getHead();

    /**
     * get the tail section of paged sql
     * @param page
     * @return
     */
    public String getFoot(Page<T> page);
    
    
    /**
     * get the whole paged sql
     * @param sql
     * @return
     */
    public String getTotalCountSql(String sql);
}
