// Simple Event Management System
import java.util.*;

class Event {
    int id;
    String name;
    String venue;
    String date;
    int capacity;
    List<String> participants = new ArrayList<>();

    Event(int id, String name, String venue, String date, int capacity) {
        this.id = id;
        this.name = name;
        this.venue = venue;
        this.date = date;
        this.capacity = capacity;
    }

    void register(String person) {
        if (participants.size() < capacity) {
            participants.add(person);
            System.out.println(person + " registered successfully!");
        } else {
            System.out.println("Event is full!");
        }
    }

    void showDetails() {
        System.out.println("Event ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Venue: " + venue);
        System.out.println("Date: " + date);
        System.out.println("Capacity: " + capacity);
        System.out.println("Participants: " + participants);
    }
}

public class SimpleEMS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Event> events = new ArrayList<>();

        // Pre-added sample events
        events.add(new Event(1, "Tech Talk", "Hall A", "2025-09-15", 3));
        events.add(new Event(2, "Music Fest", "Ground B", "2025-09-20", 2));

        while (true) {
            System.out.println("\n--- Event Management System ---");
            System.out.println("1. View Events");
            System.out.println("2. Register for Event");
            System.out.println("3. Show Event Details");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    for (Event e : events) {
                        System.out.println(e.id + ". " + e.name + " at " + e.venue + " on " + e.date);
                    }
                    break;

                case 2:
                    System.out.print("Enter Event ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Your Name: ");
                    String name = sc.nextLi1ne();
                    for (Event e : events) {
                        if (e.id == id) {
                            e.register(name);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Event ID: ");
                    id = sc.nextInt();
                    for (Event e : events) {
                        if (e.id == id) {
                            e.showDetails();
                        }
                    }
                    break;

                case 0:
                    System.out.println("Thank you for using EMS!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
