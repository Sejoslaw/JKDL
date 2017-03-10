package main.java.kd.jkdl.math;

/**
 * Matrix operations.
 * 
 * @author <a href="mailto:k.dobrzynski94@gmail.com">Krzysztof Dobrzyñski</a> -> https://github.com/Sejoslaw
 */
public class MatrixHelper
{
	public static <T> int[][] setZeroOneMatrix(T[][] matrixT)
	{
		int[][] tab = new int[matrixT.length][matrixT[0].length];
		for(int i = 0; i < tab.length; i++)
		{
			for(int j = 0; j < tab[0].length; j++)
			{
				if(matrixT[i][j] == null)
				{
					tab[i][j] = 0;
				}
				else
				{
					tab[i][j] = 1;
				}
			}
		}
		return tab;
	}
	
	public static int[][] setZeroOneMatrix(int[][] matrixT)
	{
		int[][] tab = new int[matrixT.length][matrixT[0].length];
		for(int i = 0; i < tab.length; i++)
		{
			for(int j = 0; j < tab[0].length; j++)
			{
				if(matrixT[i][j] != 0)
				{
					tab[i][j] = 1;
				}
			}
		}
		return tab;
	}
	
	public static <T> Object[][] toObjectArraySquareMatrix(T[][] matrixT)
	{
		int size = matrixT.length;
		Object[][] arObj = new Object[size][size];
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
			{
				arObj[i][j] = (Object) matrixT[i][j];
			}
		}
		return arObj;
	}

	public static <T> Object[][] toObjectArray(T[][] matrixT)
	{
		int sizeY = matrixT.length;
		int sizeX = matrixT[0].length;
		Object[][] mat = new Object[sizeX][sizeY];
		for(int i = 0; i < sizeY; i++)
		{
			for(int j = 0; j < sizeX; j++)
			{
				mat[i][j] = (Object) matrixT[i][j];
			}
		}
		return mat;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T[][] reverseShapeVerticallySquareMatrix(T[][] matrixT)
	{
		Object[][] matrix = new Object[matrixT.length][matrixT.length];
		int matrixSize = matrixT.length;
		int rowSize = matrix[0].length - 1;
		for(int i = 0; i < matrixSize; i++)
		{
			for(int j = 0; j < matrixSize; j++)
			{
				matrix[i][j] = matrix[rowSize - 1 - i][j];
			}
		}
		for(int i = 0; i < matrixSize; i++)
		{
			for(int j = 0; j < matrixSize; j++)
			{
				matrixT[i][j] = (T) matrix[i][j];
			}
		}
		return matrixT;
	}
	
	public static <T> Object[][] reverseShapeVertically(T[][] matrixT)
	{
		int sizeY = matrixT.length;
		int sizeX = matrixT[0].length;
		Object[][] mat = new Object[sizeX][sizeY];
		for(int i = 0; i < sizeY; i++)
		{
			for(int j = 0; j < sizeX; j++)
			{
				mat[i][j] = (Object) matrixT[sizeX - 1 - i][j];
			}
		}
		return mat;
	}
	
	public static int[][] reverseShapeVertically(int[][] matrixT)
	{
		int sizeY = matrixT.length;
		int sizeX = matrixT[0].length;
		int[][] mat = new int[sizeX][sizeY];
		for(int i = 0; i < sizeY; i++)
		{
			for(int j = 0; j < sizeX; j++)
			{
				mat[i][j] = matrixT[sizeX - 1 - i][j];
			}
		}
		return mat;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T[][] reverseShapeHorizontallySquareMatrix(T[][] matrixT)
	{
		Object[][] matrix = new Object[matrixT.length][matrixT.length];
		int matrixSize = matrixT.length;
		int rowSize = matrix[0].length - 1;
		for(int i = 0; i < matrixSize; i++)
		{
			for(int j = 0; j < matrixSize; j++)
			{
				matrix[i][j] = matrix[i][rowSize - 1 - j];
			}
		}
		for(int i = 0; i < matrixSize; i++)
		{
			for(int j = 0; j < matrixSize; j++)
			{
				matrixT[i][j] = (T) matrix[i][j];
			}
		}
		return matrixT;
	}
	
	public static <T> Object[][] reverseShapeHorizontally(T[][] matrixT)
	{
		int sizeY = matrixT.length;
		int sizeX = matrixT[0].length;
		Object[][] mat = new Object[sizeX][sizeY];
		for(int i = 0; i < sizeY; i++)
		{
			for(int j = 0; j < sizeX; j++)
			{
				mat[i][j] = (Object) matrixT[i][sizeY - 1 - j];
			}
		}
		return mat;
	}
	
	public static int[][] reverseShapeHorizontally(int[][] matrixT)
	{
		int sizeY = matrixT.length;
		int sizeX = matrixT[0].length;
		int[][] mat = new int[sizeX][sizeY];
		for(int i = 0; i < sizeY; i++)
		{
			for(int j = 0; j < sizeX; j++)
			{
				mat[i][j] = matrixT[i][sizeY - 1 - j];
			}
		}
		return mat;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T[][] rotateRightSquareMatrix(T[][] matrixT)
	{
		Object[][] matrix = new Object[matrixT.length][matrixT.length];
		int matrixSize = matrixT.length;
		for(int i = 0; i < matrixSize; i++)
		{
			for(int j = 0; j < matrixSize; j++)
			{
				matrix[i][j] = matrixT[matrixSize - j - 1][i];
			}
		}
		for(int i = 0; i < matrixSize; i++)
		{
			for(int j = 0; j < matrixSize; j++)
			{
				matrixT[i][j] = (T) matrix[i][j];
			}
		}
		return matrixT;
	}
	
	public static int[][] rotateRightSquareMatrix(int[][] matrixT)
	{
		int[][] matrix = new int[matrixT.length][matrixT.length];
		int matrixSize = matrixT.length;
		for(int i = 0; i < matrixSize; i++)
		{
			for(int j = 0; j < matrixSize; j++)
			{
				matrix[i][j] = matrixT[matrixSize - j - 1][i];
			}
		}
		for(int i = 0; i < matrixSize; i++)
		{
			for(int j = 0; j < matrixSize; j++)
			{
				matrixT[i][j] = matrix[i][j];
			}
		}
		return matrixT;
	}
	
	public static <T> Object[][] rotateRight(T[][] matrixT)
	{
		int sizeY = matrixT.length;
		int sizeX = matrixT[0].length;
		Object[][] matrix = new Object[sizeX][sizeY];
		for(int i = 0; i < sizeY; i++)
		{
			for(int j = 0; j < sizeX; j++)
			{
				matrix[i][j] = matrixT[sizeY - j - 1][i];
			}
		}
		return matrix;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T[][] rotateLeftSquareMatrix(T[][] matrixT)
	{
		Object[][] matrix = new Object[matrixT.length][matrixT.length];
		int matrixSize = matrixT.length;
		for(int i = 0; i < matrixSize; i++)
		{
			for(int j = 0; j < matrixSize; j++)
			{
				matrix[i][j] = matrixT[j][matrixSize - i - 1];
			}
		}
		for(int i = 0; i < matrixSize; i++)
		{
			for(int j = 0; j < matrixSize; j++)
			{
				matrixT[i][j] = (T) matrix[i][j];
			}
		}
		return matrixT;
	}
	
	public static int[][] rotateLeftSquareMatrix(int[][] matrixT)
	{
		int[][] matrix = new int[matrixT.length][matrixT.length];
		int matrixSize = matrixT.length;
		for(int i = 0; i < matrixSize; i++)
		{
			for(int j = 0; j < matrixSize; j++)
			{
				matrix[i][j] = matrixT[j][matrixSize - i - 1];
			}
		}
		for(int i = 0; i < matrixSize; i++)
		{
			for(int j = 0; j < matrixSize; j++)
			{
				matrixT[i][j] = matrix[i][j];
			}
		}
		return matrixT;
	}
	
	public static <T> Object[][] rotateLeft(T[][] matrixT)
	{
		int sizeY = matrixT.length;
		int sizeX = matrixT[0].length;
		Object[][] matrix = new Object[sizeX][sizeY];
		for(int i = 0; i < sizeY; i++)
		{
			for(int j = 0; j < sizeX; j++)
			{
				matrix[i][j] = matrixT[j][sizeY - i - 1];
			}
		}
		return matrix;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T[][] transposeSquareMatrix(T[][] matrixT)
	{
		Object[][] matrix = new Object[matrixT.length][matrixT.length];
		int matrixSize = matrixT.length;
		for(int i = 0; i < matrixSize; i++)
		{
			for(int j = 0; j < matrixSize; j++)
			{
				matrix[i][j] = (Object) matrixT[j][i];
			}
		}
		return (T[][]) matrix;
	}
	
	public static int[][] transposeSquareMatrix(int[][] matrixT)
	{
		int[][] matrix = new int[matrixT.length][matrixT.length];
		int matrixSize = matrixT.length;
		for(int i = 0; i < matrixSize; i++)
		{
			for(int j = 0; j < matrixSize; j++)
			{
				matrix[i][j] = matrixT[j][i];
			}
		}
		return matrix;
	}
	
	public static <T> Object[][] transpose(T[][] matrixT)
	{
		int sizeY = matrixT.length;
		int sizeX = matrixT[0].length;
		Object[][] mat = new Object[sizeX][sizeY];
		for(int i = 0; i < sizeX; i++)
		{
			for(int j = 0; j < sizeY; j++)
			{
				mat[i][j] = (Object) matrixT[j][i];
			}
		}
		return mat;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T[][] rebuildMatrixAfterTransposition(T[][] matrix)
	{
		Object[][] objAr = transpose(matrix);
		return (T[][]) objAr;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T[][] toTArray(Object[][] matrixO)
	{
		return (T[][]) matrixO;
	}
	
	/**
	 * Czy macierz zwrotna
	 * 
	 * @return isMatrixReturnable ???
	 */
	public static <T> boolean isMatrixReflexive(T[][] matrixT)
	{
		for(int i = 0; i < matrixT.length; i++)
		{
			if(matrixT[i][i] == null)
			{
				return false;
			}
		}
		return true;
	}
	
	/**
	 * czyMacierzPrzeciwzwrotna
	 * 
	 * @return - isMatrixAntiReturnable ???
	 */
	public static <T> boolean isMatrixIrreflexive(T[][] matrixT)
	{
		for(int i = 0; i < matrixT.length; i++)
		{
			if(matrixT[i][i] != null)
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * matrixT[i][j].compareTo(matrixT[j][i]) != 0
	 * @param matrixT
	 * @return
	 */
	public static <T extends Comparable<T>> boolean isMatrixSymmetrical(T[][] matrixT)
	{
		for(int i = 0; i < matrixT.length; i++)
		{
			for(int j = i + 1; j < matrixT.length; j++)
			{
				if(matrixT[i][j].compareTo(matrixT[j][i]) != 0)
				{
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * matrixT[i][j] != matrixT[j][i]
	 * @param matrixT
	 * @return
	 */
	public static <T> boolean isMatrixSymmetrical2(T[][] matrixT)
	{
		for(int i = 0; i < matrixT.length; i++)
		{
			for(int j = i + 1; j < matrixT.length; j++)
			{
				if(matrixT[i][j] != matrixT[j][i])
				{
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * !(matrixT[i][j].equals(matrixT[j][i]))
	 * @param matrixT
	 * @return
	 */
	public static <T> boolean isMatrixSymmetrical3(T[][] matrixT)
	{
		for(int i = 0; i < matrixT.length; i++)
		{
			for(int j = i + 1; j < matrixT.length; j++)
			{
				if(!(matrixT[i][j].equals(matrixT[j][i])))
				{
					return false;
				}
			}
		}
		return true;
	}
	
	public static <T> boolean isMatrixAntySymmetrical(T[][] matrixT)
	{
		int[][] tab = setZeroOneMatrix(matrixT);
		for(int i = 0; i < tab.length; i++)
		{
			for(int j = 0; j < tab[0].length; j++)
			{
				if(tab[i][j] * tab[j][i] == 1)
				{
					return false;
				}
			}
		}
		return true;
	}
	
	public static <T extends Comparable<T>> T getMaxFromMatrix(T[][] matrixT)
	{
		T max = matrixT[0][0];
		int sizeY = matrixT.length;
		int sizeX = matrixT[0].length;
		for(int i = 0; i < sizeX; i++)
		{
			for(int j = 0; j < sizeY; j++)
			{
				if(max.compareTo(matrixT[i][j]) <= 0)
				{
					max = matrixT[i][j];
				}
			}
		}
		return max;
	}
	
	public static <T extends Comparable<T>> T getMinFromMatrix(T[][] matrixT)
	{
		T min = matrixT[0][0];
		int sizeY = matrixT.length;
		int sizeX = matrixT[0].length;
		for(int i = 0; i < sizeX; i++)
		{
			for(int j = 0; j < sizeY; j++)
			{
				if(min.compareTo(matrixT[i][j]) > 0)
				{
					min = matrixT[i][j];
				}
			}
		}
		return min;
	}
	
	public static int[][] multiply(int[][] mat1, int[][] mat2)
	{
		int sizeY = mat1.length;
		int sizeX = mat1[0].length;
		int tmp = 0;
		int[][] result = new int[sizeX][sizeY];
		for(int i = 0; i < sizeX; i++)
		{
			for(int j = 0; j < sizeX; j++)
			{
				tmp = 0;
				for(int k = 0; k < sizeY; k++)
				{
					tmp += mat1[k][j] * mat2[i][k];
				}
				result[i][j] = tmp;
			}
		}
		return result;
	}

	public static int[][] toThePowerOf(int[][] matrixT, int power)
	{
		int sizeY = matrixT.length;
		int sizeX = matrixT[0].length;
		int[][] result = new int[sizeX][sizeY];
		if(power == 1) return matrixT;
		if(power == 0) return result;
		if(power > 1)
		{
			result = multiply(matrixT, matrixT);
			for(int i = 0; i < power - 2; i++)
			{
				result = multiply(result, matrixT);
			}
		}
		return result;
	}
	
	public static <T> IMatrix<T> toThePowerOf(IMatrix<T> matrixT, int power)
	{
		if(power == 1) return matrixT;
		if(power == 0) return null;
		if(power > 1)
		{
			matrixT = matrixT.multiply(matrixT);
			for(int i = 0; i < power - 2; i++)
			{
				matrixT = matrixT.multiply(matrixT);
			}
		}
		return matrixT;
	}
}