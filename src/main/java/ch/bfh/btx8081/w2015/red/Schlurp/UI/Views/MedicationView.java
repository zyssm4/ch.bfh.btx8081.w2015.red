package ch.bfh.btx8081.w2015.red.Schlurp.UI.Views;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import ch.bfh.btx8081.w2015.red.Schlurp.MyUI;
import ch.bfh.btx8081.w2015.red.Schlurp.UI.Elements.DrugTakeWrapper;
import ch.bfh.btx8081.w2015.red.Schlurp.UI.Elements.DrugWrapper;
import ch.bfh.btx8081.w2015.red.Schlurp.UI.Elements.Wrapper;
import ch.bfh.btx8081.w2015.red.Schlurp.mediplan.Medicament;
import ch.bfh.btx8081.w2015.red.Schlurp.persistenceLayer.MedicineManager;
import ch.bfh.btx8081.w2015.red.Schlurp.persistenceLayer.UserManager;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.MediaControl;
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
 * Creates the view for the medicaments. It displays a list with the drugs of
 * the day. It checks the state of every drug, if it is taken or it has to take
 * .
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

		
		// Load Medicaments
		MedicineManager mc = MedicineManager.getInstance();
		ArrayList<Medicament> mediList = mc.getMediList();
		
		for(Medicament m : mediList){
			m.setTaken(new GregorianCalendar(2016, Calendar.DECEMBER, 18).getTime());
			drugTakeWrapper = new DrugTakeWrapper();
			HorizontalLayout layoutDrugWrapper = drugTakeWrapper.getDrugTakeLayout();
			drugTakeWrapper.setMedicament(m);
			drugTakeWrapper.getMedicament().getState().checkTime();
			drugTakeWrapper.setStateStyleName();
			drugTakeWrapper.setName();
			drugTakeWrapper.setAmount();


			drugBox.addComponent(layoutDrugWrapper);
			
		}
		
		Panel panel = new Panel();
		panel.setContent(drugBox);
		panel.setHeight("543");
		body.addComponent(panel);
		layout.addComponent(header);
		layout.addComponent(body);
		layout.addComponent(footer);
		

		wrapper.getFooterRefreshButton().setVisible(false);
		wrapper.getFooterAddButton().setVisible(false);
		wrapper.getFooterDeleteButton().setVisible(false);
	
		
		addComponent(layout);
		layout.setMargin(false);
		/**
		 * ClickListener method for the back button, navigate back to the
		 * homeview.
		 */
		wrapper.getFooterBackButton().addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyUI.HOMEVIEW);
			}
		});
		
		wrapper.getfooterFurtherButton().addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyUI.MEDICATIONLISTVIEW);
			}
		});

	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

		MedicineManager mc = MedicineManager.getInstance();
		UserManager um = UserManager.getInstance();
		mc.createMediListObject(um.getUser());
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
