package ch.bfh.btx8081.w2015.red.Schlurp.uiElements;

import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

@SuppressWarnings("serial")
public class Wrapper extends CustomComponent {

	// defined Height
	final String HEIGHT_LAYOUT = "568";
	final String HEIGHT_HEADER = "25";
	final String HEIGHT_BODY = "543";
	final String HEIGHT_HEADER_BODY_SPLITTER = "60";
	final String HEIGHT_LABEL = "23";
	final String HEIGHT_TEXTFIELD = "23";

	// defined Width
	final String WIDTH_LAYOUT = "320";
	final String WIDTH_LAYOUT_TEXTFIELDBOX = "160";
	final String WIDTH_LAYOUT_LABELBOX = "160";
	final String WIDTH_COMBOBOX = "100";
	final String WIDTH_HEADER_BUTTON = "68";
	final String WIDTH_HEADER_LABEL = "71";
	final String WIDTH_LABEL = "54";
	final String WIDTH_TEXTFIELD = "145";
	
	private HorizontalLayout header = null;
	private VerticalLayout layout = null;
	private HorizontalLayout body = null;

	public Wrapper() {

		layout = new VerticalLayout();
		header = new HorizontalLayout();
		header.setHeight(HEIGHT_HEADER);
		header.setWidth(WIDTH_LAYOUT);
		body = new HorizontalLayout();
		body.setHeight(HEIGHT_BODY);
		body.setWidth(WIDTH_LAYOUT);
		layout.addComponent(header);
		layout.addComponent(body);

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
