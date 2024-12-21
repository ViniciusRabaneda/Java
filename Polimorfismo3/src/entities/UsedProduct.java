package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsedProduct extends Product{
	DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private LocalDate manufacturedDate;
	
	public UsedProduct() {
		
	}

	public UsedProduct(String name, Double price, LocalDate manufacturedDate) {
		super(name, price);
		this.manufacturedDate = manufacturedDate;
	}

	public LocalDate getManufacturedDate() {
		return manufacturedDate;
	}

	public void setManufacturedDate(LocalDate manufacturedDate) {
		this.manufacturedDate = manufacturedDate;
	}
	
	@Override
	public String priceTag() {
		String text = super.getName() + " (used) $ " + super.getPrice() + " (manufactured date: " + manufacturedDate.format(formatter).toString() + ")";
		return text;
	}
	
	
	
	
	
}
