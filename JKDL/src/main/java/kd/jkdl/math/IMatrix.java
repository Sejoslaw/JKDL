package main.java.kd.jkdl.math;

/**
 * Matrix definition.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 *
 * @param <T> Matrix type
 */
public interface IMatrix<T> 
{
	/**
	 * @return Width of the Matrix.
	 */
	public int getWidth();
	
	/**
	 * @return Height of the Matrix.
	 */
	public int getHeight();
	
	/**
	 * @return The Matrix itself.
	 */
	public T[][] getMatrix();
	
	/**
	 * @param x Number of the columns.
	 * @return The column[x].
	 */
	public T[] getColumn(int x);
	
	/**
	 * @param y The number of the rows.
	 * @return The row[y].
	 */
	public T[] getRow(int y);
	
	/**
	 * @param width
	 * @param height
	 * @return The element at the position Matrix[width][height].
	 */
	public T getElementAt(int width, int height);
	
	/**
	 * @param width
	 * @param height
	 * @param newElement New element which should be placed on (width, height) place in Matrix.
	 */
	public void setElementAt(int x, int y, T newElement);
	
	/**
	 * @param m1 Matrix to add
	 * @return this + m1
	 */
	public IMatrix<T> add(IMatrix<T> m1);
	
	/**
	 * @param m1 Matrix to add
	 * @return this * m1
	 */
	public IMatrix<T> multiply(IMatrix<T> m1);
}