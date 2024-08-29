package Models;

import commons.DateInterval;

public class Reservation {
    private int id;
    private Room room;
    private DateInterval date;

    public Reservation(int id, Room room, DateInterval date) {
        this.id = id;
        this.room = room;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public DateInterval getDate() {
        return date;
    }

    public void setDate(DateInterval date) {
        this.date = date;
    }
}

