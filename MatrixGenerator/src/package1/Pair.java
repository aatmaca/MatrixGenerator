package package1;

public class Pair {
	
	int p1;
	int p2;
	
	public Pair(int p1, int p2) {
		setP1(p1);
		setP2(p2);
	}

	public int getP1() {
		return p1;
	}

	public void setP1(int p1) {
		this.p1 = p1;
	}

	public int getP2() {
		return p2;
	}

	public void setP2(int p2) {
		this.p2 = p2;
	}
	
	@Override
	public boolean equals(Object obj) {
		Pair other = (Pair) obj;
		return other.getP1() == p1 && other.getP2() == p2;
	}
	
	@Override
	public int hashCode() {
		return (p1+"-"+p2).hashCode();
	}
}