package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import enums.OrderStatus;

public class Order {
	
	DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	
	private LocalDateTime moment;
	private OrderStatus status;
	
	private ArrayList<OrderItem> items = new ArrayList<>();
	private Client client;

	public Order() {
		
	}

	public Order(LocalDateTime moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public LocalDateTime getMoment() {
		return moment;
	}

	public void setMoment(LocalDateTime moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}


	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public double total() {
		double sum =0.0;
		for(OrderItem it:items) {
			sum = sum +it.subTotal();
		}
		return sum;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		sb.append(sdf.format((moment))+ "\n");
		sb.append("Order Status: ");
		sb.append(status+ "\n");
		sb.append("Client: ");
		sb.append(client+ "\n");
		sb.append("Order Items:\n ");
		for (OrderItem item:items) {
			sb.append(item + "\n");
		}
		sb.append("Total Price: $");
		sb.append(String.format("%.2f",total()));
		return sb.toString() ;
	}
	
	
}
