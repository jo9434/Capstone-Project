package progs;

import java.util.*;

// This class works similarly as Timers in Java via java.util.Timer and java.util.TimerTask
// But, I have implemented a custom timer to do the same function and to allow customization as per my task what I'm trying to achieve
// without any of those imports statements

public class Timer
{
	static int timeCount;
	static int n=5, m=5;
	static Scanner sc = new Scanner(System.in);
	static String msgConCheck, msgLoading;
	
	public static String receiveConCheckMsg()
	{
		msgLoading = "Loading";
		
		for(timeCount=m; timeCount<=m; timeCount--)
		{
			if(timeCount==1)
			{
				System.out.print(msgLoading);
			}
			if(timeCount==0)
			{
				msgConCheck = "Checking Connection and Connecting to Database...";
			}
		}
		return msgConCheck;
	}
	
	public static void stopTimerCloseApp()
	{
		for(timeCount=n; timeCount<=n; timeCount--)
		{
			if(timeCount>0)
			{
    			System.out.println("Closing App in "+timeCount+" Seconds...\n"); // Label to print the output with the no reducing 5..4..3..2..1 when it reaches to one the app is closed.
			}

			if(timeCount==0)
			{
    			System.out.println("-----------");
    			System.out.println("App Closed.");
    			System.out.println("-----------");
   				System.exit(0);
			}
		}
	}
	
	public static void reloadMenu()
	{
		System.out.println("Do you want to go back?\n1. Yes\n2. No\n\n");
		int reply = sc.nextInt();
		
		if(reply==1)
		{
			Aira.showMainMenu();
		}
		else if(reply==2)
		{
			stopTimerCloseApp();
		}
	}
}