package models;

/**
 * This class is used to represent a person with an email and a name.
 */
public class Person {
	private String email;
	private String name;

	/**
	 * Constructor for creating a new Person object with an email and a name.
	 * 
	 * @param email The email address of the person.
	 * @param name  The name of the person.
	 */
	public Person(String email, String name) {
		this.email = email;
		this.name = name;
	}

	/**
	 * Retrieves the email address of the person.
	 * 
	 * @return A string representing the person's email.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Updates the email address of the person.
	 * 
	 * @param email The new email address to be set.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Retrieves the name of the person.
	 * 
	 * @return A string representing the person's name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Updates the name of the person.
	 * 
	 * @param name The new name to be set.
	 */
	public void setName(String name) {
		this.name = name;
	}
}
