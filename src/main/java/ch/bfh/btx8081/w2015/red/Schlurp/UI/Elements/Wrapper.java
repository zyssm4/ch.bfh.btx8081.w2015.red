package ch.bfh.btx8081.w2015.red.Schlurp.UI.Elements;

import ch.bfh.btx8081.w2015.red.Schlurp.MyUI;

import com.google.gwt.user.cellview.client.HeaderBuilder;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
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

	private HorizontalLayout header = null;
	private VerticalLayout layout = null;
	private HorizontalLayout body = null;
	private Label headerLabel = null;
	private ComboBox headerComboBox = null;
	private Button homeButton = null;
	
	public Wrapper() {

		layout = new VerticalLayout();
		header = new HorizontalLayout();
		body = new HorizontalLayout();
		headerLabel = new Label();
		headerComboBox = new ComboBox();
		headerComboBox.setNullSelectionAllowed(false);
		headerComboBox.setInvalidAllowed(false);
		body.setStyleName("myWrapper");
		headerLabel.setStyleName("myHeaderLabel");
		
		headerComboBox.addItem("EN");
		headerComboBox.addItem("DE");
		headerComboBox.addItem("FR");
		headerComboBox.setValue(headerComboBox.getItemIds().iterator().next());
		homeButton = new Button("Home");
		
		//Button		
	
		homeButton.setStyleName("tiny");
		homeButton.setHeight(HEIGHT_HEADER);
		
		
		// Header
		header.setHeight(HEIGHT_HEADER);
		header.setWidth(WIDTH_LAYOUT);
		headerComboBox.setHeight(HEIGHT_HEADER);
		headerComboBox.setWidth(WIDTH_HEADER_COMBOBOX);

		// Body
		body.setHeight(HEIGHT_BODY);
		body.setWidth(WIDTH_LAYOUT);

		// Add Components
		layout.addComponent(header);
		layout.addComponent(body);
		header.addComponent(homeButton);
		header.addComponent(headerLabel);
		header.addComponent(headerComboBox);
		headerComboBox.setStyleName("tiny");
		headerLabel.setWidth(null);
		header.setComponentAlignment(headerLabel, Alignment.MIDDLE_CENTER);
		header.setComponentAlignment(headerComboBox, Alignment.MIDDLE_RIGHT);

	}
	
	public void setLabel(String title) {
		String titleLabel = title;
		headerLabel.setCaption(titleLabel);
	}
	
	public Button getButton(){
		return homeButton;
	}
	
	public HorizontalLayout getHeader() {
		return header;

	}

	public HorizontalLayout getBody() {
		return body;

	}

	public VerticalLayout getLayout() {
		return layout;
	}

}