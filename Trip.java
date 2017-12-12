package stuff;

import java.io.IOException;

public class Trip {

	private String arrivalLocation;
	private String departureLocation;
	private String arrivalTime;
	private String departureTime;
	private String arrivalDate;
	private String departureDate;
	private String price;
	private static int totalTrips;
	public int tripNumber;
	private int seats = 40;
	
	public Trip(final String arrivalLocation, final String departureLocation, final String arrivalTime, final String departureTime, final String arrivalDate, 
			final String price) throws IOException {
		this.setArrivalLocation(arrivalLocation);
		this.setDepartureLocation(departureLocation);
		this.setArrivalTime(arrivalTime);
		this.setDepartureTime(departureTime);
		this.setArrivalDate(arrivalDate);
		this.setDepartureDate(departureDate);
		
		this.setPrice(price);
		totalTrips++;
		this.setTripNumber(totalTrips);
		Database.addTrip(this);
	}
	
	//Setter Functions
	public void setArrivalLocation(final String arrival) {
		this.arrivalLocation = arrival;
	}
	public void setDepartureLocation(final String departure) {
		this.departureLocation = departure;
	}
	public void setArrivalTime(final String time) {
		this.arrivalTime = time;
	}
	public void setDepartureTime(final String time) {
		this.departureTime = time;
	}
	public void setArrivalDate(final String date) {
		this.arrivalDate = date;
	}
	public void setDepartureDate(final String date) {
		this.departureDate = date;
	}
	public void addSeat() {
		seats--;
	}
	public void setPrice(final String price) {
		this.price = price;
	}
	public void setTripNumber(final int trip) {
		this.tripNumber = trip;
	}
	
	//Getter Functions
	public String getArrivalLocation() {
		return this.arrivalLocation;
	}
	public String getDepartureLocation() {
		return this.departureLocation;
	}
	public String getArrivalTime() {
		return this.arrivalTime;
	}
	public String getDepartureTime() {
		return this.departureTime;
	}
	public String getArrivalDate() {
		return this.arrivalDate;
	}
	public String getDepartureDate() {
		return this.departureDate;
	}
	public String getPrice() {
		return this.price;
	}
	public int getTripNumber() {
		return this.tripNumber;
	}
	
}
