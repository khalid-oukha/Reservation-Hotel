package Models;

import commons.DateInterval;

public class Reservation {
    private int id;
    private Client client;
    private Room room;
    private DateInterval date;

    public Reservation(int id, Client client, Room room, DateInterval date) {
        this.id = id;
        this.client = client;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Reservation id : " + id + " client full name : " + client.getFullName() + " room : " + room.getRoomID() + " date start : " + date.getStartDate() + " date end : " + date.getEndDate();
    }

}

