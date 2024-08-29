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

    public Reservation addReservation(Room room, LocalDate startDate, LocalDate endDate) {
        Reservation reservation = new Reservation(reservations.size() + 1, room, startDate, endDate);
        reservations.add(reservation);
        room.setAvailable(false);
        return reservation;
    }

    public void deleteReservation(int reservationId) {
        Reservation reservation = reservations.get(reservationId);
        reservations.remove(reservation);
    }

    public Reservation getReservation(int reservationId) {
        for (int i = 0; i < reservations.size(); i++) {
            if (reservations.get(i).getId() == reservationId) {
                return reservations.get(i);
            }
        }
    }
}
