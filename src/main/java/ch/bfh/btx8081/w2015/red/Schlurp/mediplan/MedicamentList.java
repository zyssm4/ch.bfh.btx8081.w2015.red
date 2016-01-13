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
 * The class represents an MedicamentList witch consists of an ArrayList filled
 * with Medicaments.
 * <p>
 * Methods for reading and writing from/to a text file and one for checking if a
 * certain Medicament already exists in the ArrayList are provided.
 * <p>
 * 
 * @author Rea Iseli
 *
 */
public class MedicamentList {
	private ArrayList<Medicament> medicaments = new ArrayList<Medicament>();
	private final static SimpleDateFormat FORMAT = new SimpleDateFormat("dd-MM-yyyy");

	public MedicamentList(ArrayList<Medicament> medicaments) {
		this.medicaments = medicaments;
	}

	/**
	 * Reads the content of a text file with the name of the variable
	 * inputFileName. Each line represents a Medicament and its values are
	 * separated with the delimiter defined in the Method. It stores the read
	 * data in an ArrayList<Medicament> object.
	 * 
	 * @param inputFileName
	 *            the name of the file that will be read
	 * @return the ArrayList<Medicament>: newMediList
	 */
	public static ArrayList<Medicament> readInformationsFromMediplan(String inputFileName) {

		Scanner input = null;
		String delimiter = ";";

		try {
			input = new Scanner(new File(inputFileName), "UTF-16");
		} catch (FileNotFoundException e) {
			// If the file doesn't exist, an empty one with the inputFileName is
			// created and the Method starts over with the the same
			// inputFileName
			try {
				PrintWriter out = new PrintWriter(inputFileName, "UTF-16");
				out.close();
				readInformationsFromMediplan(inputFileName);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		// the main part of the method
		// processing the content of the File
		ArrayList<Medicament> newMediList = new ArrayList<Medicament>();

		while (input.hasNextLine()) {
			String data = null;
			data = input.nextLine();
			// each Line gets splitted, so the attribute values of the
			// Medicament can be extracted
			String[] splittedData = data.split(delimiter);
			for (int i = 0; i < splittedData.length; i++) {
				splittedData[i] = splittedData[i].trim();
			}
			try {
				// the content of the line(Medicament:Name, Amount, Intervall,
				// StartDate, EndDate) is added to the ArrayList
				newMediList.add(new Medicament(splittedData[1], splittedData[2], splittedData[3],
						FORMAT.parse(splittedData[4]), FORMAT.parse(splittedData[5])));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		input.close();
		return newMediList;
	}

	/**
	 * Writes the data of the MedicamentList to a defined Textfile
	 * 
	 * @param medi
	 *            an ArrayList filled with Medicaments
	 * @param outputfileName
	 *            the name of the file which will be overwritten
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
					+ FORMAT.format(medi.get(i).getStart()) + delimiter + " " + FORMAT.format(medi.get(i).getEnd())
					+ "%n");

		}
		out.close();
	}

	/**
	 * Tests if the Medicament medi already exists in the ArrayList mediList.
	 * The test is based on the name of the Medicament and if it already exsits,
	 * this Medicament is removed from the ArrayList so that it can be added
	 * with the new content
	 * 
	 * @param medi
	 *            the Medicament to test if it exsits
	 * @param mediList
	 *            the MedicamentList with the recent Medicaments of the Patient
	 * @return modified ArrayList<Medicament> newMediList
	 */
	public static ArrayList<Medicament> exists(Medicament medi, ArrayList<Medicament> mediList) {
		Medicament newMedi = medi;
		ArrayList<Medicament> newMediList = mediList;
		for (int i = 0; i < mediList.size(); i++) {
			// returns true if they have the same UUID value(doesn't work,
			// because the saveMethod creates a new Medicamentobject ->
			// therefore the UUID is never the same)
			// temporary solution: compares the name of the medicament
			if (mediList.get(i).getName().equals(newMedi.getName())) {
				newMediList.remove(i);
			}
		}

		return newMediList;
	}

	// Only for testing
	@Override
	public String toString() {
		return "MedicamentList [medi=" + medicaments + "]";
	}

}
