package practice;

import java.util.*;
import java.text.*;

public class Events {

	static HashMap<Date, Map<String, String>> events = new LinkedHashMap<>();

	public static void main(String[] args) {
		menu();
		System.out.println(events);
	}

	public static void menu() {
		Scanner sc = new Scanner(System.in);
		boolean check = false;
		do {
			System.out.println("CALENDAR \n");
			System.out.println("Add a new event to Calendar : Press 1");
			System.out.println("Retrieve event details : Press 2");
			System.out.print("\n Please Enter your Choice : ");

			try {
				int userChoice = sc.nextInt();
				switch (userChoice) {
				case 1:
					addEvent();
					break;
				case 2:
					retrieveEvent();
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Option you entered is not present in the Menu. Enter a valid option");
				menu();
			}

			String empty = sc.nextLine();
			System.out.println("Do you want to perform another operation: Enter 'y' for Yes and 'n' for Exit :");
			String yesNo = sc.nextLine();

			if (yesNo.equals("y")) {
				check = false;
			}
			if (yesNo.equals("n")) {
				check = true;
				System.out.println("Thank you");
			}
		} while (check == false);

	}

	public static void addEvent() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Event Date (Like this format 12/08/2018) : ");
		String eDate = sc.nextLine();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date eventDate = null;
		try {
			eventDate = formatter.parse(eDate);
		} catch (ParseException e) {
			System.out.println("Date not entered as in prescribed format");
			retrieveEvent();
		}
		System.out.print("Enter Event Name : ");
		String eName = sc.nextLine();
		System.out.print("Enter Event Time (Like this format: 5PM, 10AM) : ");
		String eTime = sc.nextLine();
		Map<String, String> eventOrder = new LinkedHashMap<>();
		eventOrder.put(eName, eTime);
		events.put(eventDate, eventOrder);
	}

	public static void retrieveEvent() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Event Date (Like this format 12/08/2018) : ");
		String eDate = sc.nextLine();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date eventDate = null;
		try {
			eventDate = formatter.parse(eDate);
		} catch (ParseException e) {
			System.out.println("Date not entered as in prescribed format");
			retrieveEvent();
		}
		if(events.containsKey(eventDate)) {
			System.out.println("The Event scheduled on " + eventDate + " are : " + events.get(eventDate));
			
		}else {
			System.out.println("There are no Events scheduled on the given date");
		}
	}
}
