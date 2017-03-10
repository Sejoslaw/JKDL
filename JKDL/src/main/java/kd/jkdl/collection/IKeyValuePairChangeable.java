package main.java.kd.jkdl.collection;

/**
 * Key value pair with changeable value.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 *
 * @param <K> Key type
 * @param <V> Value type
 */
public interface IKeyValuePairChangeable<K, V> extends IKeyValuePair<K, V>
{
	/**
	 * Returns true if key in this pair can be changed.
	 */
	public boolean canChangeKey();
	
	/**
	 * Returns true if value in this pair can be changed.
	 */
	public boolean canChangeValue();
	
	/**
	 * Returns the old key.
	 */
	public void setNewKey(K newKey);
	
	/**
	 * Returns the old value.
	 */
	public void setNewValue(V newValue);
}