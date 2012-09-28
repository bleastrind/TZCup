package net.tiaozhanbei.aspects;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.sun.org.apache.bcel.internal.generic.NEW;

@Aspect
@SuppressWarnings("unused")
public class performanceTest {


	/*
	@Pointcut("within(net.tiaozhanbei.action..*)")
	private void inaction(){}
	
	@Pointcut("within(net.tiaozhanbei.model..*)")
	private void inmodel(){}
	
	@Pointcut("within(net.tiaozhanbei.dao..*)")
	private void indao(){}
	
	@Pointcut("within(net.tiaozhanbei.service..*)")
	private void inservice(){}
	
	
	@Pointcut("execution(public * *(..))")
	private void anyPublic(){}
	
	
	@Pointcut("anyPublic() && indao()")
	private void time(){}
	
	@Before("time()")
	public void tickerstart(JoinPoint jp){
		System.out.println("before:"+ jp.getSignature().getName()+" "+new Date());
	}
	
	
	
	@After("time()")
	public void tickerend(){
		System.out.println("after:"+new Date());
	}
	*/
}
