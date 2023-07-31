package Model;

public class Day {
	
	int id,date_id;
	String status;
	public Day(int id, int date_id, String status) {
		super();
		this.id = id;
		this.date_id = date_id;
		this.status = status;
	}
	
	public Day() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDate_id() {
		return date_id;
	}

	public void setDate_id(int date_id) {
		this.date_id = date_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}
