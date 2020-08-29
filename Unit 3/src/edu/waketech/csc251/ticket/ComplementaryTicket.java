package edu.waketech.csc251.ticket;

import edu.waketech.csc251.ticket.common.Ticket;

public class ComplementaryTicket extends Ticket {

	public ComplementaryTicket(String venue, String event, String date) {
		
		//ticket price equals 0 since ticket is given away for free
		super(venue, event, date, 0);
	}

	@Override
	public double getPrice() {
		return getBasePrice();
	}
}
