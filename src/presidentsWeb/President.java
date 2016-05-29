package presidentsWeb;

public class President {

	private int presidentNum;
	private String firstName;
	private String lastName;
	private int startYear;
	private int endYear;
	private String party;
	private String picture;

	public President() {

	}

	public President(int presNum, String fn, String ln, int startYear, int endYear, String party, String picture) {
		presidentNum = presNum;
		firstName = fn;
		lastName = ln;
		this.startYear = startYear;
		this.endYear = endYear;
		this.party = party;
		this.picture = picture;
	}
	public String getPicture()
	{
		return picture;
	}

	public void setPicture(String picture)
	{
		this.picture = picture;
	}

	public int getPresidentNum(){
		return presidentNum;
	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getStartYear() {
		return startYear;
	}

	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}

	public int getEndYear() {
		return endYear;
	}

	public void setEndYear(int endYear) {
		this.endYear = endYear;
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	@Override
	public String toString() {
		return "President " + firstName + " " + lastName + " " + presidentNum + "" + "\n\t In Office: " + startYear
				+ "-" + endYear + "\n\tParty: " + party;
	}

}
