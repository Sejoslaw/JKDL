package main.java.kd.jkdl.collection;

import java.io.Serializable;

/**
 * Key value pair.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 *
 * @param <K> Key type
 * @param <V> Value type
 */
public interface IKeyValuePair<K, V> extends 
	Comparable<IKeyValuePair<K, V>>, Cloneable, Serializable
{
	/**
	 * Returns key.
	 */
	public K getKey();
	
	/**
	 * Returns value.
	 */
	public V getValue();
}