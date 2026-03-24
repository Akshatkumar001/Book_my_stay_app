import java.util.*;

class Room {
    String type;
    int beds;
    int size;
    double price;
    int available;

    Room(String type, int beds, int size, double price, int available) {
        this.type = type;
        this.beds = beds;
        this.size = size;
        this.price = price;
        this.available = available;
    }

    void display() {
        System.out.println(type + " Room:");
        System.out.println("Beds: " + beds);
        System.out.println("Size: " + size + " sqft");
        System.out.println("Price per night: " + price);
        System.out.println("Available: " + available);
        System.out.println();
    }
}

class RoomInventory {
    Map<String, Integer> availability = new HashMap<>();

    Room single = new Room("Single", 1, 250, 1500.0, 5);
    Room doub = new Room("Double", 2, 400, 2500.0, 3);
    Room suite = new Room("Suite", 3, 750, 5000.0, 2);

    RoomInventory() {
        availability.put("Single", single.available);
        availability.put("Double", doub.available);
        availability.put("Suite", suite.available);
    }

    Map<String, Integer> getRoomAvailability() {
        return availability;
    }
}

class RoomSearch {
    public void searchAvailableRooms(RoomInventory inventory,
                                     Room singleRoom,
                                     Room doubleRoom,
                                     Room suiteRoom) {

        Map<String, Integer> availability = inventory.getRoomAvailability();

        System.out.println("Room Search\n");

        if (availability.get("Single") > 0) {
            singleRoom.display();
        }

        if (availability.get("Double") > 0) {
            doubleRoom.display();
        }

        if (availability.get("Suite") > 0) {
            suiteRoom.display();
        }
    }
}

public class UseCase4RoomSearch {
    public static void main(String[] args) {
        RoomInventory inventory = new RoomInventory();
        RoomSearch search = new RoomSearch();

        search.searchAvailableRooms(
                inventory,
                inventory.single,
                inventory.doub,
                inventory.suite
        );
    }
}