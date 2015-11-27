package ch.bfh.btx8081.w2015.red.Schlurp.views;

import java.io.File;

import ch.bfh.btx8081.w2015.red.Schlurp.MyUI;
import ch.bfh.btx8081.w2015.red.Schlurp.login.PasswordValidator;
import ch.bfh.btx8081.w2015.red.Schlurp.login.UsernameValidator;
import ch.bfh.btx8081.w2015.red.Schlurp.uiElements.Wrapper;

import com.vaadin.data.Validator;
import com.vaadin.data.validator.EmailValidator;
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

	public LoginView() {
		setSizeFull();
		setSpacing(true);
		
		Label label = new Label("Enter your information below to log in.");
		Label schlurpLabel = new Label();
		// Create the user input Field
		TextField username = new TextField("Username");
		username.setRequired(true);
		username.setInvalidAllowed(false);
		username.addValidator(new UsernameValidator());
		username.setImmediate(true);
		//username.setNullSettingAllowed(true);
		
		//Create the password input Field
		PasswordField password = new PasswordField("Password");
		password.setRequired(true);
		password.setInvalidAllowed(false);
		password.addValidator(new PasswordValidator());
		password.setImmediate(true);
		//password.setNullSettingAllowed(true);
		
		label.setStyleName(ValoTheme.LABEL_COLORED);
		
		addComponent(label);
		addComponent(username);
		addComponent(password);
		addComponent(loginButton());
		
	
		FileResource saveImage = new FileResource(new File("src/main/resources/ch/bfh/btx8081/w2015/red/Schlurp/Images/108px-Schlurp_Traumwelt.png"));
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
				getUI().getNavigator().navigateTo(MyUI.HOMEVIEW);
			}
		});
		return button;
	}

}
