package com.crm.comcast.genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
*/
public class FileUtility {
public String getproperty_keyvalue(String key) throws IOException {
	FileInputStream fis=new FileInputStream("./common.property");
	Properties pobj=new Properties();
	pobj.load(fis);
	String value = pobj.getProperty(key);
	return value;
	}
}
