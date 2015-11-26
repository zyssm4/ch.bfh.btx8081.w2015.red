package ch.bfh.btx8081.w2015.red.Schlurp.views;

import ch.bfh.btx8081.w2015.red.Schlurp.MyUI;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class HomeView extends VerticalLayout implements View {

	public HomeView() {
		setSizeFull();
	
		
        //HorizontalLayout sample = new HorizontalLayout();

        HorizontalSplitPanel sample = new HorizontalSplitPanel();
        sample.setWidth("200");
        addComponent(sample);
        
        sample.addStyleName("outlined");
        
      
        sample.addComponent(infoPage());
        sample.addComponent(logOut());
        

        
        }
	private Button infoPage() {
		Button button = new Button("Infopage", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyUI.INFOPAGE);
			}
		});
		return button;
	}
	private Button logOut() {
		Button button = new Button("Logout", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getSession().close();
				getUI().getPage().setLocation(getLogoutPath());
			}
		});
		return button;
	}


	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
	private String getLogoutPath() {
		return getUI().getPage().getLocation().getPath();
	}

	
	
}
