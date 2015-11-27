package ch.bfh.btx8081.w2015.red.Schlurp.infopage;

import java.io.IOException;
import java.util.ArrayList;

public class infopageTest {
	public static void main(String[] args) throws IOException {
		
		Infopage.writeInfomationsToFile(new Infopage("a","b","c","d","e","f","g","h","i","j","n"), "abc.txt");
		
		System.out.println(Infopage.readInformationsFromFile("abc.txt"));
		}
}
