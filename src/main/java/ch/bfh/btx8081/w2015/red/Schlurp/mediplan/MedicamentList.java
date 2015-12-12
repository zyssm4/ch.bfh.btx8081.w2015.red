package ch.bfh.btx8081.w2015.red.Schlurp.mediplan;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.vaadin.ui.Notification;

public class MedicamentList {
	ArrayList<Medicament> medi = new ArrayList<Medicament>();
	static DateFormat format = new SimpleDateFormat("yyyyMMdd");
	
	public MedicamentList(ArrayList<Medicament> medis) {
		this.medi = medis;
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
	public static ArrayList readInformationsFromMediplan(String inputFileName) {

		Scanner input = null;
		String delimiter = ";";

		try {
			input = new Scanner(new File(inputFileName), "UTF-16");
		} catch (FileNotFoundException e) {
			try {
				PrintWriter out = new PrintWriter(inputFileName, "UTF-16");
				ArrayList<Medicament> infos = new ArrayList<Medicament>();
				String dummy = "19000101";
			for(int i = 0; i < 5; i++){
				try {
					infos.add(new Medicament("", 0, 0, 0, 0, 0, format.parse(dummy), format.parse(dummy), format.parse(dummy), format.parse(dummy)));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
				for (int i = 0; i < infos.size(); i++) {
					out.format(infos.get(i).getName() + delimiter + " " + infos.get(i).getDoseMorning() + delimiter
							+ " " + infos.get(i).getDoseMidday() + delimiter + " " + infos.get(i).getDoseEvening()
							+ delimiter + " " + infos.get(i).getDoseNight() + delimiter + " "
							+ infos.get(i).getInterval() + delimiter + " " + infos.get(i).getStart() + delimiter + " "
							+ infos.get(i).getEnd() + delimiter + " " + infos.get(i).getTaken() + delimiter + " "
							+ infos.get(i).getToTake() + delimiter + "%n");
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

		ArrayList info = new ArrayList<Medicament>();
		
		while (input.hasNextLine()) {
			String data = input.nextLine();
			String[] splittedData = data.split(delimiter);
			for (int i = 0; i < splittedData.length; i++) {
				splittedData[i] = splittedData[i].trim();
			}
			try {
				info.add(new Medicament(splittedData[0], Integer.parseInt(splittedData[1]),
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
		return info;
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
	public static ArrayList readInformationsFromDaily(String inputFileName) {

		Scanner input = null;
		String delimiter = ";";

		try {
			input = new Scanner(new File(inputFileName), "UTF-16");
		} catch (FileNotFoundException e) {
			Notification.show("This can't happen");
		}

		ArrayList info = new ArrayList<Medicament>();
		while (input.hasNextLine()) {
			String data = input.nextLine();
			String[] splittedData = data.split(delimiter);
			for (int i = 0; i < splittedData.length; i++) {
				splittedData[i] = splittedData[i].trim();
			}
			try {
				info.add(new Medicament(splittedData[0], Integer.parseInt(splittedData[1]),
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
		return info;
	}

	/**
	 * Writes the data of the infopage to a defined Textfile
	 * 
	 * @param infos
	 *            a infopage object
	 * @param outputfileName
	 *            the name of the file which will be (over)written
	 */
	public static void writeMediToMediplan(MedicamentList medi, String outputfileName) {

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
	public static void writeMediToDaily(MedicamentList medi, String outputfileName) {

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

		out.close();
	}

}
