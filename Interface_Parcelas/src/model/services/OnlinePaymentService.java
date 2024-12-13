package model.services;


/*Atributos em interfaces são sempre public, static e final: Isso significa que são essencialmente constantes. 
Você não pode declarar variáveis de instância em uma interface, apenas constantes.*/

public interface OnlinePaymentService {
	
	public Double paymentFee(Double amount);
	public Double interest(Double amount, Integer months);
	
}
