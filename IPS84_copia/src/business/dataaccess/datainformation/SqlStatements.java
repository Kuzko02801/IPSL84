package business.dataaccess.datainformation;

public class SqlStatements {
	public static final String SQL_SELECT_CARRERA = "select from carrera where id = ?";
	public static final String SQL_INSCRIBIR_ATLETA = "insert into inscripcion (email_atleta, id_carrera, estado, categoria, fecha_inscripcion, id_inscripcion) values (?, ?, ?, ?, ?, ?)";
	public static final String SQL_NUMERO_INSCRIPCIONES = "select count(*) from carrera, inscripcion where carrera.id = ? and carrera.id = inscripcion.id_carrera";
	public static final String SQL_CARRERA_ABIERTA = "select id, nombre, fecha, tipo, distancia, cuota, cierre, plazasLibre from Carrera where estado = no_comenzada"; // Devuelve carreras fechas de inscripcion abierta
	public static final String SQL_INSCRIPCIONES_ATLETA = "select at.dni, at.nombre, ins.categoria, ins.fecha_inscripcion, ins.estado " // Devuelve datos de inscripcion de atletas.
														+ "from Atleta at, Inscripcion ins "
														+ "where ins.id_carrera = ? "
														+ "and ins.email_atleta = at.email"
														+ "order by fecha_inscripcion asc, estado asc";
	public static final String SQL_INSERT_CARRERA = "insert into carrera (nombre, fecha, tipo, distancia, cuota, id, plazas_maximas, cierre, apertura, estado) "
												  + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	// For testing
	public static final String SQL_TESTING_INSERT_ATLETA = "insert into Atleta (Email, Nombre, FechaNacimiento, Sexo) values (?, ?, ?, ?)";
	
	
}


