package stuff;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Database {

	private static Trip[] TripDatabase;
	private static Profile[] CommonUsers;
	private static Profile[] AdminUsers;
	static Scanner kin = new Scanner(System.in);
	public static String userInput;
	static String passwordInput;
	static int choice;
	static String path = "logininfo.txt";
	static boolean admin = false;
	static boolean edDis;
	static int id;
	
	//Constructor Function
	public Database(String username, String password) throws IOException{
		TripDatabase = new Trip[1000];
		CommonUsers = new Profile[1000];
		AdminUsers = new Profile[1000];
		
		
		String info = username + "$" + password;
	    BufferedWriter writer = new BufferedWriter(new FileWriter("admininfo.txt", true));
	    writer.append(info + "\n");
	     
	    writer.close();
	
	}
	
	public static void writeToFile(String username, String password, String name, int age, String mobileNumber, boolean edDiscount)
		throws IOException {
		edDis = edDiscount;
		String info = username + "$" + password + "$" + name + "$" + age + "$" + mobileNumber + "$" + edDiscount;
	    BufferedWriter writer = new BufferedWriter(new FileWriter("logininfo.txt", true));
	    writer.append(info + "\n");
	     
	    writer.close();
	}
	
	public static void addTripToProfile(String username) throws IOException{
		String info = username + "$" + id;
		
		
	    BufferedWriter writer = new BufferedWriter(new FileWriter("ticketinfo.txt", true));
	    writer.append(info + "\n");
	     
	    writer.close();
	}
	
	public static void writeAdminToFile(String username, String password)
			throws IOException {
			String info = username + "$" + password;
		    BufferedWriter writer = new BufferedWriter(new FileWriter("logininfo.txt", true));
		    writer.append(info + "\n");
		     
		    writer.close();
		}
	
	public static void writeTripToFile(String arrivalLoc, String arrivalDest, String departureTime, String arrivalTime, String tripDate, String price)
			throws IOException {
		
		if(Profile.getAge() >= 65 || edDis == true)
			price += .75;
			
			String info = arrivalLoc + "$" + arrivalDest + "$" + departureTime + "$" + arrivalTime + "$" + tripDate + "$" + price + "$" + "tripID:";
		    BufferedWriter writer = new BufferedWriter(new FileWriter("tripinfo.txt", true));
		    writer.append(info);	     
		    writer.close();
		    
		    Scanner sc = new Scanner(new File("tripinfo.txt"));
			List<String> lines = new ArrayList<String>();
			while (sc.hasNextLine()) {
			  lines.add(sc.nextLine());
			  //System.out.println("1");
			}

			String[] arr = lines.toArray(new String[0]);
			id = arr.length;
			
			BufferedWriter writer2 = new BufferedWriter(new FileWriter("tripinfo.txt", true));
			writer2.append("" + id + "\n");	     
		    writer2.close();
		    
		}
	
	//Instance Methods
	public static void addTrip(final Trip newTrip) throws IOException {
		for (int i=0; i<TripDatabase.length; i++ ) {
			if(TripDatabase[i] == null) {
				TripDatabase[i] = newTrip;
				writeTripToFile(TripDatabase[i].getArrivalLocation(), TripDatabase[i].getDepartureLocation(), TripDatabase[i].getDepartureTime(), TripDatabase[i].getArrivalTime(), TripDatabase[i].getArrivalDate(), TripDatabase[i].getPrice());
				break;
			}
		}
	}
	public static void addCommonUser(final Profile CommonUser) throws IOException {
		for (int i=0; i<CommonUsers.length; i++ ) {
			if(CommonUsers[i] == null) {
				CommonUsers[i] = CommonUser;
				writeToFile(CommonUsers[i].getUsername(), CommonUsers[i].getPassword(), CommonUsers[i].getName(), CommonUsers[i].getAge(), CommonUsers[i].getMobileNumber(), CommonUsers[i].getEducationalDiscount());
				break;
			}
		}
	}
	public static void addAdminUser(final Profile AdminUser) throws IOException {
		for (int i=0; i<AdminUsers.length; i++ ) {
			if(AdminUsers[i] == null) {
				AdminUsers[i] = AdminUser;
				writeAdminToFile(AdminUsers[i].getUsername(), AdminUsers[i].getPassword());
				break;
			}
		}
	}
	
	public static boolean checkUsername(String check) throws FileNotFoundException{
		
		Scanner sc = new Scanner(new File("logininfo.txt"));
		List<String> lines = new ArrayList<String>();
		while (sc.hasNextLine()) {
		  lines.add(sc.nextLine());
		}

		String[] arr = lines.toArray(new String[0]);
		
		for(int i = 0; i < arr.length; i++){
			if(arr[i].contains(check)){
				System.out.println("That username is taken, sorry");
				return false;
			}
		}
		return true;
	}
	
	public Profile[] getUsers(){
		return CommonUsers;
	}
	
	public static boolean login() throws FileNotFoundException{
		boolean loggedIn = false;
		System.out.print("Please enter your username below: ");
		//kin.nextLine();
		userInput = kin.nextLine();
		System.out.print("Please enter your password below: ");
		//kin.nextLine();
		passwordInput = kin.nextLine();
		
		//System.out.println("1");
		Scanner sc = new Scanner(new File("logininfo.txt"));
		List<String> lines = new ArrayList<String>();
		while (sc.hasNextLine()) {
		  lines.add(sc.nextLine());
		  //System.out.println("1");
		}

		String[] arr = lines.toArray(new String[0]);
		
		for(int i = 0; i < arr.length; i++){
			//System.out.println("1");
			if(arr[i].contains(userInput + "$" + passwordInput)){
				System.out.println("Logged in!");
				loggedIn = true;
				break;
			}
		}
		
		if(!loggedIn){
		System.out.println("Username/Password combination not found.");
		return false;
		}else{
			return true;
		}
		
	}
	
	public static boolean adminLogin() throws FileNotFoundException{
		boolean loggedIn = false;
		System.out.print("Please enter your username below: ");
		//kin.nextLine();
		userInput = kin.nextLine();
		System.out.print("Please enter your password below: ");
		//kin.nextLine();
		passwordInput = kin.nextLine();
		
		//System.out.println("1");
		Scanner sc = new Scanner(new File("admininfo.txt"));
		List<String> lines = new ArrayList<String>();
		while (sc.hasNextLine()) {
		  lines.add(sc.nextLine());
		  //System.out.println("1");
		}

		String[] arr = lines.toArray(new String[0]);
		
		for(int i = 0; i < arr.length; i++){
			//System.out.println("1");
			if(arr[i].contains(userInput + "$" + passwordInput)){
				System.out.println("Logged in!");
				admin = true;
				break;
			}
		}
		
		if(!admin){
		System.out.println("Username/Password combination not found.");
		return false;
		}else{
			return true;
		}
		
	}
	
	
}
