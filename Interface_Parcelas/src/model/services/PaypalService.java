package model.services;

/*Curiosidade: Uma classe que implementa uma interface pode ter variáveis de instância*/

public class PaypalService implements OnlinePaymentService {
	
	public Double paymentFee(Double amount) {
		return amount*0.02;
	}
	public Double interest(Double amount, Integer months) {
		return (amount*0.01)*months;
	}

}