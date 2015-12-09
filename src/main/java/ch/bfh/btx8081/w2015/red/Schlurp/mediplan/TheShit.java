package ch.bfh.btx8081.w2015.red.Schlurp.mediplan;


public class TheShit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Medicament theShit = new Medicament("theShit", 1, 1, 1, 1, 1, null, null);
		System.out.println(theShit.getState().getStyle());
		theShit.switchState(); // IZ Wärs TAKEN
		
		System.out.println(theShit.getStyle());
		theShit.switchState(); // IZ wärs UPCOMMING
		System.out.println("--> "+theShit.getStyle());
		theShit.checkTime();
		System.out.println(theShit.getStyle());
	}

}
