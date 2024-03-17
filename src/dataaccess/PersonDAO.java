package dataaccess;

import java.util.ArrayList;
import java.util.List;

import models.Person;

/**
 * Data Access Object (DAO) class for handling the persistence of Person
 * objects. This class provides methods to perform operations such as retrieving
 * and adding Person instances.
 */
public class PersonDAO {
	// Static list to hold Person objects in lieu of data storage;
	private static List<Person> people = new ArrayList<Person>();
	// Static initializer block to add default Person objects to the list.
	static {
		people.add(new Person("adam@corporate.dk", "Adam Adamson"));
		people.add(new Person("bill@corporate.dk", "Bill Billson"));
		people.add(new Person("cecilia@corporate.dk", "Cecilia Ceciliason"));
	}

	/**
	 * Retrieves a list of all people.
	 * 
	 * @return A list of Person objects.
	 */
	public List<Person> getPeople() {
		return people;
	}

	/**
	 * Retrieves a Person object by their email.
	 * 
	 * @param email The email address to search for.
	 * @return The Person object with the matching email, or null if not found.
	 */
	public Person getPerson(String email) {
		for (Person i : people) {
			if (i.getEmail().equals(email)) {
				return i;
			}
		}
		return null;
	}

	/**
	 * Adds a new Person object to the list.
	 * 
	 * @param person The Person to add.
	 * @throws IllegalArgumentException if the person already exists or the email is in use.
	 */
	public static void addPerson(Person person) throws Exception {
		if (people.contains(person)) {
			throw new IllegalArgumentException("This person already exists in the system.");
		} else {
			for (Person i : people) {
				if (i.getEmail().equals(person.getEmail())) {
					throw new Exception("This email address is already in use.");
				}
			}
		}
		people.add(person);
	}
}
