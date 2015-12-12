package ch.bfh.btx8081.w2015.red.Schlurp.mediplan;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.vaadin.ui.Notification;

public class MedicamentList {
	private ArrayList<Medicament> medicaments = new ArrayList<Medicament>();
	static SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

	public MedicamentList(ArrayList<Medicament> medicaments){
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
				
				Date dummy = new Date(01 - 01 - 1900);
				for (int i = 0; i < 5; i++) {
					
					mediList.add(new Medicament("", 0, 0, 0, 0, 0, dummy, dummy, dummy, dummy));
				}
				for (int i = 0; i < mediList.size(); i++) {
					out.format(mediList.get(i).getName() + delimiter + " " + mediList.get(i).getDoseMorning() + delimiter + " "
							+ mediList.get(i).getDoseMidday() + delimiter + " " + mediList.get(i).getDoseEvening() + delimiter
							+ " " + mediList.get(i).getDoseNight() + delimiter + " " + mediList.get(i).getInterval() + delimiter
							+ " " + format.format(mediList.get(i).getStart()) + delimiter + " "
							+ format.format(mediList.get(i).getEnd()) + delimiter + " "
							+ format.format(mediList.get(i).getTaken()) + delimiter + " "
							+ format.format(mediList.get(i).getToTake()) + delimiter + "%n");
				}
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
			String data = input.nextLine();
			String[] splittedData = data.split(delimiter);
			for (int i = 0; i < splittedData.length; i++) {
				splittedData[i] = splittedData[i].trim();
			}
			try {
				mediListsOne.add(new Medicament(splittedData[0], Integer.parseInt(splittedData[1]),
						Integer.parseInt(splittedData[2]), Integer.parseInt(splittedData[3]),
						Integer.parseInt(splittedData[4]), Integer.parseInt(splittedData[5]),
						format.parse(splittedData[6]), format.parse(splittedData[7]), format.parse(splittedData[8]),
						format.parse(splittedData[9])));
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
	 * Reads the content of a text file with the name inputFileName and stores
	 * the read data in an Infopage object.
	 * 
	 * @param inputFileName
	 *            the name of the file that will be read
	 * @return returns an Infopage object
	 * 
	 */
	public static ArrayList<Medicament> readInformationsFromDaily(String inputFileName) {

		Scanner input = null;
		String delimiter = ";";

		try {
			input = new Scanner(new File(inputFileName), "UTF-16");
		} catch (FileNotFoundException e) {
			Notification.show("This can't happen");
		}

		ArrayList<Medicament> mediList = null;

		while (input.hasNextLine()) {
			for (int b = 0; b < 5; b++) {
				int line = b;
				String data = input.nextLine();
				String[] splittedData = data.split(delimiter);
				for (int i = 0; i < splittedData.length; i++) {
					splittedData[i] = splittedData[i].trim();
				}
				try {
					mediList.add(new Medicament(splittedData[0], Integer.parseInt(splittedData[1]),
							Integer.parseInt(splittedData[2]), Integer.parseInt(splittedData[3]),
							Integer.parseInt(splittedData[4]), Integer.parseInt(splittedData[5]),
							format.parse(splittedData[6]), format.parse(splittedData[7]), format.parse(splittedData[8]),
							format.parse(splittedData[9])));
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		input.close();
		return mediList;
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
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String delimiter = ";";
		for (int i = 0; i < medi.size(); i++) {
			for (int a = 0; a < 5; a++) {
				out.format(medi.get(i).getName() + delimiter + " " + medi.get(i).getDoseMorning() + delimiter + " "
						+ medi.get(i).getDoseMidday() + delimiter + " " + medi.get(i).getDoseEvening() + delimiter + " "
						+ medi.get(i).getDoseNight() + delimiter + " " + medi.get(i).getInterval() + delimiter + " "
						+ format.format(medi.get(i).getStart()) + delimiter + " " + format.format(medi.get(i).getEnd())
						+ delimiter + " " + format.format(medi.get(i).getTaken()) + delimiter + " "
						+ format.format(medi.get(i).getToTake()) + delimiter + "%n");
			}
		}
		out.close();
	}

	/**
	 * Writes the data of the infopage to a defined Textfile
	 * 
	 * @param infos
	 *            a infopage object
	 * @param outputfileName
	 *            the name of the file which will be (over)written
	 */
	public static void writeMediToDaily(ArrayList<Medicament> medi, String outputfileName) {

		PrintWriter out = null;
		try {
			out = new PrintWriter(outputfileName, "UTF-16");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String delimiter = ";";
		for (int i = 0; i < medi.size(); i++) {
			for (int a = 0; a < 5; a++) {
				out.format(medi.get(i).getName() + delimiter + " " + medi.get(i).getDoseMorning() + delimiter + " "
						+ medi.get(i).getDoseMidday() + delimiter + " " + medi.get(i).getDoseEvening() + delimiter + " "
						+ medi.get(i).getDoseNight() + delimiter + " " + medi.get(i).getInterval() + delimiter + " "
						+ format.format(medi.get(i).getStart()) + delimiter + " " + format.format(medi.get(i).getEnd())
						+ delimiter + " " + format.format(medi.get(i).getTaken()) + delimiter + " "
						+ format.format(medi.get(i).getToTake()) + delimiter + "%n");
			}
		}
		out.close();
	}

	@Override
	public String toString() {
		return "MedicamentList [medi=" + medicaments + "]";
	}

}
