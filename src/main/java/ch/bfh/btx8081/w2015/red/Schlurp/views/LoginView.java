package ch.bfh.btx8081.w2015.red.Schlurp.views;

import java.io.File;

import ch.bfh.btx8081.w2015.red.Schlurp.MyUI;
import ch.bfh.btx8081.w2015.red.Schlurp.uiElements.Wrapper;

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
		TextField username = new TextField("Username");
		PasswordField password = new PasswordField("Password");
		
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
