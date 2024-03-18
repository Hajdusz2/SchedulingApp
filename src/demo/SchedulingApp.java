package demo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import dataaccess.PersonDAO;
import managers.MeetingManager;
import models.Meeting;
import models.Person;

/**
 * A class to demonstrate the API functions via the console.
 */
public class SchedulingApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		MeetingManager meetingManager = new MeetingManager();

		// 1.
		System.out.println("Please write the name of the person to be added.");
		String personName = scanner.nextLine();
		System.out.println("Please write the unique email address of the person to be added.");
		String personEmail = scanner.nextLine();
		PersonDAO personDAO = new PersonDAO();
		try {
			personDAO.addPerson(new Person(personEmail, personName));
		} catch (Exception e) {
			System.out.println(e);
		}

		// 2.
		System.out.println("Please write the email addresses of the people involved in the meeting,"
				+ " separated only by commas and no spaces.");
		String meetingEmails = scanner.nextLine();
		System.out.println(
				"Please enter the desired date and time for the meeting in the following format: 1111-11-11T11:11");
		String meetingDateTime = scanner.nextLine();
		meetingManager.createMeeting(meetingEmails, meetingDateTime);

		// 4.
		System.out.println("Please enter the email address of the person whose schedule you would like to see.");
		String scheduleEmail = scanner.nextLine();
		List<Meeting> schedule = meetingManager.showSchedule(scheduleEmail);
		for (Meeting meeting : schedule) {
			System.out.println(meeting.getTimeSlot());
		}

		// 5.
		System.out
				.println("Please write the email addresses of the people you plan to involve in the scheduled meeting,"
						+ " separated only by commas and no spaces.");
		String plannedEmails = scanner.nextLine();
		System.out.println("Please enter the planned date of the meeting.");
		String plannedDate = scanner.nextLine();
		try {
			LocalDateTime suggested = meetingManager.suggestTime(plannedEmails, plannedDate);
			System.out.println("Suggested time: " + suggested.toString());
		} catch (Exception e) {
			System.out.println(e);
		}

		scanner.nextLine();
		scanner.close();
	}

}
