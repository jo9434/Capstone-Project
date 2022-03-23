package progs;

import java.util.*;

public class ViewTickets
{
	static Scanner sc = new Scanner(System.in);
	static String ticketno1, ticketno2;
	static String fullname1, fullname2, firstname, middlename, lastname;
	static int pnrno1, pnrno2;
	
	public static void viewTickets()
	{
		System.out.println("View Tickets For\n1. Domestic Flight\n2. International Flight");
		int viewChoice = sc.nextInt();
		
		if(viewChoice == 1)
		{
			// SQL Query to view all ticket details for Domestic Flights
			SQLQueries.displayDomTicketDetails();
			System.out.println("\n\nDisplay Tickets via\n1. Ticket Number\n2. PNR No\n3. Back to Main Menu\n4. Exit");
			int choice = sc.nextInt();
			
			if(choice == 1)
			{
				searchDomTicketsByTicketNo();
			}
			else if(choice == 2)
			{
				searchDomTicketsByPNRNo();
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
		else if(viewChoice == 2)
		{
			// SQL Query to view all ticket details for International Flights
			SQLQueries.displayIntlTicketDetails();
			System.out.println("\n\nDisplay Tickets via\n1. Ticket Number\n2. PNR No\n3. Back to Main Menu\n4. Exit");
			int choice = sc.nextInt();
			
			if(choice == 1)
			{
				searchIntlTicketsByTicketNo();
			}
			else if(choice == 2)
			{
				searchIntlTicketsByPNRNo();
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
	
	public static void searchDomTicketsByTicketNo()
	{
		System.out.println("Enter your Ticket No:");
		ticketno1 = sc.next();
		displayTicketViaTicketNo();
	}
	
	public static void searchDomTicketsByPNRNo()
	{
		System.out.println("Enter your PNR No:");
		pnrno1 = sc.nextInt();
		displayTicketViaPNRNo();
	}
	
	public static void searchIntlTicketsByTicketNo()
	{
		System.out.println("Enter your Ticket No:");
		ticketno2 = sc.next();
		displayTicketViaTicketNo();
	}
	
	public static void searchIntlTicketsByPNRNo()
	{
		System.out.println("Enter your PNR No:");
		pnrno2 = sc.nextInt();
		displayTicketViaPNRNo();
	}
	
	public static void displayTicketViaTicketNo()
	{
		System.out.println("View Ticket via Ticket No For\n1. Domestic Flight\n2. International Flight\n");
		int dispTcktChoice = sc.nextInt();
		
		switch(dispTcktChoice)
		{
			case 1: // Domestic Flight
					SQLQueries.showDomTicketDetViaTicketNo();
					break;
					
			case 2: // International Flight
					SQLQueries.showIntlTicketDetViaTicketNo();
					break;
		}
	}
	
	public static void displayTicketViaPNRNo()
	{
		System.out.println("View Ticket via PNR No For\n1. Domestic Flight\n2. International Flight\n");
		int dispTcktChoice = sc.nextInt();
		
		switch(dispTcktChoice)
		{
			case 1: // Domestic Flight
					SQLQueries.showDomTicketDetViaPNRNo();
					break;
					
			case 2: // International Flight
					SQLQueries.showIntlTicketDetViaPNRNo();
					break;
		}
	}
}