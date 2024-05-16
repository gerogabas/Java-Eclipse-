package main;

public class Singleton<T> {
	
	private T instance = null;
	
	public T getInstance() {
		if (instance == null)
			instance = (T) new Singleton<T>();
		return instance;
	}
}
