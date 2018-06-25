package practice;
import java.util.ArrayList;
public class ArraylistDemo {

	public static void main(String[] args) {
		ArrayList raw = new ArrayList();
		raw.add(1);
		raw.add("India");
		Object n = raw.get(0);
		int n1 = (int) raw.get(0);  
		
		
		ArrayList<Integer> normal = new ArrayList();
		normal.add(1);
		normal.add(0, 0);
		normal.add(2);
		for(int i = 0 ; i < normal.size() ; i ++) {
			System.out.println(normal.get(i));
		}

	}

}
