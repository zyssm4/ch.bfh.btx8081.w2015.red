package ch.bfh.btx8081.w2015.red.Schlurp.UI.Elements;

import java.io.File;
import java.util.Date;

import com.vaadin.client.ui.LayoutClickEventHandler;
import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.server.FileResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.DateField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
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
	private TextField DrugName = null;
	private TextField TextField_Morning = null;
	private TextField TextField_Noon = null;
	private TextField TextField_Evening = null;
	private TextField TextField_Night = null;
	private TextField Intervall = null;

	// create Labels
	private Label Label_DrugTimeTakeSplitter_Morning_Noon = null;
	private Label Label_DrugTimeTakeSplitter_Noon_Evening = null;
	private Label Label_DrugTimeTakeSplitter_Evening_Night = null;
	private Label Label_DrugTakeTime = null;

	// create DateFields
	private DateField StartDate = null;
	private DateField EndDate = null;

	// create Button
	private Button SaveButton = null;
	private Button CrossButton = null;

	public DrugWrapper() {

		// generate Boxes
		layoutDrug_leftBox = new VerticalLayout();
		layoutDrug_leftBox.setEnabled(false);
		layoutDrug_rightBox = new VerticalLayout();
		layoutDrug_rightBox.setEnabled(false);
		layoutDrugBox = new HorizontalLayout();
		drugTimeTakeBox = new HorizontalLayout();

		// generate Components
		DrugName = new TextField();
		TextField_Morning = new TextField();
		TextField_Noon = new TextField();
		TextField_Evening = new TextField();
		TextField_Night = new TextField();
		Label_DrugTimeTakeSplitter_Morning_Noon = new Label();
		Label_DrugTimeTakeSplitter_Noon_Evening = new Label();
		Label_DrugTimeTakeSplitter_Evening_Night = new Label();
		Label_DrugTakeTime = new Label();
		Intervall = new TextField();
		StartDate = new DateField();
		EndDate = new DateField();
		SaveButton = new Button();
		CrossButton = new Button();

		// set Boxes
		DrugName.setCaption("Enter drug name");
		Label_DrugTimeTakeSplitter_Morning_Noon.setValue("-");
		Label_DrugTimeTakeSplitter_Noon_Evening.setValue("-");
		Label_DrugTimeTakeSplitter_Evening_Night.setValue("-");
		Label_DrugTakeTime.setValue("Drug take time");
		Intervall.setCaption("Set repetition");
		StartDate.setCaption("Start date");
		EndDate.setCaption("End Date");

		layoutDrugBox.setWidth(WIDTH_DRUGLAYOUT);

		Label_DrugTakeTime.setHeight("23");
		drugTimeTakeBox.setHeight("23");

		TextField_Morning.setStyleName("drugTakeTimeField");
		TextField_Noon.setStyleName("drugTakeTimeField");
		TextField_Evening.setStyleName("drugTakeTimeField");
		TextField_Night.setStyleName("drugTakeTimeField");

		StartDate.setWidth(WIDTH_DRUGBOXCOMPONENTS);
		EndDate.setWidth(WIDTH_DRUGBOXCOMPONENTS);
		Intervall.setWidth(WIDTH_DRUGBOXCOMPONENTS);
		DrugName.setWidth(WIDTH_DRUGBOXCOMPONENTS);

		// set Components
		layoutDrugBox.setStyleName("myDrugWrapper");
		layoutDrug_leftBox.setStyleName("myDrugWrapperMargin");
		layoutDrug_rightBox.setStyleName("myDrugWrapperMargin");

		// Set Button
		FileResource saveImage = new FileResource(
				new File("src/main/resources/ch/bfh/btx8081/w2015/red/Schlurp/Images/diskette.png"));
		FileResource xImage = new FileResource(
				new File("src/main/resources/ch/bfh/btx8081/w2015/red/Schlurp/Images/xCross.png"));

		SaveButton.setIcon(saveImage);
		SaveButton.setPrimaryStyleName("nobackground");
		SaveButton.setVisible(false);

		CrossButton.setIcon(xImage);
		CrossButton.setPrimaryStyleName("nobackground");
		CrossButton.setVisible(false);
		// Add Components

		layoutDrug_leftBox.addComponent(DrugName);
		layoutDrug_leftBox.addComponent(Intervall);
		layoutDrug_leftBox.addComponent(SaveButton);
		layoutDrug_leftBox.addComponent(CrossButton);

		layoutDrug_rightBox.addComponent(Label_DrugTakeTime);
		layoutDrug_rightBox.addComponent(drugTimeTakeBox);
		layoutDrug_rightBox.addComponent(StartDate);
		layoutDrug_rightBox.addComponent(EndDate);

		drugTimeTakeBox.addComponent(TextField_Morning);
		drugTimeTakeBox.addComponent(Label_DrugTimeTakeSplitter_Morning_Noon);
		drugTimeTakeBox.addComponent(TextField_Noon);
		drugTimeTakeBox.addComponent(Label_DrugTimeTakeSplitter_Noon_Evening);
		drugTimeTakeBox.addComponent(TextField_Evening);
		drugTimeTakeBox.addComponent(Label_DrugTimeTakeSplitter_Evening_Night);
		drugTimeTakeBox.addComponent(TextField_Night);

		layoutDrugBox.addComponent(layoutDrug_leftBox);
		layoutDrugBox.addComponent(layoutDrug_rightBox);

		// Layout Events
		layoutDrugBox.addLayoutClickListener(new LayoutClickListener() {
			@Override
			public void layoutClick(LayoutClickEvent event) {
				if (event.isDoubleClick()) {
					layoutDrug_leftBox.setEnabled(true);
					layoutDrug_rightBox.setEnabled(true);
					CrossButton.setVisible(false);
					SaveButton.setVisible(true);
				}
			}
		});

		SaveButton.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				layoutDrug_leftBox.setEnabled(false);
				layoutDrug_rightBox.setEnabled(false);
				SaveButton.setVisible(false);
				Medicament medicament = new Medicament(DrugName.getValue(),
						Integer.parseInt(TextField_Morning.getValue()), Integer.parseInt(TextField_Noon.getValue()),
						Integer.parseInt(TextField_Evening.getValue()), Integer.parseInt(TextField_Night.getValue()),
						Integer.parseInt(Intervall.getValue()), StartDate.getValue(), EndDate.getValue(), new Date(),
						new Date());
				uc.saveMedicament(medicament);
			}
		});

	}

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
		return SaveButton;
	}

	public Button getCrossButton() {
		return CrossButton;
	}

	public void addCrossButton() {
		CrossButton.setVisible(true);
	}

	// Setters for Medicament Fields
	public void setDrugName(String drugName) {
		DrugName.setValue(drugName);
	}

	public void setTextField_Morning(String textField_Morning) {
		TextField_Morning.setValue(textField_Morning);
	}

	public void setTextField_Noon(String textField_Noon) {
		TextField_Noon.setValue(textField_Noon);
	}

	public void setTextField_Evening(String textField_Evening) {
		TextField_Evening.setValue(textField_Evening);
	}

	public void setTextField_Night(String textField_Night) {
		TextField_Night.setValue(textField_Night);
	}

	public void setIntervall(String intervall) {
		Intervall.setValue(intervall);
	}

	public void setStartDate(Date startDate) {
		StartDate.setValue(startDate);
	}

	public void setEndDate(Date endDate) {
		EndDate.setValue(endDate);
	}

}