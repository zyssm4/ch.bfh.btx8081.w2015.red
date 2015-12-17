package ch.bfh.btx8081.w2015.red.Schlurp.UI.Views;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import ch.bfh.btx8081.w2015.red.Schlurp.MyUI;
import ch.bfh.btx8081.w2015.red.Schlurp.UI.Elements.DrugTakeWrapper;
import ch.bfh.btx8081.w2015.red.Schlurp.UI.Elements.DrugWrapper;
import ch.bfh.btx8081.w2015.red.Schlurp.UI.Elements.Wrapper;
import ch.bfh.btx8081.w2015.red.Schlurp.mediplan.Medicament;

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
/**
 * Creates the view for the medicaments.
 * It displays a list with the drugs of the day. 
 * It checks the state of every drug, if it is taken or it has to take .
 * 
 * @author team red
 * @version V1.0
 *
 */
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
		HorizontalLayout layoutDrugWrapper = drugTakeWrapper.getDrugTakeLayout();

		// -----------------------------------------------//
		// -------- Medicament State Dummie Data ---------//
		// ----------------------------------------------//
		Calendar date1 = new GregorianCalendar(2015, Calendar.DECEMBER, 20);
		Calendar date2 = new GregorianCalendar(2015, Calendar.DECEMBER, 13);
		Calendar date3 = new GregorianCalendar(2015, Calendar.DECEMBER, 20);

		Medicament m1 = new Medicament("Tafalgan", "1", "10", date1.getTime(), new Date());
		drugTakeWrapper.setMedicament(m1);
		drugTakeWrapper.getMedicament().getState().checkTime();
		drugTakeWrapper.setStateStyleName();
		drugTakeWrapper.setName();
		drugTakeWrapper.setAmount();

		drugBox.addComponent(layoutDrugWrapper);
		drugTakeWrapper = new DrugTakeWrapper();
		layoutDrugWrapper = drugTakeWrapper.getDrugTakeLayout();
		drugTakeWrapper.setStyleName("taken");

		Medicament m2 = new Medicament("Naloxon", "3", "2", date2.getTime(), new Date());
		drugTakeWrapper.setMedicament(m2);
		drugTakeWrapper.getMedicament().getState().checkTime();
		drugTakeWrapper.setName();
		drugTakeWrapper.setStateStyleName();
		drugTakeWrapper.setAmount();
		
		drugBox.addComponent(layoutDrugWrapper);
		drugTakeWrapper = new DrugTakeWrapper();
		layoutDrugWrapper = drugTakeWrapper.getDrugTakeLayout();
		drugTakeWrapper.setStyleName("expired");
		drugBox.addComponent(layoutDrugWrapper);

		Medicament m3 = new Medicament("Zelboraf", "3", "10", date3.getTime(), new Date());
		drugTakeWrapper.setMedicament(m3);
		drugTakeWrapper.getMedicament().getState().checkTime();
		drugTakeWrapper.setName();
		drugTakeWrapper.setStateStyleName();
		drugTakeWrapper.setAmount();

		// -----------------------------------------------//
		// --------END Medicament State Dummie Data -----//
		// ----------------------------------------------//

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
/**
 * ClickListener method, handles the log out button in the header component
 * 
 * @return <code>logOut</code>: ClickListener
 * 
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
/**
 * get logout path
 * 
 * @return <code>getLogoutPath</code>: String
 */
	private String getLogoutPath() {
		return getUI().getPage().getLocation().getPath();
	}
}
