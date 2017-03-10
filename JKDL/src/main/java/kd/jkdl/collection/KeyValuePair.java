package main.java.kd.jkdl.collection;

/**
 * Basic IKeyValuePair implementation.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 *
 * @param <K> Key type
 * @param <V> Value type
 */
public class KeyValuePair<K, V> implements IKeyValuePair<K, V>
{
	private static final long serialVersionUID = 5373275311348844489L;
	
	/**
	 * Key
	 */
	protected K key;
	
	/**
	 * Value
	 */
	protected V value;
	
	public KeyValuePair(K key, V value)
	{
		this.key = key;
		this.value = value;
	}
	
	public K getKey() 
	{
		return key;
	}
	
	public V getValue() 
	{
		return value;
	}
	
	public int compareTo(IKeyValuePair<K, V> o) 
	{
		if(this.key == o.getKey())
		{
			if(this.value == o.getValue())
			{
				return 0;
			}
		}
		return -1;
	}
}