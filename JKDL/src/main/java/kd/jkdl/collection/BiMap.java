package main.java.kd.jkdl.collection;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.Stack;
import java.util.Vector;

/**
 * Basic bidirectional map implementation.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 *
 * @param <K> Key type
 * @param <V> Value type
 */
public class BiMap<K, V> implements IBiMap<K, V>
{
	/**
	 * Map itself.
	 */
	protected Map<K, V> map = new HashMap<K, V>();
	
	public int size() 
	{
		return map.size();
	}
	
	public boolean isEmpty() 
	{
		return map.isEmpty();
	}
	
	public boolean containsKey(Object key) 
	{
		return map.containsKey(key);
	}
	
	public boolean containsValue(Object value) 
	{
		return map.containsValue(value);
	}
	
	public V get(Object key) 
	{
		return map.get(key);
	}
	
	public V put(K key, V value) 
	{
		return map.put(key, value);
	}
	
	public V remove(Object key) 
	{
		return map.remove(key);
	}
	
	public void putAll(Map<? extends K, ? extends V> m) 
	{
		map.putAll(m);
	}
	
	public void clear() 
	{
		map.clear();
	}
	
	public Set<K> keySet() 
	{
		return map.keySet();
	}
	
	public Collection<V> values() 
	{
		return map.values();
	}
	
	public Set<Entry<K, V>> entrySet() 
	{
		return map.entrySet();
	}
	
	public void add(K key, V value) 
	{
		map.put(key, value);
	}
	
	public V getValue(K key) 
	{
		return map.get(key);
	}
	
	public K getKey(V value) 
	{
		for(Entry<K, V> entry : map.entrySet())
		{
			if(entry.getValue() == value)
			{
				return entry.getKey();
			}
		}
		return null;
	}
	
	public IKeyValuePair<K, V> getPairAt(int index)
	{
		if(index < 0 || index > map.size())
		{
			throw new IndexOutOfBoundsException();
		}
		int i = 0;
		for(Entry<K, V> entry : map.entrySet())
		{
			if(i == index)
			{
				return new KeyValuePair<K, V>(entry.getKey(), entry.getValue());
			}
			i++;
		}
		return null;
	}
	
	public int indexOf(K key) 
	{
		int i = 0;
		for(Entry<K, V> entry : map.entrySet())
		{
			if(entry.getKey() == key)
			{
				return i;
			}
			i++;
		}
		return -1;
	}
	
	public int indexOf(IKeyValuePair<K, V> pair) 
	{
		int i = 0;
		for(Entry<K, V> entry : map.entrySet())
		{
			if(entry.getKey() == pair.getKey())
			{
				if(entry.getValue() == pair.getValue())
				{
					return i;
				}
			}
			i++;
		}
		return -1;
	}
	
	public IKeyValuePair<K, V> removeAt(int index) 
	{
		int i = 0;
		for(Entry<K, V> entry : map.entrySet())
		{
			if(i == index)
			{
				IKeyValuePair<K, V> removed = new KeyValuePair<K, V>(entry.getKey(), entry.getValue());
				map.remove(entry.getKey(), entry.getValue());
				return removed;
			}
			i++;
		}
		return null;
	}
	
	public IBiMap<V, K> reposition() 
	{
		IBiMap<V, K> repositioned = new BiMap<V, K>();
		for(Entry<K, V> entry : map.entrySet())
		{
			repositioned.put(entry.getValue(), entry.getKey());
		}
		return repositioned;
	}
	
	public List<K> getKeysList() 
	{
		List<K> list = new ArrayList<K>();
		list.addAll(map.keySet());
		return list;
	}
	
	public List<V> getValuesList() 
	{
		List<V> list = new ArrayList<V>();
		list.addAll(map.values());
		return list;
	}
	
	public Set<K> getKeysSet() 
	{
		return map.keySet();
	}
	
	public Set<V> getValuesSet() 
	{
		Set<V> set = new HashSet<V>();
		set.addAll(map.values());
		return set;
	}
	
	public Deque<K> getKeysDeque() 
	{
		Deque<K> deque = new ArrayDeque<K>();
		deque.addAll(map.keySet());
		return deque;
	}
	
	public Deque<V> getValuesDeque() 
	{
		Deque<V> deque = new ArrayDeque<V>();
		deque.addAll(map.values());
		return deque;
	}
	
	public Queue<K> getKeysQueue() 
	{
		Queue<K> queue = new PriorityQueue<K>();
		queue.addAll(map.keySet());
		return queue;
	}
	
	public Queue<V> getValuesQueue() 
	{
		Queue<V> queue = new PriorityQueue<V>();
		queue.addAll(map.values());
		return queue;
	}
	
	public Stack<K> getKeysStack() 
	{
		Stack<K> stack = new Stack<K>();
		stack.addAll(map.keySet());
		return stack;
	}
	
	public Stack<V> getValuesStack() 
	{
		Stack<V> stack = new Stack<V>();
		stack.addAll(map.values());
		return stack;
	}
	
	public Collection<K> getKeysCollecion() 
	{
		Collection<K> col = new ArrayList<K>();
		col.addAll(map.keySet());
		return col;
	}
	
	public Collection<V> getValuesCollection() 
	{
		return map.values();
	}
	
	public Iterator<K> getKeysIterator() 
	{
		return map.keySet().iterator();
	}
	
	public Iterator<V> getValuesIterator() 
	{
		return map.values().iterator();
	}
	
	public Enumeration<K> getKeysEnumeration() 
	{
		Vector<K> v = new Vector<K>();
		v.addAll(map.keySet());
		return v.elements();
	}
	
	public Enumeration<V> getValuesEnumeration() 
	{
		Vector<V> v = new Vector<V>();
		v.addAll(map.values());
		return v.elements();
	}
	
	public ListIterator<K> getKeysListIterator() 
	{
		return getKeysList().listIterator();
	}
	
	public ListIterator<V> getValuesListIterator() 
	{
		return getValuesList().listIterator();
	}
	
	public Spliterator<K> getKeysSpliterator() 
	{
		return Spliterators.spliterator(map.keySet(), 0);
	}
	
	public Spliterator<V> getValuesSpliterator() 
	{
		return Spliterators.spliterator(map.values(), 0);
	}
	
	public int compareTo(IBiMap<K, V> o) 
	{
		if(o != null)
		{
			List<K> oKeys = o.getKeysList();
			List<V> oValues = o.getValuesList();
			List<K> keys = getKeysList();
			List<V> values = getValuesList();
			for(int i = 0; i < keys.size(); i++)
			{
				if(keys.get(i) != oKeys.get(i))
				{
					if(values.get(i) != oValues.get(i))
					{
						return -1;
					}
				}
			}
			return 0;
		}
		return -1;
	}
}