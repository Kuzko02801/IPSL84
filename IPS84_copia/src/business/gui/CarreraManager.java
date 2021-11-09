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

	public void checkCategories() throws BusinessDataException {
		if(categorias.size()<1) {
			throw new BusinessDataException("Ha de haber al menos 1 categoría");
		}
		for (Categoria pivote : categorias) {
			for (Categoria categoria : categorias) {
				if (!categoria.equals(pivote)) {
					if (pivote.getEdadMinima() > categoria.getEdadMinima()
							&& pivote.getEdadMinima() < categoria.getEdadMaxima()
							|| pivote.getEdadMaxima() > categoria.getEdadMinima()
									&& pivote.getEdadMaxima() < categoria.getEdadMaxima()) {
						throw new BusinessDataException("Las edades de las categorias no se pueden solapar.");
					}
				}
			}
		}

	}

	public void checkPeriods(String fecha) throws BusinessDataException {
		if(periodos.size()<1) {
			throw new BusinessDataException("Ha de haber al menos 1 periodo");
		}
		for (Periodo pivote : periodos) {
			if (pivote.getFechaInicio().isAfter(new DateSqlite(fecha))
					|| pivote.getFechaFin().isAfter(new DateSqlite(fecha))) {
				throw new BusinessDataException("Las fechas de inicio y fin deben ser antes del inicio de la carrera.");
			}

			for (Periodo periodo : periodos) {
				if (!periodo.equals(pivote)) {
					/**
					 * Tira BusinessException si alguna de las fechas del pivote esta solapada con
					 * las del periodo.
					 */
					if (pivote.getFechaInicio().isAfter(periodo.getFechaInicio())
							&& pivote.getFechaInicio().isBefore(periodo.getFechaFin())
							|| pivote.getFechaFin().isAfter(periodo.getFechaInicio())
									&& pivote.getFechaFin().isBefore(periodo.getFechaFin())) {
						throw new BusinessDataException("Las fechas no se pueden solapar.");
					}
				}
			}
		}
	}

	public void addCategoria(String nombreCategoria, int edadInicio, int edadFin) {
		Categoria c=new Categoria(nombreCategoria, edadInicio, edadFin);
		categorias.add(c);
	}

	public void addPeriodo(String fechaInicio, String fechaFin, double cuota) {
		Periodo p=new Periodo(new DateSqlite(fechaInicio), new DateSqlite(fechaFin), cuota);
		periodos.add(p);
	}
}
