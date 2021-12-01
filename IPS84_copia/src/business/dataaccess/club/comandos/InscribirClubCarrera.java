package business.dataaccess.club.comandos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import business.dataaccess.DataAccessFactory;
import business.dataaccess.datainformation.SqlStatements;
import business.dataaccess.datainformation.SqliteConnectionInfo;
import business.dataaccess.dto.AtletaDto;
import business.dataaccess.dto.carrera.CarreraDto;
import business.dataaccess.exception.BusinessDataException;
import business.dataaccess.util.Check;

public class InscribirClubCarrera {

	private String idCarrera;
	private List<AtletaDto> atletas;
	private String nombreClub;

	public InscribirClubCarrera(String idCarrera, List<AtletaDto> atletas,String nombreClub) {
		this.idCarrera = idCarrera;
		this.atletas = atletas;
		this.nombreClub=nombreClub;
	}

	public double inscribirClub() throws BusinessDataException {
		if (!Check.raceExists(idCarrera)) {
			throw new BusinessDataException("La carrera a la que se quiere inscribir no existe");
		}
		CarreraDto carrera = DataAccessFactory.forCarreraService().findCarreraById(idCarrera);
		if (!Check.checkCarreraAbierta(carrera.periodos)) {
			throw new BusinessDataException("La carrera no tiene plazos de inscripción abiertos");
		}

		int numeroDeAtletas = atletas.size();
		if (!Check.hayPlazasLibres(numeroDeAtletas, carrera)) {
			throw new BusinessDataException("La carrera no tiene plazas para tantos atletas");
		}
		int numeroAtletasInscritos=0;
		for (AtletaDto atleta : atletas) {
			if (!DataAccessFactory.forAtletaService().existeAtleta(atleta.email)) {
				DataAccessFactory.forAtletaService().atletaAdd(atleta);
			}
			if (!Check.existeInscripcion(atleta.email, idCarrera)) {
				DataAccessFactory.forAtletaService().inscribirAtleta(idCarrera, atleta.email);
				actualizarEstadoInscrito(atleta.email);
				numeroAtletasInscritos++;
			}
		}
		return DataAccessFactory.forInscripcionService().cuotaActualCarrera(idCarrera)*numeroAtletasInscritos;
	}
	
	private void actualizarEstadoInscrito(String email) throws BusinessDataException {
		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = DriverManager.getConnection(SqliteConnectionInfo.URL);
			ps = con.prepareStatement(SqlStatements.SQL_ACTUALIZAR_ESTADO_INSCRITO);
			ps.setString(1, nombreClub);
			ps.setString(2, idCarrera);
			ps.setString(3, email);
			ps.executeQuery();
			
			ps.close();
			con.close();
		} catch (SQLException e) {
			throw new RuntimeException("Ha ocurrido un error al cambiar el estado de los atletas del club a inscrito");
		}
	}
}
