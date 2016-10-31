package util;

import java.util.Properties;

public class LoadLists {
	Properties p = LoadProperties.getProp();
	
	public String[] load(String type){
		String list[] = type.split(",");
		return list;
	}

	public String[] loadImg() {
		return load(p.getProperty("IMG"));
	}

	public String[] loadDoc() {
		return load(p.getProperty("DOC"));
	}

	public String[] loadVid() {
		return load(p.getProperty("VID"));
	}

	public String[] loadMus() {
		return load(p.getProperty("MUS"));
	}

	public String[] loadOut() {
		return load(p.getProperty("OUT"));
	}

}