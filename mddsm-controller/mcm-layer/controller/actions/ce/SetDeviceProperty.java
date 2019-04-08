package controller.actions.ce;
import java.util.Hashtable;
import java.util.Map;

import broker.managers.MHB_TopManager;
import controller.util.BuildCmdHashTable;
import br.inf.ufg.mddsm.controller.manager.ManagerContext;
import br.inf.ufg.mddsm.controller.manager.SignalInstance;
import br.inf.ufg.mddsm.controller.manager.actions.MacroActionInstance;
import br.inf.ufg.mddsm.controller.state.StateHolder;


public class SetDeviceProperty implements MacroActionInstance {
	private Hashtable<String,Object> properties = new Hashtable<String,Object>();
	

	@Override
	public Object execute(ManagerContext ctx, Map<String, Object> params) {
		Object id = "CE01";
		StateHolder state = ctx.getStateManager().getType("CommandExecutorState").get(id);
		MHB_TopManager brokerManager = (MHB_TopManager)state.get("broker");
		brokerManager.setDevProperty("LC001", (String)params.get("deviceID"), (String)params.get("atribute"), params.get("value"));
		ctx.getMainManager().sendEvent(new SignalInstance("ack"));
		return null;
	}

}
