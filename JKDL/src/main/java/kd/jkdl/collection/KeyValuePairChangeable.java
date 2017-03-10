package main.java.kd.jkdl.collection;

/**
 * Basic IKeyValuePairChangeable implementation.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 *
 * @param <K> Key type
 * @param <V> Value type
 */
public class KeyValuePairChangeable<K, V> extends KeyValuePair<K, V> implements IKeyValuePairChangeable<K, V>
{
	private static final long serialVersionUID = 7084874415333594580L;

	public KeyValuePairChangeable(K key, V value) 
	{
		super(key, value);
	}
	
	public boolean canChangeKey() 
	{
		return false;
	}
	
	public boolean canChangeValue() 
	{
		return true;
	}
	
	public void setNewKey(K newKey) 
	{
		if(canChangeKey())
		{
			this.key = newKey;
		}
	}
	
	public void setNewValue(V newValue) 
	{
		if(canChangeValue())
		{
			this.value = newValue;
		}
	}
}