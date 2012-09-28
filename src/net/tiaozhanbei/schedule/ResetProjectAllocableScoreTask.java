package net.tiaozhanbei.schedule;

import java.util.Date;
import java.util.TimerTask;

import net.tiaozhanbei.dao.impl.ProjectDAO;
import net.tiaozhanbei.util.ProjectConst;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * 用于恢复每个项目每天可以分配给优秀评论的分数
 * @author Administrator
 *
 */
public class ResetProjectAllocableScoreTask extends TimerTask{
	 private static final Log log = LogFactory.getLog(ProjectDAO.class);
	@Autowired
	private DriverManagerDataSource dataSource;
	
	@Override
	public void run() {
		SimpleJdbcTemplate jdbcTemplate = new SimpleJdbcTemplate(dataSource);
		jdbcTemplate.update("update tzcup.dbo.project set score=?", new Object[]{ProjectConst.AllocableScore});
		System.out.println("ResetProjectAllocableScoreTask executed!");
		log.info("ResetProjectAllocableScoreTask executed! at "+ new Date());
	}
	
}
