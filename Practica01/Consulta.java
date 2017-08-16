import java.io.FileNotFoundException;
import java.io.IOException;
import com.csvreader.CsvReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class Consulta {

	List<Cliente> numClientes = new ArrayList<Cliente>();

	public Consulta(){
		inicializar();
	}
	
	public void inicializar() {
		//int i = 0;
		try {
         
        	CsvReader mi_csv = new CsvReader("P1.csv"); //Cambien a la ruta de su archivo
        	mi_csv.readHeaders(); // Leemos las Cabeceras, las cuales nos dan informacion de cada campo
        	while (mi_csv.readRecord())
        	{
            	String nombre = mi_csv.get(0);
            	String tel = mi_csv.get(1);
            	String direccion = mi_csv.get(2);
            	String correo = mi_csv.get(3);
            	String m2 = mi_csv.get(4);
            	String val_prop = mi_csv.get(5);
            	String val_venta = mi_csv.get(6);
            	numClientes.add(new Cliente(nombre, tel, direccion, correo, Float.parseFloat(m2), Float.parseFloat(val_prop), Float.parseFloat(val_venta)));

        	} 
        	mi_csv.close();
        
        } catch (FileNotFoundException e) {
           	e.printStackTrace();
           	System.out.println("No hay archivo");
        } catch (IOException e) {
        	System.out.println("Si hay archivo");
           	e.printStackTrace();
      	}
	}

	public void imprimir(List<Cliente> resultadoConsulta) {
		if (!resultadoConsulta.isEmpty()){
			for (Cliente resultados : resultadoConsulta) {
            	System.out.println("Nombre: "+ resultados.getNombre());
            	System.out.println("Telefono: " + resultados.getTelefono()); 
            	System.out.println("Direccion: " + resultados.getDireccion());             
            	System.out.println("Correo: " + resultados.getCorreo() + "\t");     
            	System.out.println("Metros Cuadrados: "+ resultados.getMetrosPropiedad() +" m2"); 
            	System.out.println("Valor de la Propiedad: $" + resultados.getValorPropiedad()); 
            	System.out.println("Valor para Venta: $"+ resultados.getVentaPropiedad() + "\n");
       		}
       	}
       	else
       		System.out.println("0 coincidencias\n");
       	System.out.println("/***********************************/\n");
	}

	public void imprimirSubLista(List<Cliente> resultadoConsulta, int numDatos) {
		if (!resultadoConsulta.isEmpty()){
			for (int i = 0 ; i < numDatos ; i++) {
            	System.out.println("Nombre: "+ resultadoConsulta.get(i).getNombre());
            	System.out.println("Telefono: " + resultadoConsulta.get(i).getTelefono()); 
            	System.out.println("Direccion: " + resultadoConsulta.get(i).getDireccion());             
            	System.out.println("Correo: " + resultadoConsulta.get(i).getCorreo() + "\t");     
            	System.out.println("Metros Cuadrados: "+ resultadoConsulta.get(i).getMetrosPropiedad() +" m2"); 
            	System.out.println("Valor de la Propiedad: $" + resultadoConsulta.get(i).getValorPropiedad()); 
            	System.out.println("Valor para Venta: $"+ resultadoConsulta.get(i).getVentaPropiedad() + "\n");
       		}
       	}
       	else
       		System.out.println("0 coincidencias\n");
       	System.out.println("/***********************************/\n");
	}

	public void imprimirSubListaGanancia(List<Cliente> resultadoConsulta, int numDatos) {
		if (!resultadoConsulta.isEmpty()){
			for (int i = 0 ; i < numDatos ; i++) {
            	System.out.println("Nombre: "+ resultadoConsulta.get(i).getNombre());
            	System.out.println("Telefono: " + resultadoConsulta.get(i).getTelefono()); 
            	System.out.println("Direccion: " + resultadoConsulta.get(i).getDireccion());             
            	System.out.println("Correo: " + resultadoConsulta.get(i).getCorreo() + "\t");     
            	System.out.println("Metros Cuadrados: "+ resultadoConsulta.get(i).getMetrosPropiedad() +" m2"); 
            	System.out.println("Valor de la Propiedad: $" + resultadoConsulta.get(i).getValorPropiedad()); 
            	System.out.println("Valor para Venta: $"+ resultadoConsulta.get(i).getVentaPropiedad());
            	System.out.println("Margen de Ganancia: $"+ (resultadoConsulta.get(i).getVentaPropiedad() - resultadoConsulta.get(i).getValorPropiedad())+ "\n");
       		}
       	}
       	else
       		System.out.println("0 coincidencias\n");
       	System.out.println("/***********************************/\n");
	}

    public void consulta1() {
    	List<Cliente> resultadoConsulta = new ArrayList<Cliente>();
    	for (Cliente aux : numClientes)
    		if ( (aux.getMetrosPropiedad() < 200) && (aux.getValorPropiedad() >= 50000) && (aux.getValorPropiedad() <= 500000) ) {
    			resultadoConsulta.add(new Cliente(aux));
    	}
    	System.out.println("\nPropiedades de menos de 200m2 y valen entre $50,000 y $500,000\n");
    	imprimir(resultadoConsulta);
    }

    public void consulta2() {
    	List<Cliente> resultadoConsulta = new ArrayList<Cliente>(numClientes);
    	int repetido = 0;
 	   	Collections.sort(resultadoConsulta, new Comparator<Cliente>() {
			@Override
			public int compare(Cliente p1, Cliente p2) {
				return new String(p1.getNombre()).compareTo(new String(p2.getNombre()));
			}
		});
		for (Cliente aux1 : numClientes) {
			for(Cliente aux2 : resultadoConsulta){
				if(aux2.getNombre().equals(aux1.getNombre()))
					repetido++;
			}
			if(repetido==1)
				resultadoConsulta.remove(aux1);
			repetido = 0;
		}
		System.out.println("Los nombres de los clientes que tienen más de un inmueble\n");
		imprimir(resultadoConsulta);
    }

    public void consulta3() {
    	List<Cliente> resultadoConsulta = new ArrayList<Cliente>(numClientes);
 	   	Collections.sort(resultadoConsulta, new Comparator<Cliente>() {
			@Override
			public int compare(Cliente p1, Cliente p2) {
				return new Float(p1.getValorPropiedad()).compareTo(new Float(p2.getValorPropiedad()));
			}
		});
 	   	System.out.println("\nLas 10 propiedades más baratas\n");
		imprimirSubLista(resultadoConsulta, 10);
    }

    public void consulta4() {
    	List<Cliente> resultadoConsulta = new ArrayList<Cliente>(numClientes);
 	   	Collections.sort(resultadoConsulta, new Comparator<Cliente>() {
			@Override
			public int compare(Cliente p1, Cliente p2) {
				return new Float(p2.getValorPropiedad()).compareTo(new Float(p1.getValorPropiedad()));
			}
		});
 	   	System.out.println("Cuántas y cuáles son las 5 propiedades más caras\n");
		imprimirSubLista(resultadoConsulta, 5);
    }

    public void consulta5() {
    	List<Cliente> resultadoConsulta = new ArrayList<Cliente>(numClientes);
 	   	Collections.sort(resultadoConsulta, new Comparator<Cliente>() {
			@Override
			public int compare(Cliente p1, Cliente p2) {
				return new Float(p2.getVentaPropiedad()-p2.getValorPropiedad()).compareTo(new Float(p1.getVentaPropiedad()-p1.getValorPropiedad()));
			}
		});
 	   	System.out.println("Las 5 propiedades con mayor margen de ganancia\n");
		imprimirSubListaGanancia(resultadoConsulta, 5);
    }

    public void consulta6() {
    	List<Cliente> resultadoConsulta = new ArrayList<Cliente>();
    	for (Cliente aux : numClientes)
    		if (aux.getDireccion().contains(", 2824"))  {
    			resultadoConsulta.add(new Cliente(aux));
    	}
    	System.out.println("Existen propiedades en el C.P. 2824\n");
    	imprimir(resultadoConsulta);
    }

    public static void main(String[] args) {
        Consulta personal = new Consulta();
        personal.consulta1();
        personal.consulta2();
        personal.consulta3();
        personal.consulta4();
        personal.consulta5();
        personal.consulta6();
    }
}