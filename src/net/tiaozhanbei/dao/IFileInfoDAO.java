package net.tiaozhanbei.dao;

import java.util.List;

import net.tiaozhanbei.model.FileInfo;
import net.tiaozhanbei.util.Page;

public interface IFileInfoDAO {

	public abstract void save(FileInfo transientInstance);

	public abstract void delete(FileInfo persistentInstance);

	public abstract FileInfo findById(java.lang.Integer id);

	public abstract List<FileInfo> findByExample(FileInfo instance);

	public abstract List<FileInfo> findByProperty(String propertyName, Object value);

	public abstract List<FileInfo> findByFileName(Object fileName);

	public abstract List<FileInfo> findByFilePath(Object filePath);

	public abstract List<FileInfo> findByFileProject(Object fileProject);

	public abstract List<FileInfo> findByFileType(Object fileType);

	public abstract List<FileInfo> findByFileOwner(Object fileOwner);

	public abstract List<FileInfo> findAll();

	public abstract FileInfo merge(FileInfo detachedInstance);

	public abstract void attachDirty(FileInfo instance);

	public abstract void attachClean(FileInfo instance);

	
	public void fillPage(Page<FileInfo> page,String hql,Object[] values);
	public void fillPage(Page<FileInfo> page,String hql);
	public void fillPage(Page<FileInfo> page);
	public List<FileInfo> queryForList(String select,Object[] values);
	public void update(FileInfo fileInfo);
}