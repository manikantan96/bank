import java.util.*;
public class Bank {
private Map<Integer,Account> Accounts=new Hashtable<>();
static Scanner sc=new Scanner(System.in);
public void Menu() {
	while(true) {
	System.out.println("1: Create Acoount");
	System.out.println("2: Login to Account");
    System.out.println("3 :Exist");
    int opt=sc.nextInt();
    sc.nextLine();
    switch(opt) {
    case 1:
    	createAccount();
        break;
    case 2:
    	loginToAccount();
    	break;
    case 3:
    	return;
    default:
    	System.out.println("Enter Correct Choice");
}
   
	}
}
private void createAccount(){
	System.out.println("Enter Name: ");
	String name=sc.nextLine();
	System.out.println("Enter Mobile Number: ");
	String mbno=sc.nextLine();
	System.out.println("Enter Initial Amount: ");
	double amount=sc.nextDouble();
	System.out.println("Enter Type of Account 1.Saving or 2.Fixed Deposite");
    int type=sc.nextInt();
	int accNo=accountNo();
	Account acc;
	if(type==1) {
		acc=new SavingsAccount(name,mbno,amount,accNo);
	}else {
		acc=new FD_Account(name,mbno,amount,accNo);
	}
    Accounts.put(accNo, acc);
    System.out.println("Account Created sucessfully and your account Number is: "+accNo);
    
}
private int num=1000;
private int accountNo() {
	return num++;
}
void loginToAccount() {
	boolean flage=false;
	if(Accounts.isEmpty()) {
		System.out.println("No Account Found");
		return;
	}else {
		System.out.println("Enter Account Number: ");
		int number=sc.nextInt();
		Set<Integer> keys=Accounts.keySet();
		for(Integer key:keys) {
			if(key==number) {
				flage=true;
				Account a=Accounts.get(key);
				System.out.println("Welcome: "+a.getName());
				a.menu();
			}
		}
		try {
			if(flage!=true) {
				throw new InvalidAccountException("Invalid Account Number! Please Enter Correct Number");
			}
		}
		catch(InvalidAccountException e){
			System.out.println("Error: "+e.getMessage());
			
		}
	}
	
}



}
