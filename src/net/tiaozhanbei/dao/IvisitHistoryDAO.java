package net.tiaozhanbei.dao;

import java.util.List;

import net.tiaozhanbei.model.visitHistory;
import net.tiaozhanbei.util.Page;

public interface IvisitHistoryDAO {
	public static final String ACTIVENUM = "activenum";
	public static final String TOTALNUM = "totalnum";

	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.IvisiHistoryDAO#save(net.tiaozhanbei.model.visitHistory)
	 */
	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IvisitHistoryDAO#save(net.tiaozhanbei.model.visitHistory)
	 */
	public abstract void save(visitHistory transientInstance);

	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.IvisiHistoryDAO#update(net.tiaozhanbei.model.visitHistory)
	 */
	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IvisitHistoryDAO#update(net.tiaozhanbei.model.visitHistory)
	 */
	public abstract void update(visitHistory persistentInstance);

	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.IvisiHistoryDAO#delete(net.tiaozhanbei.model.visitHistory)
	 */
	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IvisitHistoryDAO#delete(net.tiaozhanbei.model.visitHistory)
	 */
	public abstract void delete(visitHistory persistentInstance);

	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.IvisiHistoryDAO#findById(java.util.Date)
	 */
	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IvisitHistoryDAO#findById(java.util.Date)
	 */
	public abstract visitHistory findById(java.util.Date id);

	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.IvisiHistoryDAO#findByExample(net.tiaozhanbei.model.visitHistory)
	 */
	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IvisitHistoryDAO#findByExample(net.tiaozhanbei.model.visitHistory)
	 */
	public abstract List<visitHistory> findByExample(visitHistory instance);

	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.IvisiHistoryDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IvisitHistoryDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public abstract List<visitHistory> findByProperty(String propertyName, Object value);

	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.IvisiHistoryDAO#findByActivenum(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IvisitHistoryDAO#findByActivenum(java.lang.Object)
	 */
	public abstract List<visitHistory> findByActivenum(Object activenum);

	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.IvisiHistoryDAO#findByTotalnum(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IvisitHistoryDAO#findByTotalnum(java.lang.Object)
	 */
	public abstract List<visitHistory> findByTotalnum(Object totalnum);

	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.IvisiHistoryDAO#findAll()
	 */
	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IvisitHistoryDAO#findAll()
	 */
	public abstract List<visitHistory> findAll();

	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.IvisiHistoryDAO#merge(net.tiaozhanbei.model.visitHistory)
	 */
	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IvisitHistoryDAO#merge(net.tiaozhanbei.model.visitHistory)
	 */
	public abstract visitHistory merge(visitHistory detachedInstance);

	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.IvisiHistoryDAO#attachDirty(net.tiaozhanbei.model.visitHistory)
	 */
	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IvisitHistoryDAO#attachDirty(net.tiaozhanbei.model.visitHistory)
	 */
	public abstract void attachDirty(visitHistory instance);

	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.IvisiHistoryDAO#attachClean(net.tiaozhanbei.model.visitHistory)
	 */
	/* (non-Javadoc)
	 * @see net.tiaozhanbei.dao.impl.IvisitHistoryDAO#attachClean(net.tiaozhanbei.model.visitHistory)
	 */
	public abstract void attachClean(visitHistory instance);
	public void fillPage(Page<visitHistory> page,String hql,Object[] values);
	public void fillPage(Page<visitHistory> page,String hql);
	public void fillPage(Page<visitHistory> page);
	
}