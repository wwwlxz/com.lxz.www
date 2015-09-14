package com.lxz.roughset;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileLogListener extends LogListener{
	public static String LogPath = "";
	
	private File outputFile = null;
	private FileWriter fileWriter = null;
	private BufferedWriter writer = null;
	
	public TextFileLogListener(){
		try{
			outputFile = new File(TextFileLogListener.LogPath);
			fileWriter = new FileWriter(outputFile);
			writer = new BufferedWriter(fileWriter);
		} catch(IOException e){
			throw new ApplicationException("Error while opening file: " + e.getMessage());
			//e.printStackTrace();
		}
	}
	
	@Override
	public void update(String message, boolean newLine) {
		try{
			writer.write(message);
			if(newLine){
				writer.write("\n");
			}
			writer.flush();
		} catch(IOException e){
			try{
				writer.close();
				fileWriter.close();
			} catch(IOException e1){
				//e.printStackTrace();
				throw new ApplicationException("Error while closing file : " + e1.getMessage());
			}
		}
	}
}
