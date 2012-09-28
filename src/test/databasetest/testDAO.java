package test.databasetest;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;


import net.tiaozhanbei.dao.GenericHibernateDAOCrud;
import net.tiaozhanbei.model.User;

public class testDAO extends GenericHibernateDAOCrud<User> {

	public HibernateTemplate getemplate(){
		return getHibernateTemplate();
	}
	public testDAO() {
		super(User.class);
		System.out.println(User.class);
		// TODO Auto-generated constructor stub
	}

    public Object test(String hql) {  
    	final String select=hql;
    	HibernateCallback selectCallback = new HibernateCallback() {  
            
        	public Object doInHibernate(Session session) {  
                Query query = session.createQuery(select);  
              
                return query.uniqueResult();  
            }  
        };  
        return getemplate().execute(selectCallback);  
    }  
    
    public Object test(final String select,final Object value){
    	HibernateCallback hibernateCallback = new HibernateCallback() {  
            public Object doInHibernate(Session session) throws HibernateException, SQLException {  
                Query query = session.createQuery(select);  
                query.setParameter(0, value);
                return query.uniqueResult();  
            }  
        };  
        return getHibernateTemplate().execute(hibernateCallback);  
  
    }
	@Override
	public void create(User t) {
		// TODO Auto-generated method stub
		super.create(t);
		
		
	}

	@Override
	public void delete(User t) {
		// TODO Auto-generated method stub
		super.delete(t);
	}

	@Override
	public int executeUpdate(String updateHql, Object[] values) {
		// TODO Auto-generated method stub
		return super.executeUpdate(updateHql, values);
	}

	@Override
	public User query(Serializable id) {
		// TODO Auto-generated method stub
		return super.query(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List queryForLists(String select, Object[] values) {
		// TODO Auto-generated method stub
		return super.queryForLists(select, values);
	}

	@Override
	public User queryForObject(DetachedCriteria dc) {
		// TODO Auto-generated method stub
		return (User)super.queryForObject(dc);
	}

	@Override
	public Object queryForObject(String select, Object[] values) {
		// TODO Auto-generated method stub
		return super.queryForObject(select, values);
	}

	@Override
	public Object uniqueResult(DetachedCriteria dc) {
		// TODO Auto-generated method stub
		return super.uniqueResult(dc);
	}

	@Override
	public void update(User t) {
		// TODO Auto-generated method stub
		super.update(t);
	}

	@Override
	public HibernateTemplate createHibernateTemplate(
			SessionFactory sessionFactory) {
		// TODO Auto-generated method stub
		return super.createHibernateTemplate(sessionFactory);
	}

	@Override
	public void initDao() throws Exception {
		// TODO Auto-generated method stub
		super.initDao();
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return super.equals(arg0);
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
