package br.inf.ufg.mddsm.controller.script

import org.eclipse.emf.compare.Diff

class ScriptInterpreter{
	
	private List<Diff> diffs;
	
	public void interpreter(ControlScript script) {
		
		List<Command> commands = script.commands
						
		commands.each{
			interpret($(it))
		}
	}
	
	public void interpret(Command command) {
		Map metadata = command.valueMetada();
		
		switch(command.action()) {
			case CommandAction.ADD:
				assert metadata.get("kindInteraction") == "DISTRIBUTED"
			
			case CommandAction.DELETE:
				log.info "Not implemented yet"
				break
				
			case CommandAction.CHANGE:
				log.info "Not implemented yet"
				break
				
			default:
				log.error "Action ${action} not supported"
				throw new RuntimeException("Action not supported")
		}
		
	}
	
}