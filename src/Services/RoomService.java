package Services;

import Models.Room;

import java.util.List;

public class RoomService {
    private List<Room> rooms;

    public RoomService(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public Room findById(int id) {
        for (Room room : rooms) {
            if (room.getRoomID() == id) {
                return room;
            }
        }
        return null;
    }

    public void findAll(List<Room> rooms) {
        System.out.println();
        System.out.println("======================================================");
        System.out.println("=                         Rooms                      =");
        System.out.println("======================================================");
        for (Room room : rooms) {
            System.out.println();

            System.out.println("room : " + room.getRoomID());
            System.out.println("available : " + room.isAvailable());
            System.out.println("======================================================");
        }
    }
}
