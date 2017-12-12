package stuff;

public class Profile {

	private String name;
	private int Year;
	private static int Age;
	private String mobileNumber;
	private String username;
	private String password;
	private boolean seniorCitizen;
	private boolean educationalDiscount;
	private static int totalUsers;
	private int memberID;

	public Profile(final String name, final int Age, final String mobileNumber, final String username, final String Password, final boolean edDiscount) {
		this.setName(name);
		this.setYear(Year);
		this.setAge(Age);
		this.setMobileNumber(mobileNumber);
		this.setUsername(username);
		this.setPassword(Password);
		
		if(Age >= 65)
			seniorCitizen = true;
		
		
		this.setEducationalDiscount(educationalDiscount);
		totalUsers++;
		this.setMemberID(totalUsers);
	}
	
	
	
	//Setter Functions
	public void setName(final String name) {
		this.name = name;
	}
	public void setYear(final int Year) {
		this.Year = Year;
	}
	public void setAge(final int Age) {
		this.Age = Age;
	}
	public void setMobileNumber(final String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public void setUsername(final String username) {
		this.username = username;
	}
	public void setPassword(final String password) {
		this.password = password;
	}
	public void setSeniorCitizen(final boolean seniorCitizen) {
		this.seniorCitizen = seniorCitizen;
	}
	public void setEducationalDiscount(final boolean educationalDiscount) {
		this.educationalDiscount = educationalDiscount;
	}
	public void setMemberID(final int memberID) {
		this.memberID = memberID;
	}
	
	//Getter Functions
	public String getName() {
		return this.name;
	}
	public int getYear() {
		return this.Year;
	}
	public static int getAge() {
		return Age;
	}
	public String getMobileNumber() {
		return this.mobileNumber;
	}
	public String getUsername() {
		return this.username;
	}
	public String getPassword() {
		return this.password;
	}
	public boolean getSeniorCitizen() {
		return this.seniorCitizen;
	}
	public boolean getEducationalDiscount() {
		return this.educationalDiscount;
	}
	public int getMemberID() {
		return this.memberID;
	}
	
	
}
