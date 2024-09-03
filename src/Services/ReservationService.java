package Services;

import Models.Client;
import Models.Reservation;
import Models.Room;
import commons.DateInterval;

import java.time.LocalDate;
import java.util.List;

public class ReservationService {
    private List<Reservation> reservations;
    private List<Room> rooms;

    public ReservationService(List<Reservation> reservations, List<Room> rooms) {
        this.reservations = reservations;
        this.rooms = rooms;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public Reservation findById(int reservationId) {
        for (Reservation reservation : reservations) {
            if (reservation.getId() == reservationId) {
                return reservation;
            }
        }
        return null;
    }


    public void addReservation(Client client, Room room, DateInterval dateInterval) {

        if (room.isAvailable()) {
            Reservation reservation = new Reservation(reservations.size() + 1, client, room, dateInterval);
            reservations.add(reservation);
            room.setAvailable(false);
            System.out.println("============================================================================================================");
            System.out.println("=                                              Reservation Added                                           =");
            System.out.println("============================================================================================================");
            findById(reservation.getId());
        } else {
            System.out.println("============================================================================================================");
            System.out.println("=                                     Room is not available for Now                                        =");
            System.out.println("============================================================================================================");
        }

    }

    public void deleteReservation(int reservationId) {
        Reservation reservation = findById(reservationId);

        if (reservation != null) {
            reservation.getRoom().setAvailable(true);

            System.out.println("============================================================================================================");
            System.out.println("=                                            Reservation Cancelled                                         =");
            System.out.println("============================================================================================================");
        } else {
            System.out.println("============================================================================================================");
            System.out.println("=                                            Reservation Not Found                                         =");
            System.out.println("============================================================================================================");
        }
    }

    public Reservation updateReservation(int reservationId, Reservation newReservation) {
        Reservation currentReservation = findById(reservationId);
        if (currentReservation != null) {
            currentReservation.setRoom(newReservation.getRoom());
            currentReservation.setDate(newReservation.getDate());
            return currentReservation;
        }
        System.out.println("============================================================================================================");
        System.out.println("=                                            Reservation Not Found                                         =");
        System.out.println("============================================================================================================");
        return null;
    }

    public void findAllReservations(List<Reservation> reservations) {
        System.out.println();
        System.out.println("======================================================");
        System.out.println("=                      Reservations                  =");
        System.out.println("======================================================");
        if (reservations.isEmpty()) {
            System.out.println("==============There is No Reservations for now ! ============");
        } else {
            for (Reservation reservation : reservations) {
                System.out.println("==");

                System.out.println("Room Id :" + reservation.getRoom().getRoomID());
                System.out.println("Room reserved by : " + reservation.getClient().getFullName());
                System.out.println("Reservation Start Date :" + reservation.getDate().getStartDate());
                System.out.println("Reservation End Date :" + reservation.getDate().getEndDate());
            }
        }
    }

    public void updateRoomAvailability(List<Reservation> reservations) {
        for (Reservation reservation : reservations) {
            if (reservation.getDate().getEndDate().isBefore(LocalDate.now())) {
                reservation.getRoom().setAvailable(true);
            }
        }
    }
}

