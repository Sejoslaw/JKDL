package main.java.kd.jkdl.logicgate;

/**
 * TODO: Create all basic logic gates.
 * 
 * Determines basics of each logic gate.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzy�ski</a> -> https://github.com/Sejoslaw
 */
public interface ILogicGate<T>
{
	/**
	 * @param object Object which will be determined.
	 * 
	 * @return Return TRUE if given object can be treated as Zero, otherwise FALSE.
	 */
	public abstract boolean isZero(T object);
	
	/**
	 * @param object Object which will be determined.
	 * 
	 * @return Return TRUE if given object can be treated as One, otherwise FALSE.
	 */
	public abstract boolean isOne(T object);
	
	/**
	 * @param input Input objects.
	 * 
	 * @return Return the result of this logic gate based on given input.
	 */
	@SuppressWarnings("unchecked")
	public abstract T result(T... input);
}