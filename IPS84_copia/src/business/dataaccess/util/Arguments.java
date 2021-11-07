package business.dataaccess.util;

public class Arguments {

	public static void isNotNull(Object o, String msg) {
		if(o == null)
			throw new IllegalArgumentException(msg);
	}
	
	public static void isTrue(boolean cond, String msg) {
		if(cond)
			throw new IllegalArgumentException(msg);
	}
}
