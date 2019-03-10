import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args)
	{
		List list = new List();
		
		int selec = 0, position,option,number;
		double price;
		String name;
		String[] object = {"Agregar elementos a la factura","Eliminar elementos",
						   "Modificar elementos","Recalcular factura","Cerrar Programa"};
		for (int i = 0; i < 8; i++)
		{
			Product product = new Product();
			product.Product();
			list.addToFinal(product.getName(),product.getPrice(),product.getNumber());
		}
		
		//print with Jtable
		do{
			String resp = (String) JOptionPane.showInputDialog(null, "Seleccione "
			+ "una Obcion", "Super Mercado", JOptionPane.DEFAULT_OPTION, null, object, object[0]);
			
			
			
			for(int i = 0; i < 5 ; i++)
				if(resp == object[i])
					selec = i;
			
			switch (selec) {
			case 0:
				name = JOptionPane.showInputDialog(null,"Ingresa el nombre del producto","Añadir producto",JOptionPane.INFORMATION_MESSAGE);				
				price = Double.parseDouble(JOptionPane.showInputDialog(null,"Ingresa el precio","Añadir producto",JOptionPane.INFORMATION_MESSAGE));
				number = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa la cantidad","Añadir producto",JOptionPane.INFORMATION_MESSAGE));
				list.addToFinal(name, price, number);
				JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
				break;
			case 1:
				position = Integer.parseInt(JOptionPane.showInputDialog(null,"Numero del producto que quieres eliminar","Eliminar producto", JOptionPane.WARNING_MESSAGE));
				list.removeForPosition(position - 1);
				JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
				break;
			case 2:
				position = (Integer.parseInt(JOptionPane.showInputDialog(null,"Numero del producto que Quieres Editar","Editar Producto",JOptionPane.INFORMATION_MESSAGE))-1);
				option = JOptionPane.showOptionDialog(null,"Editar Producto", 
				   		"Que desea cambiar del producto",JOptionPane.YES_NO_CANCEL_OPTION,
				   		JOptionPane.QUESTION_MESSAGE,null,// null para icono por defecto.
				   		new Object[] { "Nombre", "Cantidad", "Precio" },"option 1");
				switch (option)
				{
				case 0:
					name = JOptionPane.showInputDialog(null,"Ingresa el nombre del producto","Editar Nombre",JOptionPane.INFORMATION_MESSAGE);
					list.editName(position, name);
					JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
					break;
				case 1:
					number = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa la cantidad del producto","Editar Cantidad",JOptionPane.INFORMATION_MESSAGE));
					list.editNumber(position, number);;
					JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
					break;
				case 2:
					price = Double.parseDouble(JOptionPane.showInputDialog(null,"Ingresa el precio	 del producto","Editar Precio",JOptionPane.INFORMATION_MESSAGE));
					list.editPrice(position, price);;
					JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
					break;
				}
				break;
			case 3:
				list.printList();
				break;
			}	
			System.out.println("Producto\tCantidad\tPrecio\t\tTotal");
			list.printList();
			System.out.println("\t\t\t\tIVA\t\t" + list.IVA());
			System.out.println("\t\t\t\tTOTAL\t\t" + list.total());
		}while (selec >= 0 && selec < 4);
	}
}
