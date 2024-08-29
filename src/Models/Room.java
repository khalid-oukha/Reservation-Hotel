package Models;

public class Room {
    private int RoomID;
    private boolean isAvailable;

    public Room(int roomID, boolean isAvailable) {
        this.RoomID = roomID;
        this.isAvailable = isAvailable;
    }

    public int getRoomID() {
        return RoomID;
    }
    public void setRoomID(int roomID) {
        RoomID = roomID;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
