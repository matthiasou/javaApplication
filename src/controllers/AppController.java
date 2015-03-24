package controllers;

import models.ActifUser;
import vues.VAccueil;

public class AppController {
	private static ActifUser activeUser = new ActifUser();

	public static ActifUser getActiveUser() {
		return activeUser;
	}

	public static void setActiveUser(ActifUser activeUser) {
		AppController.activeUser = activeUser;
	}

	public AppController(VAccueil vAccueil) {
		AccueilController accueilController = new AccueilController(vAccueil);
		vAccueil.init();
		accueilController.init();
	}
	
}