package ch.bfh.btx8081.w2015.red.Schlurp.UI.Elements;

import java.io.File;
import java.util.Date;

import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.server.FileResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.DateField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8081.w2015.red.Schlurp.mediplan.Medicament;
import ch.bfh.btx8081.w2015.red.Schlurp.persistenceLayer.UserManager;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

@SuppressWarnings("serial")
public class DrugWrapper extends CustomComponent {

	// get ObjectController
	UserManager uc = UserManager.getInstance();

	// defined Width
	final String WIDTH_DRUGLAYOUT = "320";
	final String WIDTH_DRUGTAKETIME = "25";
	final String WIDTH_DRUGBOXCOMPONENTS = "140";
	// create Boxes
	private VerticalLayout layoutDrug_leftBox = null;
	private VerticalLayout layoutDrug_rightBox = null;
	private HorizontalLayout layoutDrugBox = null;
	private HorizontalLayout drugTimeTakeBox = null;

	// create Textfields
	private TextField drugName = null;
	private TextField drugAmount = null;

	// create Labels
	private Label label_DrugTimeTakeSplitter_Morning_Noon = null;
	private Label label_DrugTimeTakeSplitter_Noon_Evening = null;
	private Label label_DrugTimeTakeSplitter_Evening_Night = null;
	private Label label_DrugTakeTime = null;

	// create DateFields
	private DateField startDate = null;
	private DateField endDate = null;

	// create Button
	private Button saveButton = null;
	private Button crossButton = null;

	// create ComboBox
	private NativeSelect nativSelect_Intervall = null;

	public DrugWrapper() {

		// generate Boxes
		layoutDrug_leftBox = new VerticalLayout();
		layoutDrug_leftBox.setEnabled(false);
		layoutDrug_rightBox = new VerticalLayout();
		layoutDrug_rightBox.setEnabled(false);
		layoutDrugBox = new HorizontalLayout();
		drugTimeTakeBox = new HorizontalLayout();

		// generate Components
		drugName = new TextField();
		label_DrugTimeTakeSplitter_Morning_Noon = new Label();
		label_DrugTimeTakeSplitter_Noon_Evening = new Label();
		label_DrugTimeTakeSplitter_Evening_Night = new Label();
		label_DrugTakeTime = new Label();
		startDate = new DateField();
		endDate = new DateField();
		saveButton = new Button();
		crossButton = new Button();
		drugAmount = new TextField();
		nativSelect_Intervall = new NativeSelect("Intervall");

		// set NativSelect
		nativSelect_Intervall.addItems("6", "12", "24", "48");
		nativSelect_Intervall.setItemCaption("6", "6 Std");
		nativSelect_Intervall.setItemCaption("12", "12 Std");
		nativSelect_Intervall.setItemCaption("24", "24 Std");
		nativSelect_Intervall.setItemCaption("48", "48 Std");

		nativSelect_Intervall.setImmediate(true);
		nativSelect_Intervall.addValueChangeListener(e -> Notification.show(
				"Value changed:", String.valueOf(e.getProperty().getValue()),
				Notification.TYPE_HUMANIZED_MESSAGE));
		// set Boxes
		drugName.setCaption("Enter drug name");
		label_DrugTimeTakeSplitter_Morning_Noon.setValue("-");
		label_DrugTimeTakeSplitter_Noon_Evening.setValue("-");
		label_DrugTimeTakeSplitter_Evening_Night.setValue("-");
		label_DrugTakeTime.setValue("Drug take time");
		drugAmount.setCaption("Set Amount");
		startDate.setCaption("Start date");
		endDate.setCaption("End Date");

		layoutDrugBox.setWidth(WIDTH_DRUGLAYOUT);

		label_DrugTakeTime.setHeight("23");
		drugTimeTakeBox.setHeight("23");

		startDate.setWidth(WIDTH_DRUGBOXCOMPONENTS);
		endDate.setWidth(WIDTH_DRUGBOXCOMPONENTS);
		drugAmount.setWidth(WIDTH_DRUGBOXCOMPONENTS);
		drugName.setWidth(WIDTH_DRUGBOXCOMPONENTS);

		// set Components
		layoutDrugBox.setStyleName("myDrugWrapper");
		layoutDrug_leftBox.setStyleName("myDrugWrapperMargin");
		layoutDrug_rightBox.setStyleName("myDrugWrapperMargin");

		// Set Button
		FileResource saveImage = new FileResource(
				new File(
						"src/main/resources/ch/bfh/btx8081/w2015/red/Schlurp/Images/diskette.png"));
		FileResource xImage = new FileResource(
				new File(
						"src/main/resources/ch/bfh/btx8081/w2015/red/Schlurp/Images/xCross.png"));

		saveButton.setIcon(saveImage);
		saveButton.setPrimaryStyleName("nobackground");
		saveButton.setVisible(false);

		crossButton.setIcon(xImage);
		crossButton.setPrimaryStyleName("nobackground");
		crossButton.setVisible(false);

		// Add Components

		layoutDrug_leftBox.addComponent(drugName);
		layoutDrug_leftBox.addComponent(drugAmount);
		layoutDrug_leftBox.addComponent(saveButton);
		layoutDrug_leftBox.addComponent(crossButton);

		layoutDrug_rightBox.addComponent(nativSelect_Intervall);
		layoutDrug_rightBox.addComponent(startDate);
		layoutDrug_rightBox.addComponent(endDate);

		layoutDrugBox.addComponent(layoutDrug_leftBox);
		layoutDrugBox.addComponent(layoutDrug_rightBox);

		// Layout Events
		layoutDrugBox.addLayoutClickListener(new LayoutClickListener() {
			@Override
			public void layoutClick(LayoutClickEvent event) {
				if (event.isDoubleClick()) {
					layoutDrug_leftBox.setEnabled(true);
					layoutDrug_rightBox.setEnabled(true);
					crossButton.setVisible(false);
					saveButton.setVisible(true);
				}
			}
		});

		saveButton.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				layoutDrug_leftBox.setEnabled(false);
				layoutDrug_rightBox.setEnabled(false);
				saveButton.setVisible(false);
				Medicament medicament = new Medicament(drugName.getValue(),
						drugAmount.getValue(), nativSelect_Intervall.getValue()
								.toString(), startDate.getValue(), endDate
								.getValue());
				uc.saveMedicament(medicament);
			}
		});

	}

	// ---------------------------------------------------------------------//
	// --------------------DRUGWRAPPER-GETTER-SECTION-----------------------//
	// ---------------------------------------------------------------------//

	public HorizontalLayout getLayoutDrugBox() {
		return layoutDrugBox;
	}

	public VerticalLayout getLeftLayoutDrugBox() {
		return layoutDrug_leftBox;
	}

	public VerticalLayout getRightLayoutDrugBox() {
		return layoutDrug_rightBox;
	}

	public Button getSaveButton() {
		return saveButton;
	}

	public Button getCrossButton() {
		return crossButton;
	}

	public void addCrossButton() {
		crossButton.setVisible(true);
	}

	// Könnte für removeMedicament verwendet werden
	public String getDrugName() {
		return drugName.getValue();
	}

	// ---------------------------------------------------------------------//
	// --------------------DRUGWRAPPER-SETTER-SECTION-----------------------//
	// ---------------------------------------------------------------------//

	public void setDrugName(String drugName) {
		this.drugName.setValue(drugName);
	}

	public void setIntervall(String drugAmount) {
		this.drugAmount.setValue(drugAmount);
	}

	public void setStartDate(Date startDate) {
		this.startDate.setValue(startDate);
	}

	public void setEndDate(Date endDate) {
		this.endDate.setValue(endDate);
	}

	public void setDrugAmount(String amount) {
		this.drugAmount.setValue(amount);
	}

	public void setNativSelect_Intervall(String nativSelect_Intervall) {
		this.nativSelect_Intervall.setValue(nativSelect_Intervall);
	}

}