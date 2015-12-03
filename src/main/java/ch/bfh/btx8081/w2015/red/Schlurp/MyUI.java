package ch.bfh.btx8081.w2015.red.Schlurp;

import javax.servlet.annotation.WebServlet;

import ch.bfh.btx8081.w2015.red.Schlurp.UI.Views.HomeView;
import ch.bfh.btx8081.w2015.red.Schlurp.UI.Views.InfoView;
import ch.bfh.btx8081.w2015.red.Schlurp.UI.Views.LoginView;
import ch.bfh.btx8081.w2015.red.Schlurp.UI.Views.MedicationView;
import ch.bfh.btx8081.w2015.red.Schlurp.UI.Views.TimeView;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.Navigator.ComponentContainerViewDisplay;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 *
 */
@Theme("mytheme")
@Widgetset("ch.bfh.btx8081.w2015.red.Schlurp.MyAppWidgetset")
public class MyUI extends UI {

	public Navigator navigator;

	public static final String HOMEVIEW = "home";
	public static final String LOGINVIEW = "login";
	public static final String INFOVIEW = "infoview";
	public static final String TIMEVIEW = "timeview";
	public static final String MEDICATIONVIEW = "medicationview";

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		layout.setSpacing(true);
	
		setContent(layout);
		ComponentContainerViewDisplay viewDisplay = new ComponentContainerViewDisplay(layout);
		navigator = new Navigator(UI.getCurrent(), viewDisplay);
		navigator.addView("", new LoginView());
		navigator.addView(HOMEVIEW, new HomeView());
		navigator.addView(INFOVIEW, new InfoView());
		navigator.addView(TIMEVIEW, new TimeView());
		navigator.addView(MEDICATIONVIEW, new MedicationView());

	}
    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
	
}