package ch.bfh.btx8081.w2015.red.Schlurp.UI.Views;

import ch.bfh.btx8081.w2015.red.Schlurp.MyUI;
import ch.bfh.btx8081.w2015.red.Schlurp.UI.Elements.Wrapper;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FileResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class GIFView extends VerticalLayout implements View {
	// defined Height
	final String HEIGHT_BODY = "543";

	private ArrayList<Image> gifs = new ArrayList<>();

	final VerticalLayout componentContainer;
	Random r = new Random();

	public GIFView() {

		FileResource res1 = new FileResource(
				new File("src/main/resources/ch/bfh/btx8081/w2015/red/Schlurp/GIFs/giphy1.gif"));
		gifs.add(new Image("", res1));
		FileResource res2 = new FileResource(
				new File("src/main/resources/ch/bfh/btx8081/w2015/red/Schlurp/GIFs/giphy2.gif"));
		gifs.add(new Image("", res2));
		FileResource res3 = new FileResource(
				new File("src/main/resources/ch/bfh/btx8081/w2015/red/Schlurp/GIFs/giphy3.gif"));
		gifs.add(new Image("", res3));

		setSizeFull();
		setSpacing(false);

		Wrapper wrapper = new Wrapper();
		final VerticalLayout layout = wrapper.getLayout();
		addComponent(layout);
		layout.setMargin(false);

		final HorizontalLayout header = wrapper.getHeader();
		final HorizontalLayout body = wrapper.getBody();
		final HorizontalLayout footer = wrapper.getFooter();

		wrapper.setLabel("Random GIF");

		componentContainer = new VerticalLayout();
		componentContainer.setHeight(HEIGHT_BODY);


		displayRandomGIF();

		wrapper.getHeader().removeComponent(wrapper.getButton());
		wrapper.getHeader().addComponent(logOut(), 0);
		body.addComponent(componentContainer);

		wrapper.getFooterAddButton().setVisible(false);
		wrapper.getFooterDeleteButton().setVisible(false);

		wrapper.getFooterBackButton().addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyUI.HOMEVIEW);
			}
		});

		layout.addComponent(header);
		layout.addComponent(body);
		layout.addComponent(footer);
		
		

	}

	private Button logOut() {
		Button button = new Button("Logout", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getSession().close();
				getUI().getPage().setLocation(getLogoutPath());
			}
		});
		return button;
	}

	@Override
	public void enter(ViewChangeEvent event) {
		displayRandomGIF();
	}

	private String getLogoutPath() {
		return getUI().getPage().getLocation().getPath();
	}

	private void displayRandomGIF() {
		componentContainer.removeAllComponents();
		componentContainer.addComponent(gifs.get(r.nextInt(gifs.size())));

	}

}
