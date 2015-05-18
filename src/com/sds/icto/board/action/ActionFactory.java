package com.sds.icto.board.action;

import com.sds.icto.web.Action;

public class ActionFactory {
	private static ActionFactory instance;

	static {
		instance = new ActionFactory();
	}

	private ActionFactory() {
	}

	public static ActionFactory getInstance() {
		// if( instance == null ) {
		// instance = new ActionFactory();
		// }
		return instance;
	}

	public Action getAction(String a) {
		Action action = null;	
		
		
		if ( "listform".equals(a)){
			action = new ListFormAction();
		} else if ("add".equals(a)) {
			action = new AddAction();
		} else if ("delete".equals(a)) {
			action = new DeleteAction();
		} else if ("writeform".equals(a)) {
			action = new WriteFormAction();
		} else if ("modify".equals(a)) {
			action = new ModifyAction();
		} else if ("contents".equals(a)) {
			action = new ContentsAction();
		} else if ("update".equals(a)) {
			action = new UpdateAction();
		} else {
			action = new ListFormAction();
		}
		

		return action;
	}
}
