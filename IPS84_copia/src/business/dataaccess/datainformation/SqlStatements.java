package business.dataaccess.datainformation;

public class SqlStatements {

	public static final String SQL_SELECT_CARRERA = "select * from carrera where id = ?";
	public static final String SQL_SELECT_ATLETA = "select * from atleta where email = ?";
	public static final String SQL_INSCRIBIR_ATLETA = "insert into inscripcion (email_atleta, id_carrera, estado, categoria, fecha_inscripcion) values (?, ?, ?, ?, ?)";
	public static final String SQL_NUMERO_INSCRIPCIONES = "select count(*) as numeroInscripciones from carrera, inscripcion where carrera.id = ? and carrera.id = inscripcion.id_carrera";
	public static final String SQL_CARRERAS = "select * from Carrera";

	public static final String SQL_INSCRIPCIONES_ATLETA = "select atleta.dni, atleta.nombre, inscripcion.categoria, inscripcion.fecha_inscripcion, inscripcion.estado, inscripcion.dorsal, inscripcion.club from inscripcion, atleta where atleta.email = inscripcion.email_atleta and inscripcion.id_carrera = ? order by inscripcion.fecha_inscripcion asc, inscripcion.estado asc";

	public static final String SQL_SELECT_TODAS_CARRERAS = "select * from carreras";
	public static final String SQL_INSERT_CARRERA = "insert into carrera (nombre, fecha, tipo, distancia, id, plazas_maximas, categorias, periodos,puntosdecorte,listaDeEspera, cancelacionInscripcion, porcentajeADevolver, fechaMaxCancelacion) "
			+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?)";
	public static final String SQL_CARRERA_PARTICIPADO = "select c.id,i.estado,c.nombre,c.fecha,c.tipo,c.distancia,c.categorias,c.periodos from carrera c, inscripcion i where i.email_atleta = ? and c.id = i.id_carrera";
	public static final String SQL_FIND_CATEGORIAS = "select categorias from carrera where id = ?";
	public static final String SQL_CLASIFICACION_ABSOLUTA = "SELECT ROW_NUMBER() over(order by inscripcion.tiempo) as posicion, atleta.nombre as nombre, atleta.sexo as sexo, inscripcion.tiempo as tiempo,"
			+ "inscripcion.tiemposCorte as tiemposCorte, inscripcion.club as club, inscripcion.dorsal as dorsal \r\n"
			+ "FROM carrera, inscripcion, atleta \r\n" + "WHERE carrera.id = ?\r\n"
			+ "AND carrera.id = inscripcion.id_carrera\r\n" + "AND atleta.email = inscripcion.email_atleta\r\n";

	public static final String SQL_CLASIFICACION_FEMENINA = "SELECT ROW_NUMBER() over(order by inscripcion.tiempo) as posicion, atleta.nombre as nombre, atleta.sexo as sexo, inscripcion.tiempo as tiempo,"
			+ "inscripcion.tiemposCorte as tiemposCorte, inscripcion.club as club, inscripcion.dorsal as dorsal \r\n"
			+ "FROM carrera, inscripcion, atleta \r\n" + "WHERE carrera.id = ?\r\n"
			+ "AND carrera.id = inscripcion.id_carrera\r\n"
			+ "AND atleta.email = inscripcion.email_atleta AND atleta.sexo = 'mujer'\r\n";

	public static final String SQL_CLASIFICACION_MASCULINA = "SELECT ROW_NUMBER() over(order by inscripcion.tiempo) as posicion, atleta.nombre as nombre, atleta.sexo as sexo, inscripcion.tiempo as tiempo,"
			+ "inscripcion.tiemposCorte as tiemposCorte, inscripcion.club as club, inscripcion.dorsal as dorsal \r\n"
			+ "FROM carrera, inscripcion, atleta \r\n" + "WHERE carrera.id = ?\r\n"
			+ "AND carrera.id = inscripcion.id_carrera\r\n"
			+ "AND atleta.email = inscripcion.email_atleta AND atleta.sexo = 'hombre'\r\n";
	public static final String SQL_CLASIFICACION_CATEGORIA = "SELECT ROW_NUMBER() over(order by inscripcion.tiempo) as posicion, atleta.nombre as nombre, atleta.sexo as sexo, inscripcion.tiempo as tiempo \r\n"
			+ " inscripcion.tiemposCorte as tiemposCorte, inscripcion.club as club, inscripcion.dorsal as dorsal "
			+ "FROM carrera, inscripcion, atleta \r\n" + "WHERE carrera.id = ?\r\n"
			+ "AND inscripcion.categoria = ?\r\n" + "AND carrera.id = inscripcion.id_carrera\r\n"
			+ "AND atleta.email = inscripcion.email_atleta\r\n";

	public static String SQL_ADD_ATLETA = "insert into atleta (email, dni, nombre, fechanacimiento, sexo) values (?, ?, ?, ?, ?)";
	// For testing
	public static final String SQL_TESTING_INSERT_ATLETA = "insert into Atleta (Email, dni, Nombre, FechaNacimiento, Sexo) values (?, ?, ?, ?, ?)";

	public static final String SQL_INSCRIPCION_PAGO = "UPDATE inscripcion SET estado = 'INSCRITO' WHERE email_atleta = ? AND id_carrera = ?";
	public static final String SQL_CARRERAS_ORGANIZADOR = "select id,nombre,fecha,tipo,distancia,plazas_maximas,categorias,periodos,puntosdeCorte,listaDeEspera,cancelacionInscripcion from carrera";
	public static final String SQL_INSCRIPCION_CARRERA_PAGO = "select * from inscripcion where id_carrera = ? and email_atleta = ? and estado = 'pendiente-de-pago'";

	public static final String SQL_FECHA_INSCRIPCION = "select fecha_inscripcion from inscripcion where id_carrera = ? and email_atleta = ?";

	public static final String SQL_INSCRIPCION_CONCRETA = "select * from inscripcion where email_atleta = ? and id_carrera = ?";
	public static final String SQL_PARTICIPANTES_CARRERA = "select count(*) from inscripcion where id_carrera = ?";
	public static final String SQL_INSCRIPCION_DORSAL = "select * from inscripcion where id_carrera = ?";
	public static final String SQL_INSCRIPCION_ACTUALIZAR_TIEMPOS = "UPDATE inscripcion SET tiempo= ?,tiempoInicio = ?, tiempoFin = ?, tiemposCorte = ? where id_carrera=? AND dorsal=?";
	public static final String SQL_INSCRIPCION_CARRERA = "select * from inscripcion where id_carrera = ? ";
	public static final String SQL_INSCRIPCION_ACTUALIZAR_DORSALES = "UPDATE inscripcion SET dorsal = ? where id_carrera = ? and email_atleta = ?";
	public static final String SQL_INSERTAR_LISTA_ESPERA = "INSERT INTO LISTADEESPERA (email_atleta, id_carrera) VALUES (?, ?)";
	public static final String SQL_ACTUALIZAR_CANTIDAD_PAGADA = "update inscripcion SET cantidadPagada = ? where id_carrera = ? and email_atleta = ?";
	public static final String SQL_OBTENER_CANTIDAD_PAGADA = "select cantidadPagada from inscripcion where id_carrera = ? and email_atleta = ?";
	public static final String SQL_ESTA_CARRERA_LLENA = "SELECT COUNT(*) " + "FROM CARRERA " + "WHERE ID = ? "
			+ "AND PLAZAS_MAXIMAS < (SELECT COUNT(*) " + "FROM INSCRIPCION" + "WHERE ID_CARRERA = ?)";
	public static final String SQL_PUESTO_LISTA_ESPERA = "SELECT COUNT(*) FROM LISTADEESPERA WHERE ID_CARRERA = ?";
	public static final String SQL_PLAZAS_MAXIMAS_CARRERA = "select plazas_Maximas from carrera where id = ?";
	public static final String SQL_EN_LISTA_ESPERA = "SELECT * FROM LISTADEESPERA WHERE email_atleta = ? AND id_carrera = ?";
	public static final String SQL_TIENE_LISTA_ESPERA = "SELECT listadeespera from carrera where id = ?";
	public static final String SQL_TIENE_CANCELACION = "SELECT cancelacionInscripcion from carrera where id = ?";
	public static final String SQL_CANCELAR_INSCRIPCION = "DELETE FROM inscripcion WHERE email_atleta = ? AND id_carrera = ?";
	public static final String SQL_INSCRIPCION_ESTADO_PAGO = "SELECT ESTADO FROM INSCRIPCION WHERE EMAIL_ATLETA = ? AND ID_CARRERA = ?";
	public static final String SQL_CHECKEAR_PAGO_A_TIEMPO = "select fecha_inscripcion from inscripcion where id_carrera = ? and email_atleta = ?";
	public static final String SQL_ACTUALIZAR_ESTADO_INSCRITO = "UPDATE inscripcion SET estado= 'INSCRITO', club = ? WHERE inscripcion.id_Carrera = ? AND email_atleta = ?";
	public static final String SQL_ENCONTRAR_EN_LISTA_ESPERA = "select * from listadeespera where email_atleta = ? and id_carrera = ?";
}
