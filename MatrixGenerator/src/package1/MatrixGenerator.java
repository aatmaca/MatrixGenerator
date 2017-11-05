package package1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MatrixGenerator {

	public static int numberOfProposals = 100;
	public static int halfOfNumberOfReferees = 25;
	public static int numberOfReferees = 2 * halfOfNumberOfReferees;
	public static double p = 0.1;
	public static int capacity = (int) (numberOfProposals * p);
	public static int numberOfMatrices = 1000;

	public static void main(String[] args) {

		// MATRIX REPRESENTATION
		// new int[ROWS][COLS];
		// int[][] a = new int[2][4]; --Two rows and four columns.
		//
		// a[0][0] a[0][1] a[0][2] a[0][3]
		// a[1][0] a[1][1] a[1][2] a[1][3]

		int numberOfPairsOfProposals = (numberOfProposals * (numberOfProposals - 1)) / 2;

		int sum = 0;
		for (int i = 0; i < numberOfMatrices; i++) {

			int[][] matrix = generateMatrix(numberOfProposals, capacity, numberOfReferees);
			int numberOfPairs = numberOfPairsOfProposals(matrix, numberOfReferees, numberOfProposals);
			sum += numberOfPairs;
			System.out.println(numberOfPairsOfProposals + "  " + numberOfPairs);

			// Helper.printMatrix(matrix);
			// printMatrix2(matrix);
		}

		System.out.println("--------------------------numberOfPairsOfProposals : " + numberOfPairsOfProposals);
		System.out.println("             Average:  " + new Double(sum) / numberOfMatrices);
		System.out.println("             Sample Data Percentage:  " + (new Double(sum) / numberOfMatrices) / numberOfPairsOfProposals);
		System.out.println("             Proposed Percentage:  " + (new Double(1).doubleValue() - Math.pow((1 - p * p), numberOfReferees)));
	}

	public static int[][] generateMatrix(int proposalCount, int capacity, int refereeCount) {

		int[][] matrix = new int[refereeCount][proposalCount];

//		for (int i = 0; i < refereeCount / 2; i++) {
//
//			List<Integer> selectedRandomNumbers = new ArrayList<Integer>();
//			int numberOfAssociation = capacity + 1 * i;
//			for (int j = 0; j < numberOfAssociation; j++) {
//				matrix[2 * i][Helper.distinctRandomIndexGenerator(selectedRandomNumbers, proposalCount)] = 1;
//			}
//			selectedRandomNumbers = new ArrayList<Integer>();
//			numberOfAssociation = capacity - 1 * i;
//			for (int j = 0; j < numberOfAssociation; j++) {
//				matrix[2 * i + 1][Helper.distinctRandomIndexGenerator(selectedRandomNumbers, proposalCount)] = 1;
//			}
//		}
		
		for (int i = 0; i < refereeCount; i++) {
			List<Integer> selectedRandomNumbers = new ArrayList<Integer>();
			for (int j = 0; j < capacity; j++) {
				matrix[i][Helper.distinctRandomIndexGenerator(selectedRandomNumbers, proposalCount)] = 1;
			}
		}

		return matrix;
	}

	private static int numberOfPairsOfProposals(int[][] matrix, int numberOfReferees, int numberOfProposals) {

		Set<Pair> pairList = new HashSet<Pair>();

		for (int row = 0; row < numberOfReferees; row++) {
			for (int j = 0; j < numberOfProposals; j++) {

				if (matrix[row][j] == 1) {
					for (int k = j + 1; k < numberOfProposals; k++) {
						if (matrix[row][k] == 1) {
							pairList.add(new Pair(j, k));
						}
					}
				}

			}
		}

		return pairList.size();
	}
}