package ch.bfh.btx8081.w2015.red.Schlurp.UI.Views;

import ch.bfh.btx8081.w2015.red.Schlurp.MyUI;
import ch.bfh.btx8081.w2015.red.Schlurp.UI.Elements.DrugWrapper;
import ch.bfh.btx8081.w2015.red.Schlurp.UI.Elements.Wrapper;
import ch.bfh.btx8081.w2015.red.Schlurp.mediplan.Medicament;
import ch.bfh.btx8081.w2015.red.Schlurp.persistenceLayer.UserManager;

import java.util.ArrayList;

import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class MedicationListView extends VerticalLayout implements View {

	// get ObjectController
	UserManager uc = UserManager.getInstance();

	DrugWrapper drugWrapper = null;
	Wrapper wrapper = null;
	ArrayList<DrugWrapper> drugWrapperList = null;
	VerticalLayout drugBox = null;
	HorizontalLayout layoutDrugWrapper = null;

	public MedicationListView() {
		setSizeFull();
		drugWrapper = new DrugWrapper();
		drugWrapperList = new ArrayList<>();
		wrapper = new Wrapper();
		final VerticalLayout layout = wrapper.getLayout();
		addComponent(layout);
		layout.setMargin(false);

		final HorizontalLayout header = wrapper.getHeader();
		final HorizontalLayout body = wrapper.getBody();
		final HorizontalLayout footer = wrapper.getFooter();

		wrapper.setLabel("Medication");
		drugBox = new VerticalLayout();

		Panel panel = new Panel();
		panel.setContent(drugBox);
		panel.setHeight("543");
		panel.setCaptionAsHtml(true);

		body.addComponent(panel);
		layout.addComponent(header);
		layout.addComponent(body);
		layout.addComponent(footer);

		wrapper.getButton().setCaption("Logout");
		wrapper.getButton().addClickListener(logOut());

		wrapper.getSwitchButton().setCaption("Home");
		wrapper.getSwitchButton().setVisible(true);
		wrapper.getSwitchButton().addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyUI.HOMEVIEW);
			}
		});

		wrapper.getFooterAddButton().addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				drugWrapper = new DrugWrapper();
				drugWrapperList.add(drugWrapper);
				layoutDrugWrapper = drugWrapper.getLayoutDrugBox();
				drugBox.addComponent(layoutDrugWrapper);
				drugWrapper.getSaveButton().setVisible(true);
				drugWrapper.getRightLayoutDrugBox().setEnabled(true);
				drugWrapper.getLeftLayoutDrugBox().setEnabled(true);
			}
		});

		wrapper.getFooterBackButton().addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyUI.MEDICATIONVIEW);
			}
		});

		wrapper.getFooterDeleteButton().addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				panel.setCaption("<strong>click Medicament to remove</strong>");
				for (DrugWrapper dw : drugWrapperList) {
					dw.setStyleName("remove");
				}
				drugBox.addLayoutClickListener(new LayoutClickListener() {
					public void layoutClick(LayoutClickEvent event) {
						drugBox.removeComponent(event.getClickedComponent());
						drugBox.removeLayoutClickListener(this);
						panel.setCaption("");
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
		uc.createMediListObject(uc.getUser());
		ArrayList<Medicament> mediList = uc.getMediList();
		for (int i = 0; i < mediList.size(); i++) {
			drugWrapper = new DrugWrapper();
			drugWrapper.setDrugName(mediList.get(i).getName());
			drugWrapper.setDrugAmount(mediList.get(i).getAmount());
			drugWrapper.setNativSelect_Intervall(String.valueOf(mediList.get(i).getInterval()));
			drugWrapper.setStartDate(mediList.get(i).getStart());
			drugWrapper.setEndDate(mediList.get(i).getEnd());
			drugWrapperList.add(drugWrapper);
			layoutDrugWrapper = drugWrapper.getLayoutDrugBox();
			drugBox.addComponent(layoutDrugWrapper);
		}

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
