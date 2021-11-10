package business.dataaccess.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import business.dataaccess.dto.InscripcionDto;
import business.dataaccess.dto.carrera.CarreraDto;

public class TableModelAssembler {

	public static TableModel carreraAssembler(List<CarreraDto> carreras) {
		String col[] = { "ID", "Nombre", "Fecha", "Tipo", "Distancia", "Plazas maximas", "Plazo1", "Cuota1", "Plazo2",
				"Cuota2", "Plazo3", "Cuota3" };
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		for (CarreraDto carrera : carreras) {
			int nPeriodos = carrera.periodos.size();
			Object[] row = new Object[12];
			List<Object> lista = new ArrayList<Object>(Arrays.asList(carrera.carrera_id, carrera.nombre,
					carrera.fecha.toString(), carrera.tipo.toString(), carrera.distancia, carrera.plazasMaximas,
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
}
