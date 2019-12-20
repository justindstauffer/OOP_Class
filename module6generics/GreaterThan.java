package module6generics;

public class GreaterThan <T, V> {
	
	public interface Comparable<T> {
		public int compareTo(T o);
	}
	
	public static <T extends Comparable<T>> T greaterThan(T a, T b) {
		if (a.compareTo(b) > 0) {
			return a;
		}
		if (b.compareTo(a) > 0) {
			return b;
		}
		return null;
	}
	
	

}
