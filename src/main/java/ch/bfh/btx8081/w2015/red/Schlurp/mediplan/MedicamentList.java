package ch.bfh.btx8081.w2015.red.Schlurp.mediplan;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author admin
 *
 */
public class MedicamentList { private ArrayList<Medicament> medicaments = new ArrayList<Medicament>();
	static SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

	public MedicamentList(ArrayList<Medicament> medicaments) {
		this.medicaments = medicaments;
	}

	/**
	 * Reads the content of a text file with the name inputFileName and stores
	 * the read data in an Infopage object.
	 * 
	 * @param inputFileName
	 *            the name of the file that will be read
	 * @return returns an Infopage object
	 * 
	 * 
	 */
	public static ArrayList<Medicament> readInformationsFromMediplan(String inputFileName) {

		Scanner input = null;
		String delimiter = ";";
		ArrayList<Medicament> mediList = new ArrayList<Medicament>();

		try {
			input = new Scanner(new File(inputFileName), "UTF-16");
		} catch (FileNotFoundException e) {
			try {
				PrintWriter out = new PrintWriter(inputFileName, "UTF-16");
				out.close();
				input = new Scanner(new File(inputFileName), "UTF-16");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		ArrayList<Medicament> mediListsOne = new ArrayList<Medicament>();

		while (input.hasNextLine()) {
			String data = null;
			data = input.nextLine();
			String[] splittedData = data.split(delimiter);
			for (int i = 0; i < splittedData.length; i++) {
				splittedData[i] = splittedData[i].trim();
			}
			try {
				mediListsOne.add(new Medicament(splittedData[1], splittedData[2], splittedData[3],
						format.parse(splittedData[4]), format.parse(splittedData[5])));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		input.close();
		return mediListsOne;
	}

	/**
	 * Writes the data of the infopage to a defined Textfile
	 * 
	 * @param infos
	 *            a infopage object
	 * @param outputfileName
	 *            the name of the file which will be (over)written
	 */
	public static void writeMediToMediplan(ArrayList<Medicament> medi, String outputfileName) {

		PrintWriter out = null;
		try {
			out = new PrintWriter(outputfileName, "UTF-16");
			// Emties the File, the file will be generated with the content of
			// medi
			out.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String delimiter = ";";
		for (int i = 0; i < medi.size(); i++) {

			out.format(medi.get(i).getMediID() + delimiter + " " + medi.get(i).getName() + delimiter + " "
					+ medi.get(i).getAmount() + delimiter + " " + medi.get(i).getInterval() + delimiter + " "
					+ format.format(medi.get(i).getStart()) + delimiter + " " + format.format(medi.get(i).getEnd())
					+ "%n");

		}
		out.close();
	}

	public static ArrayList<Medicament> exists(Medicament medi, ArrayList<Medicament> mediList) {
		Medicament newMedi = medi;
		ArrayList<Medicament> newMediList = mediList;
		for (int i = 0; i < mediList.size(); i++) {
			// returns true if they have the same UUID value(doesn't work, because the saveMethod creates a new Medicamentobject -> therefore the UUID is never the same)
			// temporary solution: compares the name of the medicament
			if (mediList.get(i).getName().equals(newMedi.getName())) {
				newMediList.remove(i);
			}
		}

		return newMediList;
	}

	@Override
	public String toString() {
		return "MedicamentList [medi=" + medicaments + "]";
	}

}
