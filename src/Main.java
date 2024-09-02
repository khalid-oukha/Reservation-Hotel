import Models.Client;
import Models.Reservation;
import Models.Room;
import Services.ReservationService;
import Services.RoomService;
import commons.DateInterval;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Room> rooms = new ArrayList<Room>();


        Room room1 = new Room(4, true);
        Room room2 = new Room(5, false);
        Room room3 = new Room(6, false);
        rooms.add(new Room(11, true));
        rooms.add(new Room(1, true));
        rooms.add(new Room(2, true));
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);

        HashMap<Integer, Client> clients = new HashMap<>();
        Client client1 = new Client("p334396", "oukha khalid");
        Client client2 = new Client("P223212", "alami Ahmed");
        Client client3 = new Client("p23323", "brahim Diaz");

        clients.put(1, client1);
        clients.put(2, client2);

        DateInterval dateInterval0 = new DateInterval(LocalDate.now().plusDays(1), LocalDate.now().plusDays(2));
        DateInterval dateInterval1 = new DateInterval(LocalDate.now().plusDays(1), LocalDate.now().plusDays(4));
        DateInterval dateInterval2 = new DateInterval(LocalDate.now().plusDays(1), LocalDate.now().plusDays(6));

        List<Reservation> reservations = new ArrayList<Reservation>();
        Reservation reservation0 = new Reservation(1, client1, room1, dateInterval0);
        Reservation reservation1 = new Reservation(1, client2, room2, dateInterval1);
        Reservation reservation2 = new Reservation(1, client3, room3, dateInterval2);

        reservations.add(reservation0);
        reservations.add(reservation1);
        reservations.add(reservation2);

        RoomService roomService = new RoomService(rooms);
        ReservationService reservationService = new ReservationService(reservations, rooms);

        //Menu
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("============================================================================================================");
            System.out.println("=                                               Reservation System                                         =");
            System.out.println("============================================================================================================");
            System.out.println("=    1. Show all the rooms");
            System.out.println("=    2. Show all the reservations");
            System.out.println("=    3. Add a Reservation");
            System.out.println("=    4. Remove a Reservation");
            System.out.println("=    5. Change a Reservation");
            System.out.println("=    6. Search for a Reservation");
            System.out.println("=    0. Exit");
            System.out.println("============================================================================================================");
            System.out.println("=    Please Enter your option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    roomService.findAll(rooms);
                    break;
                case 2:
                    reservationService.findAllReservations(reservations);
                    break;
                case 3:
                    System.out.println("============================================================================================================");
                    System.out.println("=                                               Reserve your room                                          =");
                    System.out.println("============================================================================================================");
                    System.out.print("    Enter the room number: ");
                    int roomNumber = scanner.nextInt();
                    System.out.print("    Enter the client name: ");
                    String clientName = scanner.next();
                    System.out.print("    Enter the Client Cin: ");
                    String clientCin = scanner.next();

                    System.out.print("    Enter Date start :");
                    LocalDate dateStart = LocalDate.parse(scanner.next());

                    System.out.print("    Enter Date end :");
                    LocalDate dateEnd = LocalDate.parse(scanner.next());
                    Client client = new Client(clientCin, clientName);
                    Room selectedRoom = roomService.findById(roomNumber);
                    if (selectedRoom != null && selectedRoom.isAvailable()) {
                        DateInterval dateInterval = new DateInterval(dateStart, dateEnd);
                        reservationService.addReservation(client, selectedRoom, dateInterval);
                    } else {
                        System.out.println("Room not found");
                    }

                    break;
                case 4:
                    System.out.println("============================================================================================================");
                    System.out.println("=                                               DELETE RESERVATION                                         =");
                    System.out.println("============================================================================================================");
                    System.out.print("Enter the reservation ID please: ");
                    int reservationId = scanner.nextInt();

                    reservationService.deleteReservation(reservationId);
                    break;
                case 5:
                    System.out.println("============================================================================================================");
                    System.out.println("=                                               change Reservation                                          =");
                    System.out.println("============================================================================================================");

                    System.out.print("Enter the reservation ID please: ");
                    int oldReservationId = scanner.nextInt();
                    scanner.nextLine();
                    Reservation reservation = reservationService.findById(oldReservationId);

                    if (reservation != null) {
                        System.out.println("Current Reservation Details: " + reservation);
                        System.out.print("Enter the new room number or press Enter to keep old one: ");
                        String newRoomNumberInput = scanner.nextLine();
                        if (!newRoomNumberInput.isEmpty()) {
                            int newRoomNumber = Integer.parseInt(newRoomNumberInput);
                            Room newRoom = roomService.findById(newRoomNumber);
                            if (newRoom != null && newRoom.isAvailable()) {
                                reservation.setRoom(newRoom);
                            } else {
                                System.out.println("Room not found or not available");
                            }
                        }


                        System.out.println("Enter the new Date start or press Enter to keep old one: ");
                        String newStartDateInput = scanner.nextLine();
                        LocalDate newStartDate = newStartDateInput.isEmpty() ? reservation.getDate().getStartDate() : LocalDate.parse(newStartDateInput);

                        System.out.println("Enter the new Date end or press Enter to keep old one: ");
                        String newEndDateInput = scanner.nextLine();
                        LocalDate newEndDate = newEndDateInput.isEmpty() ? reservation.getDate().getEndDate() : LocalDate.parse(newEndDateInput);

                        DateInterval newDateInterval = new DateInterval(newStartDate, newEndDate);
                        reservation.setDate(newDateInterval);

                        System.out.println("your new Reservation : " + reservation);
                    }
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