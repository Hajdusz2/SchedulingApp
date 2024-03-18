package dataaccess;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import models.Meeting;

/**
 * Data Access Object (DAO) class for handling the persistence of Meeting
 * objects. This class provides methods to perform operations such as retrieving
 * and adding Meeting instances.
 */
public class MeetingDAO {
	// Static list to hold Meeting objects in lieu of data storage;
	private static List<Meeting> meetings = new ArrayList<Meeting>();
	// Static initializer block to add default Meeting objects to the list.
	static {
		meetings.add(new Meeting(0, LocalDateTime.of(2024, 3, 19, 8, 0)));
		meetings.add(new Meeting(1, LocalDateTime.of(2024, 3, 20, 8, 0)));
		meetings.add(new Meeting(2, LocalDateTime.of(2024, 3, 19, 9, 0)));
	}

	/**
	 * Retrieves a list of all meetings.
	 * 
	 * @return A list of Meeting objects.
	 */
	public List<Meeting> getMeetings() {
		return meetings;
	}

	/**
	 * Retrieves a Meeting object by their meeting identifier.
	 * 
	 * @param meetingId The meeting identifier to search for.
	 * @return The Meeting object with the matching meeting identifier, or null if
	 *         not found.
	 */
	public Meeting getMeeting(Integer meetingId) {
		for (Meeting i : meetings) {
			if (i.getMeetingId().equals(meetingId)) {
				return i;
			}
		}
		return null;
	}

	/**
	 * Adds a new Meeting object to the list. Does NOT create a new meeting!
	 * 
	 * @param meeting The Meeting to add.
	 * @throws IllegalArguementException if the meeting does not begin at a whole
	 *                                   hour.
	 */
	public void addMeeting(Meeting meeting) throws Exception {
		if (meeting.getTimeSlot().getMinute() != 0) {
			throw new IllegalArgumentException("Meetings can only begin at whole hours.");
		}
		meetings.add(meeting);
	}
}
