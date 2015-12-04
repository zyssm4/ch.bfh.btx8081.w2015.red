package ch.bfh.btx8081.w2015.red.Schlurp.persistenceLayer;


import ch.bfh.btx8081.w2015.red.Schlurp.infopage.Infopage;

public class UserManager {

	private static UserManager uc = null;
	private Infopage infopage = null;
	private String user = null;
	private final String FILETYPE = ".txt";


	private UserManager() {
	}

	public static UserManager getInstance() {
		if (uc == null) {
			uc = new UserManager();
		}
		return uc;
	}

	public void createInfoPageObject(String username) {
		infopage = Infopage.readInformationsFromFile(username + FILETYPE);
	}
	
	public void saveInfopage(Infopage iP){
		infopage = iP;
		Infopage.writeInfomationsToFile(infopage, user);
	}
	
	public Infopage getInfopage() {
		return infopage;
	}

	public void createUser(String user) {
		this.user = user;
	}

	public String getUser() {
		return user;
	}

}
