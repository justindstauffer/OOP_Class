package module6generics;
import java.util.*;

public class generics <T, V> {
	
	ArrayList<T> collection = new ArrayList<>();
	
	@SuppressWarnings("unchecked")
	public int findIndex(T t, V theElement) {
		
		collection = (ArrayList<T>) t;
		
		if( t == null) {
			return -1;
		}
		
		int tLength = collection.size();
		int i = 0;
		
		while(i < tLength) {
			if (collection.get(i) == theElement) {
				return i;
			}
			else {
				i++;
			}
		}
		return -1;
	}
	

	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		generics<ArrayList, Integer> tester = new generics<>();
		
		ArrayList<Integer> test = new ArrayList<>();
		test.add(0);
		test.add(2);
		test.add(4);
		test.add(6);
		
		int result = tester.findIndex(test, 6);
		
		System.out.println("The number 6 is in position: " + result);
		
	}
		

}
