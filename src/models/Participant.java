package models;

/**
 * This class is used to represent a participant (of a meeting) with an email
 * and a meetingId.
 */
public class Participant {
	private String email;
	private Integer meetingId;

	/**
	 * Constructor for creating a new Participant object with an email and a
	 * meetingId.
	 * 
	 * @param email
	 * @param meetingId
	 */
	public Participant(String email, Integer meetingId) {
		this.email = email;
		this.meetingId = meetingId;
	}

	/**
	 * Retrieves the email address of the participant.
	 * 
	 * @return A string representing the participant's email.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Updates the email address of the participant.
	 * 
	 * @param email The new email address to be set.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Retrieves the meeting identifier of the participant.
	 * 
	 * @return An Integer representing the meeting identifier of the participant.
	 */
	public Integer getMeetingId() {
		return meetingId;
	}

	/**
	 * Updates the meeting identifier of the participant.
	 * 
	 * @param meetingId The new meeting identifier to be set.
	 */
	public void setMeetingId(Integer meetingId) {
		this.meetingId = meetingId;
	}
}
