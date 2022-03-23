create database aira;

use aira;

create table domregdetails (
	dompnrno int,
	uname1 varchar(20),
    pwd1 varchar(20),
    fullname1 char(50) not null,
    age1 int check(age1 >= 18) not null,
    emailId1 varchar(30),
    phoneNo1 char(10) check(phoneNo1 !=11),
    gender1 char(10) not null,
    dob1 char(20) not null,
    passportno1 char(20),
    primary key(dompnrno, uname1, pwd1, passportno1, phoneNo1, emailId1)
);

select username1 from domuserdetails;
select username2 from intluserdetails;

create table domuserdetails (
    username1 varchar(20),
    passwrd1 varchar(20),
    primary key(username1, passwrd1)
);

create table intlregdetails (
	intlpnrno int,
	uname2 varchar(20),
    pwd2 varchar(20),
    fullname2 char(50) not null,
    age2 int check(age2 >= 18) not null,
    emailId2 varchar(30),
    phoneNo2 char(10) check(phoneNo2 !=11),
    gender2 char(10) not null,
    dob2 char(20) not null,
    passportno2 char(20),
    primary key(intlpnrno, uname2, pwd2, passportno2, phoneNo2, emailId2)
);

create table intluserdetails (
    username2 varchar(20),
    passwrd2 varchar(20),
    primary key(username2, passwrd2)
);

create table domFareDetails (
	id int check(id > 0),
	domairlinename char(50),
    domairlinefare double check(domairlinefare > 100.0),
    terminalno int,
    primary key(id, terminalno)
);

insert into domFareDetails values
(1, 'Air India', 4932.00, 4),
(2, 'SpiceJet', 7384.00, 6),
(3, 'IndiGo', 4784.00, 8),
(4, 'GoAir', 8926.00, 2),
(5, 'JetLite', 5783.00, 10);

create table intlFareDetails (
	id int check(id > 0),
    intlairlinename char(50),
    intlairlinefare double check(intlairlinefare > 100.00),
    terminalno int,
    primary key(id, terminalno)
);

insert into intlFareDetails values
(1, 'Emirates', 23495.00, 7),
(2, 'Lufthansa', 12938.00, 1),
(3, 'Air Cananda', 16482.00, 3),
(4, 'Qatar Airways', 32839.00, 9),
(5, 'Turkish Airlines', 27984.00, 5);

create table domesticFlightDetails (
	domsourceCity char(50) not null,
    domdestCity char(50) not null,
    domdepdate char(20)  not null,
    domretdate char(20)  not null,
    domterminalNo int primary key,
    domairlinename char(40) not null,
    domairfare double not null
);

create table internationalFlightDetails (
	intlsourceCity char(50) not null,
    intldestCity char(50) not null,
    intldepdate char(20)  not null,
    intlretdate char(20)  not null,
    intlterminalNo int primary key,
    intlairlinename char(40) not null,
    intlairfare double not null
);

create table domticketdetails (
	ticketNo char(20) not null,
    pnrno int,
    flighttype char(40) not null,
	fullname char(50) not null,
    age int check(age >= 18) not null,
    emailId varchar(30),
    phoneNo char(10) check(phoneNo != 11),
    gender char(10) not null,
    passportno char(20),
    airlinename char(50) default('N/A') not null,
    srcCity char(50) default('N/A') not null,
    destcity char(50) default('N/A') not null,
    dptdate char(20) default('N/A') not null,
    retdate char(20) default('N/A') not null,
    terminalno int default(0) not null,
    primary key(pnrno, phoneNo, emailId, passportno)
);

create table intlticketdetails (
	TicketNo char(20) not null,
    pnrNo int,
    flightType char(40) not null,
	fullName char(50) not null,
    Age int check(Age >= 18) not null,
    EmailId varchar(50),
    PhoneNo char(10) check(PhoneNo != 11),
    Gender char(10) not null,
    passportNo char(20),
    airlineName char(50) default('N/A') not null,
    SrcCity char(50) default('N/A') not null,
    destCity char(50) default('N/A') not null,
    dptDate char(20) default('N/A') not null,
    retDate char(20) default('N/A') not null,
    terminalNo int default(0) not null,
    primary key(pnrNo, PhoneNo, EmailId, passportNo)
);

/* Drop Table and Database Statements */
drop database aira;
drop table domuserdetails;
drop table domregdetails;
drop table intluserdetails;
drop table intlregdetails;
drop table domesticFlightDetails;
drop table internationalFlightDetails;
drop table domFareDetails;
drop table intlFareDetails;
drop table domticketdetails;
drop table intlticketdetails;

/* Select Query Statements */
select * from domuserdetails;
select * from domregdetails;
select * from intluserdetails;
select * from intlregdetails;
select * from domesticFlightDetails;
select * from internationalFlightDetails;
select * from domFareDetails;
select * from intlFareDetails;
select * from domticketdetails;
select * from intlticketdetails;