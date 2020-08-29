package edu.waketech.csc251.ticket;

import edu.waketech.csc251.ticket.common.Ticket;

public class DayOfTicket extends Ticket {

	public DayOfTicket(String venue, String event, String date, double basePrice) {
		super(venue, event, date, basePrice);
	}

	@Override
	public double getPrice() {
		return getBasePrice();
	}

}
