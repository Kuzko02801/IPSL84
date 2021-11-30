package business.dataaccess.parsers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import business.dataaccess.dto.AtletaDto;
import business.dataaccess.dto.dtoassembler.DtoAssembler;
import business.dataaccess.exception.BusinessDataException;
import gui.validadoresGUI.Validadores;

public class LoteAtletaParser {


	public static ArrayList<AtletaDto> parsearAtletas(File atletasFile) throws BusinessDataException {
		ArrayList<AtletaDto> atletas = new ArrayList<AtletaDto>();
		try {
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(atletasFile)));
			String line;
			int linea = 1;
			while ((line = br.readLine()) != null) {
				String[] args = line.split(";");
				if (args.length != 5) {
					throw new BusinessDataException("El archivo esta corrupto en la linea " + linea);
				}
				String email = args[0];
				if (!Validadores.comprobarEmail(email)) {
					throw new BusinessDataException("El archivo esta corrupto (email incorrecto) en la linea " + linea);
					//TODO continue; si quieres que se parseen los demas aunque 1 este corrupto
				}
				String dni = args[1];
				if (!Validadores.comprobarNoVacio(dni)) {
					throw new BusinessDataException("El archivo esta corrupto (dni incorrecto) en la linea " + linea);
				}
				String nombre = args[2];
				if (!Validadores.comprobarNoVacio(nombre)) {
					throw new BusinessDataException(
							"El archivo esta corrupto (nombre incorrecto) en la linea " + linea);
				}
				String sexo = args[4];
				if (!(sexo.equals("mujer") || sexo.equals("hombre"))) {
					throw new BusinessDataException("El archivo esta corrupto (sexo incorrecto) en la linea " + linea);
				}
				String fechaNacimiento = args[3];
				if (!Validadores.comprobarMayor18(fechaNacimiento)) {
					throw new BusinessDataException(
							"El archivo esta corrupto (fecha nacimiento incorrecta) en la linea " + linea);
				}
				AtletaDto atleta = DtoAssembler.forAtletaDto(email, dni, nombre, fechaNacimiento, sexo);
				atletas.add(atleta);
			}
			br.close();
		} catch (IOException e) {
			throw new BusinessDataException("El archivo esta corrupto");
		} catch (BusinessDataException e) {
			throw new BusinessDataException(e.getMessage());
		}

		return atletas;

	}

}
