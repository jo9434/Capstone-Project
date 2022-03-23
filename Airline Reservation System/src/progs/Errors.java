package progs;

public class Errors
{
	// This class contains multiple error handling messages for the user to receive if anything is selected or entered wrongly...
	// To avoid writing the same error messages again and again I'm adding it to a class and calling the methods wherever it is applicable
	// and under any scenario...
	// To promote Code Re-usability Concept for Timer and Errors to ensure smooth functioning and avoid writing lengthly and make a clean code...
	
	static String errorIC = "Invalid Choice!"; // Error Invalid Choice
	static String appClosed = "App Closed."; // Application is Closed
	static String errorTNF = "Sorry, Ticket No doesn't exist...!";
	static String errorPN = "Sorry, Passenger Name doesn't exist...!";
	static String errorUNF = "Sorry, User doesn't exist..! Better Luck, Next Time!";
	static String errorNIEnter = "No Input Entered!";
	static String errorNFFFound = "Sorry, No Fares or Flights Found!";
	static String errorNDTDel = "No Data Found to be Deleted";
	static String errorMsgConFail, errorMsgLoginFail;
	static String errorNoMatch = "No Match Found!";
	
	public static String recieveConFailMsg()
	{
		errorMsgConFail = "Sorry, Unable To Connect to Database..!";
		return errorMsgConFail;
	}
	
	public static String recieveLoginFailMsg()
	{
		errorMsgLoginFail = "Login Failed..., Please Try Again..!";
		System.out.println("\n"+appClosed);
		System.exit(0);
		return errorMsgLoginFail;
	}
	
	public static void errorInvalidChoice()
	{
		System.out.println(errorIC); // display error message to user
		System.out.println("\n"+appClosed); // closes application
		System.exit(0);
 	}
	
	public static void errorTicketNotFound()
	{
		System.out.println(errorTNF);
		System.out.println("\n"+appClosed);
		System.exit(0);
	}
	
	public static void errorUserNotFound()
	{
		System.out.println(errorUNF);
		System.out.println("\n"+appClosed);
		System.exit(0);
	}
	
	public static void errorTicketNoNotFound()
	{
		System.out.println(errorPN);
		System.out.println("\n"+appClosed);
		System.exit(0);
	}
	
	public static void errorNoFaresOrFlightsFound()
	{
		System.out.println(errorNFFFound);
		System.out.println("\n"+appClosed);
		System.exit(0);
	}
	public static void errorNoInput()
	{
		System.out.println(errorNIEnter);
	}
	
	public static void errorNoDataToDelete()
	{
		System.out.println(errorNDTDel);
	}
}