package main.java.kd.jkdl.collection;

import java.util.Collection;
import java.util.Deque;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Spliterator;
import java.util.Stack;

/**
 * Bidirectional Map
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 *
 * @param <K> Key type
 * @param <V> Value type
 */
public interface IBiMap<K, V> extends Map<K, V>, Comparable<IBiMap<K, V>>, Cloneable
{
	/**
	 * Adds key with value.
	 */
	public void add(K key, V value);
	
	/**
	 * Get value from key.
	 */
	public V getValue(K key);
	
	/**
	 * Get key for value.
	 */
	public K getKey(V value);
	
	/**
	 * Returns pair from the specified index.
	 */
	public IKeyValuePair<K, V> getPairAt(int index) throws IndexOutOfBoundsException;
	
	/**
	 * Returns index of the specified key.
	 */
	public int indexOf(K key);
	
	/**
	 * Returns the index of the specified pair.
	 */
	public int indexOf(IKeyValuePair<K, V> pair);
	
	/**
	 * Returns the pair that has been removed from Map.
	 */
	public IKeyValuePair<K, V> removeAt(int index);
	
	//============================================================================================
	
	/**
	 * Returns this Map but with switched positions for keys and values.
	 */
	public IBiMap<V, K> reposition();
	
	//============================================================================================
	
	/**
	 * Returns keys as list.
	 */
	public List<K> getKeysList();
	
	/**
	 * Returns values as list.
	 */
	public List<V> getValuesList();
	
	/**
	 * Returns keys as set.
	 */
	public Set<K> getKeysSet();
	
	/**
	 * Returns values as set.
	 */
	public Set<V> getValuesSet();
	
	/**
	 * Returns keys as deque.
	 */
	public Deque<K> getKeysDeque();
	
	/**
	 * Returns values as deque.
	 */
	public Deque<V> getValuesDeque();
	
	/**
	 * Returns keys as queue.
	 */
	public Queue<K> getKeysQueue();
	
	/**
	 * Returns values as queue.
	 */
	public Queue<V> getValuesQueue();
	
	/**
	 * Returns keys as stack.
	 */
	public Stack<K> getKeysStack();
	
	/**
	 * Returns values as stack.
	 */
	public Stack<V> getValuesStack();
	
	/**
	 * Returns keys as basic collection
	 */
	public Collection<K> getKeysCollecion();
	
	/**
	 * Returns values as basic collection.
	 */
	public Collection<V> getValuesCollection();
	
	/**
	 * Returns keys as iterator.
	 */
	public Iterator<K> getKeysIterator();
	
	/**
	 * Returns values as iterator.
	 */
	public Iterator<V> getValuesIterator();
	
	/**
	 * Returns keys enumeration.
	 */
	public Enumeration<K> getKeysEnumeration();
	
	/**
	 * Returns values enumeration.
	 */
	public Enumeration<V> getValuesEnumeration();
	
	/**
	 * Returns keys as list iterator.
	 */
	public ListIterator<K> getKeysListIterator();
	
	/**
	 * Returns values as list iterator.
	 */
	public ListIterator<V> getValuesListIterator();
	
	/**
	 * Returns keys as spliterator.
	 */
	public Spliterator<K> getKeysSpliterator();
	
	/**
	 * Returns values as spliterator.
	 */
	public Spliterator<V> getValuesSpliterator();
}