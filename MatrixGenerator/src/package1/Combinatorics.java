package package1;

class Combinatorics {

	public static long combination(long n, long r) {
		if (n >= r) {
			return permutation(n, r) / getFact(r);			
		} else
			throw new RuntimeException("r cannot be greater than n");
	}

	public static long permutation(long n, long r) {
		if (n >= r) {
			long f = 1;

			for (long i = n; i >= 1; i--) {
				f *= i;
				r--;
				if (r == 0) {
					break;
				}
			}

			return f;
		} else
			throw new RuntimeException("r cannot be greater than n");
	}

	public static long getFact(long n) {
		long f = 1;

		for (long i = n; i >= 1; i--) {
			f *= i;
		}

		return f;
	}
}