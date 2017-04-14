package main.java.kd.jkdl.system;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * This class provide various method for reflection operations and Class operations.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class ClassUtils 
{
	private ClassUtils()
	{
	}
	
	/**
	 * 
	 * @param className
	 * @param fieldName
	 * 
	 * @return Returns the Field object from the given class name and name of this field.
	 * 
	 * @throws ClassNotFoundException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 */
	public static Field getField(String className, String fieldName) 
			throws ClassNotFoundException, NoSuchFieldException, SecurityException
	{
		return getField(className, fieldName, true);
	}
	
	/**
	 * 
	 * @param className
	 * @param fieldName
	 * @param accessible
	 * 
	 * @return Returns the Field object from the given class name and name of this field.
	 * 
	 * @throws ClassNotFoundException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 */
	public static Field getField(String className, String fieldName, boolean accessible)
			throws ClassNotFoundException, NoSuchFieldException, SecurityException
	{
		Class<?> clazz = Class.forName(className);
		Field field = clazz.getField(fieldName);
		field.setAccessible(accessible);
		return field;
	}
	
	/**
	 * 
	 * @param className
	 * @param fieldName
	 * @param isStatic
	 * 
	 * @return Returns the value from the specified class for the specified field name.
	 * 
	 * @throws ClassNotFoundException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public static Object getFieldObject(String className, String fieldName, boolean isStatic)
			throws ClassNotFoundException, NoSuchFieldException, SecurityException, InstantiationException, IllegalAccessException
	{
		Class<?> clazz = Class.forName(className);
		Object instance = clazz.newInstance();
		Field field = clazz.getField(fieldName);
		if(isStatic)
		{
			return field.get(null);
		}
		else
		{
			return field.get(instance);
		}
	}
	
	/**
	 * 
	 * @param className
	 * @param methodName
	 * @param params
	 * 
	 * @return Returns the Method object from the specified class name, method name and parameters of this method.
	 * 
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	public static Method getMethod(String className, String methodName, Class<?>[] params) 
			throws ClassNotFoundException, NoSuchMethodException, SecurityException
	{
		Class<?> clazz = Class.forName(className);
		return clazz.getMethod(methodName, params);
	}
	
	/**
	 * 
	 * @param className
	 * @param methodName
	 * @param params
	 * @param args
	 * @param isStatic
	 * 
	 * @return Returns the Method object from the specified class name, method name, parameters of this method and if this method is static.
	 * 
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static Object getMethodReturn(String className, String methodName, Class<?>[] params, Object[] args, boolean isStatic)
			throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, 
			IllegalArgumentException, InvocationTargetException
	{
		Class<?> clazz = Class.forName(className);
		Object instance = clazz.newInstance();
		Method method = clazz.getMethod(methodName, params);
		if(isStatic)
		{
			return method.invoke(null, args);
		}
		else
		{
			return method.invoke(instance, args);
		}
	}
	
	/**
	 * @param className
	 * @param interfaceName
	 * 
	 * @return Returns the if the specified class implements specified interface.
	 * 
	 * @throws ClassNotFoundException
	 */
	public static boolean isClassImplementingInterface(String className, String interfaceName) 
			throws ClassNotFoundException
	{
		Class<?> clazz = Class.forName(className);
		return clazz.isAssignableFrom(Class.forName(interfaceName));
	}
	
	/**
	 * 
	 * @param className
	 * @param fieldName
	 * 
	 * @return Returns true if the specified class contains object named "INSTANCE" and returns the value from the specified field name.
	 * 
	 * @throws ClassNotFoundException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 */
	public static Object getFieldFromStaticInstance(String className, String fieldName) 
			throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException
	{
		Class<?> clazz = Class.forName(className);
		Object INSTANCE = clazz.getField("INSTANCE").get(null);
		return clazz.getField(fieldName).get(INSTANCE);
}
}