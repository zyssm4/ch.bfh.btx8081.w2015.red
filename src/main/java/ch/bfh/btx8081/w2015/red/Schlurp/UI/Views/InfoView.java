package ch.bfh.btx8081.w2015.red.Schlurp.UI.Views;

import java.io.File;
import java.text.SimpleDateFormat;

import ch.bfh.btx8081.w2015.red.Schlurp.MyUI;
import ch.bfh.btx8081.w2015.red.Schlurp.persistenceLayer.UserManager;
import ch.bfh.btx8081.w2015.red.Schlurp.UI.Elements.Wrapper;
import ch.bfh.btx8081.w2015.red.Schlurp.infopage.Infopage;
import ch.bfh.btx8081.w2015.red.Schlurp.mediplan.Medicament;
import ch.bfh.btx8081.w2015.red.Schlurp.person.Doctor;
import ch.bfh.btx8081.w2015.red.Schlurp.person.FamilyMember;
import ch.bfh.btx8081.w2015.red.Schlurp.person.Patient;

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

@SuppressWarnings("serial")
@Theme("mytheme")
@Widgetset("ch.bfh.btx8081.w2015.red.Schlurp.MyAppWidgetset")
public class InfoView extends VerticalLayout implements View {

	// create Infopage
	Infopage infopage;

	// get ObjectController
	UserManager uc = UserManager.getInstance();

	//Set File Type
	private final String FILETYPE = ".txt";
	
	// defined Height
	final String HEIGHT_BODY = "543";
	final String HEIGHT_TEXTFIELD = "23";

	// defined Width
	final String WIDTH_TEXTFIELD = "145";

	// set TextFields
	TextField textField_Name = new TextField();
	TextField textField_Firstname = new TextField();
	TextField textField_Insurance = new TextField();
	TextField textField_InsuranceNumber = new TextField();
	TextField textField_Disease = new TextField();
	TextField textField_firstTreatment = new TextField();
	TextField textField_Medicament = new TextField();
	TextField textField_DoctorContactName = new TextField();
	TextField textField_DoctorContactPhone = new TextField();
	TextField textField_RelativesContactName = new TextField();
	TextField textField_RelativesContactPhone = new TextField();

	// define SimpleDate default
	SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

	// create InfoView
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

		VerticalLayout textFieldBox = new VerticalLayout();
		textFieldBox.setEnabled(false);
		textFieldBox.setHeight(HEIGHT_BODY);

		// Add Infopage Components
		Label label_ButtonCompensation = new Label();
		Label label_Name = new Label("Name: ");
		Label label_Firstname = new Label("Vorname: ");
		Label label_Insurance = new Label("Krankenkasse: ");
		Label label_InsuranceNumber = new Label("Versicherten Nr: ");
		Label label_Disease = new Label("Krankheit: ");
		Label label_FirstThreatment = new Label("Erste Behandlung: ");
		Label label_Medicament = new Label("Medikamente: ");
		Label label_DoctorContact = new Label("Arzt Kontakt: ");
		Label label_DoctorPhone = new Label("");
		Label label_RelativesContact = new Label("Angehörige: ");
		Label label_RelativesPhone = new Label("");

		// //DateField
		// DateField dateField_firstTreatment = new DateField();
		// dateField_firstTreatment.setValue(new Date());
		// dateField_firstTreatment.setHeight(HEIGHT_TEXTFIELD);
		// dateField_firstTreatment.setWidth(WIDTH_TEXTFIELD);

		// Ressource Images
		FileResource editImage = new FileResource(
				new File("src/main/resources/ch/bfh/btx8081/w2015/red/Schlurp/Images/book_edit.png"));
		FileResource saveImage = new FileResource(
				new File("src/main/resources/ch/bfh/btx8081/w2015/red/Schlurp/Images/Floppy-64.png"));

		// Buttons

		editButton.setPrimaryStyleName("nobackground");
		editButton.setIcon(editImage);

		saveButton.setPrimaryStyleName("nobackground");
		saveButton.setIcon(saveImage);
		saveButton.setVisible(false);

		// ClickListeners

		editButton.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				textFieldBox.setEnabled(true);
				editButton.setVisible(false);
				saveButton.setVisible(true);
			}
		});

		saveButton.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				textFieldBox.setEnabled(false);
				editButton.setVisible(true);
				saveButton.setVisible(false);
				Patient patient = new Patient(textField_Name.getValue(), textField_Firstname.getValue(),
						textField_Insurance.getValue(), textField_InsuranceNumber.getValue(),
						textField_Disease.getValue(), textField_firstTreatment.getValue(),
						new Medicament(textField_Medicament.getValue()),
						new Doctor(textField_DoctorContactName.getValue(), textField_DoctorContactPhone.getValue()),
						new FamilyMember(textField_RelativesContactName.getValue(),
								textField_RelativesContactPhone.getValue()));
				Infopage infoPage = new Infopage(patient);
				Infopage.writeInfomationsToFile(infoPage, uc.getUser() + FILETYPE);

			}
		});

		wrapper.getButton().addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyUI.HOMEVIEW);
			}
		});

		// add Components to the Layout

		// Body
		body.addComponent(labelBox);
		body.addComponent(textFieldBox);

		// textFieldBox
		textFieldBox.addComponent(textField_Name);
		textFieldBox.addComponent(textField_Firstname);
		textFieldBox.addComponent(textField_Insurance);
		textFieldBox.addComponent(textField_InsuranceNumber);
		textFieldBox.addComponent(textField_Disease);
		textFieldBox.addComponent(textField_firstTreatment);
		textFieldBox.addComponent(textField_Medicament);
		textFieldBox.addComponent(textField_DoctorContactName);
		textFieldBox.addComponent(textField_DoctorContactPhone);
		textFieldBox.addComponent(textField_RelativesContactName);
		textFieldBox.addComponent(textField_RelativesContactPhone);
		textFieldBox.addComponent(label_ButtonCompensation);

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

		// Button

		labelBox.addComponent(editButton);
		labelBox.addComponent(saveButton);

		// layout
		layout.addComponent(header);
		layout.addComponent(body);

	}

	@Override
	public void enter(ViewChangeEvent event) {
		uc.createInfoPageObject(uc.getUser());
		infopage = uc.getInfopage();
		textField_Name.setValue(infopage.getPatient().getLastName());
		textField_Firstname.setValue(infopage.getPatient().getFirstName());
		textField_Insurance.setValue(infopage.getPatient().getInsurance());
		textField_InsuranceNumber.setValue(infopage.getPatient().getInsPolicyNb());
		textField_Disease.setValue(infopage.getPatient().getDisease());
		textField_firstTreatment.setValue(infopage.getPatient().getFirstTreatment());
		textField_Medicament.setValue(infopage.getPatient().getMedicaments());
		textField_DoctorContactName.setValue(infopage.getPatient().getDoctor().getLastName());
		textField_DoctorContactPhone.setValue((infopage.getPatient().getDoctor().getPhoneNb()));
		textField_RelativesContactName.setValue(infopage.getPatient().getFmember().getLastName());
		textField_RelativesContactPhone.setValue(infopage.getPatient().getFmember().getPhoneNb());
	}
}