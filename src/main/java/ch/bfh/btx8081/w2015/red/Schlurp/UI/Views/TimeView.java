package ch.bfh.btx8081.w2015.red.Schlurp.UI.Views;

import ch.bfh.btx8081.w2015.red.Schlurp.MyUI;
import ch.bfh.btx8081.w2015.red.Schlurp.UI.Elements.Wrapper;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.gridlayout.GridLayoutState.ChildComponentData;
import com.vaadin.ui.AbstractOrderedLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class TimeView extends VerticalLayout implements View {

	public TimeView() {
		setSizeFull();

		Wrapper wrapper = new Wrapper();
		final VerticalLayout layout = wrapper.getLayout();
		addComponent(layout);
		layout.setMargin(false);

		final HorizontalLayout header = wrapper.getHeader();

		final HorizontalLayout body = wrapper.getBody();
		
		final VerticalLayout buttonContainer = new VerticalLayout();
		buttonContainer.setHeight(wrapper.getBody().getHeight()+"");
		buttonContainer.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
		
		wrapper.setLabel("Home");
		wrapper.getHeader().removeComponent(wrapper.getButton());
		wrapper.getHeader().addComponent(logOut(), 0);
		body.addComponent(buttonContainer);
		buttonContainer.addComponent(infoPage());
		buttonContainer.addComponent(timeTable());
		buttonContainer.addComponent(mediPlan());

		layout.addComponent(header);
		layout.addComponent(body);

	}

	private Button infoPage() {
		Button button = new Button("Infopage", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyUI.INFOVIEW);
			}
		});
		return button;
		
	}

	private Button timeTable() {
		Button button = new Button("Terminplan", new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyUI.TIMEVIEW);
			}
		});
		return button;
	}

	private Button mediPlan() {
		Button button = new Button("Medikationsplan", new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyUI.MEDICATIONVIEW);
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
