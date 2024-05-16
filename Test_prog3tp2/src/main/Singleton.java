package main;

import java.lang.reflect.GenericDeclaration;

public class Singleton<T>
{
	private static T instance = null;
	
	public static T getlnstance()
	{
		if (instance == null)
			instance = new Singleton<T>();
		return instance;
	}
}
