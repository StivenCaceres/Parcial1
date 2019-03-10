
public class List 
{
	private Product start;
	private int size;
	
	public void List() 			//Start the List
	{
		start = null;
		size = 0;
	}
	
	public boolean isEmpty()	//question ¿is Empty?
	{return start == null;}
	
	public int getSize()		//Get the size
	{return size;}
	
	public void addToFinal(String name, double value, int number) //add the product to list
	{
		Product newProduct = new Product();
		newProduct.setPrice(value);
		newProduct.setNumber(number);
		newProduct.setName(name);
		if(isEmpty())
			start = newProduct;
		else {
			Product aux = start;
			while (aux.getNext() != null)
				aux = aux.getNext();
			aux.setNext(newProduct);
		}
		size++;
	}
	
	public void editPrice(int position, double price)
	{
		if(position >= 0 && position < size) 
		{
			if(position == 0)
				start.setPrice(price);
			else {
				Product aux = start;
				for(int i = 0; i < position; i++)
					aux = aux.getNext();
				aux.setPrice(price);
			}
		}
	}
	
	public void editNumber(int position, int number)
	{
		if(position >= 0 && position < size) 
		{
			if(position == 0)
				start.setNumber(number);
			else {
				Product aux = start;
				for(int i = 0; i < position; i++)
					aux = aux.getNext();
				aux.setNumber(number);
			}
			subTotal(position);
		}
	}
	
	public void editName(int position, String name)
	{
		if(position >= 0 && position < size) 
		{
			if(position == 0)
				start.setName(name);
			else {
			Product aux = start;
			for(int i = 0; i < position; i++)
				aux = aux.getNext();
			aux.setName(name);
			}
		}
	}
	
	public void removeForPosition(int position)
	{
		if(position >= 0 && position < size) {
			if(position == 0)
				start = start.getNext();
			else {
				Product aux = start;
				for(int i = 0 ; i< position - 1; i++)
					aux = aux.getNext();
				Product next = aux.getNext();
				aux.setNext(next.getNext());
			}
			size--;
		}
	}
	
	public double subTotal(int position)		//Get the sub total 
	{
		double subtotal = 0.0;
		if(position >= 0 && position < size) {
			if(position == 0)
				subtotal = start.getPrice()*start.getNumber();
			else {
				Product aux = start;
				for(int i = 0 ; i < position; i++)
					aux = aux.getNext();
				subtotal = aux.getPrice() * aux.getNumber();
			}
		}
		return subtotal;
	}
	
	public double IVA()
	{
		return total() * 0.19;
	}
	
	public double total()		//sum all the products
	{
		int auxPosition = 0;
		double total = 0.0;
		while(auxPosition != size)
		{
			total += subTotal(auxPosition);
			auxPosition++;
		}
		return total;
	}

	public void printList()
	{
		if(!isEmpty())
		{
			Product aux = start;
			int i = 0;
			while (aux != null)
			{
				if(aux.getName().equals("Producto"))
					System.out.print("Producto" + (i+1) + "\t    " + aux.getNumber()
					+ "\t\t" + aux.getPrice() + "\t\t" + subTotal(i));
				else
					System.out.print(aux.getName() + "\t\t    " + aux.getNumber()
					+ "\t\t" + aux.getPrice() + "\t\t" + subTotal(i));
				
				aux = aux.getNext();
				i++;
				System.out.println();
			}
			System.out.println();
		}
	}
}
