import java.util.HashMap;
import java.util.Map;

public class RoomInventory {

    private Map<String, Integer> roomAvailability;

    public RoomInventory(){
        initializeInventory();
    }

    private void initializeInventory(){
        roomAvailability = new HashMap<>();
        roomAvailability.put("Single Room",5);
        roomAvailability.put("Double Room",3);
        roomAvailability.put("Suite Room",2);
    }

    public Map<String, Integer> getRoomAvailability(){
        return roomAvailability;
    }

    public void uodateAvailability(String roomType, int count){
        roomAvailability.put(roomType,count);
    }

    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();

        System.out.println("Hotel Room Inventory Status\n");

        System.out.println("Single Room:");
        System.out.println("Beds: 1");
        System.out.println("Size: 250 sqft");
        System.out.println("Price per night: 1500.0");
        System.out.println("Available Rooms: " + inventory.getRoomAvailability().get("Single Room") + "\n");

        System.out.println("Double Room:");
        System.out.println("Beds: 2");
        System.out.println("Size: 400 sqft");
        System.out.println("Price per night: 2500.0");
        System.out.println("Available Rooms: " + inventory.getRoomAvailability().get("Double Room") + "\n");

        System.out.println("Suite Room:");
        System.out.println("Beds: 3");
        System.out.println("Size: 750 sqft");
        System.out.println("Price per night: 5000.0");
        System.out.println("Available Rooms: " + inventory.getRoomAvailability().get("Suite Room"));
    }
}