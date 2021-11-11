package business.dataaccess.parsers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import business.dataaccess.dto.pago.HistorialPago;

public class HistorialSerializer {
	

	
	public static void serializarPagos(List<HistorialPago> pagos, String id_carrera) throws IOException {
		
		FileWriter fileWriter = new FileWriter("pagos" + id_carrera + ".txt");
	    PrintWriter printWriter = new PrintWriter(fileWriter);	    
	    for(HistorialPago hp : pagos) {
	    	printWriter.printf(hp.toString());
	    }	    
	    printWriter.close();
	}

	public static void serializarPagos(HistorialPago hp) throws IOException {
		
	    BufferedWriter writer = new BufferedWriter(new FileWriter("pagos" + hp.getId_carrera() + ".txt", true));
	    writer.append('\n');
	    writer.append(hp.toString());
	    
	    writer.close();
		
	}
}
