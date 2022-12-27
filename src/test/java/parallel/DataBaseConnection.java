package parallel;

public class DataBaseConnection {

	//singleton design pattern

	private static DataBaseConnection db= new DataBaseConnection();

	private DataBaseConnection() {

	}

	public static DataBaseConnection getObject() {
		return db;
	}



	public void m1() {
		// code written to connect database
	}





}
