package june.th.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 */
public class InvocationHandler2 implements InvocationHandler{

	private Object obj;

	public Object bind(Object obj)
	{
		this.obj = obj;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), (java.lang.reflect.InvocationHandler) this);
	}
	
	public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		Object temp = method.invoke(this.obj, args);
		return temp;
	}
}
