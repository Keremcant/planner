package Model;

public class School extends Day{

	private String ameliyat, service, clinic, freeDay, nobet;
	public School(String ameliyat, String service, String clinic, String freeDay, String nobet) {
		super();
		this.ameliyat = ameliyat;
		this.service = service;
		this.clinic = clinic;
		this.freeDay = freeDay;
		this.nobet = nobet;

	}
	public String getAmeliyat() {
		return ameliyat;
	}
	public void setAmeliyat(String ameliyat) {
		this.ameliyat = ameliyat;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getClinic() {
		return clinic;
	}
	public void setClinic(String clinic) {
		this.clinic = clinic;
	}
	public String getFreeDay() {
		return freeDay;
	}
	public void setFreeDay(String freeDay) {
		this.freeDay = freeDay;
	}
	public String getNobet() {
		return nobet;
	}
	public void setNobet(String nobet) {
		this.nobet = nobet;
	}

	
	
}
