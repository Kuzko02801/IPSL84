package business.dataaccess.datainformation;

public class SqlStatements {
	public static final String SQL_SELECT_CARRERA = "select from carrera where id = ?";
	public static final String SQL_INSCRIBIR_ATLETA = "insert into inscripcion (email_atleta, id_carrera, estado, fecha_inscripcion, categoria) values (?, ?, ?, ?, ?)";
	public static final String SQL_NUMERO_INSCRIPCIONES = "select count(*) from carrera, inscripcion where carrera.id = ? and carrera.id = inscripcion.id_carrera";
}
