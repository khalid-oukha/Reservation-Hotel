package Services;

import Models.Reservation;
import Models.Room;

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

    public Reservation addReservation(Room room, LocalDate startDate, LocalDate endDate) {
        Reservation reservation = new Reservation(reservations.size() + 1, room, startDate, endDate);
        reservations.add(reservation);
        room.setAvailable(false);
        System.out.println("reservation added");
        return reservation;
    }

    public void deleteReservation(int reservationId) {
        Reservation reservation = findById(reservationId);
        reservation.getRoom().setAvailable(false);
        reservations.remove(reservation);
        System.out.println("reservation deleted");
    }

    public Reservation updateReservation(int reservationId, Reservation newReservation) {
        Reservation currentReservation = findById(reservationId);
        if (currentReservation != null) {
            currentReservation.setRoom(newReservation.getRoom());
            currentReservation.setStartDate(newReservation.getStartDate());
            currentReservation.setEndDate(newReservation.getEndDate());

            return currentReservation;
        }
        System.out.println("Reservation not found.");
        return null;
    }
}
