-- Table 1

create schema tata_aia;
use tata_aia;

create table `policies` (
`Product_ID` bigint NOT NULL  ,
`Product_Name` VARCHAR(100) NOT NULL  ,
`Product_Details` VARCHAR(100) NULL  ,
`Product_Launch_Date` DATE NOT NULL  ,
`Product_End_Date` DATE NOT NULL,
PRIMARY KEY (Product_ID)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- Table 2

create table customerpolicy(
`Policy_Number` bigint NOT NULL ,
`Customer_ID` VARCHAR(50) NOT NULL ,
`Customer_Name` VARCHAR(100) NOT NULL ,
`Insured_Name` VARCHAR(100) NOT NULL ,
`DOB` DATE NULL ,
`Email_Address` VARCHAR(100) NULL ,
`Mobile_Number` bigint null ,
`Premium_Mode` VARCHAR(11) NULL ,
`Policy_Status` VARCHAR(8) NOT NULL ,
`Customer_PAN_NO` VARCHAR(10) NULL ,
`Policy_Issuance_Date` Date NOT NULL ,
`Contact_Number_Last_updated` Date NULL ,
`Email_Address_Last_updated` Date NULL ,
`Bank_Account_Number` varchar(20) NOT NULL ,
`whatsapp_opt_in_status` VARCHAR(3) NULL ,
`Product_Name` VARCHAR(100) NOT NULL ,
`Product_ID` bigint NOT NULL ,
`Reinvest_Applicable` boolean NULL ,
`Outstanding_Payout` bigint NULL ,
`Unclaimed_Amount` bigint NULL ,
`NEFT_Registered` boolean NULL ,
`Last_Premium_Paid` DATE NULL,
PRIMARY KEY (Policy_Number),
FOREIGN KEY (`Product_ID`) REFERENCES policies(`Product_ID`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

-- Table 3

create table optinlogger (
`Optin_ID` bigint NOT NULL auto_increment ,
`Mobile_Number` bigint NULL  ,
`Policy_Number` bigint UNIQUE NULL  ,
`Optin_Date` DATE NULL,
PRIMARY KEY (`Optin_ID`),
FOREIGN KEY (`Policy_Number`) REFERENCES customerpolicy(`Policy_Number`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

alter table optinlogger
auto_increment = 1;

-- Table 4
create table OtpLogger (
`Mobile_Number` bigint not NULL  ,
`OTP` bigint NULL  ,
`Expire_Time` TIME NULL  ,
`Created_Time` TIME NULL,
primary key (`Mobile_Number`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

-- Table 5
create table servicerequest (
`entityId` bigint NOT NULL auto_increment ,
`Mobile_Number` bigint NULL  ,
`Policy_Number` bigint NULL  ,
`Optin_Date` DATE NULL,
`Request_Details` VARCHAR(100) null,
PRIMARY KEY (`entityId`),
FOREIGN KEY (`Policy_Number`) REFERENCES customerpolicy(`Policy_Number`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

alter table servicerequest
auto_increment = 10001;


-- Table 1 insert 
insert into policies value (1, "aa" , "Not Available"  , "2019-07-10" , "2021-07-10");
insert into policies value(2, "bb" , "Not Available"  , "2019-07-10" , "2021-07-10");

-- Table 2 insert queries

insert into customerpolicy value( 1,123,"Kushagra1","Kushagra1","1994-12-21","Kushagra1@gmail.com",1111111111,"Monthly","Active","AS22AA22","2020-07-10","2020-05-10","2020-05-10","953421656526426000","Yes","aa",1,TRUE,20020,23333,TRUE,"2020-05-05");
insert into customerpolicy value( 
2,124,"Kushagra2","Kushagra2","1994-12-21","Kushagra2@gmail.com",1111111111,"Half Yearly","Active","AS22AA22","2020-07-10","2020-05-10","2020-05-10","953421656526426000","Yes","bb",2,TRUE,20020,23333,TRUE,"2020-05-05");
insert into customerpolicy value( 
3,125,"Kushagra3","Kushagra3","1994-12-21","Kushagra3@gmail.com",2222222222,"Yearly","Active","AS22AA22","2020-07-10","2020-05-10","2020-05-10","953421656526426000","No","aa",1,TRUE,20020,23333,TRUE,"2020-05-05");
insert into customerpolicy value( 
4,126,"Kushagra4","Kushagra4","1994-12-21","Kushagra4@gmail.com",3333333333,"Monthly","Active","AS22AA22","2020-07-10","2020-05-10","2020-05-10","953421656526426000","Yes","bb",2,TRUE,20020,23333,TRUE,"2020-05-05");
 insert into customerpolicy value( 
5,127,"Kushagra5","Kushagra5","1994-12-21","Kushagra5@gmail.com",4444444444,"Half Yearly","Active","AS22AA22","2020-07-10","2020-05-10","2020-05-10","953421656526426000","Yes","aa",1,TRUE,20020,23333,TRUE,"2020-05-05");
 insert into customerpolicy value( 
6,128,"Kushagra6","Kushagra6","1994-12-21","Kushagra6@gmail.com",1111111111,"Yearly","Active","AS22AA22","2020-07-10","2020-05-10","2020-05-10","953421656526426000","No","bb",2,TRUE,20020,23333,TRUE,"2020-05-05");
 insert into customerpolicy value( 
7,129,"Kushagra7","Kushagra7","1994-12-21","Kushagra7@gmail.com",2222222222,"Monthly","Active","AS22AA22","2020-07-10","2020-05-10","2020-05-10","953421656526426000","Yes","aa",1,TRUE,20020,23333,TRUE,"2020-05-05");
 insert into customerpolicy value( 
8,130,"Kushagra8","Kushagra8","1994-12-21","Kushagra8@gmail.com",3333333333,"Half Yearly","Active","AS22AA22","2020-07-10","2020-05-10","2020-05-10","953421656526426000","Yes","bb",2,TRUE,20020,23333,TRUE,"2020-05-05");
 insert into customerpolicy value( 
9,131,"Kushagra9","Kushagra9","1994-12-21","Kushagra9@gmail.com",4444444444,"Yearly","Active","AS22AA22","2020-07-10","2020-05-10","2020-05-10","953421656526426000","No","aa",1,TRUE,20020,23333,TRUE,"2020-05-05");
 insert into customerpolicy value( 
10,132,"Kushagra10","Kushagra10","1994-12-21","Kushagra10@gmail.com",5555555555,"Monthly","Active","AS22AA22","2020-07-10","2020-05-10","2020-05-10","953421656526426000","Yes","bb",2,TRUE,20020,23333,TRUE,"2020-05-05");


-- OptInTable DATA

insert into optinlogger value (1 , 1111111111 , 1 , "2020-10-11");
insert into optinlogger value (2 , 1111111111 , 2 , "2020-10-11");
insert into optinlogger value (3 , 1111111111 , 6 , "2020-10-11");


