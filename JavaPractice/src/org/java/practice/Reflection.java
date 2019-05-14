package org.java.practice;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection {

	public static void main(String args[]) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		A rf = new A();
		
		Class cls = rf.getClass();
		System.out.println("The name of the class is "+cls.getName());
		
		Constructor cons = cls.getConstructor();
		System.out.println("The name of the constructor is "+cons);
		
		Method[] methods = cls.getMethods();
		
		for(Method method : methods) {
			System.out.println(method.getName());
		}
		
		Method methodCall1 = cls.getDeclaredMethod("method2", int.class);
		methodCall1.invoke(rf, 19);
		
		Field field = cls.getDeclaredField("s");
		field.setAccessible(true);
		
		field.set(rf, "Java");
		
		Method methodCall2 = cls.getDeclaredMethod("method1");
		methodCall2.invoke(rf);
		
		Method methodCall3 = cls.getDeclaredMethod("method3");
		methodCall3.setAccessible(true);
		methodCall3.invoke(rf);
	}
}
