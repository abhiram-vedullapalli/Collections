package practice;
import java.util.Collections;
import java.util.*;
public class IteratorDemo {
	public static void main(String[] args) {
		
		//Enumeration example with legacy collection Vector
		
		Vector<Integer> v = new Vector<Integer>(5);
		v.add(0);
		v.add(1);
		v.add(2);
		v.add(0, 1);
		v.add(3);
		Enumeration<Integer> e = v.elements();
		if(e.hasMoreElements() == true) {
			System.out.println(e.nextElement());
			System.out.println(e.nextElement());
			System.out.println(e.nextElement());
			System.out.println(e.nextElement());
			System.out.println(e.nextElement());
		}
		
		//Iterator example with Arraylist
		
		ArrayList<String> arr = new ArrayList<String>(3);
		arr.add("Sachin");
		arr.add("Zaheer");
		arr.add("Dhoni");
		Iterator<String> it = arr.iterator();
	    for(int i = 0 ; i < arr.size() ; i ++) {
	    	if(it.hasNext() == true) {
	    		System.out.println(it.next());
	    		it.remove();
	    	}
	    }
	    
	   System.out.println(arr.size());
	}
}
