package net.tiaozhanbei.filter;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

public class OpenSessionInViewFilter extends org.springframework.orm.hibernate3.support.OpenSessionInViewFilter
{
	/**
	 * Hibernate:解决会话不能写数据库问题
	 * we do a different flushmode than in the codebase
	 * here
	 */
	protected Session getSession(SessionFactory sessionFactory) throws DataAccessResourceFailureException
    {
    	Session session=SessionFactoryUtils.getSession(sessionFactory,true);
    	session.setFlushMode(FlushMode.COMMIT);
    	return session;
    }
	/**
	 * we do an explicit flush here just in case
	 * we do not have an automated flush
	 */
    protected void closeSession(Session session,SessionFactory factory)
    {
            session.flush();
            super.closeSession(session,factory);
    }
}
