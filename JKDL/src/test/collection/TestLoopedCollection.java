package test.collection;

import main.java.kd.jkdl.collection.LoopedCollection;

/**
 * This test shows how iterator will go over and over again through the LoopedCollection
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class TestLoopedCollection 
{
	public static void main(String[] args) 
	{
		LoopedCollection<Integer> lc = new LoopedCollection<>();
		lc.add(1);
		lc.add(2);
		lc.add(3);
		for(Integer i : lc)
		{
			System.out.println(i);
		}
	}
}