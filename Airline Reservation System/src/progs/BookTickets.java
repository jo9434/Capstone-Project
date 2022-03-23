package progs;

import java.util.*;

public class BookTickets
{
	// Passenger Class Variables
	static String fullname1,fullname2;
	static String firstname, firstname1, firstname2;
	static String middlename, middlename2;
	static String lastname, lastname1, lastname2;
	static String username1, uname1, username2, uname2;
	static String password1, passwrd1, password2, passwrd2;
	static int age1, age2;
	static String phoneno1, phoneno2;
	static String emailId1, emailId2;
	static String gender1, gender2;
	static String dob1, dob2;
	static String passportno1, passportno2;
	static int dompnrno, intlpnrno;
	
	// Local Variables
	static String domsrcCity,intlsrcCity;
	static String domdestCity, intldestCity;
	static String domdptdate, intldptdate;
	static String domretdate, intlretdate;
	static int curterminalno1, curterminalno2;
	static String curairlinename1, curairlinename2;
	static String flightType;
	static double curfare1, curfare2;
	static String ticketNo;

	// Scanner Statement
	static Scanner sc = new Scanner(System.in);
	
	public static void bookTickets()
	{
		System.out.println("Select the Option/n1. Domestic/n2. International/n/nSelection:");
		int choice = sc.nextInt();
		
		if(choice==1)
		{
			bookDomesticFlights();
		}
		else if(choice==2)
		{
			bookInternationalFlights();
		}
		else
		{
			Errors.errorInvalidChoice();
		}
	}
	
	public static void bookDomesticFlights()
	{
		// Book Domestic Flights
		System.out.println("Enter \n1. First Name & Last Name\n2. First, Middle and Last Name");
		int nameChoice = sc.nextInt();
		
		if(nameChoice == 1)
		{
			System.out.println("Enter the Passenger Name:");
			firstname = sc.next();
			lastname = sc.next();
						
			fullname1 = (firstname+" "+lastname);
		}
		else if(nameChoice == 2)
		{
			System.out.println("Enter the Passenger Name:");
			firstname = sc.next();
			middlename = sc.next();
			lastname = sc.next();
						
			fullname1 = (firstname+" "+middlename+" "+lastname);
		}
					
		System.out.println("\nEnter the Username:");
		username1 = sc.next();
		uname1 = username1;
			
		System.out.println("\nEnter the Password:");
		password1 = sc.next();
		passwrd1 = password1;
		
		System.out.println("\nEnter the Passenger Age:");
		age1 = sc.nextInt();
					
		System.out.println("\nEnter the Gender:");
		gender1 = sc.next();
					
		System.out.println("\nEnter the Passport No:");
		passportno1 = sc.next();
					
		System.out.println("\nEnter the Mobile No:");
		phoneno1 = sc.next();
					
		System.out.println("Enter your D.O.B:");
		String dd2 = sc.next();
		String mm2 = sc.next();
		String yyyy2= sc.next();
		dob1 = (dd2+"/"+mm2+"/"+yyyy2);
					
		if(age1>=18)
		{
			System.out.println("Ticket is Mandatory!!");
						
			System.out.println("\nEnter the Email ID:");
			emailId1 = sc.next();
		}
		else if(age1>=5 && age1<18)
		{
			System.out.println("Passenger is a Minor!");
						
			System.out.println("\nEnter the Email ID:");
			emailId1 = sc.next();
		}
		else if(age1<5)
		{
			System.out.println("No Ticket is Required!\n");
		}
		dompnrno = generatePNRNo();
		//System.out.println("\nUser Details Added Succesfully\nHere is your PNR No: "+dompnrno+"\n");
		SQLQueries.insertDomRegDetails();
		SQLQueries.insertDomUserDetails();
		displayDomFaresAndAirline();
	}
	
	public static void bookInternationalFlights()
	{
		// Book International Flights
		System.out.println("Enter \n1. First Name & Last Name\n2. First, Middle and Last Name");
		int nameChoice = sc.nextInt();
		if(nameChoice == 1)
		{
			System.out.println("Enter the Passenger Name:");
			firstname1 = sc.next();
			lastname1 = sc.next();
			
			fullname2 = (firstname1+" "+lastname1);
		}
		else if(nameChoice == 2)
		{
			System.out.println("Enter the Passenger Name:");
			firstname2 = sc.next();
			middlename2 = sc.next();
			lastname2 = sc.next();
				
			fullname2 = (firstname2+" "+middlename2+" "+lastname2);
		}
		
		System.out.println("\nEnter the Username:");
		username2 = sc.next();
		uname2 = username2;
		
		System.out.println("\nEnter the Password:");
		password2 = sc.next();
		passwrd2 = password2;
		
		System.out.println("\nEnter the Passenger Age:");
		age2 = sc.nextInt();
		
		System.out.println("\nEnter the Gender:");
		gender2 = sc.next();
		
		System.out.println("\nEnter the Passport No: ");
		passportno2 = sc.next();
		
		System.out.println("\nEnter the Mobile No:");
		phoneno2 = sc.next();
		
		System.out.println("Enter your D.O.B:");
		String dd2 = sc.next();
		String mm2 = sc.next();
		String yyyy2= sc.next();
		dob2 = (dd2+"/"+mm2+"/"+yyyy2);
		
		if(age2>=18)
		{
			System.out.println("Ticket is Mandatory!!");
			
			System.out.println("\nEnter the Email ID:");
			emailId2 = sc.next();
		}
		else if(age2>=5 && age2<18)
		{
			System.out.println("Passenger is a Minor!");
			
			System.out.println("\nEnter the Email ID:");
			emailId2 = sc.next();
		}
		else if(age2<5)
		{
			System.out.println("No Ticket is Required!\n");
		}
		intlpnrno = generatePNRNo();
		//System.out.println("\nUser Details Added Succesfully\nHere is your PNR No: "+intlpnrno+"\n");
		SQLQueries.insertIntlRegDetails();
		SQLQueries.insertIntlUserDetails();
		displayIntlFaresAndAirline();
	}
	
	public static void displayDomFaresAndAirline()
	{
		System.out.println("Enter the Place of Origin:"); // Source
		domsrcCity = sc.next();
					
		System.out.println("\nEnter the Place of Departure:"); // Destination
		domdestCity = sc.next();
					
		System.out.println("\nEnter the Date of Departure:");
		String dd = sc.next();
		String mm = sc.next();
		String yyyy= sc.next();
		domdptdate = (dd+"/"+mm+"/"+yyyy);
					
		System.out.println("\nEnter the Date of Return:");
		String dd1 = sc.next();
		String mm1 = sc.next();
		String yyyy1= sc.next();
		domretdate = (dd1+"/"+mm1+"/"+yyyy1);
		
		SQLQueries.displayDomFareDetails();
		
		System.out.println("Enter the Choice");
		int idChoice = sc.nextInt();
		
		if(idChoice == 1)
		{
			System.out.println("\nEnter the Airline Name: ");
			String input1 = sc.next();
			String input2 = sc.next();
			curairlinename1 = (input1+" "+input2);
			
			System.out.println("\nEnter the Terminal No: ");
			curterminalno1 = sc.nextInt();
			
			System.out.println("\nEnter the Fare: ");
			curfare1 = sc.nextDouble();
		}
		else if(idChoice == 2)
		{
			System.out.println("\nEnter the Airline Name: ");
			curairlinename1 = sc.next();
			
			System.out.println("\nEnter the Terminal No: ");
			curterminalno1 = sc.nextInt();
			
			System.out.println("\nEnter the Fare: ");
			curfare1 = sc.nextDouble();
		}
		else if(idChoice == 3)
		{
			System.out.println("\nEnter the Airline Name: ");
			curairlinename1 = sc.next();
			
			System.out.println("\nEnter the Terminal No: ");
			curterminalno1 = sc.nextInt();
			
			System.out.println("\nEnter the Fare: ");
			curfare1 = sc.nextDouble();
		}
		else if(idChoice == 4)
		{
			System.out.println("\nEnter the Airline Name: ");
			curairlinename1 = sc.next();
			
			System.out.println("\nEnter the Terminal No: ");
			curterminalno1 = sc.nextInt();
			
			System.out.println("\nEnter the Fare: ");
			curfare1 = sc.nextDouble();
		}
		else if(idChoice == 5)
		{
			System.out.println("\nEnter the Airline Name: ");
			curairlinename1 = sc.next();
			
			System.out.println("\nEnter the Terminal No: ");
			curterminalno1 = sc.nextInt();
			
			System.out.println("\nEnter the Fare: ");
			curfare1 = sc.nextDouble();
		}
		else
		{
			Errors.errorNoFaresOrFlightsFound();
		}
		SQLQueries.insertDomFlightsDet();
		continueAddPassenger();
	}
	
	public static void displayIntlFaresAndAirline()
	{
		System.out.println("Enter the Place of Origin:"); // Source
		intlsrcCity = sc.next();
		
		System.out.println("\nEnter the Place of Departure:"); // Destination
		intldestCity = sc.next();
		
		System.out.println("\nEnter the Date of Departure:");
		String dd = sc.next();
		String mm = sc.next();
		String yyyy= sc.next();
		intldptdate = (dd+"/"+mm+"/"+yyyy);
		
		System.out.println("\nEnter the Date of Return:");
		String dd1 = sc.next();
		String mm1 = sc.next();
		String yyyy1= sc.next();
		intlretdate = (dd1+"/"+mm1+"/"+yyyy1);
		
		SQLQueries.displayIntlFareDetails();
		
		System.out.println("Enter the Choice");
		int idChoice = sc.nextInt();
		
		if(idChoice == 1)
		{
			System.out.println("\nEnter the Airline Name: ");
			curairlinename2 = sc.next();
			
			System.out.println("\nEnter the Terminal No: ");
			curterminalno2 = sc.nextInt();
			
			System.out.println("\nEnter the Fare: ");
			curfare2 = sc.nextDouble();
		}
		else if(idChoice == 2)
		{
			System.out.println("\nEnter the Airline Name: ");
			curairlinename2 = sc.next();
			
			System.out.println("\nEnter the Terminal No: ");
			curterminalno2 = sc.nextInt();
			
			System.out.println("\nEnter the Fare: ");
			curfare2 = sc.nextDouble();
		}
		else if(idChoice == 3)
		{
			System.out.println("\nEnter the Airline Name: ");
			String input1 = sc.next();
			String input2 = sc.next();
			curairlinename2 = (input1+" "+input2);
			
			System.out.println("\nEnter the Terminal No: ");
			curterminalno2 = sc.nextInt();
			
			System.out.println("\nEnter the Fare: ");
			curfare2 = sc.nextDouble();
		}
		else if(idChoice == 4)
		{
			System.out.println("\nEnter the Airline Name: ");
			String input1 = sc.next();
			String input2 = sc.next();
			curairlinename2 = (input1+" "+input2);
			
			System.out.println("\nEnter the Terminal No: ");
			curterminalno2 = sc.nextInt();
			
			System.out.println("\nEnter the Fare: ");
			curfare2 = sc.nextDouble();
		}
		else if(idChoice == 5)
		{
			System.out.println("\nEnter the Airline Name: ");
			String input1 = sc.next();
			String input2 = sc.next();
			curairlinename2 = (input1+" "+input2);
			
			System.out.println("\nEnter the Terminal No: ");
			curterminalno2 = sc.nextInt();
			
			System.out.println("\nEnter the Fare: ");
			curfare2 = sc.nextDouble();
		}
		else
		{
			Errors.errorNoFaresOrFlightsFound();
		}
		SQLQueries.insertIntlFlightsDet();
		continueAddPassenger();
	}
	
	public static void continueAddPassenger()
	{
		System.out.println("Do You Want To Add Another Passenger? (Y/N)");
		String continueToAddPassenger = sc.next();
		
		if(continueToAddPassenger.equals("y") || continueToAddPassenger.equals("Y") || continueToAddPassenger.equals("yes") || continueToAddPassenger.equals("Yes"))
		{
			System.out.println("Select the Option/n1. Domestic/n2. International/n/nSelection:");
			int addchoice = sc.nextInt();
			
			if(addchoice == 1)
			{
				bookDomesticFlights();
			}
			else if(addchoice == 2)
			{
				bookInternationalFlights();
			}
		}
		else if(continueToAddPassenger.equals("n") || continueToAddPassenger.equals("N") || continueToAddPassenger.equals("no") || continueToAddPassenger.equals("No"))
		{
				displayTicket();
		}
	}
	
	public static void displayTicket()
	{
		System.out.println("Did You Book\n1. Domestic Flight\n2. International Flight\n");
		int dispTcktChoice = sc.nextInt();
		
		switch(dispTcktChoice)
		{
			case 1: // Domestic Flights Ticket
					flightType = "Domestic";
					ticketNo = generateTicketNo();
					System.out.println("Login Details:\n\nUsername: "+username1+" Password: "+password1+"\n");
					System.out.println("Here is Your Ticket\n------------------------------------------\n");
					System.out.println("Ticket No: "+ticketNo+" PNR No: "+dompnrno);
					System.out.println("\n\nName: "+fullname1+"\nAge: "+age1+"\nGender: "+gender1+"\nEmail ID: "+emailId1+"\nPhone Number: "+phoneno1+"\nPassport No: "+passportno1);
					System.out.println("\n--------------------------------");
					System.out.println("\n\nAirline Name: "+curairlinename1+"\nSource: "+domsrcCity+"\nDestination: "+domdestCity+"\nDepart Date: "+domdptdate+"\nReturn Date: "+domretdate+"\nTerminal No: "+curterminalno1);
					System.out.println("\nFare: "+curfare1);
					System.out.println("\n----------------------------------------------------------------------------");
					SQLQueries.insertDomTicketDetails();
					break;
					
			case 2: // International Flight Ticket
					flightType = "International";
					ticketNo = generateTicketNo();
					System.out.println("Login Details:\n\nUsername: "+username2+" Password: "+password2+"\n");
					System.out.println("Here is Your Ticket\n------------------------------------------\n");
					System.out.println("Ticket No: "+ticketNo+" PNR No: "+intlpnrno);
					System.out.println("\n\nName: "+fullname2+"\nAge: "+age2+"\nGender: "+gender2+"\nEmail ID: "+emailId2+"\nPhone Number: "+phoneno2+"\nPassport No: "+passportno2);
					System.out.println("\n--------------------------------");
					System.out.println("\n\nAirline Name: "+curairlinename2+"\nSource: "+intlsrcCity+"\nDestination: "+intldestCity+"\nDepart Date: "+intldptdate+"\nReturn Date: "+intlretdate+"\nTerminal No: "+curterminalno2);
					System.out.println("\nFare: "+curfare2);
					System.out.println("\n----------------------------------------------------------------------------");
					SQLQueries.insertIntlTicketDetails();
					break;
		}
	}
	
	public static String generateTicketNo()
	{
		String ticketno = "";
		int m = 10;
		String ticketNoGen = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "123456789";
		StringBuilder sb = new StringBuilder(m);
		for(int i=0; i<m; i++)
		{
			int index = (int)(ticketNoGen.length() * Math.random());
			sb.append(ticketNoGen.charAt(index));
			ticketno = sb.toString();
		}
		return ticketno;
	}
	
	public static int generatePNRNo()
	{
		int passengerno = 0;
		int n = 8;
		String pnrNoGen = "123456789";
		StringBuilder sb = new StringBuilder(n);
		for(int i=0; i<n; i++)
		{
			int index = (int)(pnrNoGen.length() * Math.random());
			sb.append(pnrNoGen.charAt(index));
			passengerno = Integer.parseInt(sb.toString());
		}
		return passengerno;
	}
}