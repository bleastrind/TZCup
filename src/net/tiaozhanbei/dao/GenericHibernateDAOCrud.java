package net.tiaozhanbei.dao;

import java.io.Serializable;  
import java.sql.SQLException;  
import java.util.*;  
   
  
import net.tiaozhanbei.util.Page;

import org.apache.commons.logging.*;  
import org.hibernate.HibernateException;  
import org.hibernate.Query;  
import org.hibernate.Session;  
import org.hibernate.criterion.DetachedCriteria;  
import org.springframework.dao.DataRetrievalFailureException;  
import org.springframework.orm.hibernate3.HibernateCallback;  
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
@SuppressWarnings("unchecked")
/** 
 * This base class is prepared for subclass to do CRUD easily. 
 *  
 * @author Tiger 
 */  
public abstract class GenericHibernateDAOCrud<T> extends HibernateDaoSupport{  
  
    protected static final Object[] EMPTY_OBJECT_ARRAY = new Object[] {};  
  
    protected Log log = LogFactory.getLog(getClass());  

    
    private final Class<T> clazz;  

  
    /** 
     * Inject domain's class type in constructor. 
     *  
     * @param clazz Domain's class. 
     */  
    public GenericHibernateDAOCrud(Class<T> clazz) {  
        this.clazz = clazz;  
    }  
  
  
    @SuppressWarnings("unchecked")  
    public T query(Serializable id) {  
    	
        T t = (T)getHibernateTemplate().get(clazz, id);  
        if(t==null)  
            throw new DataRetrievalFailureException("Object not found.");  
        // it is strange that load() method return a lazy-loading proxy object   
        // and it may cause LazyInitializationException!  
        return t;  
    }  
  
    /** 
     * Default implementation of creating new domain object. 
     */  
    public void create(T t) {  
        getHibernateTemplate().save(t);  
    }  
  
    /** 
     * Default implementation of deleting new domain object. 
     */  
    public void delete(T t) {  
        getHibernateTemplate().delete(t);  
    }  
  
    /** 
     * Default implementation of updating domain object. 
     */  
    public void update(T t) {  
        getHibernateTemplate().update(t);  

    }  
    
    public void saveOrUpdate(T t){
    	getHibernateTemplate().saveOrUpdate(t);
    }
  
    /** 
     * Do an update hql query, return the affected rows. 
     *  
     * @param updateHql Update HQL. 
     * @param values Parameters or null if none. 
     * @return The affected rows. 
     */  
    protected int executeUpdate(final String updateHql, final Object[] values) {  
        HibernateCallback updateCallback = new HibernateCallback() {  
            public Object doInHibernate(Session session) throws HibernateException, SQLException {  
                Query query = session.createQuery(updateHql);  
                if(values!=null) {  
                    for(int i=0; i<values.length; i++)  
                        query.setParameter(i, values[i]);  
                }  
                return new Integer(query.executeUpdate());  
            }  
        };  
        return ((Integer)getHibernateTemplate().execute(updateCallback)).intValue();  
    }  
  
    /**
     * 按hql语句填充Page，从DAO控制的表中获取内容,不可处理关系其它表的复杂hql
     * @param page
     * @param hql
     * @param values
     */
	public void fillPage(Page page,String hql,Object[] values) {
		int i = hql.indexOf("from");
		int j = hql.indexOf("order");
		String selectCount = hql;
		if(j>i)
			selectCount = hql.substring(i, j);
		else {
			selectCount = hql.substring(i);
		}
		log.info("i:"+i+" j:"+j+"\n"+selectCount);
		fillPage("select count(*) " + selectCount
    			, hql,
    			values, 
    			page);
	}
	
	/**
	 * 按hql语句填充Page，从DAO控制的表中获取内容
	 * @param page
	 * @param hql
	 */
	public void fillPage(Page page,String hql) {
		fillPage(page
    			, hql,
    			null);
	}
	
	/**
	 * 获得全部
	 * @param page
	 */
	public void fillPage(Page page){
		fillPage(page,"from "+clazz.getName()+" order by id desc");
	}
    /** 
     * Prepared for sub-class for convenience. Query for list and also return  
     * total results' number. 
     *  
     * @param selectCount HQL for "select count(*) from ..." and should return a Long. 
     * @param select HQL for "select * from ..." and should return object list. 
     * @param values For prepared statements. 
     * @param page Page object for store page information. 
     */  
    public void fillPage(final String selectCount, final String select, final Object[] values, final Page page) {  
        Long count = (Long)queryForObject(selectCount, values);  
        page.setTotalCount(count.intValue());  
        if(page.isEmpty())  
            page.setDataList(Collections.EMPTY_LIST);  
        page.setDataList(queryForList(select, values, page));  
    }  
  
    /** 
     * Prepared for sub-class for convenience. Query for list but do not return  
     * total results' number. 
     *  
     * @param select HQL for "select * from ..." and should return object list. 
     * @param values For prepared statements. 
     * @param page Page object for store page information. 
     */  
    
    protected List queryForList(final String select, final Object[] values, final Page page) {  
        // select:  
        HibernateCallback selectCallback = new HibernateCallback() {  
            public Object doInHibernate(Session session) {  
                Query query = session.createQuery(select);  
                if(values!=null) {  
                    for(int i=0; i<values.length; i++)  
                        query.setParameter(i, values[i]);  
                }  
                return query.setFirstResult(page.getFirstResult())  
                            .setMaxResults(page.getPageSize())  
                            .list();  
                
            }  
        };  
        return (List) getHibernateTemplate().executeFind(selectCallback);  
    }  
  
    /** 
     * Prepared for sub-class for convenience. Query for unique result. 
     *  
     * @param select HQL for "select * from ..." and should return unique object. 
     * @param values For prepared statements. 
     */  
    protected Object queryForObject(final String select, final Object[] values) {  
        HibernateCallback selectCallback = new HibernateCallback() {  
            public Object doInHibernate(Session session) {  
            	Query query=null;
            	try{
            		System.out.println("GenericHibernateDAO:hql to be created:"+select);
                query = session.createQuery(select);  
                if(values!=null) {  
                    for(int i=0; i<values.length; i++)  
                        query.setParameter(i, values[i]); 
                }  
            	}catch(Exception e){
            		System.out.println("Exception in GenericHibernateDAO queryForObject");
            	}
                
                return query.uniqueResult();  
            }  
        };  
        return getHibernateTemplate().execute(selectCallback);  
    }  
  
    protected Object queryForObject(final DetachedCriteria dc) {  
        HibernateCallback callback = new HibernateCallback() {  
            public Object doInHibernate(Session session) {  
                return dc.getExecutableCriteria(session).uniqueResult();  
            }  
        };  
        return getHibernateTemplate().execute(callback);  
    }  
  
      
  
    /** 
     * Prepared for sub-class for convenience. 
     */  
    protected Object uniqueResult(final DetachedCriteria dc) {  
        HibernateCallback callback = new HibernateCallback() {  
            public Object doInHibernate(Session session) {  
                return dc.getExecutableCriteria(session).uniqueResult();  
            }  
        };  
        return getHibernateTemplate().execute(callback);  
    }  
    protected List queryForLists(final String select, final Object[] values) {  
        // select:  
        HibernateCallback selectCallback = new HibernateCallback() {  
            public Object doInHibernate(Session session) {  
                Query query = session.createQuery(select);  
                if(values!=null) {  
                    for(int i=0; i<values.length; i++)  
                        query.setParameter(i, values[i]);  
                }  
                return query.list();  
            }  
        };  
        return (List) getHibernateTemplate().executeFind(selectCallback);  
    }

   
  
}  