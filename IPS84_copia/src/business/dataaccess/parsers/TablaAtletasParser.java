package business.dataaccess.parsers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import business.dataaccess.dto.AtletaDto;
import business.dataaccess.dto.carrera.CarreraDto;
import business.dataaccess.dto.dtoassembler.DtoAssembler;

public class TablaAtletasParser {
	
	public static List<AtletaDto> parsearTablaParticipantes(JTable tablaParticipantes){
		 List<AtletaDto> atletas=new ArrayList<AtletaDto>();
		 for (int i = 0; i < tablaParticipantes.getRowCount(); i++) {
			String email= tablaParticipantes.getModel().getValueAt(i, 0).toString();
			String dni=tablaParticipantes.getModel().getValueAt(i, 1).toString();
			String nombre=tablaParticipantes.getModel().getValueAt(i, 2).toString();
			String fechaNacimiento=tablaParticipantes.getModel().getValueAt(i, 3).toString();
			String sexo=tablaParticipantes.getModel().getValueAt(i,4).toString();
			atletas.add(DtoAssembler.forAtletaDto(email,dni,nombre,fechaNacimiento,sexo));
		}
		return atletas;
	}
	
	public static TableModel parsearParticipantesTabla(List<AtletaDto> listaAtletas) {
		String col[] = { "Email", "Dni", "Nombre", "Fecha Nacimiento", "Sexo"};
		DefaultTableModel tableModel = new DefaultTableModel(col, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		for (AtletaDto atleta : listaAtletas) {
			Object[] row = new Object[5];
			List<Object> lista = new ArrayList<Object>(Arrays.asList(atleta.email,atleta.dni,atleta.nombre,atleta.fechaDeNacimiento.toString(),atleta.genero.label));
			for (int i = 0; i < lista.size(); i++) {
				row[i] = lista.get(i);
			}
			tableModel.addRow(row);
		}
		return tableModel;
	}

}
