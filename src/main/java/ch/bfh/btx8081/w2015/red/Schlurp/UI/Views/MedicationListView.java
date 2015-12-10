package ch.bfh.btx8081.w2015.red.Schlurp.UI.Views;

import ch.bfh.btx8081.w2015.red.Schlurp.MyUI;
import ch.bfh.btx8081.w2015.red.Schlurp.UI.Elements.DrugWrapper;
import ch.bfh.btx8081.w2015.red.Schlurp.UI.Elements.Wrapper;
import ch.bfh.btx8081.w2015.red.Schlurp.mediplan.StatePattern.DrugState;

import java.util.ArrayList;

import com.google.gwt.user.client.ui.ClickListenerCollection;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.ui.LayoutClickEventHandler;
import com.vaadin.client.widget.escalator.ScrollbarBundle;
import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.gridlayout.GridLayoutState.ChildComponentData;
import com.vaadin.ui.AbstractOrderedLayout;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class MedicationListView extends VerticalLayout implements View {
	DrugWrapper drugWrapper = null;
	ArrayList<DrugWrapper> drugWrapperList = null;

	public MedicationListView() {
		setSizeFull();
		drugWrapper = new DrugWrapper();
		drugWrapperList = new ArrayList<>();
		Wrapper wrapper = new Wrapper();
		final VerticalLayout layout = wrapper.getLayout();
		addComponent(layout);
		layout.setMargin(false);

		final HorizontalLayout header = wrapper.getHeader();
		final HorizontalLayout body = wrapper.getBody();
		final HorizontalLayout footer = wrapper.getFooter();
		final Button logoutButton = wrapper.getButton();

		wrapper.setLabel("Medication");
		VerticalLayout drugBox = new VerticalLayout();
		VerticalLayout drugEditBox = new VerticalLayout();

		drugBox.addComponent(drugEditBox);

		Panel panel = new Panel();
		panel.setContent(drugBox);
		panel.setHeight("543");

		body.addComponent(panel);
		layout.addComponent(header);
		layout.addComponent(body);
		layout.addComponent(footer);

		wrapper.getButton().setCaption("Logout");
		wrapper.getButton().addClickListener(logOut());

		wrapper.getSwitchButton().setCaption("Medi Today");
		wrapper.getSwitchButton().addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyUI.MEDICATIONVIEW);
			}
		});

		wrapper.getFooterAddButton().addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				drugWrapper = new DrugWrapper();
				drugWrapperList.add(drugWrapper);
				final HorizontalLayout layoutDrugWrapper = drugWrapper.getLayoutDrugBox();
				drugEditBox.addComponent(layoutDrugWrapper);
			}
		});

		wrapper.getFooterBackButton().addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyUI.HOMEVIEW);
			}
		});

		wrapper.getFooterDeleteButton().addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {

				for (DrugWrapper dw : drugWrapperList) {
					dw.setStyleName("remove");
				}
				drugBox.addLayoutClickListener(new LayoutClickListener() {
					public void layoutClick(LayoutClickEvent event) {
						drugBox.removeComponent(event.getClickedComponent());
						drugBox.removeLayoutClickListener(this);
						for (DrugWrapper dw : drugWrapperList) {
							dw.setStyleName("");
						}
					}
				});
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