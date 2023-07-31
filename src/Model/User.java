package Model;

public class User {

	private int user_id;
	private String name, password;

	public User(int id, String name, String password) {
		this.user_id = id;
		this.name = name;
		this.password = password;
	}

	public User() {
	}

	public int getId() {
		return user_id;
	}

	public void setId(int id) {
		this.user_id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
