package vues;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class VLogin {

	protected Shell shell;
	private Text txtPassword;
	private Text txtLogin;
	private Group grpConnexion;
	private Button btnConnexion;
	private Group grpInformation;
	private Label lblInformation;
	
	public Shell getShell() {
		return shell;
	}

	public Text getTxtPassword() {
		return txtPassword;
	}

	public Text getTxtLogin() {
		return txtLogin;
	}

	public Group getGrpConnexion() {
		return grpConnexion;
	}

	public Button getBtnConnexion() {
		return btnConnexion;
	}

	public Group getGrpInformation() {
		return grpInformation;
	}

	public Label getLblInformation() {
		return lblInformation;
	}
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			VLogin window = new VLogin();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void init() {
		createContents();
	}


	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		grpConnexion = new Group(shell, SWT.NONE);
		grpConnexion.setVisible(true);
		grpConnexion.setText("Connexion");
		grpConnexion.setBounds(10, 71, 414, 180);
		
		Label label = new Label(grpConnexion, SWT.NONE);
		label.setText("Login :");
		label.setBounds(53, 56, 55, 15);
		
		Label label_1 = new Label(grpConnexion, SWT.NONE);
		label_1.setText("Mot de passe :");
		label_1.setBounds(53, 88, 76, 15);
		
		txtPassword = new Text(grpConnexion, SWT.BORDER);
		txtPassword.setBounds(135, 82, 130, 21);
		
		txtLogin = new Text(grpConnexion, SWT.BORDER);
		txtLogin.setBounds(135, 50, 130, 21);
		
		btnConnexion = new Button(grpConnexion, SWT.NONE);

		btnConnexion.setText("Se connecter");
		btnConnexion.setBounds(178, 145, 87, 25);
		
		grpInformation = new Group(shell, SWT.NONE);
		grpInformation.setLocation(10, 10);
		grpInformation.setSize(414, 46);
		grpInformation.setText("Information :");
		
		lblInformation = new Label(grpInformation, SWT.NONE);
		lblInformation.setBounds(10, 21, 490, 15);

	}




}