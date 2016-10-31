
package start;

import java.awt.AWTException;
import java.io.IOException;

import util.CreateLog;
import util.ListFiles;
import util.LoadLists;

public class Start {
	
	
	public static void main(String[] args) throws AWTException, IOException{
		CreateLog logger = new CreateLog();

		try{
			
			logger.log("Inciando Servico!");
			
			LoadLists loadLists = new LoadLists();
			String[] listImg = loadLists.loadImg();
			String[] listDoc = loadLists.loadDoc();
			String[] listVid = loadLists.loadVid();
			String[] listMus = loadLists.loadMus();
			String[] listOut = loadLists.loadOut();
			
			while(1>0){			
				Thread.sleep(10000);
				ListFiles.execute(listImg, listDoc, listVid, listMus, listOut);
			}
		}catch (InterruptedException erro){
			erro.printStackTrace();
			logger.log("Erro no Start do processo!");
		}
	}

}