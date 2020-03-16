package com.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import selenium.Cons;

public class PropertiesFile {
	public static String getProperty(String key) {
		String value = null;
		try {
			Cons.fis = new FileInputStream("/EagercrowTestProject/src/main/java/com/objectrepository");
			Cons.prop = new Properties();
			Cons.prop.load(Cons.fis);
			value = Cons.prop.getProperty(key);
		} catch (FileNotFoundException e) {
			System.out.println("unable to open ObjectRepository");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}
	public static String[] getLocator(String key) {
		String[] values= null;
		try {
			Cons.fis=new FileInputStream("/EagercrowTestProject/src/main/java/com/objectrepository");
			Cons.prop=new Properties();
			Cons.prop.load(Cons.fis);
			String part = Cons.prop.getProperty(key);
			values = part.split("##");
			System.out.println("Locator types " + values[0]);
			System.out.println("Locator value " + values[1]);
		} catch (IOException e) {
			System.out.println("unable to open ObjectRepository");
			e.printStackTrace();
		}
		return values;
	}
}
