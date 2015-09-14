package com.lxz.roughset;

//http://volkanpaksoy.com/archive/2014/04/18/rough-set-implementation/
public class FindBorderApp {
	public static void main(String[] args){
		SystemParameters params = XmlConfigReader.ReadConfig("Config.xml");
		TextFileLogListener.LogPath = params.getLogPath();
		
		ConsoleLogListener consoleListener = new ConsoleLogListener(); 
		Logger.attachListener(consoleListener);

		TextFileLogListener fileListener = new TextFileLogListener();
		Logger.attachListener(fileListener);
		
		Logger.logMessage("-------------------------");
		Logger.logMessage("FindBorder Implementation");
		Logger.logMessage("-------------------------");
		Logger.logMessage(params.toString());
		
		FindBorder fb = new FindBorder(params);
		fb.run();
		
		Logger.logMessage("FindBorder Algorithm completed");
	}
}
