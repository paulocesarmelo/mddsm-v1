package controller.script;

import controller.util.CommandTokenizer;

public class Command {

	private String[] params;
	public Command(String cmd){
		CommandTokenizer cmdTkn = new CommandTokenizer();
		params = cmdTkn.getCommandParams(cmd);
	}
	
	public String[] getCmdParams(){
		return params;
	}
}
