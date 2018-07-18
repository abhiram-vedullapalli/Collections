package practice;

import java.util.*;
import practice.Details;

public class Crud extends StringConversion {
	static HashMap<String, Details> players = new HashMap<>();
	static Crud play = new Crud();

	public static void main(String[] args) {

		displayMenu();
	}

	public static void displayMenu() {
		Scanner a = new Scanner(System.in);
		boolean check = false;
		do {
			System.out.println("MENU \n");
			System.out.println("Create a Player : 1");
			System.out.println("Retrieve Player : 2");
			System.out.println("Update a Player : 3");
			System.out.println("Delete a Player : 4");
			System.out.println("List all Players: 5");
			System.out.print("\n Please Enter your Choice : ");

			try {
				int input = a.nextInt();
				switch (input) {
				case 1:
					createPlayer();
					break;
				case 2:
					retrievePlayer();
					break;
				case 3:
					updatePlayer();
					break;
				case 4:
					deletePlayer();
					break;
				case 5:
					listAllPlayers();
				}

			} catch (InputMismatchException e) {
				System.out.println("Option you entered is not present in the Menu. Enter a valid option");
				displayMenu();
			}

			String empty = a.nextLine();
			System.out.println("Do you want to perform another operation: Enter 'y' for Yes and 'n' for Exit :");
			String yesNo = a.nextLine();

			if (yesNo.equals("y")) {
				check = false;
			}
			if (yesNo.equals("n")) {
				check = true;
				System.out.println("Thank you");
			}
		} while (check == false);
	}

	public static void createPlayer() {
		Scanner sc = new Scanner(System.in);
		boolean check = false;
		do {

			System.out.print("Enter Name of Player : ");
			String noCaseName = sc.nextLine();
			String name = play.anyCase(noCaseName);
			System.out.print("Enter Team of Player : ");
			String noCaseTeam = sc.nextLine();
			String team = play.anyCase(noCaseTeam);
			System.out.print("Enter Age of Player : ");
			int age = sc.nextInt();
			if (age > 40) {
				System.out.println("\n Players whose age is above 40 are not selected \n");
				System.out.print("Enter Age again : ");
				int age1 = sc.nextInt();
				age = age1;
			}
			String empty = sc.nextLine();

			players.put(name, new Details(name, team, age));
			System.out.println("Do you want to create another Player : If Yes enter 'y' else 'n' ");
			String yesNo = sc.nextLine();

			if (yesNo.equals("y")) {
				check = false;
			}
			if (yesNo.equals("n")) {
				check = true;
			}
		} while (check == false);

	}

	public static void retrievePlayer() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the name of player you want to retrieve : ");
		String noCaseSearch = sc.nextLine();
		String search = play.anyCase(noCaseSearch);
		if (players.containsKey(search)) {
			System.out.println(players.get(search));
		} else {
			System.out.println("Player not present . Invalid Player");
		}
	}

	public static void updatePlayer() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the name of the player you want to update the details : ");
		String noCaseUpdate = sc.nextLine();
		String update = play.anyCase(noCaseUpdate);
		if (players.containsKey(update)) {
			System.out.println("To change Team name of Player: 1");
			System.out.println("To change   Age     of Player: 2");
			System.out.print("\n Enter your choice : ");
			try {
				int choice = sc.nextInt();
				String empty = sc.nextLine();
				switch (choice) {

				case 1:
					System.out.print("Enter new team name of Player : ");
					String newTeam = sc.nextLine();
					players.get(update).setTeam(newTeam);
					break;
				case 2:
					System.out.print("Enter new Age of Player : ");
					int newAge = sc.nextInt();
					if (newAge > 40) {
						System.out.println("Players whose age is 40 or greater than 40 are retired");
						System.out.print("Enter Age again : ");
						int age = sc.nextInt();
						newAge = age;
					}
					players.get(update).setAge(newAge);
				}
			} catch (InputMismatchException e) {
				System.out.println("Option you entered is invalid. Enter the option in the Menu");
				updatePlayer();
			}
		} else {
			System.out.println("Player not present. Invalid player");
		}

	}

	public static void deletePlayer() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the name of Player you want to delete : ");
		String noCaseDelPlayer = sc.nextLine();
		String delPlayer = play.anyCase(noCaseDelPlayer);
		if (players.containsKey(delPlayer)) {
			players.remove(delPlayer);
			System.out.println("Records of player " + delPlayer + " deleted");
		} else {
			System.out.println("Player doesn't exist. Enter a valid name");
		}
	}

	public static void listAllPlayers() {
		System.out.println("\n DETAILS OF ALL PLAYERS \n");
		for (HashMap.Entry<String, Details> entry : players.entrySet()) {
			System.out.println(entry.getValue());

		}
	}

	@Override
	// whatever the case , the user may give his inputs.
	// this function converts input such that (Starting letter of every word in
	// string is in upper case)
	// this helps while retrieving and updating the data from the Hashmap
	String anyCase(String s) {
		char[] c = s.toCharArray();
		for(int i =0; i < s.length(); i++) {
			c[i] = Character.toLowerCase(c[i]);
		}
		c[0] = Character.toUpperCase(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			if (c[i] == ' ') {
				c[i + 1] = Character.toUpperCase(c[i + 1]);
			}
		}
		return String.valueOf(c);
		

	}

}
