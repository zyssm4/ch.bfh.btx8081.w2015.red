package ch.bfh.btx8081.w2015.red.Schlurp.views;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;


@Theme("mytheme")
@Widgetset("ch.bfh.btx8081.w2015.red.Schlurp.MyAppWidgetset")
public class InfoView extends VerticalLayout implements View {

	//defined Height
	final String HEIGHT_LAYOUT = "568";
	final String HEIGHT_HEADER = "25";
	final String HEIGHT_BODY = "543";
	final String HEIGHT_HEADER_BODY_SPLITTER = "60";
	final String HEIGHT_LABEL = "23";
	final String HEIGHT_TEXTFIELD = "23";
	
	//defined Width
	final String WIDTH_LAYOUT = "320";
	final String WIDTH_LAYOUT_TEXTFIELDBOX = "160";
	final String WIDTH_LAYOUT_LABELBOX = "160";
	final String WIDTH_COMBOBOX = "100";
	final String WIDTH_HEADER_BUTTON = "68";
	final String WIDTH_HEADER_LABEL = "71";
	final String WIDTH_LABEL = "54";
	final String WIDTH_TEXTFIELD = "145";
	
	public InfoView() {
		setSizeFull();
		setSpacing(true);
		
		final VerticalLayout layout = new VerticalLayout();
		layout.setHeight(HEIGHT_LAYOUT);
		layout.setWidth(WIDTH_LAYOUT);
		addComponent(layout);
		
		HorizontalLayout header = new HorizontalLayout();
		header.setHeight(HEIGHT_HEADER);
		header.setWidth(WIDTH_LAYOUT);
		
		HorizontalLayout body = new HorizontalLayout();
		body.setHeight(HEIGHT_BODY);
		body.setWidth(WIDTH_LAYOUT);
			
		VerticalLayout labelBox = new VerticalLayout();
		labelBox.setHeight(HEIGHT_BODY);
		labelBox.setWidth(WIDTH_LAYOUT_LABELBOX);
		
		VerticalLayout textFieldBox = new VerticalLayout();
		textFieldBox.setEnabled(false);
		textFieldBox.setHeight(HEIGHT_BODY);
		textFieldBox.setWidth(WIDTH_LAYOUT_TEXTFIELDBOX);

		VerticalLayout textFieldBoxSmall = new VerticalLayout();
		textFieldBoxSmall.setEnabled(false);
		textFieldBoxSmall.setHeight(HEIGHT_HEADER_BODY_SPLITTER);
		textFieldBoxSmall.setWidth(WIDTH_LAYOUT_TEXTFIELDBOX);
		
		// Add Infopage Components
		
		//ComboBox
		ComboBox comboBox_Language = new ComboBox();
		comboBox_Language.setWidth(WIDTH_COMBOBOX);
		comboBox_Language.setHeight(HEIGHT_HEADER);
		
		//Labels
		Label label_Title = new Label();
		label_Title.setWidth(WIDTH_HEADER_LABEL);
		label_Title.setHeight(HEIGHT_HEADER);
		label_Title.setCaption("InfoPage");
		
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
		
		Label label_RelativesContact = new Label();
		label_RelativesContact.setHeight(HEIGHT_LABEL);
		label_RelativesContact.setWidth(WIDTH_LABEL);
		label_RelativesContact.setCaption("Angehörige: ");
		
		
		//TextFields
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
		
		
		
		
		
		Button button = new Button("Edit");
		button.setWidth(WIDTH_HEADER_BUTTON);
		button.setHeight(HEIGHT_HEADER);
		button.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				textFieldBox.setEnabled(true);
			}
		});
		
		
		// add Components to the Layout

		
		//header
		header.addComponent(button);
		header.addComponent(label_Title);
		header.addComponent(comboBox_Language);
		
		//body
		body.addComponent(labelBox);
		body.addComponent(textFieldBox);
		
		//textFieldBox
		textFieldBox.addComponent(textFieldBoxSmall);
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
	
		//labelBox
		labelBox.addComponent(label_Name);
		labelBox.addComponent(label_Firstname);
		labelBox.addComponent(label_Insurance);
		labelBox.addComponent(label_InsuranceNumber);
		labelBox.addComponent(label_Disease);
		labelBox.addComponent(label_FirstThreatment);
		labelBox.addComponent(label_Medicament);
		labelBox.addComponent(label_DoctorContact);
		labelBox.addComponent(label_RelativesContact);
		
		//layout
		layout.addComponent(header);
		layout.addComponent(body);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
}






/**	
HorizontalLayout headerBodySplitter = new HorizontalLayout();
textFieldBox.setHeight(HEIGHT_HEADER_BODY_SPLITTER);
textFieldBox.setWidth(WIDTH_LAYOUT_TEXTFIELDBOX);

VerticalLayout textFieldBodyBox = new VerticalLayout();
textFieldBox.setHeight(HEIGHT_TEXTFIELD_BODYBOX);
textFieldBox.setWidth(WIDTH_LAYOUT_TEXTFIELDBOX);

VerticalLayout splitterBodyBox = new VerticalLayout();
textFieldBox.setHeight(HEIGHT_SPLITTER_BODYBOX);
textFieldBox.setWidth(WIDTH_LAYOUT_TEXTFIELDBOX);
*/