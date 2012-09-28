package test.aoptest;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
@SuppressWarnings("unused")
public class AspectDebug {

	
	@Pointcut("within(test..*)")
	private void inTest(){}
	
	@Pointcut("execution(public * *(..))")
	private void anyPublic(){}
	
	@Pointcut("inTest() && anyPublic()")
	private void faketest(){}
	/*
	@Before("faketest()")
	public void debugTips(){
		System.out.println("执行test包中的虚假类的方法中！");
	}
	@After("execution(* test.fake.*.*(..))")
	public void debugFinished(){
		System.out.println("虚假类方法执行完毕！");
	}
	*/
}
