package business.dataaccess.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import business.dataaccess.dto.carrera.CarreraDto;
import business.dataaccess.parsers.CategoriaParser;

public class TableModelAssembler {

	public static TableModel carreraAssembler(List<CarreraDto> carreras) {
		String col[] = { "ID", "Nombre", "Fecha", "Tipo", "Distancia", "Plazas maximas", "Categorias", "Plazo1",
				"Cuota1", "Plazo2", "Cuota2", "Plazo3", "Cuota3" };
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		for (CarreraDto carrera : carreras) {
			int nPeriodos = carrera.periodos.size();
			Object[] row = new Object[12];
			List<Object> lista = new ArrayList<Object>(Arrays.asList(carrera.carrera_id, carrera.nombre,
					carrera.fecha.toString(), carrera.tipo.toString(), carrera.distancia, carrera.plazasMaximas,
					CategoriaParser.categoriasToString(carrera.categorias),
					carrera.periodos.get(0).getFechaInicio() + " - " + carrera.periodos.get(0).getFechaFin(),
					carrera.periodos.get(0).getCuota()));
			for (int i = 1; i < nPeriodos; i++) {
				lista.add(carrera.periodos.get(i).getFechaInicio() + " - " + carrera.periodos.get(i).getFechaFin());
				lista.add(carrera.periodos.get(i).getCuota());
			}
			for (int i = 0; i < lista.size(); i++) {
				row[i] = lista.get(i);
			}
			tableModel.addRow(row);
		}
		return tableModel;
	}

	public static TableModel clasificacionesAssembler(int numeroPuntosCorte, List<ArrayList<String>> clasificaciones) {
		
		// Establecemos model
		ArrayList<String> aux = new ArrayList<String>();
		aux.add("Posicion");
		aux.add("Dorsal");
		aux.add("Nombre");
		aux.add("Sexo");
		aux.add("Club");
		for (int i = 0; i < numeroPuntosCorte; i++) {
			aux.add("Punto corte " + i);
		}
		aux.add("Tiempo Final");
		DefaultTableModel tableModel = new DefaultTableModel(aux.toArray(), 0);

		for (ArrayList<String> clasificacion : clasificaciones) {

			ArrayList<String> listaAuxiliar = new ArrayList<String>();
			// Añade la posicion
			if (clasificacion.get(clasificacion.size() - 1).equals("DNF")
					|| clasificacion.get(clasificacion.size() - 1).equals("DNS")) {
				listaAuxiliar.add(" - ");
			} else {
				listaAuxiliar.add(clasificacion.get(0));
			}
			listaAuxiliar.add(clasificacion.get(1)); // añade dorsal
			listaAuxiliar.add(clasificacion.get(2)); // añade nombre
			listaAuxiliar.add(clasificacion.get(3)); // añade sexo
			listaAuxiliar.add(clasificacion.get(4)); // añade club
			// Añade los tiempos de corte
			String[] tiemposCorte = clasificacion.get(5).split(";");

			if (tiemposCorte[0].equals("DNS")) {
				for (int i = 0; i < numeroPuntosCorte; i++) {
					listaAuxiliar.add("-");
				}
			} else {
				for (int i = 0; i < tiemposCorte.length; i++) {
					listaAuxiliar.add(tiemposCorte[i]);
				}
			}
			listaAuxiliar.add(clasificacion.get(clasificacion.size() - 1)); // añade tiempoFinal
			tableModel.addRow(listaAuxiliar.toArray());
		}
		return tableModel;
	}
}
