package org.embedded.beaglebone.messages;

import java.util.ResourceBundle;

public class BBMessages {
	
private static ResourceBundle bundle;

	public static String getMessage(String key){
		if(bundle==null) {
			bundle = ResourceBundle.getBundle("org.gradle.properties.messages");
		}
		return bundle.getString(key);
	}
	
}
