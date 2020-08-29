package edu.waketech.csc251.ticket.common;

public abstract class Ticket {
	private String venue;
	private String event;
	private String date;
	private double basePrice;

	public Ticket(String venue, String event, String date, double basePrice) {
		this.venue = venue;
		this.event = event;
		this.date = date;
		this.basePrice = basePrice;		
	}
	
	public String getVenue() {
		return venue;		
	}
	
	public String getEvent() {
		return event; 		
	}
	
	public String getDate() {
		return date;	
	}
	
	public double getBasePrice() {
		return basePrice;		
	}
	
	public int getNumberOfHolders() {
		return 1;	
	}
	
	public abstract double getPrice();

	@Override
	public String toString() {
		return "[Venue]: " +venue+ " [Event]: " +event+ " [Date]: " +date+ " [Base Price]: " +basePrice;
		
	}
}
