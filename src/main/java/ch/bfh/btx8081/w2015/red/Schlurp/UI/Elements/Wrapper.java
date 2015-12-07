package ch.bfh.btx8081.w2015.red.Schlurp.UI.Elements;

import java.io.File;

import ch.bfh.btx8081.w2015.red.Schlurp.MyUI;

import com.google.gwt.user.cellview.client.HeaderBuilder;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FileResource;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

@SuppressWarnings("serial")
public class Wrapper extends CustomComponent {

	// defined Height
	final String HEIGHT_LAYOUT = "568";
	final String HEIGHT_HEADER = "25";
	final String HEIGHT_BODY = "543";

	// defined Width
	final String WIDTH_LAYOUT = "320";
	final String WIDTH_HEADER_BUTTON = "68";
	final String WIDTH_HEADER_COMBOBOX = "60";
	final String WIDTH_HEADER_LABEL = "71";
	final String WIDTH_FOOTER_BUTTON = "50";

	// define Boxes
	private HorizontalLayout header = null;
	private HorizontalLayout footer = null;
	private VerticalLayout layout = null;
	private HorizontalLayout body = null;

	// define Components
	private Label headerLabel = null;
	private ComboBox headerComboBox = null;
	private Button homeButton = null;

	private Button footerEditButton = null;
	private Button footerSaveButton = null;
	private Button footerDeleteButton = null;
	private Button footerAddButton = null;

	public Wrapper() {

		layout = new VerticalLayout();
		header = new HorizontalLayout();
		footer = new HorizontalLayout();
		body = new HorizontalLayout();

		headerLabel = new Label();
		headerComboBox = new ComboBox();
		homeButton = new Button("Home");
		footerEditButton = new Button();
		footerSaveButton = new Button();
		footerDeleteButton = new Button();
		footerAddButton = new Button();

		// Button

		// set Button Images
		FileResource editImage = new FileResource(
				new File(
						"src/main/resources/ch/bfh/btx8081/w2015/red/Schlurp/Images/editpen.png"));
		FileResource saveImage = new FileResource(
				new File(
						"src/main/resources/ch/bfh/btx8081/w2015/red/Schlurp/Images/diskette.png"));
		FileResource deleteImage = new FileResource(
				new File(
						"src/main/resources/ch/bfh/btx8081/w2015/red/Schlurp/Images/delete.png"));
		FileResource addImage = new FileResource(
				new File(
						"src/main/resources/ch/bfh/btx8081/w2015/red/Schlurp/Images/addnew.png"));

		homeButton.setStyleName("tiny");
		homeButton.setHeight(HEIGHT_HEADER);

		footerEditButton.setPrimaryStyleName("nobackground");
		footerEditButton.setIcon(editImage);
		footerSaveButton.setPrimaryStyleName("nobackground");
		footerSaveButton.setIcon(saveImage);
		footerSaveButton.setVisible(false);
		footerDeleteButton.setPrimaryStyleName("nobackground");
		footerDeleteButton.setIcon(deleteImage);
		footerAddButton.setPrimaryStyleName("nobackground");
		footerAddButton.setIcon(addImage);

		// Header
		header.setHeight(HEIGHT_HEADER);
		header.setWidth(WIDTH_LAYOUT);

		headerLabel.setStyleName("myHeaderLabel");

		headerComboBox.setHeight(HEIGHT_HEADER);
		headerComboBox.setWidth(WIDTH_HEADER_COMBOBOX);
		headerComboBox.addItem("EN");
		headerComboBox.addItem("DE");
		headerComboBox.addItem("FR");
		headerComboBox.setValue(headerComboBox.getItemIds().iterator().next());
		headerComboBox.setNullSelectionAllowed(false);
		headerComboBox.setInvalidAllowed(false);
		headerComboBox.setStyleName("tiny");
		headerLabel.setWidth(null);

		// Body
		body.setHeight(HEIGHT_BODY);
		body.setWidth(WIDTH_LAYOUT);
		body.setStyleName("myWrapper");

		// Footer
		footer.setHeight(HEIGHT_HEADER);
		footer.setWidth(WIDTH_LAYOUT);

		// Add Components
		layout.addComponent(header);
		layout.addComponent(body);
		header.addComponent(homeButton);
		header.addComponent(headerLabel);
		header.addComponent(headerComboBox);
		headerComboBox.setStyleName("tiny");

		footer.addComponent(footerEditButton);
		footer.addComponent(footerSaveButton);
		footer.addComponent(footerAddButton);
		footer.addComponent(footerDeleteButton);

		// Set Alignment
		header.setComponentAlignment(headerLabel, Alignment.MIDDLE_CENTER);
		header.setComponentAlignment(headerComboBox, Alignment.MIDDLE_RIGHT);

	}

	public void setLabel(String title) {
		String titleLabel = title;
		headerLabel.setCaption(titleLabel);
	}

	public Button getButton() {
		return homeButton;
	}

	public Button getFooterEditButton() {
		return footerEditButton;
	}

	public Button getFooterSaveButton() {
		return footerSaveButton;
	}

	public Button getFooterAddButton() {
		return footerAddButton;
	}

	public Button getFooterDeleteButton() {
		return footerDeleteButton;
	}

	public HorizontalLayout getHeader() {
		return header;

	}

	public HorizontalLayout getBody() {
		return body;

	}

	public HorizontalLayout getFooter() {
		return footer;

	}

	public VerticalLayout getLayout() {
		return layout;
	}

}
