package l2kstudios.gme.view.actioninterface;

import l2kstudios.gme.model.action.postmove.PostMoveDecisionMenu;
import l2kstudios.gme.model.actioninterface.ActionInterface;
import l2kstudios.gme.model.actioninterface.AttackOptions;
import l2kstudios.gme.model.actioninterface.MovementGrid;

public class ActionInterfaceViewFactory {
	
	static public ActionInterfaceView newActionInterfaceView(ActionInterface actionInterface) {
		if(actionInterface instanceof MovementGrid) {
			return new MovementGridView(){{
				setModel(actionInterface);
			}};
		} else if(actionInterface instanceof PostMoveDecisionMenu) {
			return new PostMoveDecisionMenuView(){{
				setModel(actionInterface);
			}};
		} else if(actionInterface instanceof AttackOptions) {
			return new AttackOptionsView(){{
				setModel(actionInterface);
			}};
		}
		
		return null;
	}
}
