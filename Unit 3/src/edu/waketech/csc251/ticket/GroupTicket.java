package edu.waketech.csc251.ticket;

import edu.waketech.csc251.ticket.common.Ticket;

public class GroupTicket extends Ticket {
	private int quantity;
	private double discount;
	
	public GroupTicket(String venue, String event, String date, double basePrice, double discount, int quantity) {
		super(venue, event, date, basePrice);
		this.quantity = quantity;
		this.discount = discount;
	}

	@Override
	public double getPrice() {
		double bp = getBasePrice();
		return (bp * quantity) - (bp * quantity * discount);
	}
}
