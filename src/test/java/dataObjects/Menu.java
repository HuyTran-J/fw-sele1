package dataObjects;

public enum Menu {
	LOGIN("Login"),
	LOGOUT("Log out"),
	REGISTER("Register"),
	MY_TICKET("My ticket"),
	TICKET_PRICE("Ticket price"),
	TIMETABLE("Timetable"),
	BOOKTICKET("Book ticket");
	private String description;
	Menu (String description)
	{
	this.description = 	description;
	}
	@Override
	public String toString() 
	{
		return this.description;
	}

}
