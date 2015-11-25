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
        Button infoPage = new Button("Infopage") ;
        infoPage.setStyleName("danger");
        sample.addComponent(infoPage);
        sample.addComponent(new Button("Logout"));
        }

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
}
