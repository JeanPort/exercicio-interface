package services;

public class PaypalService implements OnlinePaymentService{

	private static final double FEE_VALUE = 0.02; 
	private static final double TAX_VALUE = 0.01;
	
	@Override
	public double paymentFee(double amount) {
		
		return amount * FEE_VALUE;
	}

	@Override
	public double interest(double amount, int months) {
		
		return amount * TAX_VALUE * months ;
	}

}
