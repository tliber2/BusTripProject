package stuff;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException{
		Scanner kin = new Scanner(System.in);
		int choice = 0;
		String userInput = "";
		String passwordInput;
		Database main = new Database("admin", "1234");
		int ageInput;
		String numberInput;
		String nameInput;
		boolean facultyDiscount = false;
		String arrivalLocInput;
		String departureLocInput;
		String arrivalTime;
		String departureTime;
		String arrivalDate;
		String  priceInput;
		boolean tripFound = false;
		boolean ticketPurchased = false;
		
		System.out.println("Welcome to Sareen and Thomas's final project for CS125. "
		+ "This is a bus trip program that lets users book bus trips across multiple destinations.\n\n");
		System.out.println("Please login or create an account:\n 1. Login \n 2. Create Account\n3. Admin Login");
		//kin.nextLine();
		choice = kin.nextInt();
		if(choice == 1){
			if(Database.login() == true){
				System.out.println("What would you like to do?\n1.Buy a trip ticket\n2.See purchased tickets\n 3.See user info");
				choice = kin.nextInt();
				if(choice == 1){
					Scanner sc = new Scanner(new File("tripinfo.txt"));
					List<String> lines = new ArrayList<String>();
					while (sc.hasNextLine()) {
					  lines.add(sc.nextLine());
					  //System.out.println("1");
					}

					String[] arr = lines.toArray(new String[0]);
					
					for(int i = 0; i < arr.length; i++){
						//System.out.println("1");
						if(arr[i] != null && ticketPurchased == false){
							String[] temp = arr[i].split("\\$");
							for(int j = 0; j < temp.length; j++){
								System.out.print(temp[j] + "\n");
								
							}
							System.out.println("Would you like to purchase?\n1.Yes\n2.No");
							choice = kin.nextInt();
							if(choice == 1){
								System.out.println("Great, we'll add you to the list. ");
								Database.addTripToProfile(Database.userInput);
								ticketPurchased = true;
							}
							
						}
						
					}
				}else if(choice == 2){
					tripFound = false;
					Scanner sc = new Scanner(new File("ticketinfo.txt"));
					List<String> lines = new ArrayList<String>();
					while (sc.hasNextLine()) {
					  lines.add(sc.nextLine());
					}

					String[] arr = lines.toArray(new String[0]);
					for(int i = 0; i < arr.length; i++){
						if(arr[i].contains(userInput)){
							
							Scanner sc2 = new Scanner(new File("tripinfo.txt"));
							List<String> lines2 = new ArrayList<String>();
							while (sc2.hasNextLine()) {
							  lines2.add(sc2.nextLine());
							}
							String[] arr2 = lines2.toArray(new String[0]);
							for(int j = 0; j < arr2.length;j++){
								
								String[] arr3 = arr[j].split("\\$");
								if(arr2[j].contains("tripID:" + arr3[arr3.length-1])){
									
									String[] arr4 = arr2[j].split("\\$");
									for(int y = 0; y < arr4.length; y++){
										System.out.println(arr4[y]+"\n");
									}
									
									tripFound = true;
								}
								if(tripFound == true)
									break;
							}
							if(tripFound == true)
								break;
						}
						if(tripFound == true){
							break;
						}
					}
					if(tripFound == false){
						System.out.println("Sorry, you have not purchased any tickets.");
					}
				}
				else if(choice == 3){
					Scanner sc = new Scanner(new File("logininfo.txt"));
					List<String> lines = new ArrayList<String>();
					while (sc.hasNextLine()) {
					  lines.add(sc.nextLine());
					}

					String[] arr = lines.toArray(new String[0]);
					for(int i = 0; i < arr.length; i++){
						if(arr[i].contains(Database.userInput)){
							String[] arr2 = arr[i].split("\\$");
							for(int j = 0; j < arr2.length; j++){
								System.out.println(arr2[j]+"\n");
							}
						}
					}
				}
			}
		}
		else if(choice == 2){
			System.out.print("Please enter your desired username below:\n");
			kin.nextLine();
			userInput = kin.nextLine();
			if(Database.checkUsername(userInput)){
				System.out.print("Great! That username is available. Now enter your password:\n");
				//kin.nextLine();
				passwordInput = kin.nextLine();
				System.out.print("Now enter your full name:\n");
				//kin.nextLine();
				nameInput = kin.nextLine();
				System.out.print("Please enter your age next:\n");
				//kin.nextLine();
				ageInput = kin.nextInt();
				System.out.print("Now enter your phone number:\n");
				kin.nextLine();
				numberInput = kin.nextLine();
				System.out.print("You're almost done! Are you a faculty member at a University?\n0.No\n1.Yes");
				//kin.nextLine();
				choice = kin.nextInt();
				
				if(choice == 1)
					facultyDiscount = true;
				
				Profile newUser = new Profile(nameInput, ageInput, numberInput, userInput, passwordInput, facultyDiscount);
				Database.addCommonUser(newUser);
				System.out.println("Congratulations! You've finished your account creation. Restart the program to login.");
		}
			
		
	}
		//final String arrivalLocation, final String departureLocation, final String arrivalTime, final String departureTime, final String arrivalDate, final String departureDate, 
		//final int rows, final int seats, final String price
		else if(choice == 3){
			kin.nextLine();
			if(Database.adminLogin()){
				System.out.println("What would you like to do?\n1.Add trip\n2.Remove trip");
				choice = kin.nextInt();
				if(choice == 1){
					System.out.println("Certainly. Enter the arrival location:");
					kin.nextLine();
					arrivalLocInput = kin.nextLine();
					System.out.println("Certainly. Enter the departure location:");
					departureLocInput = kin.nextLine();
					System.out.println("Certainly. Enter the departure time:");
					departureTime = kin.nextLine();
					System.out.println("Certainly. Enter the arrival time:");
					arrivalTime = kin.nextLine();
					System.out.println("Certainly. Enter the arrival date:");
					arrivalDate = kin.nextLine();
					System.out.println("Certainly. Enter the price:");
					priceInput = kin.nextLine();
					Trip input = new Trip(arrivalLocInput, departureLocInput, arrivalTime, departureTime, arrivalDate, priceInput);
					System.out.println("Sucessfully added.");
				}else if(choice == 2){
					System.out.println("What is the ID of the trip you want to delete?");
					int deletedTrip = kin.nextInt();
					File inputFile = new File("tripinfo.txt");
					File tempFile = new File("myTempFile.txt");

					BufferedReader reader = new BufferedReader(new FileReader(inputFile));
					BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

					String lineToRemove = "tripID:" + deletedTrip;
					String currentLine;

					while((currentLine = reader.readLine()) != null) {
					    // trim newline when comparing with lineToRemove
					    String trimmedLine = currentLine.trim();
					    if(trimmedLine.contains(lineToRemove)) continue;
					    writer.write(currentLine + System.getProperty("line.separator"));
					}
					writer.close(); 
					reader.close(); 
					boolean successful = tempFile.renameTo(inputFile);
					
					
				}
			}
			
			
		}

		
}
}