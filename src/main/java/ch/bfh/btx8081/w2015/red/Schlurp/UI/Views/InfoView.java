package ch.bfh.btx8081.w2015.red.Schlurp.UI.Views;

import java.io.File;

import java.text.SimpleDateFormat;

import ch.bfh.btx8081.w2015.red.Schlurp.MyUI;
import ch.bfh.btx8081.w2015.red.Schlurp.persistenceLayer.UserManager;
import ch.bfh.btx8081.w2015.red.Schlurp.UI.Elements.Wrapper;
import ch.bfh.btx8081.w2015.red.Schlurp.infopage.Infopage;
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

/**
 * Creates the view with the informations about the patient. Following
 * informations are deposited:
 * <li>name
 * <li>first name
 * <li>insurance
 * <li>insurance number
 * <li>disease
 * <li>first treatment
 * <li>attending doctor
 * <li>family member
 * 
 * <br>
 * 
 * @author team red
 * @version V1.0
 *
 */
@SuppressWarnings("serial")
@Theme("mytheme")
@Widgetset("ch.bfh.btx8081.w2015.red.Schlurp.MyAppWidgetset")
public class InfoView extends VerticalLayout implements View {

	// create Infopage
	Infopage infopage;

	// get ObjectController
	UserManager uc = UserManager.getInstance();

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
		final HorizontalLayout footer = wrapper.getFooter();
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
		Label label_Name = new Label("Last name: ");
		Label label_Firstname = new Label("First name: ");
		Label label_Insurance = new Label("Insurance: ");
		Label label_InsuranceNumber = new Label("Insurance number: ");
		Label label_Disease = new Label("Disease: ");
		Label label_FirstThreatment = new Label("First treatment: ");
		Label label_DoctorContact = new Label("Doctor contact: ");
		Label label_DoctorPhone = new Label("Doctor phone:");
		Label label_RelativesContact = new Label("Relatives contact: ");
		Label label_RelativesPhone = new Label("Relatives phone:");

		// //DateField
		// DateField dateField_firstTreatment = new DateField();
		// dateField_firstTreatment.setValue(new Date());
		// dateField_firstTreatment.setHeight(HEIGHT_TEXTFIELD);
		// dateField_firstTreatment.setWidth(WIDTH_TEXTFIELD);

		// Ressource Images
		FileResource editImage = new FileResource(
				new File("src/main/resources/ch/bfh/btx8081/w2015/red/Schlurp/Images/editpen.png"));
		FileResource saveImage = new FileResource(
				new File("src/main/resources/ch/bfh/btx8081/w2015/red/Schlurp/Images/diskette.png"));

		// Buttons
		wrapper.getFooterAddButton().setVisible(false);
		wrapper.getFooterDeleteButton().setVisible(false);
		wrapper.getFooterRefreshButton().setVisible(false);
		wrapper.getfooterFurtherButton().setVisible(false);

		editButton.setPrimaryStyleName("nobackground");
		editButton.setIcon(editImage);

		saveButton.setPrimaryStyleName("nobackground");
		saveButton.setIcon(saveImage);
		saveButton.setVisible(false);

		// ClickListeners
		wrapper.getButton().setCaption("Logout");
		wrapper.getButton().addClickListener(logOut());

		/**
		 * ClickListener method to edit the informations
		 */
		editButton.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				textFieldBox.setEnabled(true);
				editButton.setVisible(false);
				saveButton.setVisible(true);
			}
		});

		/**
		 * ClickListener method to save the edited informations.
		 */
		saveButton.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				textFieldBox.setEnabled(false);
				editButton.setVisible(true);
				saveButton.setVisible(false);
				Patient patient = new Patient(textField_Name.getValue(), textField_Firstname.getValue(),
						textField_Insurance.getValue(), textField_InsuranceNumber.getValue(),
						textField_Disease.getValue(), textField_firstTreatment.getValue(),
						new Doctor(textField_DoctorContactName.getValue(), textField_DoctorContactPhone.getValue()),
						new FamilyMember(textField_RelativesContactName.getValue(),
								textField_RelativesContactPhone.getValue()));
				Infopage infoPage = new Infopage(patient);
				uc.saveInfopage(infoPage);

			}
		});
		/**
		 * ClickListener method for the back button, navigate back to the
		 * homeview.
		 */
		wrapper.getFooterBackButton().addClickListener(new ClickListener() {
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
		textFieldBox.addComponent(textField_DoctorContactName);
		textFieldBox.addComponent(textField_DoctorContactPhone);
		textFieldBox.addComponent(textField_RelativesContactName);
		textFieldBox.addComponent(textField_RelativesContactPhone);
		// textFieldBox.addComponent(label_ButtonCompensation);

		// labelBox
		labelBox.addComponent(label_Name);
		labelBox.addComponent(label_Firstname);
		labelBox.addComponent(label_Insurance);
		labelBox.addComponent(label_InsuranceNumber);
		labelBox.addComponent(label_Disease);
		labelBox.addComponent(label_FirstThreatment);
		labelBox.addComponent(label_DoctorContact);
		labelBox.addComponent(label_DoctorPhone);
		labelBox.addComponent(label_RelativesContact);
		labelBox.addComponent(label_RelativesPhone);

		// Button

		footer.addComponent(editButton);
		footer.addComponent(saveButton);

		// layout
		layout.addComponent(header);
		layout.addComponent(body);
		layout.addComponent(footer);
	}

	/**
	 * enter method to fill the infopage with the informations.
	 */
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
		textField_DoctorContactName.setValue(infopage.getPatient().getDoctor().getLastName());
		textField_DoctorContactPhone.setValue((infopage.getPatient().getDoctor().getPhoneNb()));
		textField_RelativesContactName.setValue(infopage.getPatient().getFmember().getLastName());
		textField_RelativesContactPhone.setValue(infopage.getPatient().getFmember().getPhoneNb());
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
