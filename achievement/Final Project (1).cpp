#include<stdlib.h>
#include<iostream>	 //for cin and cout functions
#include<string.h>   //for strings
#include<unistd.h>   //for time delay
#include<conio.h>    //for getting the character
#include<cstdlib>    //for different random number
#include<fstream>	 //for file handling
#include<ctime>      //for time seed
void form();       	 //for personal info
void account();      //for setting up the pin
void balance();      //for simply displaying the account balance
void comsats();      //for displaying the title on top
void deposit();      //for depositing the amount
void display();      //signing in
void month31();      //if month contains 31 days
void month30();      //if month contains 30 days
void month28();      //if month is feb
void withdraw();     //for withdrawing the amount
void credentials();  //mainmenu
void transaction();  //for all the transaction options
void read();
using namespace std;
string data,name,file_name,b_month,month_jan1="jan",month_jan2="january",month_jan3="Jan",month_jan4="January",month_jan5="JAN",month_jan6="JANUARY",month_jan7="01",month_jan8="1",month_feb1="feb",month_feb2="february",month_feb3="Feb",month_feb4="February",month_feb5="FEB",month_feb6="FEBRUARY",month_feb7="02",month_feb8="2",month_mar1="mar",month_mar2="march",month_mar3="Mar",month_mar4="March",month_mar5="MAR",month_mar6="MAR",month_mar7="03",month_mar8="3",month_apr1="apr",month_apr2="april",month_apr3="Apr",month_apr4="April",month_apr5="APR",month_apr6="APRIL",month_apr7="04",month_apr8="4",month_may1="may",month_may2="May",month_may3="MAY",month_may4="05",month_may5="5",month_jun1="jun",month_jun2="june",month_jun3="Jun",month_jun4="June",month_jun5="JUN",month_jun6="JUNE",month_jun7="06",month_jun8="6",month_jul1="jul",month_jul2="july",month_jul3="Jul",month_jul4="July",month_jul5="JUL",month_jul6="JULY",month_jul7="07",month_jul8="7",month_aug1="aug",month_aug2="august",month_aug3="Aug",month_aug4="August",month_aug5="AUG",month_aug6="AUGUST",month_aug7="08",month_aug8="8",month_sep1="sep",month_sep2="september",month_sep3="Sep",month_sep4="September",month_sep5="SEP",month_sep6="SEPTEMBER",month_sep7="09",month_sep8="9",month_oct1="oct",month_oct2="october",month_oct3="Oct",month_oct4="October",month_oct5="OCT",month_oct6="OCTOBER",month_oct7="10",month_nov1="nov",month_nov2="november",month_nov3="Nov",month_nov4="November",month_nov5="NOV",month_nov6="NOVEMBER",month_nov7="11",month_dec1="dec",month_dec2="december",month_dec3="Dec",month_dec4="December",month_dec5="DEC",month_dec6="DECEMBER",month_dec7="12";//all the possible entries of months
int b_year/*birth year entry*/,b_date/*birth date entry*/,opt/*main menu input*/,pin/*wallet pin for signing in*/,pin1/*setting the wallet pin*/,pin2/*confirming the wallet pin*/,cvc,bal/*storing balance8*/,dep/*storing deposit amounts*/,with/*storing withdrawal amounts*/,p1,p2,p3,p4,p5,p6,p7,p8/*storing separated values of pin*/,n1,n2,n3,n4,n5,n6,n7,n8,n9,n10,n11,n12,n13/*storing separated values of cnic number*/,m1,m2,m3,m4,m5,m6,m7,m8,m9,m10/*storing separated values of mobile number*/;
char f_name[21]/*storing first name*/,l_name[21]/*storing last name*/,city[16]/*storing city name*/;
long  long int account_number; //for storing 14-digit account number
long long number,mobile;       //for storing 10-digit mobile number and 13-digit cnic number
ofstream create;
ifstream variable;
main()
{
	credentials();
return 0;
}
void read()
{
				comsats();
				cout<<"Enter the first name of the account holder: ";cin>>name;
				char dot='.';
				char t='t';
				char x='x';
				name.push_back(dot);
				name.push_back(t);
				name.push_back(x);
				name.push_back(t);
				name[0]=toupper (name[0]);
				for(int i=1;i<=name.size();i++) // converting all the remaining alphabets of first name to lowercase
				{
					name[i]=tolower(name[i]);
				}
				variable.open(name.c_str());
				while(getline(variable,data))
				{
					cout<<data<<endl;
				}
				cout<<"\nEnter your pin to login: ";cin>>pin;cout<<endl; //matching the already set pin with the pin being used to sign in
				if(pin==pin2)
				{
					comsats();
					cout<<"You are logged in successfully!"<<endl;
					variable.close();
					sleep(1);
					cout<<"Press any key to continue..........";
					getch();
					transaction();
				}
}
void comsats() //title printing
{
	system("cls");
	cout<<"\n\t\t\t==========================================="<<endl;
	cout<<"\n\t\t\t     WELCOME TO COMSATS BANKING SYSTEM"<<endl;
	cout<<"\n\t\t\t==========================================="<<"\n\n\n";
}
void credentials() //mainmenu
{
	cred:
	{
		comsats();
		cout<<"Please select an option."<<"\n\n1. Account Details.\n2. Sign Up.\n3. Sign In.\n4. Exit.\n\n";cin>>opt;cout<<endl;
		switch(opt)
		{
			case 1:
			{
				if(account_number==0)//if no account data exists
				{
					comsats();
					cout<<"Please create an account first!";
					sleep(1);
					cout<<"\nPress any key to continue..........";
					getch();
					credentials();
				}
				else //display account data if exists
				{
					comsats();
					cout<<"\nYour account details are: "<<endl<<"_________________________________________________"<<"\n\nAccount    Number    : "<<account_number<<endl<<"Physical Card PIN    : "<<pin1<<endl<<"Expiry Date          : 12/27"<<endl<<"CVC                  : "<<cvc<<"\n_________________________________________________"<<"\n\nAccount Holder Name  : "<<f_name<<" "<<l_name<<endl<<"Date    of    Birth  : "<<b_date<<"."<<b_month<<"."<<b_year<<endl<<"Mobile#              : 0"<<m1<<m2<<m3<<"-"<<m4<<m5<<m6<<m7<<m8<<m9<<m10<<endl<<"CNIC#                : "<<n1<<n2<<n3<<n4<<n5<<"-"<<n6<<n7<<n8<<n9<<n10<<n11<<n12<<"-"<<n13<<endl<<"City                 : "<<city<<"\n_________________________________________________"<<"\n\nWarning! Don't share your PIN and CVC with anyone.";
					sleep(1);
					cout<<"\nPress any key to continue..........";
					getch();
					goto cred;
				}
				break;
			}
			case 2: //opening the account
			{
				form();
				cout<<"\n\nWarning! Don't share your PIN and CVC with anyone.";
				sleep(1);
				cout<<"\nPress any key to continue..........";
				getch();
				goto cred;
				break;
			}
			case 3: //not signing in without account creation
			{
				read();
				break;
			}
			case 4: //killing
			{
				comsats();
				cout<<"_________________________________________________";
				cout<<"\nDESIGNED	|    MUNEEB IQBAL (SP22-BCS-030)\nBY		|    ALI    ASJAD (SP22-BCS-055)";
				cout<<"\n________________|________________________________";
				sleep(1);
				cout<<"\n\nProcess ending in..........";
				sleep(1);
				cout<<"\n\n3";
				sleep(1);
				cout<<"\n\n2";
				sleep(1);
				cout<<"\n\n1";
				sleep(1);
				cout<<"\n\n";
				exit(0);
				break;
			}
			default:
			{
				comsats();
				cout<<"Please select from the given choices only.";
				sleep(1);
				cout<<"\nPress any key to continue..........";
				getch();
				goto cred;
			}
		}
	}
}
void form() //account creation
{
	comsats();
	cout<<"Enter your first name: ";cin.getline(f_name,41);
	cin.getline(f_name,41);
	f_name[0]=toupper(f_name[0]); //converting the first alphabet of first name to uppercase
	for(int i=1;i<21;i++) // converting all the remaining alphabets of first name to lowercase
	{
		f_name[i]=tolower(f_name[i]);
	}
	cout<<"Enter your last name: ";
	cin.getline(l_name,41);
	l_name[0]=toupper(l_name[0]); //converting the first alphabet of last name to uppercase
	for(int i=1;i<21;i++) // converting all the remaining alphabets of last name to lowercase
	{
		l_name[i]=tolower(l_name[i]);
	}
	cout<<"Enter your place of Birth: ";
	cin.getline(city,16);
	city[0]=toupper(city[0]); //converting the first alphabet of birthplace to uppercase
	for(int i=1;i<16;i++) // converting all the remaining alphabets of birthplace to lowercase
	{
		city[i]=tolower(city[i]);
	}
	byear:
	{
		cout<<"Enter your Birth Year: ";
		cin>>b_year;
		if(b_year<1919 || b_year>2023) 	//oldest man alive in Pak is 103 years old and nobody is born in 2024 yet
		{
			comsats();
			cout<<"Please enter the correct Birth Year!";
			sleep(1);
			cout<<"\nPress any key to continue..........";
			getch();
			comsats();
			goto byear;
		}
		else if(b_year>2005)	//kids born in 2006 or after are under-18
		{
			comsats();
			cout<<"You are not eligible to open an account!";
			sleep(1);
			cout<<"\nPress any key to continue..........";
			getch();
			comsats();
			goto byear;
		}
		else
		{
			bmonth:
			{	
				cout<<"Enter your birth month: ";
				cin>>b_month;
				if(b_month==month_jan1 || b_month==month_jan2 || b_month== month_jan3 || b_month==month_jan4 || b_month==month_jan5 || b_month==month_jan6 || b_month==month_jan7 || b_month==month_jan8 || b_month==month_mar1 || b_month==month_mar2|| b_month==month_mar3 || b_month==month_mar4 || b_month==month_mar5 || b_month==month_mar6 || b_month==month_mar7 || b_month==month_mar8 || b_month==month_may1 || b_month==month_may2 || b_month==month_may3 || b_month==month_may4 || b_month==month_may5 || b_month==month_jul1 || b_month==month_jul2 || b_month==month_jul3 || b_month==month_jul4 || b_month==month_jul5 || b_month==month_jul6 || b_month==month_jul7 || b_month==month_jul8 || b_month==month_aug1 || b_month==month_aug2 || b_month==month_aug3 || b_month==month_aug4 || b_month==month_aug5 || b_month==month_aug6 || b_month==month_aug7 || b_month==month_aug8 || b_month==month_oct1 || b_month==month_oct2 || b_month==month_oct3 || b_month==month_oct4 || b_month==month_oct5 || b_month==month_oct6 || b_month==month_oct7 || b_month==month_dec1 || b_month==month_dec2 || b_month==month_dec3 || b_month==month_dec4 || b_month==month_dec5 || b_month==month_dec6 || b_month==month_dec7)
				{
					month31(); //if the birth month contains 31 days
				}
				else if(b_month==month_apr1 || b_month==month_apr2 || b_month==month_apr3 || b_month==month_apr4 || b_month==month_apr5 || b_month==month_apr6 || b_month==month_apr7 || b_month==month_apr8 || b_month==month_jun1 || b_month==month_jun2 || b_month==month_jun3 || b_month==month_jun4 || b_month==month_jun5 || b_month==month_jun6 || b_month==month_jun7 || b_month==month_jun8 || b_month==month_sep1 || b_month==month_sep2 || b_month==month_sep3 || b_month==month_sep4 || b_month==month_sep5 || b_month==month_sep6 || b_month==month_sep7 || b_month==month_sep8 || b_month==month_nov1 || b_month==month_nov2 || b_month==month_nov3 || b_month==month_nov4 || b_month==month_nov5 || b_month==month_nov6 || b_month==month_nov7)
				{
					month30();	//if the birth month contains 30 days
				}
				else if(b_month==month_feb1 || b_month==month_feb2|| b_month==month_feb3 || b_month==month_feb4 || b_month==month_feb5 || b_month==month_feb6 || b_month==month_feb7 || b_month==month_feb8)
				{
					month28();	//if the birth month is february
				}
				else
				{
					comsats();
					cout<<"Please enter the correct birth month!";
					sleep(1);
					cout<<"\nPress any key to continue..........";
					getch();
					comsats();
					goto bmonth;	
				}
			}
		}
	}
}
void account() //creating wallet
{
	pin:
	{
		comsats();
		cout<<"Please set a 4-digit PIN: ";cin>>pin1; //setting the pin initially
		if(pin1>999 && pin1<10000 )
		{
			pin1:
			{
				comsats();
				cout<<"Re-enter the 4-digit PIN: ";cin>>pin2; //whether the pin entered is what the user wanted to enter
				if(pin1==pin2)
				{
					srand(time(0));//generating different sets of random numbers
					account_number=(rand()%(99999999999999-10000000000000+1))+10000000000000; //generating random 14-digit account number
					cvc=(rand()%(999-100+1))+100; //generating random 3-digit CVC number
					comsats();
					cout<<"Please wait for a while..........";
					sleep(2);
					comsats();
					cout<<"Congratulations! Your wallet has been created.\nYour account details are: "<<endl<<"_________________________________________________"<<"\n\nAccount    Number    : "<<account_number<<endl<<"Physical Card PIN    : "<<pin1<<endl<<"Expiry Date          : 12/27"<<endl<<"CVC                  : "<<cvc<<"\n_________________________________________________";
				}
				else
				{
					comsats();
					cout<<"Incorrect PIN entered!"<<endl<<endl;
					cout<<"Your previous PIN was: "<<pin1<<endl;
					sleep(1);
					cout<<"\nPress any key to continue..........";
					getch();
					goto pin1;
				}
			}
		}
		else if(pin1<1000 && pin1>=0) //if pin contains a starting zero
		{
			//storing the values separately
			p1=pin1/1000;
			p2=(pin1/100)%10;
			p3=(pin1/10)%10;
			p4=pin1%10;
			pin3:
			{
				comsats();
				cout<<"Re-enter the 4-digit PIN: ";cin>>pin2;
				p5=pin2/1000;
				p6=(pin2/100)%10;
				p7=(pin2/10)%10;
				p8=pin2%10; //comparing the all digits of the pin
				if(p5==p1 && p6==p2 && p7==p3 && p8==p4)
				{
					srand(time(0)); //generating different sets of random number
					account_number=(rand()%(99999999999999-10000000000000+1))+10000000000000; //generating random 14-digit account number
					cvc=(rand()%(999-100+1))+100; 	//generating random 3-digit cvc number
					comsats();
					cout<<"Please wait for a while..........";
					sleep(2);
					comsats();
					cout<<"Congratulations! Your wallet has been created.\nYour account details are: "<<endl<<"_________________________________________________"<<"\n\nAccount    Number    : "<<account_number<<endl<<"Physical Card PIN    : "<<p5<<p6<<p7<<p8<<endl<<"Expiry Date          : 12/27"<<endl<<"CVC                  : "<<cvc<<"\n_________________________________________________";
				}	
				else
				{
					comsats();
					cout<<"Incorrect PIN entered!"<<endl<<endl;
					cout<<"Your previous PIN was: "<<p1<<p2<<p3<<p4<<endl;
					sleep(1);
					cout<<"\nPress any key to continue..........";
					getch();
					goto pin3;
				}	
			}
		}
		else
		{
			goto pin;
		}
	}
}
void display() //sign in menu
{
	correct:
	{
		comsats();
		cout<<"Enter the first name of the account holder: ";cin>>name;
		char dot='.';
		char t='t';
		char x='x';
		char tee='t';
		name.push_back(dot);
		name.push_back(t);
		name.push_back(x);
		name.push_back(tee);
		variable.open(name.c_str());
		while(getline(variable,data))
		{
			variable>>data;
		}
		cout<<"\nEnter your pin to login: ";cin>>pin;cout<<endl; //matching the already set pin with the pin being used to sign in
		if(pin==pin2)
		{
			comsats();
			cout<<"You are logged in successfully!"<<endl;
			variable.close();
			sleep(1);
			cout<<"Press any key to continue..........";
			getch();
			transaction();
		}
		else
		{
			cout<<"Please enter the correct PIN!";
			sleep(2);
			goto correct;
		}
	}
}
void transaction() //transactions menu
{
	transac:
	{
		comsats();
		cout<<"Please select an option."<<"\n\n1. Balance Inquiry.\n2. Cash Withdrawal.\n3. Cash Deposit.\n4. Log Out.\n\n";cin>>opt;cout<<endl;
		switch(opt)
		{
			case 1: //balance inquiry
			{
				balance();
				break;
			}
			case 2: //amount withdrawal
			{
				withdraw();
				break;
			}
			case 3: //amount deposit
			{
				deposit();
				break;
			}
			case 4: //logout
			{
				comsats();
				cout<<"\n\nLogging Out in.........."<<"\n\n3";
				sleep(1);
				cout<<"\n\n2";
				sleep(1);
				cout<<"\n\n1";
				sleep(1);
				cout<<"\n\n";
				credentials();
				break;
			}
			default:
			{
				comsats();
				cout<<"Please select from the given choices only.";
				sleep(1);
				cout<<"\nPress any key to continue..........";
				getch();
				goto transac;
			}
		}
	}
}
void balance() //balance inquiry
{
	comsats();
	cout<<"Your Balance is: "<<bal<<".0 PKR.";
	sleep(1);
	cout<<"\nPress any key to continue..........";
	getch();
	transaction();
}
void withdraw() //withdrawing the amount
{
	with:
	{
		comsats();
		cout<<"Please enter the amount you want to withdraw(multiple of 500): ";cin>>with;cout<<endl;
		if(bal>0)
		{
			if(with<=bal && with%500==0 && with<=10000)
			{
				bal-=with;	//deducting the withdrawan amount from the total balance
				cout<<"Please wait for a while..........";
				sleep(2);
				comsats();
				cout<<"\nThe amount of "<<with<<".0 PKR has been withdrawn from your account."<<endl;
				cout<<"Your updated balance is "<<bal<<".0 PKR.";
				sleep(1);
				cout<<"\nPress any key to continue..........";
				getch();
				transaction();
			}
			else if(with<=bal && with%500==0 && with>10000) //setting the withdrawal amount limit to 10k
			{
				cout<<"Your withdrawal limit is 10,000 only!";
				sleep(1);
				cout<<"\nPress any key to continue..........";
				getch();
				goto with;
			}
			else if(with>bal && with%500==0 && with<=10000) // if withdraw is greater than available balance
			{
				cout<<"Insufficient funds! Your available balance is less than your withdrawal amount.";
				sleep(1);
				cout<<"\nPress any key to continue..........";
				getch();
				transaction();
			}		
			else	//if the withdrawal amount isn't a mutiple of 500
			{
				cout<<"Please enter the valid amount!";
				sleep(1);
				cout<<"\nPress any key to continue..........";
				getch();
				goto with;
			}
		}	
		else //if no balance found
		{
			cout<<"You don't have any funds in your account.";
			sleep(1);
			cout<<"\nPress any key to continue..........";
			getch();
			transaction();
		}
	}
}
void deposit() //depositing
{
	dep:
	{	
		comsats();
		cout<<"Please enter the amount you want to deposit(multiple of 500): ";cin>>dep;cout<<endl;
		if(dep%500==0 && dep>0)
		{
			bal+=dep;	//adding the deposit amount to the total balance
			if(bal>0 && bal<=500000)
			{
				cout<<"Please wait for a while..........";
				sleep(2);
				comsats();
				cout<<"\nYour account has been credited with the amount of "<<dep<<".0 PKR."<<endl;
				cout<<"Your updated balance is "<<bal<<".0 PKR.";
				sleep(1);
				cout<<"\nPress any key to continue..........";
				getch();
				transaction();
			}
			else
			{
				bal-=dep;	//limiting the balance limit to 500k
				cout<<"Your account limit is 500,000 only!";
				sleep(1);
				cout<<"\nPress any key to continue..........";
				getch();
				transaction();
			}
		}
		else //if the deposit amount isn't a multiple of 500
		{
			cout<<"Please enter the valid amount!";
			sleep(1);
			cout<<"\nPress any key to continue..........";
			getch();
			goto dep;
		}
	}
}
void month31() //entries for all the months with 31 days
{
	bdate:
	{
		cout<<"Enter your birth date: ";
		cin>>b_date;
		if(b_date<=0 || b_date>31)
		{
			comsats();
			cout<<"Please enter the correct birth date!";
			sleep(1);
			cout<<"\nPress any key to continue..........";
			getch();
			comsats();
			goto bdate;
		}
		else
		{	
			cnic:
			{
				cout<<"Enter your 13-digit CNIC#: ";
				cin>>number;
				if(number<1000000000000 || number>9999999999999)	
				{
					comsats();
					cout<<"Please enter the correct CNIC#!";
					sleep(1);
					cout<<"\nPress any key to continue..........";
					getch();
					comsats();
					goto cnic;
				}
				else
				{
					mobile:
					{
						cout<<"Enter your Mobile#: "<<"+92";cin>>mobile;
						if(mobile<3000000000 || mobile>=3479999999)	//checking the validity of mobile number acc to rules in Pakistan
						{ 
							comsats();
							cout<<"Please enter the correct Mobile#!";
							sleep(1);
							cout<<"\nPress any key to continue..........";
							getch();
							comsats();
							goto mobile;
						}
						else
						{
							comsats();
							cout<<"Please wait for a while..........";
							sleep(2);
							system("cls");
							account();
							if(b_month==month_jan1 || b_month==month_jan2 || b_month== month_jan3 || b_month==month_jan4 || b_month==month_jan5 || b_month==month_jan6 || b_month==month_jan7 || b_month==month_jan8) 
							{
								b_month="01";	//replacing all the entries of month january with "01"
							}
							else if(b_month==month_mar1 || b_month==month_mar2|| b_month==month_mar3 || b_month==month_mar4 || b_month==month_mar5 || b_month==month_mar6 || b_month==month_mar7 || b_month==month_mar8)
							{
								b_month="03";	//replacing all the entries of month march with "03"
							}
							else if(b_month==month_may1 || b_month==month_may2|| b_month==month_may3 || b_month==month_may4 || b_month==month_may5)
							{
								b_month="05";	//replacing all the entries of month may with "05"
							}
							else if(b_month==month_jul1 || b_month==month_jul2|| b_month==month_jul3 || b_month==month_jul4 || b_month==month_jul5 || b_month==month_jul6 || b_month==month_jul7 || b_month==month_jul8)
							{
								b_month="07";	//replacing all the entries of month july with "07"
							}
							else if(b_month==month_aug1 || b_month==month_aug2|| b_month==month_aug3 || b_month==month_aug4 || b_month==month_aug5 || b_month==month_aug6 || b_month==month_aug7 || b_month==month_aug8)
							{
								b_month="08";	//replacing all the entries of month august with "08"
							}
							else if(b_month==month_oct1 || b_month==month_oct2|| b_month==month_oct3 || b_month==month_oct4 || b_month==month_oct5 || b_month==month_oct6 || b_month==month_oct7)
							{
								b_month="10";	//replacing all the entries of month october with "10"
							}
							else if(b_month==month_dec1 || b_month==month_dec2|| b_month==month_dec3 || b_month==month_dec4 || b_month==month_dec5 || b_month==month_dec6 || b_month==month_dec7)
							{
								b_month="12";	//replacing all the entries of month december with "12"
							}
							n1=number/1000000000000;
							n2=(number/100000000000)%10;
							n3=(number/10000000000)%10;
							n4=(number/1000000000)%10;
							n5=(number/100000000)%10;
							n6=(number/10000000)%10;
							n7=(number/1000000)%10;
							n8=(number/100000)%10;
							n9=(number/10000)%10;
							n10=(number/1000)%10;
							n11=(number/100)%10;
							n12=(number/10)%10;
							n13=number%10;
							m1=mobile/1000000000;
							m2=(mobile/100000000)%10;
							m3=(mobile/10000000)%10;
							m4=(mobile/1000000)%10;
							m5=(mobile/100000)%10;
							m6=(mobile/10000)%10;
							m7=(mobile/1000)%10;
							m8=(mobile/100)%10;
							m9=(mobile/10)%10;
							m10=mobile%10;
							cout<<"\n\nAccount Holder Name  : "<<f_name<<" "<<l_name<<endl<<"Date    of    Birth  : "<<b_date<<"."<<b_month<<"."<<b_year<<endl<<"Mobile#              : 0"<<m1<<m2<<m3<<"-"<<m4<<m5<<m6<<m7<<m8<<m9<<m10<<endl<<"CNIC#                : "<<n1<<n2<<n3<<n4<<n5<<"-"<<n6<<n7<<n8<<n9<<n10<<n11<<n12<<"-"<<n13<<endl<<"City                 : "<<city<<"\n_________________________________________________";
							file_name=f_name;
							create.open(file_name.c_str());
							create<<"_________________________________________________"<<"\n\nAccount    Number    : "<<account_number<<endl<<"Physical Card PIN    : "<<pin1<<endl<<"Expiry Date          : 12/27"<<endl<<"CVC                  : "<<cvc<<"\n_________________________________________________"<<"\n\nAccount Holder Name  : "<<f_name<<" "<<l_name<<endl<<"Date    of    Birth  : "<<b_date<<"."<<b_month<<"."<<b_year<<endl<<"Mobile#              : 0"<<m1<<m2<<m3<<"-"<<m4<<m5<<m6<<m7<<m8<<m9<<m10<<endl<<"CNIC#                : "<<n1<<n2<<n3<<n4<<n5<<"-"<<n6<<n7<<n8<<n9<<n10<<n11<<n12<<"-"<<n13<<endl<<"City                 : "<<city<<"\n_________________________________________________";
							create.close();
						}
					}
				}
			}
		}
	}
}
void month30()	////entries for all the months with 30 days
{
	bdate:
	{
		cout<<"Enter your birth date: ";
		cin>>b_date;
		if(b_date<=0 || b_date>30)
		{
			comsats();
			cout<<"Please enter the correct birth date!";
			sleep(1);
			cout<<"\nPress any key to continue..........";
			getch();
			comsats();
			goto bdate;
		}
		else
		{	
			cnic:
			{
				cout<<"Enter your 13-digit CNIC#: ";
				cin>>number;
				if(number<1000000000000 || number>9999999999999)	
				{
					comsats();
					cout<<"Please enter the correct CNIC#!";
					sleep(1);
					cout<<"\nPress any key to continue..........";
					getch();
					comsats();
					goto cnic;
				}
				else
				{
					mobile:
					{
						cout<<"Enter your Mobile#: "<<"+92";cin>>mobile;
						if(mobile<3000000000 || mobile>3479999999)	//checking the validity of mobile number acc to rules in Pakistan
						{ 
							comsats();
							cout<<"Please enter the correct Mobile#!";
							sleep(1);
							cout<<"\nPress any key to continue..........";
							getch();
							comsats();
							goto mobile;
						}
						else
						{
							comsats();
							cout<<"Please wait for a while..........";
							sleep(2);
							system("cls");
							account();
							if(b_month==month_apr1 || b_month==month_apr2 || b_month== month_apr3 || b_month==month_apr4 || b_month==month_apr5 || b_month==month_apr6 || b_month==month_apr7 || b_month==month_apr8)
							{
								b_month="04";	//replacing all the entries of month april with "04"
							}
							else if(b_month==month_jun1 || b_month==month_jun2 || b_month== month_jun3 || b_month==month_jun4 || b_month==month_jun5 || b_month==month_jun6 || b_month==month_jun7 || b_month==month_jun8)
							{
								b_month="06";	//replacing all the entries of month june with "06"
							}
							else if(b_month==month_sep1 || b_month==month_sep2 || b_month== month_sep3 || b_month==month_sep4 || b_month==month_sep5 || b_month==month_sep6 || b_month==month_sep7 || b_month==month_sep8)
							{
								b_month="09";	//replacing all the entries of month september with "09"
							}
							else if(b_month==month_nov1 || b_month==month_nov2 || b_month== month_nov3 || b_month==month_nov4 || b_month==month_nov5 || b_month==month_nov6 || b_month==month_nov7)
							{
								b_month="11";	//replacing all the entries of month november with "11"
							}
							n1=number/1000000000000;
							n2=(number/100000000000)%10;
							n3=(number/10000000000)%10;
							n4=(number/1000000000)%10;
							n5=(number/100000000)%10;
							n6=(number/10000000)%10;
							n7=(number/1000000)%10;
							n8=(number/100000)%10;
							n9=(number/10000)%10;
							n10=(number/1000)%10;
							n11=(number/100)%10;
							n12=(number/10)%10;
							n13=number%10;
							m1=mobile/1000000000;
							m2=(mobile/100000000)%10;
							m3=(mobile/10000000)%10;
							m4=(mobile/1000000)%10;
							m5=(mobile/100000)%10;
							m6=(mobile/10000)%10;
							m7=(mobile/1000)%10;
							m8=(mobile/100)%10;
							m9=(mobile/10)%10;
							m10=mobile%10;
							cout<<"\n\nAccount Holder Name  : "<<f_name<<" "<<l_name<<endl<<"Date    of    Birth  : "<<b_date<<"."<<b_month<<"."<<b_year<<endl<<"Mobile#              : 0"<<m1<<m2<<m3<<"-"<<m4<<m5<<m6<<m7<<m8<<m9<<m10<<endl<<"CNIC#                : "<<n1<<n2<<n3<<n4<<n5<<"-"<<n6<<n7<<n8<<n9<<n10<<n11<<n12<<"-"<<n13<<endl<<"City                 : "<<city<<"\n_________________________________________________";
							file_name=f_name;
							create.open(file_name.c_str());
					        create<<"_________________________________________________"<<"\n\nAccount    Number    : "<<account_number<<endl<<"Physical Card PIN    : "<<pin1<<endl<<"Expiry Date          : 12/27"<<endl<<"CVC                  : "<<cvc<<"\n_________________________________________________"<<"\n\nAccount Holder Name  : "<<f_name<<" "<<l_name<<endl<<"Date    of    Birth  : "<<b_date<<"."<<b_month<<"."<<b_year<<endl<<"Mobile#              : 0"<<m1<<m2<<m3<<"-"<<m4<<m5<<m6<<m7<<m8<<m9<<m10<<endl<<"CNIC#                : "<<n1<<n2<<n3<<n4<<n5<<"-"<<n6<<n7<<n8<<n9<<n10<<n11<<n12<<"-"<<n13<<endl<<"City                 : "<<city<<"\n_________________________________________________";
							create.close();
						}
					}
				}
			}
		}
	}
}
void month28()	//entries for month february
{
	bdate:
	{
		cout<<"Enter your birth date: ";
		cin>>b_date;
		if(b_date<=0 || b_date>28)
		{
			comsats();
			cout<<"Please enter the correct birth date!";
			sleep(1);
			cout<<"\nPress any key to continue..........";
			getch();
			comsats();
			goto bdate;
		}
		else
		{	
			cnic:
			{
				cout<<"Enter your 13-digit CNIC#: ";
				cin>>number;
				if(number<1000000000000 || number>9999999999999)	
				{
					comsats();
					cout<<"Please enter the correct CNIC#!";
					sleep(1);
					cout<<"\nPress any key to continue..........";
					getch();
					comsats();
					goto cnic;
				}
				else
				{
					mobile:
					{
						cout<<"Enter your Mobile#: "<<"+92";cin>>mobile;
						if(mobile<3000000000 || mobile>3479999999) //checking the validity of mobile number acc to rules in Pakistan
						{ 
							comsats();
							cout<<"Please enter the correct Mobile#!";
							sleep(1);
							cout<<"\nPress any key to continue..........";
							getch();
							comsats();
							goto mobile;
						}
						else
						{
							comsats();
							cout<<"Please wait for a while..........";
							sleep(2);
							system("cls");
							account();
							if(b_month==month_feb1 || b_month==month_feb2 || b_month== month_feb3 || b_month==month_feb4 || b_month==month_feb5 || b_month==month_feb6 || b_month==month_feb7 || b_month==month_feb8)
							{
								b_month="02";	//replacing all the entries of month february with "02"
							}
							n1=number/1000000000000;
							n2=(number/100000000000)%10;
							n3=(number/10000000000)%10;
							n4=(number/1000000000)%10;
							n5=(number/100000000)%10;
							n6=(number/10000000)%10;
							n7=(number/1000000)%10;
							n8=(number/100000)%10;
							n9=(number/10000)%10;
							n10=(number/1000)%10;
							n11=(number/100)%10;
							n12=(number/10)%10;
							n13=number%10;
							m1=mobile/1000000000;
							m2=(mobile/100000000)%10;
							m3=(mobile/10000000)%10;
							m4=(mobile/1000000)%10;
							m5=(mobile/100000)%10;
							m6=(mobile/10000)%10;
							m7=(mobile/1000)%10;
							m8=(mobile/100)%10;
							m9=(mobile/10)%10;
							m10=mobile%10;
							cout<<"\n\nAccount Holder Name  : "<<f_name<<" "<<l_name<<endl<<"Date    of    Birth  : "<<b_date<<"."<<b_month<<"."<<b_year<<endl<<"Mobile#              : 0"<<m1<<m2<<m3<<"-"<<m4<<m5<<m6<<m7<<m8<<m9<<m10<<endl<<"CNIC#                : "<<n1<<n2<<n3<<n4<<n5<<"-"<<n6<<n7<<n8<<n9<<n10<<n11<<n12<<"-"<<n13<<endl<<"City                 : "<<city<<"\n_________________________________________________";
							file_name=f_name;
							create.open(file_name.c_str());
							create<<"_________________________________________________"<<"\n\nAccount    Number    : "<<account_number<<endl<<"Physical Card PIN    : "<<pin1<<endl<<"Expiry Date          : 12/27"<<endl<<"CVC                  : "<<cvc<<"\n_________________________________________________"<<"\n\nAccount Holder Name  : "<<f_name<<" "<<l_name<<endl<<"Date    of    Birth  : "<<b_date<<"."<<b_month<<"."<<b_year<<endl<<"Mobile#              : 0"<<m1<<m2<<m3<<"-"<<m4<<m5<<m6<<m7<<m8<<m9<<m10<<endl<<"CNIC#                : "<<n1<<n2<<n3<<n4<<n5<<"-"<<n6<<n7<<n8<<n9<<n10<<n11<<n12<<"-"<<n13<<endl<<"City                 : "<<city<<"\n_________________________________________________";
							create.close();
						}
					}
				}
			}
		}
	}
}
