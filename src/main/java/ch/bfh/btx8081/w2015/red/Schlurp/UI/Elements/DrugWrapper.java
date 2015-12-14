package ch.bfh.btx8081.w2015.red.Schlurp.UI.Elements;

import java.io.File;
import java.util.Date;

import com.vaadin.client.ui.LayoutClickEventHandler;
import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.server.FileResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.DateField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeSelect;
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
	// private TextField TextField_Morning = null;
	// private TextField TextField_Noon = null;
	// private TextField TextField_Evening = null;
	// private TextField TextField_Night = null;
	private TextField intervall = null;

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
		intervall = new TextField();
		nativSelect_Intervall = new NativeSelect("Intervall");

		//set NativSelect
		nativSelect_Intervall.addItems("6 Std", "12 Std", "24 Std", "48 Std");
		
		// set Boxes
		drugName.setCaption("Enter drug name");
		label_DrugTimeTakeSplitter_Morning_Noon.setValue("-");
		label_DrugTimeTakeSplitter_Noon_Evening.setValue("-");
		label_DrugTimeTakeSplitter_Evening_Night.setValue("-");
		label_DrugTakeTime.setValue("Drug take time");
		intervall.setCaption("Set repetition");
		startDate.setCaption("Start date");
		endDate.setCaption("End Date");

		layoutDrugBox.setWidth(WIDTH_DRUGLAYOUT);

		label_DrugTakeTime.setHeight("23");
		drugTimeTakeBox.setHeight("23");

		startDate.setWidth(WIDTH_DRUGBOXCOMPONENTS);
		endDate.setWidth(WIDTH_DRUGBOXCOMPONENTS);
		intervall.setWidth(WIDTH_DRUGBOXCOMPONENTS);
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
		layoutDrug_leftBox.addComponent(nativSelect_Intervall);
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
						nativSelect_Intervall.getItem(1).toString(), startDate
								.getValue(), endDate.getValue());
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

	// ---------------------------------------------------------------------//
	// --------------------DRUGWRAPPER-SETTER-SECTION-----------------------//
	// ---------------------------------------------------------------------//

	public void setDrugName(String drugName) {
		this.drugName.setValue(drugName);
	}

	public void setIntervall(String intervall) {
		this.intervall.setValue(intervall);
	}

	public void setStartDate(Date startDate) {
		this.startDate.setValue(startDate);
	}

	public void setEndDate(Date endDate) {
		this.endDate.setValue(endDate);
	}

}