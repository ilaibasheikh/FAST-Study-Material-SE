#include<iostream>
#include<fstream>
#include<stdlib.h>
#include<windows.h>
#include<string.h>

using namespace std;
int i , j;
int MenuOption;

void OpenMenuM();
void OpenMenuE();
void CloseProgram();

class Date{
	
	int Month,Day,Year,ExpMonth,ExpDay,ExpYear;
	
	public:
		
		void setMonth(int Month){
			this->Month = Month;
		}
		
		void setDay(int Day){
			this->Day = Day;
		}
		
		void setYear(int Year){
			this->Year = Year;
		}
		
		void setExpMonth(int ExpMonth){
			this->ExpMonth = ExpMonth;
		}
		
		void setExpDay(int ExpDay){
			this->ExpDay = ExpDay;
		}
		
		void setExpYear(int ExpYear){
			this->ExpYear = ExpYear;
		}
		

		int getMonth(){
			return Month;
		}
		
		int getDay(){
			return Day;
		}
		
		int getYear(){
			return Year;
		}
		
		int getExpMonth(){
			return ExpMonth;
		}
		
		int getExpDay(){
			return ExpDay;
		}
		
		int getExpYear(){
			return ExpYear;
		}
		
};

class Stock : public Date{
	
	float Price;
	int Quantity;

	char ItemName[60];
	
	public:
		
		void setPrice(float Price){
			this->Price=Price;
		}
		
		void setQuantity(int Quantity){
			this->Quantity=Quantity;
		}
		
		void setItemName( string ItemName){
			strncpy(this->ItemName, ItemName.c_str(), 60);
		}
		
		float getPrice(){
			return Price;
		}
		
		int getQuantity(){
			return Quantity;
		}
		
		char *getItemName(){
			return ItemName;
		}
		
		friend void AddStock();
		
};

class Details {
	
	char Name[50], Address[50], Phone[50];
	int Age;
	
	public:
	
		void setAge(int Age){
			this->Age=Age;
		}
		
		void setName(char Name){
			this->Name[50] = Name;
		}
		
		void setName(string Name){
			strncpy(this->Name,Name.c_str(),50);
		}
		
		void setAddress(string Address){
			strncpy(this->Address,Address.c_str(),50);
		}
		
		void setPhone(string Phone){
			strncpy(this->Phone,Phone.c_str(),50);
		}
		
		int getAge(){
			return Age;
		}
		
		char *getName(){
			return Name;
		}
		
		char *getAddress(){
			return Address;
		}
		
		char *getPhone(){
			return Phone;
		}
};

class Customer: public Details{
	
	bool Membership;
	float Spent;
	
	public:
		
		void setMembership(bool Membership){
			this->Membership=Membership;
		}
				
		void setSpent(float Spent){
			this->Spent=Spent;
		}
		
		bool getMembership(){
			return Membership;
		}
		
		float getSpent(){
			return Spent;
		}
		
		friend void AddCustomer();
};

class Employee: public Details{
	
	char Password[50];
	int EmpNum;
	
	public:
		
		void setPassword(string Password){
			strncpy(this->Password, Password.c_str(), 60);
		}
		
		char *getPassword(){
			return Password;
		}
		
		void setEmpNum(int EmpNum){
			this->EmpNum=EmpNum;
		}
		
		int getEmpNum(){
			return EmpNum;
		}
		
		friend void AddEmployee();
};

void fordelay(int j)
{   int i,k;
    for(i=0;i<j;i++)
         k=i;
}

void HideCursor(){
   HANDLE consoleHandle = GetStdHandle(STD_OUTPUT_HANDLE);
   CONSOLE_CURSOR_INFO info;
   info.dwSize = 100;
   info.bVisible = FALSE;
   SetConsoleCursorInfo(consoleHandle, &info);
}

void BackMenu (){
	
	FutherOptions:
    	cout<<"\n\n1: Main Menu \n0: Exit \n";
    	cin>>MenuOption;
    	
        system("cls");
        
        if (MenuOption == 1)
            OpenMenuM(); //menu
        else if(MenuOption == 0)
            CloseProgram(); //close
        else {
            cout<<"\nInvalid Option!\a";
            goto FutherOptions;
        }
        
}

fstream EmpFile;
Employee NewEmployee;

fstream CusFile;
Customer NewCustomer;

fstream StockFile;
Stock NewStock;

fstream InvoiceFile;
Stock InvoiceReport;

void ViewStock(){ 

	bool Found = false;
	
    StockFile.open("StockRecord.txt",ios::in);
    
    system("cls");
    
    cout<<"\nNAME\t\tPRICE\t\tQUANTITY\t\tEXPIRY DATE\n";

	//StockFile.seekg(0);
	
   	while(StockFile.read((char*)&NewStock,sizeof(NewStock))){
        cout << NewStock.getItemName() << "\t\t"<< NewStock.getPrice() << "\t\t" << NewStock.getQuantity() << "\t\t\t" << NewStock.getExpDay() << "/" << NewStock.getExpMonth() <<"/"<< NewStock.getExpYear()<< endl;
       	Found = true;
	}	

    StockFile.close();
    
    if (Found == false){ 
	 	system("cls");
        cout<<"\nSTOCK RECORDS NOT FOUND!\n";
	}

	BackMenu ();	
}


void ViewEmployee(){ 
    
    bool Found = false;

    EmpFile.open("EmployeeRecord.txt",ios::in);
    
    system("cls");
    
    cout<<"\nEMPLOYEE NUMBER\t\tNAME\t\tAGE\t\tADDRESS\t\tPHONE\n";

    while(EmpFile.read((char*)&NewEmployee,sizeof(NewEmployee))){
        cout<< NewEmployee.getEmpNum() <<"\t\t"<< NewEmployee.getName() <<"\t\t"<< NewEmployee.getAge() <<"\t\t"<< NewEmployee.getAddress() <<"\t\t"<< NewEmployee.getPhone()<< endl;
        Found = true;
	}	

    EmpFile.close();
    
    if (Found == false){ 
	 	system("cls");
        cout<<"\nEMPLOYEE RECORDS NOT FOUND!\n";
	}

	BackMenu ();
}

void ViewCustomer(){ 

    bool Found = false;
    
    CusFile.open("CustomerRecord.txt",ios::in);
    
    system("cls");
    
    cout<<"\nMEMBERSHIP ACTIVE\t\tNAME\t\tAGE\t\tADDRESS\t\tPHONE\t\tSPENT\n";

    while(CusFile.read((char*)&NewCustomer,sizeof(NewCustomer))){
        cout<< NewCustomer.getMembership() << "\t\t"<< NewCustomer.getName() << "\t\t"<< NewCustomer.getAge() << "\t\t"<< NewCustomer.getAddress() << "\t\t"<< NewCustomer.getPhone() << "\t\t"<< NewCustomer.getSpent() << endl;
		Found = true;
	}	

     CusFile.close();
    
    if (Found == false){ 
	 	system("cls");
        cout<<"\nCUSTOMER RECORDS NOT FOUND!\n";
	}

	BackMenu ();	
}

void AddCustomer(){
	
    int choice;
    	
    account_no:
    	
        float Spent;
        char CName[50];
        
		system("cls");
        cout<<"\t\t\t ADD CUSTOMER RECORD ";

        cout<<"\nPlease Enter Amount Spent:- ";
        cin>>Spent;
        NewCustomer.setSpent(Spent);

        if(Spent >=10000){
            cout<<"\nThank you for being generous member! Membership has been Activated!";
            NewCustomer.setMembership(true);
        }
        else{
			cout<<"\nSorry, membership can not be availed!";
   			NewCustomer.setMembership(false);
    	}

        cout << "\n\nPlease Enter the Account Name:- ";
        cin.ignore();
        cin.getline(CName ,50);
        
 		CusFile.open("CustomerRecord.txt",ios::in);
 
        while(CusFile.read((char*)&NewCustomer,sizeof(NewCustomer))){
            	if ((strcmp(CName,NewCustomer.getName())) == 0){
          			cout<<"Account is taken! Please enter new details";
            		Sleep(1000);
            		CusFile.close();
            		goto account_no;
        		}
		}
		
		CusFile.close();
		
	CusFile.open("CustomerRecord.txt",ios::out|ios::app);
		
	string CAddress,CPhone;
	int CAge;
	
   	NewCustomer.setName(CName);
    	
   	cout<<"\nPlease Enter the Age: ";
   	cin>>CAge;
   	NewCustomer.setAge(CAge);
   		
	cout<<"\nPlease Enter the Address: ";
   	cin>>CAddress;
   	NewCustomer.setAddress(CAddress);
    		
	cout<<"\nPlease Enter the Phone Number: ";
   	cin>>CPhone;
   	NewCustomer.setPhone(CPhone);
    	
   	NewCustomer.setSpent(Spent);

    	
	CusFile.write((char*)&NewCustomer,sizeof(Customer));
   	CusFile.close();
  
   	cout<<"\n****Account has been created successfully!****";
    		
   	BackMenu ();

}

void AddEmployee(){//void Employee :: AddEmployee(){
	
    int choice;
    char EName[50];
    
	EmpFile.open("EmployeeRecord.txt",ios::out|ios::app);
	
    EmployeeOptions:
    	
    	system("cls");
    		
    	cout<<"\t\t\t REGISTER NEW EMPOYEE";
    	cout<<"\n\nPlease Enter the account Name of Employee:";
    		
   		cin.ignore();
        cin.getline(EName ,50);        
    
    	EmpFile.open("EmployeeRecord.txt",ios::in);
    	
    	while(EmpFile.read((char*)&NewEmployee,sizeof(NewEmployee))){
        	if ((strcmp(EName,NewEmployee.getName()) == 0)){
				cout<<"Employee Account is taken! Please enter new details";
            	Sleep(1000);
            	EmpFile.close();
               	goto EmployeeOptions;
			}
    	}
    		
    	EmpFile.close();
    		
    EmpFile.open("EmployeeRecord.txt",ios::out|ios::app);
				
    string EAddress,EPhone;
    int EAge,EmpNum;
    

    NewEmployee.setName(EName);
    	
    cout<<"\nPlease Enter the Employee Number: ";
   	cin>>EmpNum;
    NewEmployee.setEmpNum(EmpNum);
    
    cout<<"\nPlease Enter the Age: ";
   	cin>>EAge;
    NewEmployee.setAge(EAge);
    	
   	cout<<"\nPlease Enter the Address: ";
   	cin>>EAddress;
   	NewEmployee.setAddress(EAddress);
    	
   	cout<<"\nPlease Enter the Phone Number: ";
   	cin>>EPhone;
   	NewEmployee.setPhone(EPhone);

	EmpFile.write((char*)&NewEmployee,sizeof(Employee));
	EmpFile.close();
	
   	cout<<"\n**** Employee Account has been created successfully!****";
    	
	BackMenu();
}

void AddStock(){//void Stock :: AddStock(){
	
    int choice;
    char SName[50];
    
    StockOptions:
    	
    	system("cls");
    	
    	cout<<"\t\t\t ADD NEW STOCK RECORD  ";
    	cout<<"\n\nPlease Enter product: ";
    	
   		cin >> SName;            
   		
   		StockFile.open("StockRecord.txt",ios::in);
    	
		while(StockFile.read((char*)&NewStock,sizeof(NewStock))){
			if ((strcmp(SName,NewStock.getItemName())) == 0){
				cout<<"This NewStock already exists! Please enter new details!";
            	Sleep(1000);
            	StockFile.close();
            	goto StockOptions;
        	}
    	}	
    	StockFile.close();
    

    StockFile.open("StockRecord.txt",ios::out|ios::app);
     
    int SDay,SMonth,SYear,SQuantity;
    float SPrice;
    
    NewStock.setItemName(SName);
    
    cout<<"\nPlease Enter Price: ";
    cin>>SPrice;
    NewStock.setPrice(SPrice);
    
    cout<<"\nPlease Enter the Quantity: ";
    cin>>SQuantity;
    NewStock.setQuantity(SQuantity);
    
    cout<<"\nPlease Enter the Expiry Day: ";
    cin>>SDay;
    NewStock.setExpDay(SDay);
    
    cout<<"\nPlease Enter the Expiry Month: ";
    cin>>SMonth;
    NewStock.setExpMonth(SMonth);
    
    cout<<"\nPlease Enter the Expiry Year: ";
    cin>>SYear;
    NewStock.setExpYear(SYear);

	StockFile.write((char*)&NewStock,sizeof(Stock));
	StockFile.close();
	
    cout<<"\n**** STOCK has been added successfully!****";

	BackMenu();
}

//void Transaction(){
//}

void UpdateStocks(){
	
    int Option;
	bool Found = false;
	
	char SItemName[50];
	
	StockFile.open("StockRecord.txt",ios::in|ios::out);

    cout<<"\nEnter the Name of the Stock that you want to update:";
    cin>>SItemName;
    
 	while(StockFile.read((char*)&NewStock,sizeof(NewStock)) && Found == false){	 
	 	if ((strcmp(SItemName,NewStock.getItemName())) == 0){
            system("cls");
            
            cout << NewStock.getItemName() << "\t\t"<< NewStock.getPrice() << "\t\t" << NewStock.getQuantity() << "\t\t\t" << NewStock.getExpDay() << "/" << NewStock.getExpMonth() <<"/"<< NewStock.getExpYear();
            	
            string SName;
           	int SDay,SMonth,SYear,SQuantity;
    		float SPrice;
    
       		cout<<"\n\nEnter the Name: ";
    		cin>>SName;
    		NewStock.setItemName(SName);
    
    		cout<<"\nEnter the Price: ";
    		cin>>SPrice;
    		NewStock.setPrice(SPrice);
    
    		cout<<"\nEnter the Quantity: ";
    		cin>>SQuantity;
    		NewStock.setQuantity(SQuantity);
    
    		cout<<"\nEnter the Expiry Day: ";
    		cin>>SDay;
    		NewStock.setExpDay(SDay);
    
    		cout<<"\nEnter the Expiry Month: ";
   			cin>>SMonth;
    		NewStock.setExpMonth(SMonth);
    
    		cout<<"\nEnter the Expiry Year: ";
    		cin>>SYear;
    		NewStock.setExpYear(SYear);


            int Position = -1*sizeof(NewStock);
			StockFile.seekp(Position,ios::cur);
			StockFile.write((char*)&NewStock,sizeof(Stock));
				
			Found = true;
				
            
        	system("cls");
    		cout<<"\n\n\nChanges saved!";
    	
    	}
    
    }
    
	StockFile.close();
	
	if(Found == false){ 
		system("cls");
        cout<<"\nITEM RECORDS NOT FOUND!\a\a\a";
        Sleep(100000);
   	}
   	
	BackMenu();
    
}

fstream SearchFile;
Stock History;

void SearchProduct (){
  	int Option;
	bool Found = false;
	
	SearchFile.open("SearchFile.txt",ios::in|ios::out);

    cout<<"\t\t\tSEARCH FILE";    
    int i = 1;
	while(SearchFile.read((char*)&History,sizeof(History))){	
	   cout << endl << i << ". "<< History.getDay() << "/" << History.getMonth() <<"/"<< History.getYear();
	   i ++;	
	}
	
	int HDay,HMonth,HYear;
	
	cout << "\n\t\t\tDATE OF TRANSACTION ";
		
	cout << "\nEnter Day: ";
   	cin >> HDay;
    
	cout << "Enter Month: ";
   	cin >> HMonth;
		
	cout << "Enter Year: ";
    cin >> HYear;	
    	
 	while(SearchFile.read((char*)&History,sizeof(Stock))){	  
        if (HDay == History.getDay() && HMonth == History.getMonth() && HYear == History.getYear()){
            system("cls");
            cout << History.getItemName() << "\t\t"<< History.getPrice() << "\t\t" << History.getQuantity() << "\t\t\t" << History.getExpDay() << "/" << History.getExpMonth() <<"/"<< History.getExpYear();
    	}
    }
    
	SearchFile.close();

	BackMenu();	
}

void Transaction (){
	int Option;
	float TotalPrice = 0;
	int Count = 0;
    char ItemName[50];
    int Quantity;
    int NumItem = 0;
    bool Found = false;
    bool CheckFile = false;
//    string InvoiceItems[100][30] = {};
    
    cout<<"\t\t\t GENERATE TRANSACTION";
    cout<<"\n\t\tEnter End to Generate Invoice!";
	
	
	int SetQuantity;
	
	remove("InvoiceFile.txt");
	
	while(((strcmp(ItemName,"End")) != 0)){
		
		StockFile.open("StockRecord.txt",ios::in|ios::out);
		InvoiceFile.open("InvoiceFile.txt",ios::out|ios::app);
		SearchFile.open("SearchFile.txt",ios::out|ios::app);
		
		CheckFile = false;

		cout<<"\nName of the Item: ";
		cin.ignore();
		cin.getline(ItemName ,50);
    //	cin>>ItemName;
    	
    	if (((strcmp(ItemName,"End")) == 0)){
    		break;
		}
		
		SetQuantity = 0;
		
		int HDay,HMonth,HYear;
		cout << "\n\t\t\tDATE OF TRANSACTION";
		cout << "\nEnter Today Day: ";
    	cin >> HDay;
    
		cout << "Enter Today Month: ";
    	cin >> HMonth;
		
		cout << "Enter Today Year: ";
    	cin >> HYear;	
    
   		while(StockFile.read((char*)&NewStock,sizeof(NewStock))){
       		if ((strcmp(ItemName,NewStock.getItemName())) == 0){
       			
       			CheckFile = true;
       			
       			cout << "Enter Quantity of the Item: ";
       				
       			EnterQuantity:
    				cin>>Quantity;
       			
       				if ((Quantity < NewStock.getQuantity()) && (Quantity > 0)){
       					
					   
       					SetQuantity = NewStock.getQuantity() - Quantity;
       					NewStock.setQuantity(SetQuantity);
       			}
					   else{
        				cout<<"Enter a Valid Quantity of the Item: ";
       					goto EnterQuantity;      					
					}
       			
       			TotalPrice += NewStock.getPrice() * Quantity;
    			//NumItem ++ ;
    			
    			InvoiceReport.setItemName(NewStock.getItemName());
    			InvoiceReport.setPrice(NewStock.getPrice());
    			InvoiceReport.setQuantity(Quantity);
    			InvoiceReport.setExpDay(NewStock.getExpDay());
    			InvoiceReport.setExpMonth(NewStock.getExpMonth());
    			InvoiceReport.setExpYear(NewStock.getExpYear());
    			
				History.setItemName(NewStock.getItemName());
    			History.setPrice(NewStock.getPrice());
    			History.setQuantity(NewStock.getQuantity());
    			History.setExpDay(NewStock.getExpDay());
    			History.setExpMonth(NewStock.getExpMonth());
    			History.setExpYear(NewStock.getExpYear());
    	
    			History.setDay(HDay);
    			History.setMonth(HMonth);
    			History.setYear(HYear);
				    			    			
    			NewStock.setItemName(NewStock.getItemName());
    			NewStock.setPrice(NewStock.getPrice());
    			NewStock.setExpDay(NewStock.getExpDay());
    			NewStock.setExpMonth(NewStock.getExpMonth());
    			NewStock.setExpYear(NewStock.getExpYear());
    				
    			int Position = -1*sizeof(NewStock);
				StockFile.seekp(Position,ios::cur);
				StockFile.write((char*)&NewStock,sizeof(Stock));
				
				InvoiceFile.write((char*)&InvoiceReport,sizeof(Stock));
				SearchFile.write((char*)&History,sizeof(Stock));
				
				Found = true;
				
				SearchFile.close();
				InvoiceFile.close();
				StockFile.close();
			}
		}
		
		if (CheckFile == false){
			cout << "Item doesn't exist in the Database!";
		}
	}
	
	SearchFile.close();
	InvoiceFile.close();
	StockFile.close();

    if(Found == false){ 
		system("cls");
        cout<<"\nITEM RECORDS NOT FOUND!\a\a\a";
        Sleep(100000);
        BackMenu();
   	}
   	
	//BackMenu();
	
	//system("cls");
	
    cout<<"\n\n\t\t\t CUSTOMER INVOICE";
	
	int i;
    
    InvoiceFile.open("InvoiceFile.txt",ios::in);
    
	//printf("\n\n\t\tPRODUCT NAME\t\tPRICE");
	
	cout<<"\n\nNAME\t\tPRICE\t\tQUANTITY\t\tEXPIRY DATE\n";

	while(InvoiceFile.read((char*)&InvoiceReport,sizeof(Stock))){
  		cout << InvoiceReport.getItemName() << "\t\t"<< InvoiceReport.getPrice() << "\t\t" << InvoiceReport.getQuantity() << "\t\t\t" << InvoiceReport.getExpDay() << "/" << InvoiceReport.getExpMonth() <<"/"<< InvoiceReport.getExpYear();
    }
	
	
	printf("\n\n\t\tTotal Price: %f",TotalPrice);
	
	BackMenu();
	
}

void CloseProgram(){
    printf("\n\n\n\nLogged Off!");
}

void OpenMenuM(){  
 
	int MenuOption;
	
    system("cls");
    system("color 2");
  
    cout <<"\n\n\t\t\t\t CHILL MARKET MANAGEMENT";
    cout <<"\n\n\n\t\t\t\xB2\xB2\xB2\xB2\xB2\xB2\xB2 WELCOME TO THE MAIN MENU \xB2\xB2\xB2\xB2\xB2\xB2\xB2";
    cout <<"\n\n\t\t1.Add New Stocks\n\t\t2.Generate Transaction\n\t\t3.Create New Customer Account\n\t\t4.Create New Employee Account\n\t\t5.View Customer Records\n\t\t6.View Employee Records\n\t\t7.View Stocks\n\t\t8.Update Stocks\n\t\t9.Search Product\n\t\t10.Exit\n\n\t\tPlease Enter your choice: ";

	cin >> MenuOption;

    system("cls");
    
    switch(MenuOption){
  
	    case 1:AddStock();
	    	break;
   
        case 2:Transaction();
        	break;
        
	    case 3:AddCustomer();
        	break;
       
	    case 4:AddEmployee();
        	break;
       
	    case 5:ViewCustomer();
        	break;
        
        case 6:ViewEmployee();
            break;
       
	    case 7:ViewStock();
        	break;
       
	    case 8:UpdateStocks();
        	break;
        
		case 9:SearchProduct();
        	break;
        	
        case 0:CloseProgram();
        	break;
    }
}
void OpenMenuE(){  
 
	int MenuOption;
	
    system("cls");
    system("color 2");
  
    cout << "\n\n\t\t\t     CHILL MARKET MANAGEMENT SYSTEM";
    cout << "\n\n\n\t\t\t\xB2\xB2\xB2\xB2\xB2\xB2\xB2 WELCOME TO THE MAIN MENU \xB2\xB2\xB2\xB2\xB2\xB2\xB2";
    cout << "\n\n\t\t1.Add New Stocks\n\t\t2.Create New Customer Account\n\t\t3.Generate Transaction\n\t\t4.View Customer Records\n\t\t5.View Stocks\n\t\t6.Update Stocks\n\t\t7.Exit\n\n\n\n\n\t\t Enter your choice: ";

	cin >> MenuOption;

    system("cls");
    
    switch(MenuOption){
  
	    case 1:AddStock();
	    	break;
   
	    case 2:AddCustomer();
        	break;
        	
        case 3:Transaction();
        	break;
       
	    case 4:ViewCustomer();
        	break;
       
	    case 5:ViewStock();
        	break;
       
	    case 6:UpdateStocks();
        	break;
        
		case 7:CloseProgram();
        	break;
    }
}

int main()
{

	HideCursor();
	system("Color 9");
	
    char GetPass[20];
	char Password1[20]="M";
	char Password2[20]="E";
    pass:
    cout<<"\n\n\t\t\t******* CHILL MARKET *******";
    cout<<"\n\n\t\t\t----------------------------";
    cout<<"\n\n\t\t\tEnter the Password to login: ";
    cin >> GetPass;
    cout<<"\n\n\t\t\t----------------------------";

    if (strcmp(GetPass, Password1) == 0){
		
		cout<< "\n\n\n\t\t\t   ^^^Password Match!^^^\n\n\n\t\t\tLOADING";
    
    	int i;
    	
        for(i = 0; i <= 6; i++){
          fordelay(100000000);
            printf(".");
        }
        
		system("cls");
        OpenMenuM();
    }
    else if(strcmp(GetPass, Password2) == 0){
		cout<<"\n\n\n\t\t\t   ^^^Password Match!^^^\n\n\n\t\t\tLOADING";
    
    	int i;
    	
        for(i = 0; i <= 6; i++){
            fordelay(100000000);
            printf(".");
        }
        
		system("cls");
        OpenMenuE();
    }
    else{ 
		cout<<"\n\n\t\t\t**Error: Invalid Password!**\a\a\a";
		
       goto pass;   	
    }
    return 0;
}

