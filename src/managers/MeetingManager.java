package managers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dataaccess.MeetingDAO;
import dataaccess.ParticipantDAO;
import models.Meeting;
import models.Participant;

/*
 * This class is used to perform tasks relating to meetings.
 */
public class MeetingManager {
	private MeetingDAO meetingDAO = new MeetingDAO();
	private ParticipantDAO participantDAO = new ParticipantDAO();

	/**
	 * Creates a new meeting.
	 * 
	 * @param emails   Comma-separated string of participant emails.
	 * @param datetime String representation of the meeting date and time.
	 */
	public void createMeeting(String emails, String datetime) {
		List<String> listemails = new ArrayList<String>(Arrays.asList(emails.split(",")));

		LocalDateTime meetingTime = LocalDateTime.parse(datetime);
		Integer meetingId = meetingDAO.getMeetings().getLast().getMeetingId() + 1;

		try {
			meetingDAO.addMeeting(new Meeting(meetingId, meetingTime));
		} catch (Exception e) {
			System.out.println(e);
		}

		for (String email : listemails) {
			participantDAO.addParticipant(new Participant(email, meetingId));
		}
	}

	/**
	 * Shows the schedule of meetings for a given person.
	 * 
	 * @param email The email of the participant whose schedule is requested.
	 * @return A list of Meetings that the person is involved in.
	 */
	public List<Meeting> showSchedule(String email) {
		List<Participant> schedule = participantDAO.getSchedule(email);
		List<Meeting> meetings = new ArrayList<Meeting>();
		for (Participant participant : schedule) {
			meetings.add(meetingDAO.getMeeting(participant.getMeetingId()));
		}
		return meetings;
	}

	/**
	 * Suggests a time for the meeting based on the availability of the
	 * participants.
	 * 
	 * @param emails Comma-separated string of participant emails.
	 * @param date   String representation of the desired meeting date.
	 * @return A LocalDateTime object representing the suggested meeting time.
	 * @throws Exception if no time is available for the meeting.
	 */
	public LocalDateTime suggestTime(String emails, String date) throws Exception {
		List<String> listemails = new ArrayList<String>(Arrays.asList(emails.split(",")));
		List<Meeting> meetings = new ArrayList<Meeting>();
		for (String email : listemails) {
			meetings.addAll(showSchedule(email));
		}
		for (int i = 8; i < 16; i++) {
			Boolean free = true;
			for (Meeting meeting : meetings) {
				if (meeting.getTimeSlot().getHour() == i) {
					free = false;
				}
			}
			if (free) {
				return LocalDateTime.of(LocalDate.parse(date), LocalTime.of(i, 0));
			}
		}
		throw new Exception("No time available.");
	}
}
