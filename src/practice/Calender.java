package practice;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Calender {
public static void main(String[] args) throws ParseException {
	Map<Date,Map<String,String>> calender=new HashMap();
   Scanner sc=new Scanner(System.in);
   //enter the no of dates
   int n=sc.nextInt();
  
   for(int i=0;i<n;i++)
   {
	//enter the date
	     Date date=null;
	   //String formatDate=null;
	   String dateString=sc.next();
	   DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	   try {
		  date= df.parse(dateString);
		  System.out.println("Date is "+date);
		  //formatDate=df.format(date);
		  
	   }
	   catch ( Exception ex ){
	        System.out.println(ex);
	    }
	  // Date date1=new SimpleDateFormat("dd-MM-yyyy").parse(date);  
	  // System.out.println(date);
	   //enter the no of events
	   System.out.println("enter the no of events");
	   int e=sc.nextInt();
	   Map<String,String> events=new LinkedHashMap<String,String>();
	   for(int j=0;j<e;j++)
	   {
		   System.out.println("enter the event name");
		   String eventName=sc.next();
		   System.out.println("enter the time");
		   String eventTime=sc.next();
		   
		  
		   events.put(eventName, eventTime);
	   }
	   calender.put(date,events);
	   
   }
//   System.out.println(calender);
   System.out.println("Nishanth enters the date");
   String userDate=sc.next();
   Date date1=null;
   DateFormat df1 = new SimpleDateFormat("dd-MM-yyyy");
   try {
	  date1= df1.parse(userDate);
	  //System.out.println("Date is "+date);
	  //formatDate=df.format(date);
	  
   }
   catch ( Exception ex ){
        System.out.println(ex);
    }
   System.out.println("Nishanth's date is "+date1);
   
   Set<Date> keys=calender.keySet();
   for(Date key:keys)
   {
	   if(key==date1) {
	   Map<String, String> value=calender.get(key);
	   System.out.println(value); 
	   }
	   
   }
   
   


}
}
