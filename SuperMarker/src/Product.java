/**
 * This class i used how a Nodo in the list
 * 
 * This Nodo have four variable, three be for characteristic
 * of product and one variable is a pointer 
 * @author Stiven Cáceres
 */
public class Product {
	
	//all variable for class product
	private double price;
	private int number;
	private Product next;
	private String name;
	
	//Start a product
	public void Product() {
		name = "Producto"; 
		price = (int)(Math.random()*1000 + 1);
		number = (int)(Math.random()*10 + 1);
	}
	
	//Setters and Getters for modify the variables
	public double getPrice() {return price;}
	public void setPrice(double price) {this.price = price;}
	public int getNumber() {return number;}
	public void setNumber(int number) {this.number = number;}
	public Product getNext() {return next;}
	public void setNext(Product next) {this.next = next;}	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
}
