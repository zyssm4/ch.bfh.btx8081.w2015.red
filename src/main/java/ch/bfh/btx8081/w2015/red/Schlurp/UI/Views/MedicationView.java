package ch.bfh.btx8081.w2015.red.Schlurp.UI.Views;

import ch.bfh.btx8081.w2015.red.Schlurp.MyUI;
import ch.bfh.btx8081.w2015.red.Schlurp.UI.Elements.DrugTakeWrapper;
import ch.bfh.btx8081.w2015.red.Schlurp.UI.Elements.DrugWrapper;
import ch.bfh.btx8081.w2015.red.Schlurp.UI.Elements.Wrapper;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class MedicationView extends VerticalLayout implements View {
	DrugTakeWrapper drugTakeWrapper = null;

	public MedicationView() {
		setSizeFull();

		Wrapper wrapper = new Wrapper();
	
		final VerticalLayout layout = wrapper.getLayout();
		final HorizontalLayout header = wrapper.getHeader();
		final HorizontalLayout body = wrapper.getBody();
		final HorizontalLayout footer = wrapper.getFooter();
		
		
		wrapper.setLabel("Medication");
		VerticalLayout drugBox = new VerticalLayout();
	
			
		wrapper.getButton().setCaption("Logout");
		wrapper.getButton().addClickListener(logOut());
		wrapper.getSwitchButton().setVisible(true);
		wrapper.getSwitchButton().setCaption("MediList");
		
		drugTakeWrapper = new DrugTakeWrapper();
		HorizontalLayout layoutDrugWrapper = drugTakeWrapper
				.getDrugTakeLayout();
		drugBox.addComponent(layoutDrugWrapper);
		drugTakeWrapper = new DrugTakeWrapper();
		layoutDrugWrapper = drugTakeWrapper
				.getDrugTakeLayout();
		drugTakeWrapper.setStyleName("taken");
		drugBox.addComponent(layoutDrugWrapper);
		drugTakeWrapper = new DrugTakeWrapper();
		layoutDrugWrapper = drugTakeWrapper
				.getDrugTakeLayout();
		drugTakeWrapper.setStyleName("expired");
		drugBox.addComponent(layoutDrugWrapper);
		
			


		Panel panel = new Panel();
		panel.setContent(drugBox);
		panel.setHeight("543");		
		body.addComponent(panel);
		layout.addComponent(header);
		layout.addComponent(body);
		layout.addComponent(footer);
		
		addComponent(layout);
		layout.setMargin(false);
		

		
		
		
		wrapper.getSwitchButton().addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyUI.MEDICATIONLISTVIEW);
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
