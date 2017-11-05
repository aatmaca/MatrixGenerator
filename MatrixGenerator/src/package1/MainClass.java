package package1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainClass {

	public static int numberOfProposals = 40;
	public static int numberOfReferees = 10;
	public static int capacity = numberOfProposals / 2;
	public static int numberOfMatrices = 10;

	public static void main(String[] args) {

		// MATRIX REPRESENTATION
		// new int[ROWS][COLS];
		// int[][] a = new int[2][4]; --Two rows and four columns.
		//
		// a[0][0] a[0][1] a[0][2] a[0][3]
		// a[1][0] a[1][1] a[1][2] a[1][3]

		int nSquare = numberOfProposals * numberOfProposals;
		int numberOfPairsOfProposals = (numberOfProposals * (numberOfProposals - 1)) / 2;

		int sum = 0;
		System.out.println("C(n,2)-----(n*n)-----numberOfTrials");
		for (int i = 0; i < numberOfMatrices; i++) {

			int[][] matrix = generateMatrix(numberOfProposals, capacity, numberOfReferees);

			// Helper.printMatrix(matrix);
			// printMatrix2(matrix);

			int numberOfTrials = coverAllPairsOfProposals(matrix, numberOfReferees, numberOfProposals, numberOfPairsOfProposals);

			System.out.println("  " + numberOfPairsOfProposals + " ----- " + nSquare + "  ----- " + numberOfTrials);
			sum += numberOfTrials;
		}

		System.out.println("--------------------------");
		System.out.println("             Average:  " + sum / numberOfMatrices);
	}

	public static int[][] generateMatrix(int proposalCount, int capacity, int refereeCount) {
		int[][] matrix = new int[refereeCount][proposalCount];

		for (int i = 0; i < refereeCount; i++) {
			List<Integer> selectedRandomNumbers = new ArrayList<Integer>();
			for (int j = 0; j < capacity; j++) {
				matrix[i][Helper.distinctRandomIndexGenerator(selectedRandomNumbers, proposalCount)] = 1;
			}
		}

		return matrix;
	}

	private static int coverAllPairsOfProposals(int[][] matrix, int numberOfReferees, int numberOfProposals, int numberOfPairsOfProposals) {

		int numberOfTrials = 0;
		Set<Pair> pairList = new HashSet<Pair>();

		while (pairList.size() < numberOfPairsOfProposals) {

			int row = Helper.randomIndexGenerator(numberOfReferees);
			int p1 = Helper.randomIndexGenerator(numberOfProposals);
			int p2;
			do {
				p2 = Helper.randomIndexGenerator(numberOfProposals);
			} while (p1 == p2);

			if (matrix[row][p1] == 1 && matrix[row][p2] == 1) {
				if (p1 < p2) {
					pairList.add(new Pair(p1, p2));
				} else {
					pairList.add(new Pair(p2, p1));
				}
			}

			numberOfTrials++;
			if (numberOfTrials > 500000) {
				return -1;
			}
		}

		return numberOfTrials;
	}
}