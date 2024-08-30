import Models.Reservation;
import Models.Room;
import Services.ReservationService;
import Services.RoomService;
import commons.DateInterval;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Room> rooms = new ArrayList<Room>();
        rooms.add(new Room(0, true));
        rooms.add(new Room(1, true));
        rooms.add(new Room(2, true));

        List<Reservation> reservations = new ArrayList<Reservation>();
        
        RoomService roomService = new RoomService(rooms);
        ReservationService reservationService = new ReservationService(reservations, rooms);

        //Menu
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("======================================================");
            System.out.println("=                   Reservation System               =");
            System.out.println("======================================================");
            System.out.println("1. Show all the rooms");
            System.out.println("2. Show all the reservations");
            System.out.println("3. Add a Reservation");
            System.out.println("4. Remove a Reservation");
            System.out.println("5. Update a Reservation");
            System.out.println("6. Search for a Reservation");
            System.out.println("0. Exit");
            System.out.println();
            System.out.print("Please Enter your option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    roomService.findAll(rooms);
                    break;
                case 2:
                    reservationService.findAllReservations(reservations);
                    break;
                case 3:
                    System.out.print("Enter the room number: ");
                    int roomNumber = scanner.nextInt();

                    System.out.print("Enter Date start :");
                    LocalDate dateStart = LocalDate.parse(scanner.next());

                    System.out.print("Enter Date end :");
                    LocalDate dateEnd = LocalDate.parse(scanner.next());

                    Room selectedRoom = roomService.findById(roomNumber);
                    if (selectedRoom != null) {
                        DateInterval dateInterval = new DateInterval(dateStart, dateEnd);
                        reservationService.addReservation(selectedRoom, dateInterval);
                        System.out.println("Reservation added for Rooom " + roomNumber);
                    }

                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;

            }
        } while (option != 0);


    }


}