package dataaccess;

import java.util.ArrayList;
import java.util.List;

import models.Participant;

/**
 * Data Access Object (DAO) class for handling the persistence of Participant
 * objects. This class provides methods to perform operations such as retrieving
 * and adding Participant instances.
 */
public class ParticipantDAO {
	// Static list to hold Participant objects in lieu of data storage;
		private static List<Participant> participants = new ArrayList<Participant>();
		//Static initializer block to add default Participant objects to the list.
		static {
			participants.add(new Participant("adam@corporate.dk", 0));
			participants.add(new Participant("bill@corporate.dk", 0));
			participants.add(new Participant("cecilia@corporate.dk", 1));
		}

		/**
		 * Retrieves a list of all participants.
		 * 
		 * @return A list of all Participant objects.
		 */
		public List<Participant> getAllParticipants() {
			return participants;
		}

		/**
		 * Retrieves a list of Participant objects by the person's email address.
		 * 
		 * @param email The email address to search for.
		 * @return A list of Participant objects with the matching meeting email address.
		 */
		public List<Participant> getSchedule(String email) {
			List<Participant> schedule = new ArrayList<Participant>();
			for (Participant i : participants) {
				if (i.getEmail().equals(email)) {
					schedule.add(i);
				}
			}
			return schedule;
		}

		/**
		 * Adds a new Participant object to the list.
		 * 
		 * @param participant The Participant to add.
		 */
		public static void addParticipant(Participant participant) {
			participants.add(participant);
		}
}
