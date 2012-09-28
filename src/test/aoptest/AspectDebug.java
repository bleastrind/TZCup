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
		System.out.println("ִ��test���е������ķ����У�");
	}
	@After("execution(* test.fake.*.*(..))")
	public void debugFinished(){
		System.out.println("����෽��ִ����ϣ�");
	}
	*/
}
