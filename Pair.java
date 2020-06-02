package coding.graph;

public class Pair implements Comparable{
	private Integer a;
	private Integer b;
	public Pair(Integer a, Integer b) {
		this.a = a;
		this.b = b;
	}
	public Integer getA() {
		return a;
	}
	public void setA(Integer a) {
		this.a = a;
	}
	public Integer getB() {
		return b;
	}
	public void setB(Integer b) {
		this.b = b;
	}
	public int compare(Pair p1, Pair p2) {
		return p1.a.compareTo(p2.a);
	}
	@Override
	public int compareTo(Object o1) {
		return 0;
	}
}
