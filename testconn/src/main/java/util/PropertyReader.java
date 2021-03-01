package util;

import java.util.ResourceBundle;

public class PropertyReader {
	private static ResourceBundle rb=ResourceBundle.getBundle("bundel.system");
	
	
	public static String getValue(String key) {
		String value=null;
		try {
			
			value=rb.getString(key);
		}
		catch(Exception e){
			value=key;
		}
		return value;
		}

	
	public static String getValue(String key, String param) {
        String msg = getValue(key);
        msg = msg.replace("{0}", param);
        return msg;
    }
}
