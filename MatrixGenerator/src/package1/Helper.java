package package1;

import java.util.List;

public class Helper {

	// generate a random integer between 0 (including) and n (excluding).
	public static Integer randomIndexGenerator(int n) {
		return (int) (Math.random() * n);
	}

	public static int distinctRandomIndexGenerator(List<Integer> alreadySelectedRandomNumbers, int n) {

		Integer randomNumber = null;
		do {
			randomNumber = randomIndexGenerator(n);
		} while (alreadySelectedRandomNumbers.contains(randomNumber));

		alreadySelectedRandomNumbers.add(randomNumber);

		return randomNumber.intValue();
	}

	public static void printMatrix(int[][] matrix) {
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				System.out.printf("%4d", matrix[row][col]);
			}
			System.out.println();
		}
	}

	public static void printMatrix2(int[][] matrix) {
		try {
			int rows = matrix.length;
			int columns = matrix[0].length;
			String str = "|\t";

			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < columns; j++) {
					str += matrix[i][j] + "\t";
				}

				System.out.println(str + "|");
				str = "|\t";
			}

		} catch (Exception e) {
			System.out.println("Matrix is empty!!");
		}
	}
}
