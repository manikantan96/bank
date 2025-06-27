
public class SavingsAccount extends Account {
	SavingsAccount(String name,String mbno,double amount,int accNo){
		super(name,mbno,amount,accNo);

	}

	@Override
	public void menu() {
		while(true) {
		System.out.println("1.Check Balance");
        System.out.println("2.Deposite Amount");	
        System.out.println("3.Withdraw Amount");
        System.out.println("4.Account Details");
        System.out.println("5.Customer Care");
	    System.out.println("6.Exit");
	int opt=Bank.sc.nextInt();
	switch(opt) {
	case 1:
		System.out.println("your balance is"+getAmount());
		break;
	case 2:
		deposite();
		break;
	case 3:
		withdraw();
		break;
	case 4:
		statement();
		break;
	case 5:
		customerCare();
		break;
	case 6:
		return;
		
		
	}
	
		}
		
	}

	

}

