package practice;

import java.util.*;
import practice.Details;

public class Crud {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		Details sachin = new Details("Sachin", "mi", 45);
		Details dhoni = new Details("Dhoni", "csk", 35);
		Details kohli = new Details("Kohli","rcb",28);

		HashMap<String, Details> player = new HashMap<>();

		//Adding player details
		player.put(sachin.getName(), sachin);
		player.put(dhoni.getName(), dhoni);
		player.put(kohli.getName(), kohli);
		boolean check = false;
		do {
			System.out.println("MENU \n");
			System.out.println("Retrieve Player : 1");
			System.out.println("Update a Player : 2");
			System.out.println("Delete a Player : 3");
			System.out.println("Print    Players: 4");
			System.out.print("\n Please Enter your Choice : ");
			int input = a.nextInt();
			switch (input) {
			case 1:
				retrievePlayer(player);
				break;
			case 2:
				updatePlayer(player);
				break;
			case 3:
				deletePlayer(player);
				break;
			case 4:
				System.out.println("All Player Records " + player);
			}
			String empty = a.nextLine();
			System.out.println("Do you want to continue: Enter 'y' for Yes and 'n' for Exit :");
			String yesNo = a.nextLine();
			
			if (yesNo.equals("y")) {
				check = false;
			} if(yesNo.equals("n")) {
				check = true;
				System.out.println("Thank you");
			}
		} while (check == false);
	}

	public static void retrievePlayer(HashMap<String, Details> m) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the name of player you want to retrieve : ");
		String search = sc.nextLine();
		if (m.containsKey(search)) {
			System.out.println(m.get(search));
		} else {
			System.out.println("Player not present . Invalid Player");
		}
	}

	public static void updatePlayer(HashMap<String, Details> m) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the name of the player you want to update the details : ");
		String up = sc.nextLine();
		if (m.containsKey(up)) {
			System.out.println("To change Team name of Player: 1");
			System.out.println("To change   Age     of Player: 2");
			System.out.print("\n Enter your choice : ");
			int choice = sc.nextInt();
			String empty = sc.nextLine();
			switch (choice) {

			case 1:
				System.out.print("Enter new team name of Player : ");
				String newTeam = sc.nextLine();
				m.get(up).setTeam(newTeam);
				break;
			case 2:
				System.out.print("Enter new Age of Player : ");
				int newAge = sc.nextInt();
				m.get(up).setAge(newAge);
			}
		}
		else {
			System.out.println("Player doesn't exist. Enter a valid name");
		}
	}

	public static void deletePlayer(HashMap<String, Details> m) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the name of Player you want to delete : ");
		String delPlayer = sc.nextLine();
		if(m.containsKey(delPlayer)) {
			m.remove(delPlayer);
			System.out.println("Records of player " + delPlayer + " deleted");
		}
		else {
			System.out.println("Player doesn't exist. Enter a valid name");
		}
	}

}
