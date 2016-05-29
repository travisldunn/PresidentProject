package presidentsWeb;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.servlet.ServletContext;

public class DAOPres {
	String filename ="WEB-INF/presidents.csv";
	private ServletContext servletContext;
	ArrayList<President> prez = new ArrayList();
	
	public DAOPres(ServletContext context) throws FileNotFoundException, IOException {
		servletContext = context;
		readPresFile();
	}


	public DAOPres() throws FileNotFoundException, IOException {
		readPresFile();
	}

	public ArrayList<President> getPrez() {
		return prez;
	}

	public void setPrez(ArrayList<President> prez) {
		this.prez = prez;
	}

	public void whigParty(String party) {
		for (int i = 0; i < prez.size(); i++) {
			if (((President) prez.get(i)).getParty().equals(party))
				System.out.println(prez.get(i));
		}
	}

	public void presidentStartR(char startsWith) {
		for (int i = 0; i < prez.size(); i++) {
			if (((President) prez.get(i)).getLastName().charAt(0) == startsWith) {
				System.out.println(prez.get(i));
			}
		}

	}

	public President getPresident(int term) {
		President pres = new President();
		for (President president : prez) {
			if (president.getPresidentNum() == term) {
				pres = president;
			}
		}
		return pres;
	}

	public void readPresFile() throws FileNotFoundException, IOException {
		
		InputStream is = servletContext.getResourceAsStream(filename);
		try (BufferedReader president = new BufferedReader(new InputStreamReader(is))) {
			String line;

			while ((line = president.readLine()) != null) {
				String[] lines = line.split(", ");
				int presidentYear = Integer.parseInt(lines[0]);
				String[] years = lines[4].split("-");
				int startYear = Integer.parseInt(years[0]);
				int endYear = Integer.parseInt(years[1]);
				String picture = lines[lines.length-1];

				prez.add(new President(presidentYear, lines[1], lines[3], startYear, endYear, lines[5], picture));
				// System.out.println(prez[i].toString());
			}
		} catch (IOException e) {
			System.err.println(e);
		}
//System.out.println(prez.size());
	}

}
