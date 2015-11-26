package ch.bfh.btx8081.w2015.red.Schlurp.views;

import java.io.File;

import ch.bfh.btx8081.w2015.red.Schlurp.MyUI;
import ch.bfh.btx8081.w2015.red.Schlurp.uiElements.Wrapper;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FileResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@Theme("mytheme")
@Widgetset("ch.bfh.btx8081.w2015.red.Schlurp.MyAppWidgetset")
public class InfoView extends VerticalLayout implements View {

	// defined Height
	final String HEIGHT_HEADER = "25";
	final String HEIGHT_BODY = "543";
	final String HEIGHT_HEADER_BODY_SPLITTER = "60";
	final String HEIGHT_LABEL = "23";
	final String HEIGHT_TEXTFIELD = "23";

	// defined Width
	final String WIDTH_LAYOUT = "320";
	final String WIDTH_LAYOUT_TEXTFIELDBOX = "160";
	final String WIDTH_LAYOUT_LABELBOX = "160";
	final String WIDTH_LABEL = "54";
	final String WIDTH_TEXTFIELD = "145";
	
	public InfoView() {
		setSizeFull();
		setSpacing(false);

		Wrapper wrapper = new Wrapper();
		final VerticalLayout layout = wrapper.getLayout();
		addComponent(layout);
		layout.setMargin(false);

		final HorizontalLayout header = wrapper.getHeader();

		final HorizontalLayout body = wrapper.getBody();
		final Button editButton = new Button();
		final Button saveButton = new Button();
		
		wrapper.setLabel("InfoPage");

		VerticalLayout labelBox = new VerticalLayout();
		labelBox.setHeight(HEIGHT_BODY);
		labelBox.setWidth(WIDTH_LAYOUT_LABELBOX);

		VerticalLayout textFieldBox = new VerticalLayout();
		textFieldBox.setEnabled(false);
		textFieldBox.setHeight(HEIGHT_BODY);
		textFieldBox.setWidth(WIDTH_LAYOUT_TEXTFIELDBOX);


		// Add Infopage Components
		Label label_Name = new Label();
		label_Name.setHeight(HEIGHT_LABEL);
		label_Name.setWidth(WIDTH_LABEL);
		label_Name.setCaption("Name: ");

		Label label_Firstname = new Label();
		label_Firstname.setHeight(HEIGHT_LABEL);
		label_Firstname.setWidth(WIDTH_LABEL);
		label_Firstname.setCaption("Vorname: ");

		Label label_Insurance = new Label();
		label_Insurance.setHeight(HEIGHT_LABEL);
		label_Insurance.setWidth(WIDTH_LABEL);
		label_Insurance.setCaption("Krankenkasse: ");

		Label label_InsuranceNumber = new Label();
		label_InsuranceNumber.setHeight(HEIGHT_LABEL);
		label_InsuranceNumber.setWidth(WIDTH_LABEL);
		label_InsuranceNumber.setCaption("Versicherten Nr: ");

		Label label_Disease = new Label();
		label_Disease.setHeight(HEIGHT_LABEL);
		label_Disease.setWidth(WIDTH_LABEL);
		label_Disease.setCaption("Krankheit: ");

		Label label_FirstThreatment = new Label();
		label_FirstThreatment.setHeight(HEIGHT_LABEL);
		label_FirstThreatment.setWidth(WIDTH_LABEL);
		label_FirstThreatment.setCaption("Erste Behandlung: ");

		Label label_Medicament = new Label();
		label_Medicament.setHeight(HEIGHT_LABEL);
		label_Medicament.setWidth(WIDTH_LABEL);
		label_Medicament.setCaption("Medikamente: ");

		Label label_DoctorContact = new Label();
		label_DoctorContact.setHeight(HEIGHT_LABEL);
		label_DoctorContact.setWidth(WIDTH_LABEL);
		label_DoctorContact.setCaption("Arzt Kontakt: ");

		Label label_DoctorPhone = new Label();
		label_DoctorPhone.setHeight(HEIGHT_LABEL);
		label_DoctorPhone.setWidth(WIDTH_LABEL);
		label_DoctorPhone.setCaption("");

		Label label_RelativesContact = new Label();
		label_RelativesContact.setHeight(HEIGHT_LABEL);
		label_RelativesContact.setWidth(WIDTH_LABEL);
		label_RelativesContact.setCaption("Angehörige: ");

		Label label_RelativesPhone = new Label();
		label_RelativesPhone.setHeight(HEIGHT_LABEL);
		label_RelativesPhone.setWidth(WIDTH_LABEL);
		label_RelativesPhone.setCaption("");

		// TextFields
		TextField textField_Name = new TextField();
		textField_Name.setHeight(HEIGHT_TEXTFIELD);
		textField_Name.setWidth(WIDTH_TEXTFIELD);

		TextField textField_Firstname = new TextField();
		textField_Firstname.setHeight(HEIGHT_TEXTFIELD);
		textField_Firstname.setWidth(WIDTH_TEXTFIELD);

		TextField textField_Insurance = new TextField();
		textField_Insurance.setHeight(HEIGHT_TEXTFIELD);
		textField_Insurance.setWidth(WIDTH_TEXTFIELD);

		TextField textField_InsuranceNumber = new TextField();
		textField_InsuranceNumber.setHeight(HEIGHT_TEXTFIELD);
		textField_InsuranceNumber.setWidth(WIDTH_TEXTFIELD);

		TextField textField_Disease = new TextField();
		textField_Disease.setHeight(HEIGHT_TEXTFIELD);
		textField_Disease.setWidth(WIDTH_TEXTFIELD);

		TextField textField_FirstThreatment = new TextField();
		textField_FirstThreatment.setHeight(HEIGHT_TEXTFIELD);
		textField_FirstThreatment.setWidth(WIDTH_TEXTFIELD);

		TextField textField_Medicament = new TextField();
		textField_Medicament.setHeight(HEIGHT_TEXTFIELD);
		textField_Medicament.setWidth(WIDTH_TEXTFIELD);

		TextField textField_DoctorContactName = new TextField();
		textField_DoctorContactName.setHeight(HEIGHT_TEXTFIELD);
		textField_DoctorContactName.setWidth(WIDTH_TEXTFIELD);

		TextField textField_DoctorContactPhone = new TextField();
		textField_DoctorContactPhone.setHeight(HEIGHT_TEXTFIELD);
		textField_DoctorContactPhone.setWidth(WIDTH_TEXTFIELD);

		TextField textField_RelativesContactName = new TextField();
		textField_RelativesContactName.setHeight(HEIGHT_TEXTFIELD);
		textField_RelativesContactName.setWidth(WIDTH_TEXTFIELD);

		TextField textField_RelativesContactPhone = new TextField();
		textField_RelativesContactPhone.setHeight(HEIGHT_TEXTFIELD);
		textField_RelativesContactPhone.setWidth(WIDTH_TEXTFIELD);

		
		//Ressource Images
		FileResource editImage = new FileResource(new File("src/main/resources/ch/bfh/btx8081/w2015/red/Schlurp/Images/book_edit.png"));
		FileResource saveImage = new FileResource(new File("src/main/resources/ch/bfh/btx8081/w2015/red/Schlurp/Images/Floppy-64.png"));

		// Edit/Save Button
		editButton.setCaption("Edit");
		editButton.setHeight(HEIGHT_HEADER);
		editButton.setWidth(WIDTH_LABEL);
		editButton.setEnabled(true);
		editButton.setIcon(editImage, "Edit");
		saveButton.setCaption("Save");
		saveButton.setIcon(saveImage, "Edit");
		saveButton.setVisible(false);
		saveButton.setHeight(HEIGHT_HEADER);
		saveButton.setWidth(WIDTH_LABEL);
		
		editButton.addClickListener(new ClickListener(){
			public void buttonClick(ClickEvent event){
				textFieldBox.setEnabled(true);
				editButton.setVisible(false);
				saveButton.setVisible(true);
			}
		});
		
		saveButton.addClickListener(new ClickListener(){
			public void buttonClick(ClickEvent event){
				textFieldBox.setEnabled(false);
				editButton.setVisible(true);
				saveButton.setVisible(false);
			}
		});
		
		// add Components to the Layout
		// Button
		wrapper.getButton().addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyUI.HOMEVIEW);
			}
		});
		

		
		// body
		body.addComponent(labelBox);
		body.addComponent(textFieldBox);

		
		// textFieldBox
		textFieldBox.addComponent(textField_Name);
		textFieldBox.addComponent(textField_Firstname);
		textFieldBox.addComponent(textField_Insurance);
		textFieldBox.addComponent(textField_InsuranceNumber);
		textFieldBox.addComponent(textField_Disease);
		textFieldBox.addComponent(textField_FirstThreatment);
		textFieldBox.addComponent(textField_Medicament);
		textFieldBox.addComponent(textField_DoctorContactName);
		textFieldBox.addComponent(textField_DoctorContactPhone);
		textFieldBox.addComponent(textField_RelativesContactName);
		textFieldBox.addComponent(textField_RelativesContactPhone);

		// labelBox
		labelBox.addComponent(label_Name);
		labelBox.addComponent(label_Firstname);
		labelBox.addComponent(label_Insurance);
		labelBox.addComponent(label_InsuranceNumber);
		labelBox.addComponent(label_Disease);
		labelBox.addComponent(label_FirstThreatment);
		labelBox.addComponent(label_Medicament);
		labelBox.addComponent(label_DoctorContact);
		labelBox.addComponent(label_DoctorPhone);
		labelBox.addComponent(label_RelativesContact);
		labelBox.addComponent(label_RelativesPhone);

		//Button
		labelBox.addComponent(editButton);
		labelBox.addComponent(saveButton);
		// layout
		layout.addComponent(header);
		layout.addComponent(body);

	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}
}
