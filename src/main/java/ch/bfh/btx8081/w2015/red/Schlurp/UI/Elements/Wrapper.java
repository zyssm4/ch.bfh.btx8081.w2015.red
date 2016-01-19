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
	final String WIDTH_HEADER_LABEL = "71";
	final String WIDTH_FOOTER_BUTTON = "50";

	// define Boxes
	private HorizontalLayout header = null;
	private HorizontalLayout footer = null;
	private VerticalLayout layout = null;
	private HorizontalLayout body = null;

	// define Components
	private Label headerLabel = null;
	private Button homeButton = null;

	private Label fillerHeaderLabel = null;
	private Label fillerFooterLabel = null;

	private Button footerBackButton = null;
	private Button footerDeleteButton = null;
	private Button footerAddButton = null;
	private Button footerRefreshButton = null;
	private Button footerFurtherButton = null;

	public Wrapper() {

		layout = new VerticalLayout();
		header = new HorizontalLayout();
		footer = new HorizontalLayout();
		body = new HorizontalLayout();

		headerLabel = new Label();
		fillerHeaderLabel = new Label();
		fillerFooterLabel = new Label();
		homeButton = new Button("Home");
		footerBackButton = new Button();
		footerFurtherButton = new Button();
		footerDeleteButton = new Button();
		footerAddButton = new Button();
		footerRefreshButton = new Button();

		// Button

		// set Button Images
		FileResource backImage = new FileResource(
				new File(
						"src/main/resources/ch/bfh/btx8081/w2015/red/Schlurp/Images/backbutton.png"));
		FileResource furtherImage = new FileResource(
				new File(
						"src/main/resources/ch/bfh/btx8081/w2015/red/Schlurp/Images/FurtherButton.png"));
		FileResource deleteImage = new FileResource(
				new File(
						"src/main/resources/ch/bfh/btx8081/w2015/red/Schlurp/Images/delete.png"));
		FileResource addImage = new FileResource(
				new File(
						"src/main/resources/ch/bfh/btx8081/w2015/red/Schlurp/Images/addnew.png"));
		FileResource refreshImage = new FileResource(
				new File(
						"src/main/resources/ch/bfh/btx8081/w2015/red/Schlurp/Images/refresh.png"));

		homeButton.setStyleName("tiny");
		homeButton.setHeight(HEIGHT_HEADER);

		footerBackButton.setPrimaryStyleName("nobackground");
		footerBackButton.setIcon(backImage);
		footerFurtherButton.setPrimaryStyleName("nobackground");
		footerFurtherButton.setIcon(furtherImage);
		footerDeleteButton.setPrimaryStyleName("nobackground");
		footerDeleteButton.setIcon(deleteImage);
		footerAddButton.setPrimaryStyleName("nobackground");
		footerAddButton.setIcon(addImage);
		footerRefreshButton.setPrimaryStyleName("nobackground");
		footerRefreshButton.setIcon(refreshImage);

		// Header
		header.setHeight(HEIGHT_HEADER);
		header.setWidth(WIDTH_LAYOUT);

		headerLabel.setStyleName("myHeaderLabel");
		headerLabel.setWidth(null);
		fillerHeaderLabel.setWidth(null);

		fillerFooterLabel.setStyleName("myHeaderLabel");

		// Body
		body.setHeight(HEIGHT_BODY);
		body.setWidth(WIDTH_LAYOUT);
		body.setStyleName("myWrapper");

		// Footer
		footer.setHeight(HEIGHT_HEADER);
		footer.setWidth(WIDTH_LAYOUT);
		footer.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

		// Add Components
		layout.addComponent(header);
		layout.addComponent(body);
		header.addComponent(homeButton);
		header.addComponent(headerLabel);
		header.addComponent(fillerHeaderLabel);

		footer.addComponent(footerBackButton);
		footer.addComponent(footerAddButton);
		footer.addComponent(footerDeleteButton);
		footer.addComponent(fillerFooterLabel);
		footer.addComponent(footerRefreshButton);
		footer.addComponent(footerFurtherButton);

		// Set Alignment
		header.setComponentAlignment(headerLabel, Alignment.MIDDLE_CENTER);
	}

	public void setLabel(String title) {
		String titleLabel = title;
		headerLabel.setCaption(titleLabel);
	}

	public Label getFillerFooterLabel() {
		return fillerFooterLabel;
	}

	public Button getButton() {
		return homeButton;
	}

	public Button getFooterBackButton() {
		return footerBackButton;
	}

	public Button getfooterFurtherButton() {
		return footerFurtherButton;
	}

	public Button getFooterAddButton() {
		return footerAddButton;
	}

	public Button getFooterDeleteButton() {
		return footerDeleteButton;
	}

	public Button getFooterRefreshButton() {
		return footerRefreshButton;
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
