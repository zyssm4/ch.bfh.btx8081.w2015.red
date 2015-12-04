package ch.bfh.btx8081.w2015.red.Schlurp.UI.Views;

import java.io.File;
import java.io.FileNotFoundException;

import ch.bfh.btx8081.w2015.red.Schlurp.MyUI;
import ch.bfh.btx8081.w2015.red.Schlurp.persistenceLayer.UserManager;
import ch.bfh.btx8081.w2015.red.Schlurp.login.PasswordValidator;
import ch.bfh.btx8081.w2015.red.Schlurp.login.UsernameValidator;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FileResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@SuppressWarnings("serial")
public class LoginView extends VerticalLayout implements View {
	
	private TextField username = null;

	PasswordField password = null;
	
	public LoginView() {
		setSizeFull();
		setSpacing(true);

		Label label = new Label("Enter your information below to log in.");
		Label schlurpLabel = new Label();
		// Create the user input Field
		username = new TextField("Username");
		username.setRequired(true);
		username.setInvalidAllowed(false);
		username.addValidator(new UsernameValidator());
		username.setImmediate(true);
		// username.setNullSettingAllowed(true);

		// Create the password input Field
		password = new PasswordField("Password");
		password.setRequired(true);
		password.setInvalidAllowed(false);
		password.addValidator(new PasswordValidator());
		password.setImmediate(true);
		// password.setNullSettingAllowed(true);

		label.setStyleName(ValoTheme.LABEL_COLORED);

		addComponent(label);
		addComponent(username);
		addComponent(password);
		addComponent(loginButton());

		FileResource saveImage = new FileResource(
				new File("src/main/resources/ch/bfh/btx8081/w2015/red/Schlurp/Images/108px-Schlurp_Traumwelt.png"));
		schlurpLabel.setIcon(saveImage);
		addComponent(schlurpLabel);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("Welcome! Please log in.");
	}

	private Button loginButton() {
		Button button = new Button("Log In", new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				if (UsernameValidator.isUsernameValid() && PasswordValidator.isPasswordValid()) {
					getUI().getNavigator().navigateTo(MyUI.HOMEVIEW);
					UserManager oc = UserManager.getInstance();
						oc.createUser(username.getValue());
						oc.createInfoPageObject(oc.getUser());
				}
			}
		});
		return button;
	}

}