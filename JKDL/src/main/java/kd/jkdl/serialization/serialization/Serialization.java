package main.java.kd.jkdl.serialization.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Basic implementation of {@link ISerialization}
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 *
 * @param <T> Generic parameter which will determine the type of serializing objects
 * 
 * @see ISerialization
 */
public class Serialization<T extends Serializable> implements ISerialization<T>
{
	private static final long serialVersionUID = -7204745499800838021L;
	
	private Map<String, T> serializationMap;
	
	public Serialization()
	{
		serializationMap = new HashMap<String, T>();
	}
	
	public void addObject(String key, T value)
	{
		serializationMap.put(key, value);
	}
	
	public T get(String key)
	{
		return serializationMap.get(key);
	}
	
	public Map<String, T> getObjectMap()
	{
		return serializationMap;
	}
	
	public void changeValue(String key, T newValue)
	{
		serializationMap.replace(key, newValue);
	}
	
	public void serialize(String fileName) throws IOException
	{
		serialize(new File(fileName));
	}
	
	public void serialize(File file) throws IOException
	{
		if(!file.exists())
		{
			file.createNewFile();
		}
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(serializationMap);
		oos.flush();
		oos.close();
		fos.close();
	}
	
	public void deserialize(String fileName) throws IOException, ClassNotFoundException
	{
		deserialize(new File(fileName));
	}
	
	@SuppressWarnings("unchecked")
	public void deserialize(File file) throws IOException, ClassNotFoundException
	{
		if(!file.exists())
		{
			return;
		}
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		serializationMap = (Map<String, T>) ois.readObject();
		ois.close();
		fis.close();
	}
}