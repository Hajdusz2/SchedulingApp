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

public class MeetingManager {
	MeetingDAO meetingDAO = new MeetingDAO();
	ParticipantDAO participantDAO = new ParticipantDAO();
	
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
	
	public List<Meeting> showSchedule (String email) {
		List<Participant> schedule = participantDAO.getSchedule(email);
		List<Meeting> meetings = new ArrayList<Meeting>();
		for (Participant participant : schedule) {
			meetings.add(meetingDAO.getMeeting(participant.getMeetingId()));
		}
		return meetings;
	}
	
	public LocalDateTime suggestTime (String emails, String date) throws Exception {
		List<String> listemails = new ArrayList<String>(Arrays.asList(emails.split(",")));
		List<Meeting> meetings = new ArrayList<Meeting>();
		for (String email : listemails) {
			meetings.addAll(showSchedule(email));
		}
		for (int i=8; i<16; i++) {
			Boolean free = true;
			for (Meeting meeting : meetings) {
				if (meeting.getTimeSlot().getHour() == i) {
					free =false;
				}
			}
			if (free) {
				return LocalDateTime.of(LocalDate.parse(date), LocalTime.of(i, 0));
			}
		}
		throw new Exception("No time available.");
	}
}
