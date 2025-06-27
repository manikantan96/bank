public abstract class Account implements AccountOperations{
     private String name;
     private  String mbno;
     private double amount;
     private int accNo;

Account(String name,String mbno,double amount,int accNo){
	this.name=name;
	this.mbno=mbno;
	this.amount=amount;
	this.accNo=accNo;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getMobileNumber() {
	return mbno;
}
public void setMobileNumber(String mbno) {
	this.mbno = mbno;
}
public double getAmount() {
	return amount;
}
public int getAccountNumber() {
	return accNo;
}
public abstract void menu();
@Override
public void statement() {
	System.out.println("Name is: "+getName());
	System.out.println("Mobile number is: "+getMobileNumber());
	System.out.println("your Account Number is: "+getAccountNumber());
	
}
@Override
public void withdraw() {
System.out.println("Enter Amount How Much you Want to Withdraw");
double withDrawAmount =Bank.sc.nextInt();
try {
	if(withDrawAmount<=0) {
		throw new InvalidBalanceException("Enter Amount Greater than 0");
	}
	else if(withDrawAmount>amount) {
		throw new InsufficientBalanceException("Please Enter the Amount Which is lower than your Balance:  "+getAmount());
	}else {
		amount-=withDrawAmount;
		System.out.println("amount of "+withDrawAmount+" withdrawed sucessfully and remaining balance is: "+getAmount());
	}
}
catch(InvalidBalanceException e) {
	System.out.println("Error Exception :"+e.getMessage());
}
catch(InsufficientBalanceException e) {
	System.out.println("Error Exception :"+e.getMessage());
}
}
@Override
public void deposite() {
	System.out.println("Enter Amount how much we want to Deposite");
	int dp=Bank.sc.nextInt();
	try {
	if (dp<0) {
		throw new InvalidBalanceException("Enter Amount Greater than 0");
	}else {
		amount+=dp;
		System.out.println("Amount of "+dp+" deposited sucessfully and remaining balance is: "+getAmount());
	}
	}
	catch(InvalidBalanceException e) {
		System.out.println("Error Exception: "+e.getMessage());
	}
	
}
@Override
public void customerCare() {
	System.out.println("Enter what you want to change");
	System.out.println("1.change Name");
	System.out.println("2.change Mobile Number");
	int opt=Bank.sc.nextInt();
	Bank.sc.nextLine();
	switch(opt) {
	case 1:
		System.out.println("Enter New Name: ");
	    String name=Bank.sc.nextLine();
	    setName(name);
	    System.out.println("Name updated sucessfully");
	    break;
	case 2:
		System.out.println("Enter New Mobile Number: ");
	    String mbno=Bank.sc.nextLine();
	    setMobileNumber(mbno);
	    System.out.println("mobile number updated sucessfully");
	    break;
	}

}
}
