package test.databasetest;

import java.util.List;
@SuppressWarnings("unchecked")
public interface ItestmodelDAO {

	public abstract void save(testmodel transientInstance);

	public abstract void delete(testmodel persistentInstance);

	public abstract List findByExample(testmodel instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract testmodel merge(testmodel detachedInstance);

	public abstract void attachDirty(testmodel instance);

	public abstract void attachClean(testmodel instance);

}