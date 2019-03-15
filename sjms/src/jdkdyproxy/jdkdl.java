package jdkdyproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import jdkdyproxy.proxy.User;
import jdkdyproxy.proxy.UserImpl;

public class jdkdl implements InvocationHandler{

	private Object jdkdl;
	

	public jdkdl(Object target) {
		this.jdkdl= target;
	}


	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("������������");
		Object invoke = method.invoke(jdkdl, args);
		System.out.println("����");
		return invoke;
	}
	
	public static void main(String[] args) {
		User user=new UserImpl();
		jdkdl jdkdl=new jdkdl(user);
		//����user
		ClassLoader classLoader=user.getClass().getClassLoader();
		//���ؽӿ�
		Class<?>[] interfaces = user.getClass().getInterfaces();
		//����ʵ��
		User User=(jdkdyproxy.proxy.User) Proxy.newProxyInstance(classLoader, interfaces, jdkdl);
		User.add();
	}

}
