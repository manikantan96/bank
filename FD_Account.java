public class FD_Account extends Account {
	FD_Account(String name,String mbno,double amount,int accNo){
		super(name,mbno,amount,accNo);
		
	}
	
	@Override
	public void menu() {	
		while(true) {
		System.out.println("1.Check Balance");
        System.out.println("2.Account Betails");
        System.out.println("3.Customer Care");
	    System.out.println("4.Exit");
	int opt=Bank.sc.nextInt();
	switch(opt) {
	case 1:
		System.out.println("your balance is"+getAmount());
		break;
	case 2:
		statement();
		break;
	case 3:
		customerCare();
		break;
	case 4:
		return;
		
		
	}
	
		}
	}	

}
