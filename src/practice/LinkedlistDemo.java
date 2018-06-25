package practice;
import java.util.*;
public class LinkedlistDemo {

	public static void main(String[] args) {
		LinkedList<String> c = new LinkedList();
		c.add("Indonesia");
		c.addFirst("India");
		c.add(1,"Japan");
		c.add("USA");
		c.addLast("Germany");
		c.add("China");
		System.out.println("The top most economies are " + c);
		
		c.remove(4);
		c.remove(2);
		c.remove("Japan");
		System.out.println("Best economies are : " + c);
		
		ListIterator ltr = c.listIterator();
		
		ltr.add("Pakistan");
		System.out.println(" economies are : " + c);
		ltr.next();
		ltr.set("Afghan");
		ltr.previous();
		ltr.set("India");
		ltr.add("Russia");
		System.out.println("Best economies are : " + c);
		

	}

}
