package test.aoptest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class DebugTipHandler implements InvocationHandler{

	private Object delegete;
	
	public Object bind(Object interfaceImpl){
		delegete = interfaceImpl;
		return Proxy.newProxyInstance(delegete.getClass().getClassLoader(),
				delegete.getClass().getInterfaces(),this);
	}
	
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object object = null;
		System.out.println("现在正在执行虚假的测试类方法");
		try {
			object = method.invoke(delegete, args);
		} catch (Exception e) {
			System.out.println("此方法不返回值");
		}
		System.out.println("已结束测试方法");
		return object;
	}

	public static void main(String[] args){
	//	IUserService service = (IUserService)new DebugTipHandler().bind(
	//			new FakeUserService());
	//	service.addUser(new User());
	}
}
/*
import java.lang.reflect.InvocationHandler;
2import java.lang.reflect.Method;
3import java.lang.reflect.Proxy;
4
5
6public class MyProxy {
7    
8    public static void main (String[] args){
9        BusinessInterface businessImpl=new BusinessImpl();
10        
11        InvocationHandler handler = new LogHandler(businessImpl);
12        
13        BusinessInterface proxy= (BusinessInterface) Proxy.newProxyInstance(
14                businessImpl.getClass().getClassLoader(),
15                businessImpl.getClass().getInterfaces(),
16                handler);
17        
18        proxy.processBusiness();
19        
20    }
21}
22
23interface BusinessInterface{
24    public  void processBusiness();
25}
26
27class BusinessImpl implements BusinessInterface{
28
29    public void processBusiness() {
30        // TODO Auto-generated method stub
31        System.out.println("Processing business logic ");
32    }
33}
34
35class LogHandler implements InvocationHandler {
36    
37    private Object delegate;
38    public LogHandler(Object delegate){
39        this.delegate=delegate;
40    }
41
42    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
43        // TODO Auto-generated method stub
44        Object o=null;
45        try{
46            System.out.println("INFO Begin ");
47            o=method.invoke(delegate, args);
48            System.out.println("INFO End ");
49        }catch (Exception e){
50            System.out.println("INFO Exception ");
51        }
52        return o;
53    }
54}*/