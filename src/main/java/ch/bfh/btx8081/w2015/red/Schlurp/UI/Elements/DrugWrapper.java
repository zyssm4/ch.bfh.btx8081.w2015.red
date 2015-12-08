package ch.bfh.btx8081.w2015.red.Schlurp.UI.Elements;

import com.vaadin.client.ui.LayoutClickEventHandler;
import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.DateField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class DrugWrapper extends CustomComponent {

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

		// set Boxes
		DrugName.setCaption("Enter drug name");
		Label_DrugTimeTakeSplitter_Morning_Noon.setValue("-");
		Label_DrugTimeTakeSplitter_Noon_Evening.setValue("-");
		Label_DrugTimeTakeSplitter_Evening_Night.setValue("-");
		Label_DrugTakeTime.setValue("Drug take time");
		Intervall.setCaption("Set Repetiton");
		StartDate.setCaption("Start Date");
		EndDate.setCaption("End Date");

		layoutDrugBox.setWidth(WIDTH_DRUGLAYOUT);

		Label_DrugTakeTime.setHeight("23");
		drugTimeTakeBox.setHeight("23");

		TextField_Morning.setWidth(WIDTH_DRUGTAKETIME);
		TextField_Noon.setWidth(WIDTH_DRUGTAKETIME);
		TextField_Evening.setWidth(WIDTH_DRUGTAKETIME);
		TextField_Night.setWidth(WIDTH_DRUGTAKETIME);

		StartDate.setWidth(WIDTH_DRUGBOXCOMPONENTS);
		EndDate.setWidth(WIDTH_DRUGBOXCOMPONENTS);
		Intervall.setWidth(WIDTH_DRUGBOXCOMPONENTS);
		DrugName.setWidth(WIDTH_DRUGBOXCOMPONENTS);

		// set Components
		layoutDrugBox.addStyleName("myDrugWrapper");
		layoutDrug_leftBox.setStyleName("myDrugWrapperMargin");
		layoutDrug_rightBox.setStyleName("myDrugWrapperMargin");

		// Add Components
		layoutDrugBox.addComponent(layoutDrug_leftBox);
		layoutDrugBox.addComponent(layoutDrug_rightBox);

		layoutDrug_leftBox.addComponent(DrugName);
		layoutDrug_leftBox.addComponent(Intervall);

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

		// Layout Events
		layoutDrugBox.addLayoutClickListener(new LayoutClickListener() {
			@Override
			public void layoutClick(LayoutClickEvent event) {
				if (event.isDoubleClick()) {
					layoutDrug_leftBox.setEnabled(true);
					layoutDrug_rightBox.setEnabled(true);
				}

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

}