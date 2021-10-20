package business.dataaccess.datainformation;

public class SqlStatements {
	//
	
	public static final String SQL_SELECT_CARRERA = "select * from carrera where id = ?";
	public static final String SQL_SELECT_ATLETA = "select * from atleta where email = ?";
	public static final String SQL_INSCRIBIR_ATLETA = "insert into inscripcion (email_atleta, id_carrera, estado, categoria, fecha_inscripcion) values (?, ?, ?, ?, ?)";
	public static final String SQL_NUMERO_INSCRIPCIONES = "select count(*) from carrera, inscripcion where carrera.id = ? and carrera.id = inscripcion.id_carrera";
	public static final String SQL_CARRERA_ABIERTA = "select id, nombre, fecha, tipo, distancia, cuota, cierre from Carrera where estado = 'no_comenzada'"; // Devuelve carreras fechas de inscripcion abierta
	public static final String SQL_INSCRIPCIONES_ATLETA = "SELECT Atleta.dni, Atleta.nombre, Inscripcion.categoria, Inscripcion.fecha_inscripcion, Inscripcion.estado"
														+ "FROM Atleta, Inscripcion"
														+ "WHERE Atleta.email = Inscripcion.email_atleta"
														+ "AND Inscripcion.id_carrera = ?";
														
	public static final String SQL_SELECT_TODAS_CARRERAS = "select * from carreras";
	public static final String SQL_INSERT_CARRERA = "insert into carrera (nombre, fecha, tipo, distancia, cuota, id, plazas_maximas, cierre, apertura, estado) "
												  + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String SQL_CLASIFICACION_ABSOLUTA = "SELECT atleta.nombre, atleta.sexo, inscripcion.tiempo " + 
			" FROM carrera, inscripcion, atleta " + 
			" WHERE carrera.id = ? " + 
			" AND carrera.id = inscripcion.id_carrera" + 
			" AND atleta.email = inscripcion.email_atleta"
			+ "AND carrera.estado = 'finalizado'";
	public static final String SQL_CLASIFICACION_FEMENINA = "SELECT atleta.nombre, atleta.sexo, inscripcion.tiempo " + 
			"FROM carrera, inscripcion, atleta " + 
			"WHERE carrera.id = ? " + 
			"AND carrera.id = inscripcion.id_carrera " + 
			"AND atleta.email = inscripcion.email_atleta " + 
			"AND atleta.sexo = 'mujer' ";
	public static final String SQL_CLASIFICACION_MASCULINA = "SELECT atleta.nombre, atleta.sexo, inscripcion.tiempo " + 
			"FROM carrera, inscripcion, atleta " + 
			"WHERE carrera.id = ? " + 
			"AND carrera.id = inscripcion.id_carrera " + 
			"AND atleta.email = inscripcion.email_atleta " + 
			"AND atleta.sexo = 'hombre' ";
	public static String SQL_ADD_ATLETA = "insert into atleta (email, dni, nombre, fechanacimiento, sexo) values (?, ?, ?, ?, ?)";
	// For testing
	public static final String SQL_TESTING_INSERT_ATLETA = "insert into Atleta (Email, dni, Nombre, FechaNacimiento, Sexo) values (?, ?, ?, ?, ?)";
	
	public static final String SQL_INSCRIPCION_PAGO = "UPDATE inscripcion SET estado = 'INSCRITO' WHERE email_atleta = ? AND id_carrera = ?";
	
}


