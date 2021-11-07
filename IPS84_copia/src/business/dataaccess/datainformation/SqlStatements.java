package business.dataaccess.datainformation;

public class SqlStatements {
	
	
	public static final String SQL_SELECT_CARRERA = "select * from carrera where id = ?";
	public static final String SQL_SELECT_ATLETA = "select * from atleta where email = ?";
	public static final String SQL_INSCRIBIR_ATLETA = "insert into inscripcion (email_atleta, id_carrera, estado, categoria, fecha_inscripcion) values (?, ?, ?, ?, ?)";
	public static final String SQL_NUMERO_INSCRIPCIONES = "select count(*) from carrera, inscripcion where carrera.id = ? and carrera.id = inscripcion.id_carrera";
	public static final String SQL_CARRERA_ABIERTA = "select * from Carrera where"
			+ " fechaFin1 > date('now') and fechaInicio1 <= date('now')"
			+ "or fechaFin2 > date('now') and fechaInicio2 <= date('now')"
			+ "or fechaFin3 > date('now') and fechaInicio3 <= date('now')"; // Devuelve carreras fechas de inscripcion abierta

	public static final String SQL_INSCRIPCIONES_ATLETA = "select atleta.dni, atleta.nombre, inscripcion.categoria, inscripcion.fecha_inscripcion, inscripcion.estado from inscripcion, atleta where atleta.email = inscripcion.email_atleta and inscripcion.id_carrera = ? order by inscripcion.fecha_inscripcion asc, inscripcion.estado asc";
														
	public static final String SQL_SELECT_TODAS_CARRERAS = "select * from carreras";
	public static final String SQL_INSERT_CARRERA = "insert into carrera (nombre, fecha, tipo, distancia, id, plazas_maximas, estado, fechaInicio1, fechaInicio2, fechaInicio3, fechaCierre1, fechaCierre2, fechaCierre3, cuota1, cuota2, cuota3) "
												  + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String SQL_CLASIFICACION_ABSOLUTA = "SELECT atleta.nombre, atleta.sexo, inscripcion.tiempo \r\n"
			+ "FROM carrera, inscripcion, atleta \r\n"
			+ "WHERE carrera.id = ?\r\n"
			+ "AND carrera.id = inscripcion.id_carrera\r\n"
			+ "AND atleta.email = inscripcion.email_atleta\r\n"
			+ "AND carrera.estado = 'finalizada' order by inscripcion.tiempo";
	public static final String SQL_CLASIFICACION_FEMENINA = "SELECT atleta.nombre, atleta.sexo, inscripcion.tiempo \r\n"
			+ "FROM carrera, inscripcion, atleta \r\n"
			+ "WHERE carrera.id = ?\r\n"
			+ "AND carrera.id = inscripcion.id_carrera\r\n"
			+ "AND atleta.email = inscripcion.email_atleta\r\n"
			+ "AND atleta.sexo = 'mujer'\r\n"
			+ "AND carrera.estado = 'finalizada' order by inscripcion.tiempo;";
	public static final String SQL_CLASIFICACION_MASCULINA = "SELECT atleta.nombre, atleta.sexo, inscripcion.tiempo \r\n"
			+ "FROM carrera, inscripcion, atleta \r\n"
			+ "WHERE carrera.id = ?\r\n"
			+ "AND carrera.id = inscripcion.id_carrera\r\n"
			+ "AND atleta.email = inscripcion.email_atleta\r\n"
			+ "AND atleta.sexo = 'hombre'\r\n"
			+ "AND carrera.estado = 'finalizada' order by inscripcion.tiempo;";
	public static String SQL_ADD_ATLETA = "insert into atleta (email, dni, nombre, fechanacimiento, sexo) values (?, ?, ?, ?, ?)";
	// For testing
	public static final String SQL_TESTING_INSERT_ATLETA = "insert into Atleta (Email, dni, Nombre, FechaNacimiento, Sexo) values (?, ?, ?, ?, ?)";
	
	public static final String SQL_INSCRIPCION_PAGO = "UPDATE inscripcion SET estado = 'INSCRITO' WHERE email_atleta = ? AND id_carrera = ?";
	public static final String SQL_CARRERAS_ORGANIZADOR = "select * from carrera";
}


