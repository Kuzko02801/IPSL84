package business.gui;

import java.util.ArrayList;
import java.util.List;

import business.dataaccess.dto.carrera.Categoria;
import business.dataaccess.dto.carrera.Periodo;
import business.dataaccess.exception.BusinessDataException;
import business.dataaccess.util.DateSqlite;
import gui.validadoresGUI.Validadores;

public class CarreraManager {
	private List<Periodo> periodos = new ArrayList<>();
	private List<Categoria> categorias = new ArrayList<>();
	private List<Integer> puntosCorte = new ArrayList<>();

	public List<Periodo> getPeriodos() {
		return periodos;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public List<Integer> getPuntosCorte() {
		return puntosCorte;
	}

	public void cleanCategorias() {
		categorias.clear();
	}

	public void cleanPeriodos() {
		periodos.clear();
	}

	public void cleanPuntosCorte() {
		puntosCorte.clear();
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

	public void addPuntoCorte(int kilometro, int kilometroMaximo) throws BusinessDataException {
		comprobarPuntosCorte(kilometro, kilometroMaximo);
		puntosCorte.add(kilometro);
	}

	private void comprobarPuntosCorte(int kilometro, int kilometroMaximo) throws BusinessDataException {
		if (kilometro < 1) {
			throw new BusinessDataException("El kilometro no puede ser menor que 1");
		}
		if (kilometro >= kilometroMaximo) {
			throw new BusinessDataException("El kilometro es mayor que la distancia de la carrera");
		}
		for (Integer puntoCorte : puntosCorte) {
			if (kilometro == puntoCorte) {
				throw new BusinessDataException("Ya existe ese punto de corte");
			}
		}
	}

	public boolean comprobarFechaCarrera(String fechaCarrera) {
		for (Periodo p : periodos) {
			if (!Validadores.comprobarFechasValidas(fechaCarrera, p.getFechaInicio().getDate(),
					p.getFechaFin().getDate())) {
				return false;
			}
		}
		return true;
	}

	public boolean comprobarDistanciaKilometro(int kilometroMaximo) {
		for (Integer puntoCorte : puntosCorte) {
			if (puntoCorte >= kilometroMaximo) {
				return false;
			}
		}
		return true;
	}

}
