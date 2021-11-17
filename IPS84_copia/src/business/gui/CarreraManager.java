package business.gui;

import java.util.ArrayList;
import java.util.List;

import business.dataaccess.dto.carrera.Categoria;
import business.dataaccess.dto.carrera.Periodo;
import business.dataaccess.exception.BusinessDataException;
import business.dataaccess.util.DateSqlite;

public class CarreraManager {
	private List<Periodo> periodos = new ArrayList<>();
	private List<Categoria> categorias = new ArrayList<>();

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

	public void addCategoria(String nombreCategoria, int edadInicio, int edadFin) throws BusinessDataException {
		comprobarEdadCategoria(edadInicio, edadFin);
		Categoria c = new Categoria(nombreCategoria, edadInicio, edadFin);
		categorias.add(c);
	}

	private void comprobarEdadCategoria(int edadInicio, int edadFin) throws BusinessDataException {
		if (categorias.isEmpty())
			return;
		for (Categoria c : categorias) {
			if (edadInicio > c.getEdadMinima() && edadInicio <= c.getEdadMaxima()
					|| edadFin >= c.getEdadMinima() && edadFin < c.getEdadMaxima())
				throw new BusinessDataException("Las edades de las categorias no se pueden solapar.");
		}
	}

	public void addPeriodo(String fechaInicio, String fechaFin, double cuota) throws BusinessDataException {
		comprobarFechaPeriodo(fechaInicio, fechaFin);
		Periodo p = new Periodo(new DateSqlite(fechaInicio), new DateSqlite(fechaFin), cuota);
		periodos.add(p);
	}

	private void comprobarFechaPeriodo(String fechaInicio, String fechaFin) throws BusinessDataException {
		if (periodos.isEmpty())
			return;

		DateSqlite inicio = new DateSqlite(fechaInicio);
		DateSqlite fin = new DateSqlite(fechaFin);

		for (Periodo p : periodos) {
			if (inicio.isAfter(p.getFechaInicio()) && inicio.isBefore(p.getFechaFin())
					|| fin.isAfter(p.getFechaInicio()) && fin.isBefore(p.getFechaFin()))
				throw new BusinessDataException("Las fechas no se pueden solapar.");
		}
	}
}
