package main.java.kd.jkdl.collection;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.Spliterator;
import java.util.Stack;
import java.util.Vector;

/**
 * Looped collection is based on a normal list that can be search through iterator and never stops.
 * Iteration repeats each cycle over and over again. <br>
 * 
 * If You want to go through all the element once, use standard for loop: for(int i = 0; i < size(); ++i)
 * 
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 *
 * @param <T> Element type
 */
public class LoopedCollection<T> extends AbstractCollection<T> implements List<T>, Queue<T>, Set<T>
{
	/**
	 * All the basic elements are stored in {@link List};
	 */
	private final List<T> _list = new ArrayList<T>();
	
	//================================================================== AbstractCollection methods
	
	public boolean add(T e)
	{
		return this._list.add(e);
	}
	
	/**
     * @return Returns an iterator over the elements contained in this collection.
     * @see {@link Collection#iterator()}
     */
	public Iterator<T> iterator()
	{
		return new LoopedIterator(this);
	}
	
	public int size() 
	{
		return this._list.size();
	}
	
	/**
	 * LoopedCollection Iterator moves over and over through LoopedCollection elements.
	 * 
	 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
	 *
	 * @param <T> Element type
	 */
	class LoopedIterator implements Iterator<T>
	{
		private final LoopedCollection<T> _loopedColl;
		private int _index = -1;
		
		private LoopedIterator(LoopedCollection<T> loopedColl)
		{
			this._loopedColl = loopedColl;
		}
		
		/**
		 * As this is looped, there should always be next element.
		 * If currently checking element is last one, next element should be the first element.
		 * 
		 * @return Returns always true as the iteration never ends.
		 */
		public boolean hasNext() 
		{
			return true;
		}
		
		/**
		 * If it reaches the end it will start from the beginning.
		 * 
		 * @return Returns next element in iteration. 
		 * If the current element is the last one, this method in next step will return the first element.
		 * 
		 * @see Iterator#next()
		 */
		public T next() 
		{
			if(this._index >= this._loopedColl.size())
			{
				this._index = 1;
			}
			else
			{
				this._index++;
			}
			return this._loopedColl.get(this._index);
		}
	}
	
	//================================================================== List interface methods
	
	public boolean addAll(int index, Collection<? extends T> c) 
	{
		return this._list.addAll(index, c);
	}
	
	public T get(int index) 
	{
		return this._list.get(index % this._list.size());
	}
	
	public T set(int index, T element) 
	{
		return this._list.set(index % this._list.size(), element);
	}
	
	public void add(int index, T element) 
	{
		this._list.add(index % this._list.size(), element);
	}
	
	public T remove(int index) 
	{
		return this._list.remove(index % this._list.size());
	}
	
	public int indexOf(Object o) 
	{
		return this._list.indexOf(o);
	}
	
	public int lastIndexOf(Object o) 
	{
		return this._list.lastIndexOf(o);
	}
	
	public ListIterator<T> listIterator() 
	{
		return this._list.listIterator();
	}
	
	public ListIterator<T> listIterator(int index) 
	{
		return this._list.listIterator(index % this._list.size());
	}
	
	public List<T> subList(int fromIndex, int toIndex) 
	{
		List<T> newList = new ArrayList<>();
		for(int i = fromIndex; i < toIndex; ++i)
		{
			newList.add(this._list.get(i));
		}
		return newList;
	}
	
	//================================================================== Queue interface methods
	
	public boolean offer(T e) 
	{
		return this.add(e);
	}
	
	public T remove() 
	{
		T x = poll();
		if(x != null)
		{
			return x;
		}
		else
		{
			throw new NoSuchElementException();
		}
	}
	
	public T poll() 
	{
		for(int i = 0; i < this._list.size(); ++i)
		{
			T element = this._list.get(i);
			if(this._list.get(i) != null)
			{
				this._list.remove(i);
				return element;
			}
		}
		return null;
	}
	
	public T element() 
	{
		T x = peek();
		if(x != null)
		{
			return x;
		}
		else
		{
			throw new NoSuchElementException();
		}
	}
	
	public T peek() 
	{
		for(int i = 0; i < this._list.size(); ++i)
		{
			T element = this._list.get(i);
			if(this._list.get(i) != null)
			{
				return element;
			}
		}
		return null;
	}
	
	//================================================================== Set interface methods
	
	public Spliterator<T> spliterator() 
	{
		return this._list.spliterator();
	}
	
	//================================================================== Additional converting methods
	
	/**
	 * @return Returns this collection in form of {@link Stack}.
	 */
	public Stack<T> toStack()
	{
		Stack<T> stack = new Stack<>();
		for(int i = 0; i < this._list.size(); ++i)
		{
			stack.push(this._list.get(i));
		}
		return stack;
	}
	
	/**
	 * @return Returns this collection in form of {@link Vector}.
	 */
	public Vector<T> toVector()
	{
		Vector<T> v = new Vector<>();
		for(int i = 0; i < this._list.size(); ++i)
		{
			v.add(this._list.get(i));
		}
		return v;
	}
	
	/**
	 * @return Returns this collection in form of {@link List}. This will return new {@link List}.
	 * Changes won't be applied to internal elements.
	 */
	public List<T> toList()
	{
		List<T> l = new ArrayList<>();
		for(int i = 0; i < this._list.size(); ++i)
		{
			l.add(this._list.get(i));
		}
		return l;
	}
	
	/**
	 * @return Returns this collection in form of {@link Map}. 
	 * Key is a position of the list and value is an object on that position.
	 */
	public Map<Integer, T> toMap()
	{
		Map<Integer, T> map = new HashMap<>();
		for(int i = 0; i < this._list.size(); ++i)
		{
			map.put(i, this._list.get(i));
		}
		return map;
	}
	
	//================================================================== Static creation
	
	/**
	 * @return Returns new LoopedCollection.
	 */
	public static <T> LoopedCollection<T> newCollection()
	{
		return new LoopedCollection<T>();
	}
}