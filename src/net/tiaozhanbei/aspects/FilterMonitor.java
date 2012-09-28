package net.tiaozhanbei.aspects;


import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class FilterMonitor {
	Logger logger = Logger.getLogger(FilterMonitor.class);
	@Pointcut("within(net.tiaozhanbei.filter..*)")
	public void infilter(){}
	
	@Before("infilter()")
	public void filterInvoke(JoinPoint jp){
		logger.info(jp.getSignature().getName()+"Invoked");
	}
}
