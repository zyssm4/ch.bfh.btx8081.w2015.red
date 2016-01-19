package ch.bfh.btx8081.w2015.red.Schlurp.UI.Views;

import java.io.File;

import ch.bfh.btx8081.w2015.red.Schlurp.MyUI;
import ch.bfh.btx8081.w2015.red.Schlurp.UI.Elements.Wrapper;
import ch.bfh.btx8081.w2015.red.Schlurp.infopage.Infopage;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FileResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

/**
 * This class represents the main page after the login and shows the menu of
 * this application. <br>
 * There are three buttons to select the infopage, the calendar or medication
 * survey.
 * 
 * @author team red
 * @version V1.0
 *
 */
@SuppressWarnings("serial")
public class HomeView extends VerticalLayout implements View {

	// Load Images from Resources
	FileResource infoPageImage = new FileResource(
			new File(
					"src/main/resources/ch/bfh/btx8081/w2015/red/Schlurp/Images/infoPage.png"));
	FileResource gifImage = new FileResource(
			new File(
					"src/main/resources/ch/bfh/btx8081/w2015/red/Schlurp/Images/robot.png"));
	FileResource mediPlanImage = new FileResource(
			new File(
					"src/main/resources/ch/bfh/btx8081/w2015/red/Schlurp/Images/MedPlan.png"));

	public HomeView() {
		setSizeFull();

		Wrapper wrapper = new Wrapper();
		final VerticalLayout layout = wrapper.getLayout();
		addComponent(layout);
		layout.setMargin(false);

		final HorizontalLayout header = wrapper.getHeader();

		final HorizontalLayout body = wrapper.getBody();

		final VerticalLayout buttonContainer = new VerticalLayout();
		buttonContainer.setHeight(wrapper.getBody().getHeight() + "");
		buttonContainer.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

		wrapper.setLabel("Home");
		wrapper.getButton().setCaption("Logout");
		wrapper.getButton().addClickListener(logOut());

		body.addComponent(buttonContainer);
		buttonContainer.addComponent(infoPage());
		buttonContainer.addComponent(gifButton());
		buttonContainer.addComponent(mediPlan());

	}

	/**
	 * Button to change to the infopage.
	 * 
	 * @return <code>infoPage</code>: Button
	 */
	private Button infoPage() {
		Button button = new Button("Infopage", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyUI.INFOVIEW);
			}
		});
		button.setIcon(infoPageImage);
		button.setHeight("70");
		button.setWidth("70");
		button.setPrimaryStyleName("nobackground");
		return button;

	}

	/**
	 * Button to change to the calendar.
	 * 
	 * @return <code>timeTable</code>: Button
	 */
	private Button gifButton() {
		Button button = new Button("random GIF", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyUI.GIFVIEW);
			}
		});
		button.setIcon(gifImage);
		button.setStyleName("button");
		button.setHeight("70");
		button.setWidth("70");
		button.setPrimaryStyleName("nobackground");
		return button;
	}

	/**
	 * Button to change to the medication plan.
	 * 
	 * @return <code>mediPlan</code>: Button
	 */
	private Button mediPlan() {
		Button button = new Button("Medikationsplan",
				new Button.ClickListener() {

					@Override
					public void buttonClick(ClickEvent event) {
						getUI().getNavigator().navigateTo(MyUI.MEDICATIONVIEW);
					}
				});
		button.setIcon(mediPlanImage);
		button.setStyleName("button");
		button.setHeight("70");
		button.setWidth("70");
		button.setPrimaryStyleName("nobackground");
		return button;
	}

	/**
	 * ClickListener method, handles the log out button in the header component
	 * 
	 * @return <code>logOut</code>: ClickListener
	 */
	private ClickListener logOut() {
		Button.ClickListener logout = new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getSession().close();
				getUI().getPage().setLocation(getLogoutPath());
			}
		};
		return logout;
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}

	/**
	 * get logout path
	 * 
	 * @return <code>getLogoutPath</code>: String
	 */
	private String getLogoutPath() {
		return getUI().getPage().getLocation().getPath();
	}

}
