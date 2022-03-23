package progs;

import java.util.*;

public class CancelTickets
{
	static Scanner sc = new Scanner(System.in);
	static String ticketno1, ticketno2;
	static String fullname1, fullname2, firstname, middlename, lastname;
	static int pnrno1, pnrno2;
	
	public static void cancelTickets()
	{
		System.out.println("Cancel Tickets For\n1. Domestic Flight\n2. International Flight");
		int ctChoice = sc.nextInt();
		
		if(ctChoice == 1)
		{
			// SQL Query to view all ticket details for Domestic Flights
			SQLQueries.displayDomTicketDetails();
			System.out.println("\n\nCancel Tickets via\n1. Ticket Number\n2. PNR No\n3. Back to Main Menu\n4. Exit");
			int choice = sc.nextInt();
			
			if(choice == 1)
			{
				searchDomTicketViaTicketNo();
			}
			else if(choice == 2)
			{
				searchDomTicketViaPNRNo();
			}
			else if(choice == 3)
			{
				Timer.reloadMenu();
			}
			else if(choice == 4)
			{
				Timer.stopTimerCloseApp();
			}
			else
			{
				Errors.errorInvalidChoice();
			}
		}
		else if(ctChoice == 2)
		{
			// SQL Query to view all ticket details for International Flights
			SQLQueries.displayIntlTicketDetails();
			System.out.println("\n\nCancel Tickets via\n1. Ticket Number\n2. PNR No\n3. Back to Main Menu\n4. Exit");
			int choice = sc.nextInt();
			
			if(choice == 1)
			{
				searchIntlTicketViaTicketNo();
			}
			else if(choice == 2)
			{
				searchIntlTicketViaPNRNo();
			}
			else if(choice == 3)
			{
				Timer.reloadMenu();
			}
			else if(choice == 4)
			{
				Timer.stopTimerCloseApp();
			}
			else
			{
				Errors.errorInvalidChoice();
			}
		}
		else
		{
			Errors.errorInvalidChoice();
		}

	}
	
	public static void searchDomTicketViaTicketNo()
	{
		System.out.println("Enter your Ticket No:");
		ticketno1 = sc.next();
		cancelTicketViaTicketNo();
	}
	
	public static void searchDomTicketViaPNRNo()
	{
		System.out.println("Enter your PNR No:");
		pnrno1 = sc.nextInt();
		cancelTicketViaPNRNo();
	}
	
	public static void searchIntlTicketViaTicketNo()
	{
		System.out.println("Enter your Ticket No:");
		ticketno2 = sc.next();
		cancelTicketViaTicketNo();
	}
	
	public static void searchIntlTicketViaPNRNo()
	{
		System.out.println("Enter your PNR No:");
		pnrno2 = sc.nextInt();
		cancelTicketViaPNRNo();
	}
	
	public static void cancelTicketViaTicketNo()
	{
		System.out.println("Cancel Ticket via Ticket No For\n1. Domestic Flight\n2. International Flight\n");
		int canlTcktChoice = sc.nextInt();
		
		switch(canlTcktChoice)
		{
			case 1: // Domestic Flight
					SQLQueries.cancelDomTicketViaTicketNo();
					break;
			
			case 2: // International Flight
					SQLQueries.cancelIntlTicketViaTicketNo();
					break;
		}
	}
	
	public static void cancelTicketViaPNRNo()
	{
		System.out.println("Cancel Ticket via PNR No For\n1. Domestic Flight\n2. International Flight\n");
		int canlTcktChoice = sc.nextInt();
		
		switch(canlTcktChoice)
		{
			case 1: // Domestic Flight
					SQLQueries.cancelDomTicketViaPNRNo();
					break;
			
			case 2: // International Flight
					SQLQueries.cancelIntlTicketViaPNRNo();
					break;
		}
	}
}