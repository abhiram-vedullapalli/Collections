package practice;
import java.util.*;
import practice.Hotel;
public class Book {
	static ArrayList<Hotel> hotels = new ArrayList<Hotel>();
   public static void main(String[] args) {
	   Hotel h1 = new Hotel(1);
	   Hotel h2 = new Hotel(3);
	   Hotel h3 = new Hotel(1);
	   Hotel h4 = new Hotel(3);

	   
	   hotels.add(h1);
	   hotels.add(h2);
	   hotels.add(h3);
	   hotels.add(h4);
	   
	   ArrayList<Hotel> result = filterHotel(1);
   }
   
   public static ArrayList<Hotel> filterHotel(int r ){
	   ArrayList<Hotel> dummy = hotels;
	   	ArrayList<Hotel> result = new ArrayList<>();  
	   	   for(int i = 0; i < dummy.size() ; i++) {
	   		   if(dummy.get(i).getRating() == r) {
	   			   result.add(dummy.get(i));
	   			   System.out.println(dummy.get(i));
	   		   }
	   	   }
	return result;
	   
   }
}
