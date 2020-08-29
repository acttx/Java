package edu.waketech.csc251.ticket;

import edu.waketech.csc251.ticket.common.Ticket;

public class AdvanceTicket extends Ticket{
	
	private double discount;
	
	public AdvanceTicket(String venue, String event, String date, double basePrice, double discount) {
		super(venue, event, date, basePrice);
		this.discount = discount;
	}

	@Override
	public double getPrice() {
		double bp = getBasePrice();
		return bp - bp * discount;
	}
}
