package controllers;

import java.io.IOException;

import gson.TestGson;
import http.TestHttp;
import models.ActifUser;
import models.Utilisateur;
import vues.VLogin;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

public class LoginController implements SelectionListener {
	public static VLogin vLogin;

	public LoginController(VLogin vLogin) {
		this.vLogin = vLogin;
	}

	
	public void init() {
		vLogin.getBtnConnexion().addSelectionListener(new SelectionListener() {
						
		@Override
		public void widgetSelected(SelectionEvent arg0) {
			Utilisateur user= new Utilisateur();
			user.setLogin(LoginController.vLogin.getTxtLogin().getText());
			user.setPassword(LoginController.vLogin.getTxtPassword().getText());
			
			TestHttp test=new TestHttp();
			String baseUrl="http://127.0.0.1/rest-QCM/";
								
			try {
				String reponse = test.postClassic(baseUrl+"user/connect", user);
				//System.out.println(reponse);
				TestGson test2=new TestGson();
				ActifUser actif=test2.jsonToActif(reponse);
				AppController.setActiveUser(actif);
				
				System.out.println(AppController.getActiveUser());
				if(actif.getconnected()==true){
					vLogin.getShell().close();
					AccueilController.vAccueil.getItemConnexion().setEnabled(false);
					AccueilController.vAccueil.getItemMonProfil().setEnabled(true);
				}
				else{
					vLogin.getLblInformation().setText("Erreur dans l'authentification.");
				}
																	
			} catch (IOException e) {
				e.printStackTrace();
			}
								
		}
						
		@Override
		public void widgetDefaultSelected(SelectionEvent arg0) {
			// TODO Auto-generated method stub
		}
		});
	}				

	@Override
	public void widgetDefaultSelected(SelectionEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void widgetSelected(SelectionEvent arg0) {
		// TODO Auto-generated method stub

	}
}