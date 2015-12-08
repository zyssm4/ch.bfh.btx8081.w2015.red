package ch.bfh.btx8081.w2015.red.Schlurp.UI.Views;

import ch.bfh.btx8081.w2015.red.Schlurp.MyUI;
import ch.bfh.btx8081.w2015.red.Schlurp.UI.Elements.DrugWrapper;
import ch.bfh.btx8081.w2015.red.Schlurp.UI.Elements.Wrapper;

import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.ui.LayoutClickEventHandler;
import com.vaadin.event.LayoutEvents.LayoutClickEvent;
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
public class MedicationView extends VerticalLayout implements View {
	DrugWrapper drugWrapper = null;

	public MedicationView() {
		setSizeFull();
		drugWrapper = new DrugWrapper();
		Wrapper wrapper = new Wrapper();
		final VerticalLayout layout = wrapper.getLayout();
		addComponent(layout);
		layout.setMargin(false);

		final HorizontalLayout header = wrapper.getHeader();
		final HorizontalLayout body = wrapper.getBody();
		final HorizontalLayout footer = wrapper.getFooter();
		final Button logoutButton = wrapper.getButton();

		wrapper.setLabel("Medication");
		VerticalLayout drugSetBox = new VerticalLayout();

		body.addComponent(drugSetBox);
		layout.addComponent(header);
		layout.addComponent(body);
		layout.addComponent(footer);

		wrapper.getButton().setCaption("Logout");
		wrapper.getButton().addClickListener(logOut());

		wrapper.getFooterAddButton().addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				drugWrapper = new DrugWrapper();
				final HorizontalLayout layoutDrugWrapper = drugWrapper
						.getLayoutDrugBox();
				drugSetBox.addComponent(layoutDrugWrapper);
			}
		});

		wrapper.getFooterBackButton().addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyUI.HOMEVIEW);
			}
		});
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}

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

	private String getLogoutPath() {
		return getUI().getPage().getLocation().getPath();
	}
}
