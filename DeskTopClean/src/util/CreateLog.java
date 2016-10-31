package util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class CreateLog {
	
	public void log(String txt){

		File fileTxt = new File("./logs.txt");
		FileWriter fw;

		if(!fileTxt.exists()){
			try {
				fileTxt.createNewFile();
				fw = new FileWriter(fileTxt);
				fw.write("Data :" + new Date() + " - " + txt + "\n");
				fw.flush();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			try {
				fw = new FileWriter(fileTxt, true);
				PrintWriter pw = new PrintWriter(fw);
				pw.println("Data :" + new Date() + " - " + txt + "\n");
				pw.flush();
				pw.close();
			} catch (IOException err) {
				err.printStackTrace();
			}
		}
	}
}

