package progs;

import java.sql.*;

public class SQLQueries {
	
	static Connection dbConnect = checkDBConnection();
	
	public static Connection checkDBConnection()
	{
		try {
			System.out.println("\n"+Timer.receiveConCheckMsg());
			dbConnect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/aira", "joelpc","joelpc6398#");
			System.out.println(""+SuccessMsg.receiveConSucessMsg()+"\n");
		}
		catch(Exception e)
		{
			Errors.recieveConFailMsg();
			e.printStackTrace();
		}
		return dbConnect;
	}
	
	public static void insertDomFlightsDet()
	{
		try
		{
			String insertData1 = "insert into domesticFlightDetails(domsourceCity,domdestCity,domdepdate,domretdate,domterminalNo,domairlinename,domairfare) values('"+BookTickets.domsrcCity+"','"+BookTickets.domdestCity+"','"+BookTickets.domdptdate+"','"+BookTickets.domretdate+"','"+BookTickets.curterminalno1+"','"+BookTickets.curairlinename1+"','"+BookTickets.curfare1+"')";
			Statement st1 = dbConnect.createStatement();
			int no1 = st1.executeUpdate(insertData1);
			System.out.println(no1+" Row Inserted Successfully!");
		}
		catch(Exception e)
		{
			Errors.errorNoInput();
		}
	}
	
	public static void insertIntlFlightsDet()
	{
		try
		{
			String insertData2 = "insert into internationalFlightDetails(intlsourceCity,intldestCity,intldepdate,intlretdate,intlterminalNo,intlairlinename,intlairfare) values('"+BookTickets.intlsrcCity+"','"+BookTickets.intldestCity+"','"+BookTickets.intldptdate+"','"+BookTickets.intlretdate+"','"+BookTickets.curterminalno2+"','"+BookTickets.curairlinename2+"','"+BookTickets.curfare2+"')";
			Statement st2 = dbConnect.createStatement();
			int no2 = st2.executeUpdate(insertData2);
			System.out.println(no2+" Row Inserted Successfully!");
		}
		catch(Exception e)
		{
			Errors.errorNoInput();
		}
	}
	
	public static void insertDomRegDetails()
	{
		try
		{
			String insertData3 = "insert into domregdetails(dompnrno,uname1,pwd1,fullname1,age1,emailId1,phoneNo1,gender1,dob1,passportno1) values('"+BookTickets.dompnrno+"','"+BookTickets.username1+"','"+BookTickets.password1+"','"+BookTickets.fullname1+"','"+BookTickets.age1+"','"+BookTickets.emailId1+"','"+BookTickets.phoneno1+"','"+BookTickets.gender1+"','"+BookTickets.dob1+"','"+BookTickets.passportno1+"')";
			Statement st3 = dbConnect.createStatement();
			int no3 = st3.executeUpdate(insertData3);
			System.out.println(no3+" Row Inserted Successfully!");
		}
		catch(Exception e)
		{
			Errors.errorNoInput();
		}
	}
	
	public static void insertDomUserDetails()
	{
		try
		{
			String insertData4 = "insert into domuserdetails(username1, passwrd1) values('"+BookTickets.uname1+"','"+BookTickets.passwrd1+"')";
			Statement st4 = dbConnect.createStatement();
			int no4 = st4.executeUpdate(insertData4);
			System.out.println(no4+" Row Inserted Successfully!");
		}
		catch(Exception e)
		{
			Errors.errorNoInput();
		}
	}
	
	public static void insertIntlRegDetails()
	{
		try
		{
			String insertData5 = "insert into intlregdetails(intlpnrno,uname2,pwd2,fullname2,age2,emailId2,phoneNo2,gender2,dob2,passportno2) values('"+BookTickets.intlpnrno+"','"+BookTickets.username2+"','"+BookTickets.password2+"','"+BookTickets.fullname2+"','"+BookTickets.age2+"','"+BookTickets.emailId2+"','"+BookTickets.phoneno2+"','"+BookTickets.gender2+"','"+BookTickets.dob2+"','"+BookTickets.passportno2+"')";
			Statement st5 = dbConnect.createStatement();
			int no5 = st5.executeUpdate(insertData5);
			System.out.println(no5+" Row Inserted Successfully!");
		}
		catch(Exception e)
		{
			Errors.errorNoInput();
		}
	}
	
	public static void insertIntlUserDetails()
	{
		try
		{
			String insertData6 = "insert into intluserdetails(username2, passwrd2) values('"+BookTickets.uname2+"','"+BookTickets.passwrd2+"')";
			Statement st6 = dbConnect.createStatement();
			int no6 = st6.executeUpdate(insertData6);
			System.out.println(no6+" Row Inserted Successfully!");
		}
		catch(Exception e)
		{
			Errors.errorNoInput();
		}
	}
	
	public static void displayDomFareDetails()
	{
		PreparedStatement pst7 = null;
		ResultSet rs7 = null;
		
		try
		{
			String selStat7 = "select id, domairlinename, domairlinefare, terminalno from domFareDetails";
			pst7 = dbConnect.prepareStatement(selStat7);
			rs7 = pst7.executeQuery();
			
			while(rs7.next())
			{
				System.out.println("Select Your Airline\n"+rs7.getInt("id")+". "+rs7.getString("domairlinename")+" Fare: "+rs7.getDouble("domairlinefare")+" Terminal: "+rs7.getInt("terminalno"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void displayIntlFareDetails()
	{
		PreparedStatement pst8 = null;
		ResultSet rs8 = null;
		
		try
		{
			String selStat8 = "select id, intlairlinename, intlairlinefare, terminalno from intlFareDetails";
			pst8 = dbConnect.prepareStatement(selStat8);
			rs8 = pst8.executeQuery();
			
			while(rs8.next())
			{
				System.out.println("Select Your Airline\n"+rs8.getInt("id")+". "+rs8.getString("intlairlinename")+" Fare: "+rs8.getDouble("intlairlinefare")+" Terminal: "+rs8.getInt("terminalno"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void insertDomTicketDetails()
	{
		try
		{
			String insertData9 = "insert into domticketdetails(ticketNo,pnrno,flighttype,fullname,age,emailId,phoneNo,gender,passportno,airlinename,srcCity,destcity,dptdate,retdate,terminalno) values('"+BookTickets.ticketNo+"','"+BookTickets.dompnrno+"','"+BookTickets.flightType+"','"+BookTickets.fullname1+"','"+BookTickets.age1+"','"+BookTickets.emailId1+"','"+BookTickets.phoneno1+"','"+BookTickets.gender1+"','"+BookTickets.passportno1+"','"+BookTickets.curairlinename1+"','"+BookTickets.domsrcCity+"','"+BookTickets.domdestCity+"','"+BookTickets.domdptdate+"','"+BookTickets.domretdate+"','"+BookTickets.curterminalno1+"')";
			Statement st9 = dbConnect.createStatement();
			int no9 = st9.executeUpdate(insertData9);
			System.out.println(no9+" Row Inserted Successfully!");
		}
		catch(Exception e)
		{
			Errors.errorNoInput();
		}
	}
	
	public static void insertIntlTicketDetails()
	{
		try
		{
			String insertData10 = "insert into intlticketdetails(TicketNo,pnrNo,flightType,fullName,Age,EmailId,PhoneNo,Gender,passportNo,airlineName,SrcCity,destCity,dptDate,retDate,terminalNo) values('"+BookTickets.ticketNo+"','"+BookTickets.intlpnrno+"','"+BookTickets.flightType+"','"+BookTickets.fullname2+"','"+BookTickets.age2+"','"+BookTickets.emailId2+"','"+BookTickets.phoneno2+"','"+BookTickets.gender2+"','"+BookTickets.passportno2+"','"+BookTickets.curairlinename2+"','"+BookTickets.intlsrcCity+"','"+BookTickets.intldestCity+"','"+BookTickets.intldptdate+"','"+BookTickets.intlretdate+"','"+BookTickets.curterminalno2+"')";
			Statement st10 = dbConnect.createStatement();
			int no10 = st10.executeUpdate(insertData10);
			System.out.println(no10+" Row Inserted Successfully!");
		}
		catch(Exception e)
		{
			Errors.errorNoInput();
		}
	}
	
	public static void displayDomTicketDetails()
	{
		PreparedStatement pst11 = null;
		ResultSet rs11 = null;
		
		try
		{
			String selStat11 = "select ticketNo, pnrno, fullname from domticketdetails";
			pst11 = dbConnect.prepareStatement(selStat11);
			rs11 = pst11.executeQuery();
			
			while(rs11.next())
			{
				System.out.println("Viewing Ticket Details\nTicket No: "+rs11.getString("ticketNo")+" PNR No: "+rs11.getInt("pnrno")+" Name: "+rs11.getString("fullname")+"\n");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void displayIntlTicketDetails()
	{
		PreparedStatement pst12 = null;
		ResultSet rs12 = null;
		
		try
		{
			String selStat12 = "select TicketNo, pnrNo, fullName from intlticketdetails";
			pst12 = dbConnect.prepareStatement(selStat12);
			rs12 = pst12.executeQuery();
			
			while(rs12.next())
			{
				System.out.println("Viewing Ticket Details\nTicket No: "+rs12.getString("TicketNo")+" PNR No: "+rs12.getInt("pnrNo")+" Name: "+rs12.getString("fullName")+"\n");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void showDomTicketDetViaTicketNo()
	{
		PreparedStatement pst13 = null;
		ResultSet rs13 = null;
		
		try
		{
			String selStat13 = "select ticketNo, pnrno, fullname, age, gender, emailId, phoneNo, passportno, airlinename, srcCity, destcity, dptdate, retdate from domticketdetails where ticketNo = '"+ViewTickets.ticketno1+"' ";
			pst13 = dbConnect.prepareStatement(selStat13);
			rs13 = pst13.executeQuery();
			
			while(rs13.next())
			{
				System.out.println("We Found Your Ticket, here it is\n------------------------------------------\n");
				System.out.println("Ticket No: "+rs13.getString("ticketno")+" PNR No: "+rs13.getInt("pnrno"));
				System.out.println("\n\nName: "+rs13.getString("fullname")+"\nAge: "+rs13.getInt("age")+"\nGender: "+rs13.getString("gender")+"\nEmail ID: "+rs13.getString("emailId")+"\nPhone Number: "+rs13.getString("phoneNo")+"\nPassport No: "+rs13.getString("passportno"));
				System.out.println("\n--------------------------------");
				System.out.println("\n\nAirline Name: "+rs13.getString("airlinename")+"\nSource: "+rs13.getString("srcCity")+"\nDestination: "+rs13.getString("destcity")+"\nDepart Date: "+rs13.getString("dptdate")+"\nReturn Date: "+rs13.getString("retdate"));
				System.out.println("\n----------------------------------------------------------------------------");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void showDomTicketDetViaPNRNo()
	{
		PreparedStatement pst14 = null;
		ResultSet rs14 = null;
		
		try
		{
			String selStat14 = "select ticketNo, pnrno, fullname, age, gender, emailId, phoneNo, passportno, airlinename, srcCity, destcity, dptdate, retdate from domticketdetails where pnrno = '"+ViewTickets.pnrno1+"' ";
			pst14 = dbConnect.prepareStatement(selStat14);
			rs14 = pst14.executeQuery();
			
			while(rs14.next())
			{
				System.out.println("We Found Your Ticket, here it is\n------------------------------------------\n");
				System.out.println("Ticket No: "+rs14.getString("ticketno")+" PNR No: "+rs14.getInt("pnrno"));
				System.out.println("\n\nName: "+rs14.getString("fullname")+"\nAge: "+rs14.getInt("age")+"\nGender: "+rs14.getString("gender")+"\nEmail ID: "+rs14.getString("emailId")+"\nPhone Number: "+rs14.getString("phoneNo")+"\nPassport No: "+rs14.getString("passportno"));
				System.out.println("\n--------------------------------");
				System.out.println("\n\nAirline Name: "+rs14.getString("airlinename")+"\nSource: "+rs14.getString("srcCity")+"\nDestination: "+rs14.getString("destcity")+"\nDepart Date: "+rs14.getString("dptdate")+"\nReturn Date: "+rs14.getString("retdate"));
				System.out.println("\n----------------------------------------------------------------------------");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void showIntlTicketDetViaTicketNo()
	{
		PreparedStatement pst15 = null;
		ResultSet rs15 = null;
		
		try
		{
			String selStat15 = "select TicketNo, pnrNo, fullName, Age, Gender, EmailId, PhoneNo, passportNo, airlineName, SrcCity, destCity, dptDate, retDate from intlticketdetails where TicketNo = '"+ViewTickets.ticketno2+"' ";
			pst15 = dbConnect.prepareStatement(selStat15);
			rs15 = pst15.executeQuery();
			
			while(rs15.next())
			{
				System.out.println("We Found Your Ticket, here it is\n------------------------------------------\n");
				System.out.println("Ticket No: "+rs15.getString("TicketNo")+" PNR No: "+rs15.getInt("pnrNo"));
				System.out.println("\n\nName: "+rs15.getString("fullName")+"\nAge: "+rs15.getInt("Age")+"\nGender: "+rs15.getString("Gender")+"\nEmail ID: "+rs15.getString("EmailId")+"\nPhone Number: "+rs15.getString("PhoneNo")+"\nPassport No: "+rs15.getString("passportNo"));
				System.out.println("\n--------------------------------");
				System.out.println("\n\nAirline Name: "+rs15.getString("airlineName")+"\nSource: "+rs15.getString("SrcCity")+"\nDestination: "+rs15.getString("destCity")+"\nDepart Date: "+rs15.getString("dptDate")+"\nReturn Date: "+rs15.getString("retDate"));
				System.out.println("\n----------------------------------------------------------------------------");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void showIntlTicketDetViaPNRNo()
	{
		PreparedStatement pst16 = null;
		ResultSet rs16 = null;
		
		try
		{
			String selStat16 = "select TicketNo, pnrNo, fullName, Age, Gender, EmailId, PhoneNo, passportNo, airlineName, SrcCity, destCity, dptDate, retDate from intlticketdetails where pnrNo = '"+ViewTickets.pnrno2+"' ";
			pst16 = dbConnect.prepareStatement(selStat16);
			rs16 = pst16.executeQuery();
			
			while(rs16.next())
			{
				System.out.println("We Found Your Ticket, here it is\n------------------------------------------\n");
				System.out.println("Ticket No: "+rs16.getString("TicketNo")+" PNR No: "+rs16.getInt("pnrNo"));
				System.out.println("\n\nName: "+rs16.getString("fullName")+"\nAge: "+rs16.getInt("Age")+"\nGender: "+rs16.getString("Gender")+"\nEmail ID: "+rs16.getString("EmailId")+"\nPhone Number: "+rs16.getString("PhoneNo")+"\nPassport No: "+rs16.getString("passportNo"));
				System.out.println("\n--------------------------------");
				System.out.println("\n\nAirline Name: "+rs16.getString("airlineName")+"\nSource: "+rs16.getString("SrcCity")+"\nDestination: "+rs16.getString("destCity")+"\nDepart Date: "+rs16.getString("dptDate")+"\nReturn Date: "+rs16.getString("retDate"));
				System.out.println("\n----------------------------------------------------------------------------");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void cancelDomTicketViaTicketNo()
	{
		Statement st17 = null;
		
		try
		{
			String selStat17 = "delete domticketdetails, domesticFlightDetails from domticketdetails inner join domesticflightdetails where domticketdetails.ticketNo = '"+CancelTickets.ticketno1+"' and domticketdetails.terminalno = domesticflightdetails.domterminalNo";
			//String selStat17 = "delete from domticketdetails dtd, domesticFlightDetails dfd where dtd.ticketNo = '"+CancelTickets.ticketno1+"' and dtd.terminalno = dfd.domterminalNo ";
			st17 = dbConnect.createStatement();
			int no17 = st17.executeUpdate(selStat17);
			System.out.println(no17+" Row Deleted Successfully!");
		}
		catch(Exception e)
		{
			Errors.errorNoDataToDelete();
		}
	}
	
	public static void cancelDomTicketViaPNRNo()
	{
		Statement st18 = null;
		
		try
		{
			String selStat18 = "delete domticketdetails, domesticFlightDetails from domticketdetails inner join domesticflightdetails where domticketdetails.pnrno = '"+CancelTickets.pnrno1+"' and domticketdetails.terminalno = domesticflightdetails.domterminalNo";
			//String selStat18 = "delete from domticketdetails dtd, domesticFlightDetails dfd where dtd.pnrno = '"+CancelTickets.pnrno1+"' and dtd.terminalno = dfd.domterminalNo ";
			st18 = dbConnect.createStatement();
			int no18 = st18.executeUpdate(selStat18);
			System.out.println(no18+" Row Deleted Successfully!");
		}
		catch(Exception e)
		{
			Errors.errorNoDataToDelete();
		}
	}
	
	public static void cancelIntlTicketViaTicketNo()
	{
		Statement st19 = null;
		
		try
		{
			String selStat19 = "delete intlticketdetails, internationalFlightDetails from intlticketdetails inner join internationalFlightDetails where intlticketdetails.TicketNo = '"+CancelTickets.ticketno2+"' and intlticketdetails.terminalNo = internationalFlightDetails.intlterminalNo";
			//String selStat19 = "delete from intlticketdetails itd, internationalFlightDetails ifd  where itd.TicketNo = '"+CancelTickets.ticketno2+"' and itd.terminalno = ifd.intlterminalNo ";
			st19 = dbConnect.createStatement();
			int no19 = st19.executeUpdate(selStat19);
			System.out.println(no19+" Row Deleted Successfully!");
		}
		catch(Exception e)
		{
			Errors.errorNoDataToDelete();
		}
	}
	
	public static void cancelIntlTicketViaPNRNo()
	{
		Statement st20 = null;
		
		try
		{
			String selStat20 = "delete intlticketdetails, internationalFlightDetails from intlticketdetails inner join internationalFlightDetails where intlticketdetails.pnrNo = '"+CancelTickets.pnrno2+"' and intlticketdetails.terminalNo = internationalFlightDetails.intlterminalNo";
			//String selStat20 = "delete intlticketdetails itd, internationalFlightDetails ifd where pnrNo = '"+CancelTickets.pnrno2+"' and itd.terminalno = ifd.intlterminalNo ";
			st20 = dbConnect.createStatement();
			int no20 = st20.executeUpdate(selStat20);
			System.out.println(no20+" Row Deleted Successfully!");
		}
		catch(Exception e)
		{
			Errors.errorNoDataToDelete();
		}
	}
}
