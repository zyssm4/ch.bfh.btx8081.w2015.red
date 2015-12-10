package ch.bfh.btx8081.w2015.red.Schlurp.UI.Elements;

import java.io.File;

import com.vaadin.client.ui.LayoutClickEventHandler;
import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.server.FileResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.DateField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

@SuppressWarnings("serial")
public class DrugTakeWrapper extends CustomComponent {

	final String HEIGHT_DRUGTAKEBOX = "75";
	final String WIDTH_DRUGTAKEBOX = "320";

	private HorizontalLayout drugTakeBox = null;
	private VerticalLayout drugNameBox = null;
	private VerticalLayout drugAmountBox = null;

	private Label label_DrugName = null;
	private Label label_DrugAmount = null;
	private Label label_TopBoxName = null;
	private Label label_TopBoxAmount = null;
	private Label label_BottomBoxName = null;
	private Label label_BottomBoxAmount = null;
	
	// create Button
	private Button drug_Taken = null;

	public DrugTakeWrapper() {

		//create Boxes
		drugTakeBox = new HorizontalLayout();
		drugNameBox = new VerticalLayout();
		drugAmountBox = new VerticalLayout();
		
		//create Label
		label_DrugName = new Label();
		label_DrugAmount = new Label();
		label_TopBoxName = new Label();
		label_TopBoxAmount = new Label();
		label_BottomBoxName = new Label();
		label_BottomBoxAmount =  new Label();
		
		//create Button
		drug_Taken = new Button();

		// set Button
		FileResource takenImage = new FileResource(
				new File(
						"src/main/resources/ch/bfh/btx8081/w2015/red/Schlurp/Images/MedPlan.png"));
		drug_Taken.setIcon(takenImage);
		drug_Taken.setPrimaryStyleName("nobackground");

		// set Label Demo
		label_DrugName.setValue("Test Drug");
		label_DrugAmount.setValue("Test Amount");
		
		// define Boxes
		drugTakeBox.setHeight(HEIGHT_DRUGTAKEBOX);
		drugTakeBox.setWidth(WIDTH_DRUGTAKEBOX);
		
		// add to MainBox
		drugTakeBox.addComponent(drugNameBox);
		drugTakeBox.addComponent(drugAmountBox);
		drugTakeBox.addComponent(drug_Taken);
		
		//add to Name Box
		drugNameBox.addComponent(label_TopBoxName);
		drugNameBox.addComponent(label_DrugName);
		drugNameBox.addComponent(label_BottomBoxName);
		
		//add to Amount Box
		drugAmountBox.addComponent(label_TopBoxAmount);
		drugAmountBox.addComponent(label_DrugAmount);
		drugAmountBox.addComponent(label_BottomBoxAmount);
		
	
		//set Style
		drugNameBox.setStyleName("MarginLabel");
		drugAmountBox.setStyleName("MarginLabel");
		drugTakeBox.setStyleName("myDrugTakeWrapper");
		drug_Taken.setStyleName("MarginButton");
		
	}

	public HorizontalLayout getDrugTakeLayout() {
		return drugTakeBox;
	}

	public Button getDrugTakeButton() {
		return drug_Taken;
	}

}