package main.java.kd.jkdl.math;

/**
 * Vector definition.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 * 
 * @param <T> Vector type
 */
public interface IVector<T> 
{
	/**
	 * @return Return Vector
	 */
	public T[] getVector();

	/**
	 * @return Element at the given index
	 */
	public T getElementAt(int index) 
			throws IndexOutOfBoundsException;
	
	/**
	 * Sets the Element at given index.
	 */
	public void setElementAtIndex(int index, T newElement) 
			throws IndexOutOfBoundsException;
	
	/**
	 * this + vectorToAdd
	 * @return this
	 */
	public IVector<T> add(IVector<T> vectorToAdd);
	
	/**
	 * this - vectorToSubstract
	 * @return This
	 */
	public IVector<T> substract(IVector<T> vectorToSubstract);

	/**
	 * this * vertorToMultiplyBy
	 * @return This
	 */
	public IVector<T> multiply(IVector<T> vertorToMultiplyBy);
	
	/**
	 * this / vectorToDivideBy
	 * @return This
	 */
	public IVector<T> divide(IVector<T> vectorToDivideBy);
}