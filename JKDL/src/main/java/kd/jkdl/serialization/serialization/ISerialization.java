package main.java.kd.jkdl.serialization.serialization;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

/**
 * Base interface for all the serializing types.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 *
 * @param <T> Generic parameter which will determine the type of serializing objects
 */
public interface ISerialization<T extends Serializable> extends Serializable
{
	/**
	 * Add object to stored {@link Map}.
	 */
	void addObject(String key, T value);
	
	/**
	 * Returns the value based on the given key.
	 */
	T get(String key);
	
	/**
	 * Returns the {@link Map} with all previously added objects.
	 */
	Map<String, T> getObjectMap();
	
	/**
	 * Change the stored value to new one, at the given key.
	 */
	void changeValue(String key, T newValue);
	
	/**
	 * Serialize the stored {@link Map} to {@link File} based on given fileName.
	 */
	void serialize(String fileName) throws IOException;
	
	/**
	 * Serialize the stored {@link Map} to {@link File}.
	 */
	void serialize(File file) throws IOException;
	
	/**
	 * Deserialize the {@link Map} from {@link File} based on given fileName.
	 */
	void deserialize(String fileName) throws IOException, ClassNotFoundException;
	
	/**
	 * Deserialize the {@link Map} from {@link File}.
	 */
	void deserialize(File file) throws IOException, ClassNotFoundException;
}