package business.gui;

import java.util.ArrayList;
import java.util.List;

import business.dataaccess.dto.carrera.Categoria;
import business.dataaccess.dto.carrera.Periodo;

public class CarreraManager {
	private List<Periodo> periodos = new ArrayList<>();
	private List<Categoria> categorias = new ArrayList<>();
	
	public void addPeriodo(Periodo periodo) {
		periodos.add(periodo);
	}
	
	public void addCategoria(Categoria categoria) {
		categorias.add(categoria);
	}
	
	public List<Periodo> getPeriodos() {
		return periodos;
	}
	
	public List<Categoria> getCategorias() {
		return categorias;
	}
	
	public void cleanCategorias() {
		categorias.clear();
	}
	
	public void cleanPeriodos() {
		periodos.clear();
	}
}
