package models;

import java.time.LocalDateTime;

/**
 * This class is used to represent a meeting with a meetingId and a timeSlot.
 */
public class Meeting {
	private Integer meetingId;
	private LocalDateTime timeSlot;

	/**
	 * Constructor for creating a new Meeting object with a meetingId and a
	 * timeSlot.
	 * 
	 * @param meetingId The unique identifier of the meeting.
	 * @param timeSlot  The date and time of the meeting.
	 */
	public Meeting(Integer meetingId, LocalDateTime timeSlot) {
		this.meetingId = meetingId;
		this.timeSlot = timeSlot;
	}

	/**
	 * Retrieves the unique identifier of the meeting.
	 * 
	 * @return An Integer representing the unique identifier of the meeting.
	 */
	public Integer getMeetingId() {
		return meetingId;
	}

	/**
	 * Updates the unique identifier of the meeting.
	 * 
	 * @param meetingId The new unique meeting identifier to be set.
	 */
	public void setMeetingId(Integer meetingId) {
		this.meetingId = meetingId;
	}

	/**
	 * Retrieves the date and time of the meeting.
	 * 
	 * @return A LocalDateTime representing the date and time of the meeting.
	 */
	public LocalDateTime getTimeSlot() {
		return timeSlot;
	}

	/**
	 * Updates the date and time of the meeting.
	 * 
	 * @param timeSlot The new date and time to be set.
	 */
	public void setTimeSlot(LocalDateTime timeSlot) {
		this.timeSlot = timeSlot;
	}
}
