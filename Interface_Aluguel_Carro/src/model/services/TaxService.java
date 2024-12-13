package model.services;


//o uso do TaxService genérico e não TaxServiceBrasil, flexibiliza uma eventual troca na lógica do calculo da taxa, necessitando alterar apenas a instaciação no programa principal para UsaTAaxService por exemplo.
//Outro ponto de vantagem é que através do Upcasting é possível tratar a classe BrazilTaxService como sendo Taxservice sem interferir na classse RentalService.
public interface TaxService {
	double tax(double amount);
}
