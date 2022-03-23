package progs;

import java.util.*;

public class Aira
{
	static int choice;
	static int timeCount;
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		System.out.println("Welcome to the Aira, your Airline Support Assistant.");
		System.out.println("How may I help you, today?");
		
		Aira.showMainMenu();
	}
	
	public static void showMainMenu()
	{
		System.out.println("Main Menu\n1-> Book Tickets\n2-> View Tickets\n3-> Cancel Tickets\n4-> Go Back to Main Menu\n5-> Exit App\n\nSelection:\n");
		choice = sc.nextInt();
		
		// The user clicks on the desired label to select the choice
		switch(choice)
		{
			case 1: // Loading Book Tickets
					BookTickets.bookTickets();
					break;
						
			case 2: // View Tickets
					ViewTickets.viewTickets();
					break;
		
			case 3: // Cancel Tickets
					CancelTickets.cancelTickets();
					break;
					
			case 4: // Reopen the same menu
					Timer.reloadMenu();
					break;
						
			case 5: // Stop App and Close It
					System.out.println("App Closing...\n");
					Timer.stopTimerCloseApp();
					break;
						
			default: // Invalid Choice
					 Errors.errorInvalidChoice();
					 System.out.println("App Closing...\n");
					 Timer.stopTimerCloseApp();
		}
	}
}