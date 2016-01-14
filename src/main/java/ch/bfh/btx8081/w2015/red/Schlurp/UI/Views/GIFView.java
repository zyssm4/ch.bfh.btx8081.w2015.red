package ch.bfh.btx8081.w2015.red.Schlurp.UI.Views;

import ch.bfh.btx8081.w2015.red.Schlurp.MyUI;
import ch.bfh.btx8081.w2015.red.Schlurp.UI.Elements.Wrapper;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FileResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.VerticalLayout;

/**
 * Creates the view for a random gif-picture. With a click on the refresh button
 * it shows an other picture. There are five different gifs deposited in the
 * resource folder.
 * 
 * @author Kaspar
 * @version V1.0
 *
 */

@SuppressWarnings("serial")
public class GIFView extends VerticalLayout implements View {
	// defined Height
	final String HEIGHT_BODY = "543";

	private ArrayList<Image> gifs = new ArrayList<>();

	final VerticalLayout componentContainer;
	Random r = new Random();

	Wrapper wrapper = null;

	FileResource res1 = new FileResource(new File("src/main/resources/ch/bfh/btx8081/w2015/red/Schlurp/GIFs/gif1.gif"));
	FileResource res2 = new FileResource(new File("src/main/resources/ch/bfh/btx8081/w2015/red/Schlurp/GIFs/gif2.gif"));
	FileResource res3 = new FileResource(new File("src/main/resources/ch/bfh/btx8081/w2015/red/Schlurp/GIFs/gif3.gif"));
	FileResource res4 = new FileResource(new File("src/main/resources/ch/bfh/btx8081/w2015/red/Schlurp/GIFs/gif4.gif"));
	FileResource res5 = new FileResource(new File("src/main/resources/ch/bfh/btx8081/w2015/red/Schlurp/GIFs/gif5.gif"));

	public GIFView() {

		fillGIFList();

		setSizeFull();
		setSpacing(false);

		wrapper = new Wrapper();
		final VerticalLayout layout = wrapper.getLayout();
		final HorizontalLayout header = wrapper.getHeader();
		final HorizontalLayout body = wrapper.getBody();
		final HorizontalLayout footer = wrapper.getFooter();

		wrapper.setLabel("Random GIF");

		addComponent(layout);
		layout.setMargin(false);

		componentContainer = new VerticalLayout();
		componentContainer.setHeight(HEIGHT_BODY);
		componentContainer.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

		displayRandomGIF();
		wrapper.getFooterRefreshButton().setVisible(true);
		wrapper.getHeader().removeComponent(wrapper.getButton());
		wrapper.getHeader().addComponent(logOut(), 0);
		body.addComponent(componentContainer);

		wrapper.getFooterAddButton().setVisible(false);
		wrapper.getFooterDeleteButton().setVisible(false);

		/**
		 * ClickListener method for the back button, navigate back to the
		 * homeview.
		 */
		wrapper.getFooterBackButton().addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MyUI.HOMEVIEW);
			}
		});
		/**
		 * ClickListener method for the refresh button. It shows a next random
		 * picture.
		 */
		wrapper.getFooterRefreshButton().addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				displayRandomGIF();
			}
		});

		layout.addComponent(header);
		layout.addComponent(body);
		layout.addComponent(footer);

	}

	/**
	 * ClickListener method, handles the log out button in the header component
	 * 
	 * @return <code>logOut</code>: ClickListener
	 * 
	 */
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

	/**
	 * get logout path
	 * 
	 * @return <code>getLogoutPath</code>: String
	 */
	private String getLogoutPath() {
		return getUI().getPage().getLocation().getPath();
	}

	/**
	 * This method shows a new gif picture. First it removes the current gif
	 * picture, if available. Then it shows a next picture from an arraylist and
	 * deletes it from this list. So its rarely that a picture is displayed
	 * twice. If this list is empty, it calls the method
	 * <code>fillGIFList()</code>
	 */
	private void displayRandomGIF() {
		componentContainer.removeAllComponents();
		int next = r.nextInt(gifs.size());
		componentContainer.addComponent(gifs.get(next));
		gifs.remove(next);
		if (gifs.size() < 1) {
			fillGIFList();
		}
	}

	/**
	 * This method fills the gif arraylist with the five deposited pictures.
	 */
	private void fillGIFList() {
		gifs.add(new Image("", res1));
		gifs.add(new Image("", res2));
		gifs.add(new Image("", res3));
		gifs.add(new Image("", res4));
		gifs.add(new Image("", res5));
		gifs.get(0).setAlternateText("res1");
		gifs.get(1).setAlternateText("res2");
		gifs.get(2).setAlternateText("res3");
		gifs.get(3).setAlternateText("res4");
		gifs.get(4).setAlternateText("res5");
	}

}
