package util;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class ListFiles {
	
	
	public static void execute(String[] listImg, String[] listDoc, String[] listVid, String[] listMus, String[] listOut) throws IOException{
		
		Properties p = LoadProperties.getProp();
		
		File file = new File(p.getProperty("DIR_ORIGEM"));
		File aFile[] = file.listFiles();
		int i = 0;
		if(aFile != null && aFile.length > 0){
			for (int j = aFile.length; i < j; i++) {
				File arquivos = aFile[i];
				move(listImg, arquivos, p.getProperty("DIR_IMG"));
				move(listDoc, arquivos, p.getProperty("DIR_DOC"));
				move(listVid, arquivos, p.getProperty("DIR_VID"));
				move(listMus, arquivos, p.getProperty("DIR_MUS"));
				move(listOut, arquivos, p.getProperty("DIR_OUT"));
			}
		}
	}
	
	public static void move(String[] list, File arquivos, String pasta){
		
		CreateLog logger = new CreateLog();

		for (int k = 0; k < list.length; k++) {
			if(arquivos.getName().endsWith("." + list[k].trim())){
				File dir = new File(pasta);
				if(new File(dir, arquivos.getName()).exists()){
					logger.log("Sobrescrevendo o arquivo existente ("+ arquivos.getName() +") para a pasta " + pasta);
					File fileToDelete = new File(pasta + "/" + arquivos.getName());
					fileToDelete.delete();
				}else{
					logger.log("Movendo o arquivo ("+ arquivos.getName() +") para a pasta " + pasta);
				}
				arquivos.renameTo(new File(dir, arquivos.getName()));
			}	
		}
	}

}