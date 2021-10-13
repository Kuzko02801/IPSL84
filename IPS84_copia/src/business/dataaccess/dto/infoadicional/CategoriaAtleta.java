package business.dataaccess.dto.infoadicional;

public enum CategoriaAtleta {
	JUNIOR("junior"), SENIOR("senior"), VETERANO_1("veterano I"), VETERANO_2("veterano II");
	
	public final String label;
	
	private CategoriaAtleta(String label) {
		this.label = label;
	}
}

